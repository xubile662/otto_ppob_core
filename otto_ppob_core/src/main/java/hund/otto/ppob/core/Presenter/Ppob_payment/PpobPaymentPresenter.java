package hund.otto.ppob.core.Presenter.Ppob_payment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseFragment;
import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.Event.PinInteractorCallEvent;
import hund.otto.ppob.core.Interactor.Model.Event.ProductCanceledEvent;
import hund.otto.ppob.core.Interactor.Model.Event.UiUpdateEvent;
import hund.otto.ppob.core.Interactor.Model.Event.PinInteractorCallDoneEvent;
import hund.otto.ppob.core.Interactor.Model.Event.ProductInputDoneEvent;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobAirPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobInsurancePaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobListrikPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobTelkomPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.Misc.WalletDataModel;
import hund.otto.ppob.core.Interactor.Model.Misc.WidgetBuilderModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.base.BasePpobPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BasePaymentResponseModel;
import hund.otto.ppob.core.Interactor.Ppob_payment.PpobKmbPaymentInteractor;
import hund.otto.ppob.core.Interactor.Ppob_payment.PpobMiscInteractor;
import hund.otto.ppob.core.Interactor.Ppob_payment.PpobPaymentInteractor;
import hund.otto.ppob.core.Interactor.Ppob_payment.PpobPaymentInteractorInterface;
import hund.otto.ppob.core.R;
import hund.otto.ppob.core.View.Ppob_payment.PpobPaymentViewInterface;
import hund.otto.ppob.core.View.Receipt.PayDetailActivity;

