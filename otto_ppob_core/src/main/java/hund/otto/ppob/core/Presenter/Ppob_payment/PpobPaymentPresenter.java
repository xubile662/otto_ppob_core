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

import hund.otto.ppob.core.CORE;
import hund.otto.ppob.core.Interactor.Model.Event.PinInteractorCallDoneEvent;
import hund.otto.ppob.core.Interactor.Model.Event.PinInteractorCallEvent;
import hund.otto.ppob.core.Interactor.Model.Event.ProductCanceledEvent;
import hund.otto.ppob.core.Interactor.Model.Event.ProductInputDoneEvent;
import hund.otto.ppob.core.Interactor.Model.Event.UiUpdateEvent;
import hund.otto.ppob.core.Interactor.Model.Misc.WalletDataModel;
import hund.otto.ppob.core.Interactor.Model.Misc.WidgetBuilderModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.base.BasePpobPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Ppob_payment.PpobMiscInteractor;
import hund.otto.ppob.core.Interactor.Ppob_payment.PpobPaymentInteractor;
import hund.otto.ppob.core.Interactor.Ppob_payment.PpobPaymentInteractorInterface2;
import hund.otto.ppob.core.Presenter.BasePresenter;
import hund.otto.ppob.core.R;
import hund.otto.ppob.core.View.Ppob_payment.PpobPaymentViewInterface;
import hund.otto.ppob.core.View.Receipt.PayDetailActivity;

public class PpobPaymentPresenter extends BasePresenter implements PpobPaymentInteractorInterface2 {

    private Context gContext;

    private BasePpobPaymentRequestModel prm;

    private PpobMiscInteractor miscInteractor;
    private PpobPaymentInteractor paymentInteractor;

    private PpobPaymentViewInterface view;

    boolean payType;

    private BasePpobPaymentRequestModel paymentModel;


    private Boolean isWaitingForResult = false;
    private boolean isCanceled = false;
    private int walletId = -1;

    /**
     * @param viewParent
     * @param base
     */
    public PpobPaymentPresenter(Context context,
                                PpobPaymentViewInterface viewParent,
                                Object base) {
        gContext = context;
        this.paymentInteractor = new PpobPaymentInteractor(this, context);
        this.miscInteractor = new PpobMiscInteractor(base, CORE.getEndpoint(), gContext, CORE.getAppComponent());
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
            view.showErrorDialog("Data Tidak Lengkap", "Data Dompet anda tidak tersedia");

        view.toggleNextView();
        postScrollRequest(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPinInteractorCallDoneEvent(PinInteractorCallDoneEvent event) {
        this.paymentModel.setPin(event.pin);
        String productPool = paymentModel.getProduct_type();

        view.showLoading();

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
    @Override
    public void onQrPaymentCanceled() {
        isCanceled = true;
    }

    @Override
    public void onPaymentSuccess(String productCode, String productType, String custRef, String uimsg, List<WidgetBuilderModel> keyval) {
        view.hideLoading();
        view.toggleNextView();

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
        view.showLoading();
        view.showQrDialog(null, productName, paybleAmount);
    }

    @Override
    public void onConnectionFailed(Throwable t) {
        view.hideLoading();
        view.showErrorDialog(gContext.getString(R.string.error_apifailed), t.getMessage());
    }

    @Override
    public void onApiFailed(int code, String message) {
        view.hideLoading();
        view.showErrorDialog(gContext.getString(R.string.error_title_dialog_def), message);
    }

    @Override
    public void onQrStringRequestSuccess(String qrString) {
        view.hideLoading();
        view.showQrDialog(qrString, null, null);
    }

    @Override
    public void onWalletRequestSuccess(List<WalletDataModel> walletDataModels) {
        WalletDataModel odel = walletDataModels.get(0);
        walletId = walletDataModels.get(0).getId();
        view.addWalletData(odel.getOwner_name(), odel.getAccount_number(), Uri.parse(odel.getLogo()), odel.getBalance());
    }

}