public class PpobPaymentPresenter
        implements PpobPaymentInteractorInterface.WalletInteractorInterface,
        PpobPaymentInteractorInterface.PpobPaymentCallback,
        PpobPaymentInteractorInterface.QrInteractorInterface {

    private Context gContext;

    private BasePpobPaymentRequestModel prm;

    private PpobMiscInteractor miscInteractor;
    private PpobPaymentInteractor paymentInteractor;
    private PpobKmbPaymentInteractor kmbPaymentInteractor;

    private PpobPaymentViewInterface view;

    boolean payType;

    private BasePpobPaymentRequestModel paymentModel;

    private ppobPaymentPresenterCallback listener;

    private Boolean isWaitingForResult = false;
    private boolean isCanceled = false;
    private int walletId = -1;

    /**
     * @param viewParent
     * @param appComponent
     * @param parent
     * @param endpoint
     */
    public PpobPaymentPresenter(PpobPaymentViewInterface viewParent,
                                AppComponent appComponent,
                                BaseFragment parent,
                                String endpoint) {
        gContext = parent.getContext();
        this.paymentInteractor = new PpobPaymentInteractor(parent, endpoint, gContext, appComponent);
        this.miscInteractor = new PpobMiscInteractor(parent, endpoint, gContext, appComponent);
        this.kmbPaymentInteractor = new PpobKmbPaymentInteractor(parent, endpoint, gContext, appComponent);
        this.view = viewParent;
        initComponent();
        initDataContent();
    }

    /**
     * @param viewParent
     * @param appComponent
     * @param parent
     * @param endpoint
     */
    public PpobPaymentPresenter(PpobPaymentViewInterface viewParent,
                                AppComponent appComponent,
                                BaseActivity parent,
                                String endpoint) {
        gContext = parent;
        this.paymentInteractor = new PpobPaymentInteractor(parent, endpoint, gContext, appComponent);
        this.miscInteractor = new PpobMiscInteractor(parent, endpoint, gContext, appComponent);
        this.kmbPaymentInteractor = new PpobKmbPaymentInteractor(parent, endpoint, gContext, appComponent);
        this.view = viewParent;
        initComponent();
        initDataContent();
    }

    private void initComponent() {
        prm = new BasePpobPaymentRequestModel();
    }

    private void initDataContent() {
        miscInteractor.getWalletDataInt(this);
    }

    public void setPaymentModel(BasePpobPaymentRequestModel paymentModel) {
        this.paymentModel = paymentModel;
    }

    public void onResume() {
        EventBus.getDefault().register(this);
    }

    public void onPause() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onProductInputDoneEvent(ProductInputDoneEvent event) {
        this.paymentModel = event.requestModel;
        EventBus.getDefault().removeStickyEvent(event);

        if (walletId >= 0)
            this.paymentModel.setWallet_id(walletId);
        else
            view.showErrorMessage(10, "Data Tidak Lengkap", "Data Dompet anda tidak tersedia");

        view.toggleNextView();
        postScrollRequest(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPinInteractorCallDoneEvent(PinInteractorCallDoneEvent event) {
        this.paymentModel.setPin(event.pin);
        String productPool = paymentModel.getProduct_type();

        view.showLoadingDialog("Mohon Menunggu", false, false);

        //pay up
        if (payType)
            callOttoagQrPaymentApi(productPool);
        else
            callOttoagPaymentApi(productPool);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onProductCanceledEvent(ProductCanceledEvent event) {
        postScrollRequest(false, false);
    }

    public void postScrollRequest(Boolean isScrolldown) {
        EventBus.getDefault().post(new UiUpdateEvent(isScrolldown, true));
    }

    public void postScrollRequest(Boolean isScrolldown, Boolean isShowPayment) {
        EventBus.getDefault().post(new UiUpdateEvent(isScrolldown, isShowPayment));
    }

    public void callOttoagPayment() {
        EventBus.getDefault().post(new PinInteractorCallEvent());
    }

    public void callOttoagPaymentApi(String productPool) {
        paymentInteractor.callPaymentInt(productPool, (PpobOttoagPaymentRequestModel) paymentModel, this);
    }

    public void callOttoagQrPaymentApi(String productPool) {
        paymentInteractor.callPaymentQrInt(productPool, (PpobOttoagPaymentRequestModel) paymentModel, this);
    }

    public void callOttoagPaymentApi() {
        String productPool = paymentModel.getProduct_type();
        paymentInteractor.callPaymentInt(productPool, (PpobOttoagPaymentRequestModel) paymentModel, this);
    }

    public void callOttoagQrPaymentApi() {
        String productPool = paymentModel.getProduct_type();
        paymentInteractor.callPaymentQrInt(productPool, (PpobOttoagPaymentRequestModel) paymentModel, this);
    }

    public void callOttoagAdviceApi(String productPool) {
        paymentInteractor.callAdviceInt(productPool, (PpobOttoagPaymentRequestModel) paymentModel, this);
    }

    public void callOttoagAdviceApi() {
        String productPool = paymentModel.getProduct_type();
        paymentInteractor.callAdviceInt(productPool, (PpobOttoagPaymentRequestModel) paymentModel, this);
    }

    /**
     * @param isQr type of payment, true for qr, false for cash
     */
    public void setPayentType(boolean isQr) {
        payType = isQr;
    }


    public void addPayentPin(String pin) {
        paymentModel.setPin(pin);
    }

//     code reserve for kmb payment
//     delete when no longer required

    /**
     * @param paymentType itemcode
     */
    public void callKmbPaymentApi(int paymentType) {
        switch (paymentType) {
            case 10:
                kmbPaymentInteractor.callPulsaPraPayentInt((PpobOttoagPaymentRequestModel) paymentModel, this);
                break;
            case 11:
                kmbPaymentInteractor.callPulsaPraQrPayentInt((PpobOttoagPaymentRequestModel) paymentModel, this);
                break;
            case 20:
                kmbPaymentInteractor.callPulsaPaketPayentInt((PpobOttoagPaymentRequestModel) paymentModel, this);
                break;
            case 21:
                kmbPaymentInteractor.callPulsaPaketQrPayentInt((PpobOttoagPaymentRequestModel) paymentModel, this);
                break;
            case 30:
                kmbPaymentInteractor.callListrikTokenPayentInt((PpobListrikPaymentRequestModel) paymentModel, this);
                break;
            case 31:
                kmbPaymentInteractor.callListrikTokenQrPayentInt((PpobListrikPaymentRequestModel) paymentModel, this);
                break;
            case 40:
                kmbPaymentInteractor.callListrikBillPayentInt((PpobListrikPaymentRequestModel) paymentModel, this);
                break;
            case 41:
                kmbPaymentInteractor.callListrikBillQrPayentInt((PpobListrikPaymentRequestModel) paymentModel, this);
                break;
            case 50:
                kmbPaymentInteractor.callListrikNonBillPayentInt((PpobListrikPaymentRequestModel) paymentModel, this);
                break;
            case 51:
                kmbPaymentInteractor.callListrikNonBillQrPayentInt((PpobListrikPaymentRequestModel) paymentModel, this);
                break;
            case 60:
                kmbPaymentInteractor.callPulsaPascaPayentInt((PpobOttoagPaymentRequestModel) paymentModel, this);
                break;
            case 61:
                kmbPaymentInteractor.callPulsaPascaQrPayentInt((PpobOttoagPaymentRequestModel) paymentModel, this);
                break;
            case 70:
                kmbPaymentInteractor.callPdamPaymentInt((PpobAirPaymentRequestModel) paymentModel, this);
                break;
            case 71:
                kmbPaymentInteractor.callPdamQrPayentInt((PpobAirPaymentRequestModel) paymentModel, this);
                break;
            case 80:
                kmbPaymentInteractor.callBpjsPaymentInt((PpobInsurancePaymentRequestModel) paymentModel, this);
                break;
            case 81:
                kmbPaymentInteractor.callBpjsQrPayentInt((PpobInsurancePaymentRequestModel) paymentModel, this);
                break;
            case 90:
                kmbPaymentInteractor.callTelkomPaymentInt((PpobTelkomPaymentRequestModel) paymentModel, this);
                break;
            case 91:
                kmbPaymentInteractor.callTelkomQrPayentInt((PpobTelkomPaymentRequestModel) paymentModel, this);
                break;
            case 100:
                kmbPaymentInteractor.callBpjsPaymentInt((PpobInsurancePaymentRequestModel) paymentModel, this);
                break;
            case 101:
//                kmbPaymentInteractor.callBpjsQrPayentInt((PpobInsurancePaymentRequestModel) paymentModel, this);
                view.showErrorMessage(0, "", "Maaf, fitur belum dapat digunakan");
                break;
            case 110:
                callOttoagPaymentApi("tv-cable-internet");
                break;
            case 111:
                callOttoagQrPaymentApi("tv-cable-internet");
                break;
            case 120:
                callOttoagPaymentApi("multi-finance");
                break;
            case 121:
                callOttoagQrPaymentApi("multi-finance");
                break;
            case 130:
                callOttoagPaymentApi("education");
                break;
            case 131:
                view.showErrorMessage(0, "", "Maaf, fitur belum dapat digunakan");
                break;
        }
    }

    @Override
    public void onQrPaymentCanceled() {
        isCanceled = true;
    }

    @Override
    public void onPaymentSuccess(String productCode, String productType, String custRef, String uimsg, List<WidgetBuilderModel> keyval) {
        view.hideActiveLoadingDialog();
        view.toggleNextView();
        if (listener != null)
            listener.onPaymentDone(keyval);

        Intent sucessIntent = new Intent(gContext, PayDetailActivity.class);
        sucessIntent.putExtra("data", (ArrayList<? extends Parcelable>) keyval);
        sucessIntent.putExtra("uimsg", uimsg);
    }

    @Override
    public void onRequestAdvice(String productPool) {
        isWaitingForResult = true;
        callOttoagAdviceApi(productPool);
    }

    @Override
    public void onRequestQrPaymentSuccess(String qrString, String productName, String paybleAmount) {
        view.hideActiveLoadingDialog();
        view.showQrDialog(null, productName, paybleAmount);
    }

    @Override
    public void onConnectionFailed(Throwable t) {
        view.hideActiveLoadingDialog();
        view.showErrorMessage(400, gContext.getString(R.string.error_apifailed), t.getMessage());
    }

    @Override
    public void onApiFailed(int code, String message) {
        view.hideActiveLoadingDialog();
        view.showErrorMessage(code, gContext.getString(R.string.error_title_dialog_def), message);
        if (listener != null)
            listener.onPaymentFailed(message);
    }

    @Override
    public void onQrStringRequestSuccess(String qrString) {
        view.hideActiveLoadingDialog();
        view.showQrDialog(qrString, null, null);
    }

    @Override
    public void onWalletRequestSuccess(List<WalletDataModel> walletDataModels) {
        WalletDataModel odel = walletDataModels.get(0);
        walletId = walletDataModels.get(0).getId();
        view.addWalletData(odel.getOwner_name(), odel.getAccount_number(), Uri.parse(odel.getLogo()), odel.getBalance());
    }

    public interface ppobPaymentPresenterCallback {
        void onPaymentDone(Object paymentCallback);

        void onPaymentFailed(Object paymentCallback);
    }

}
