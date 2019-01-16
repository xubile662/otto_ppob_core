package hund.otto.ppob.schwein.ottoag.presenter;

import android.content.Context;

import com.otto.mart.viewmodule.viewModels.FavoriteItemModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import app.beelabs.com.codebase.base.BaseFragment;
import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.CORE;
import hund.otto.ppob.core.Interactor.Model.Event.ProductCanceledEvent;
import hund.otto.ppob.core.Interactor.Model.Event.ProductInputDoneEvent;
import hund.otto.ppob.core.Interactor.Model.KMB.Misc.ConfirmationModel;
import hund.otto.ppob.core.Interactor.Model.KMB.Misc.PaymentPriceModel;
import hund.otto.ppob.core.Interactor.Model.KMB.Misc.WidgetBuilderModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagDenomRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagInquiryRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagDenomResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagInquiryResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;
import hund.otto.ppob.schwein.ottoag.R;
import hund.otto.ppob.schwein.ottoag.interactor.PpobOttoagInteractor;
import hund.otto.ppob.schwein.ottoag.interactor.PpobOttoagInteractorInterface;
import hund.otto.ppob.schwein.ottoag.view.PpobOttoagProductViewInterface;

public class PpobOttoagProductViewPresenter implements
        PpobOttoagInteractorInterface.denomInterface,
        PpobOttoagInteractorInterface.inquiryInterface,
        PpobOttoagInteractorInterface.favoriteInterface {

    private Context gContext;
    private PpobOttoagInteractor interactor;
    private PpobOttoagProductViewInterface view;
    private PpobOttoagPaymentRequestModel prm;
    private PaymentPriceModel ppm;
    private ConfirmationModel pcm;

    public PpobOttoagProductViewPresenter(PpobOttoagInteractor interactor) {
        this.interactor = interactor;
    }

    public PpobOttoagProductViewPresenter(PpobOttoagProductViewInterface viewParent,
                                          AppComponent appComponent,
                                          BaseFragment parent,
                                          String endpoint) {
        gContext = parent.getContext();

        this.interactor = new PpobOttoagInteractor(parent, endpoint, CORE.getCallerContext(), appComponent);
        this.view = viewParent;
        initComponent();
    }

    private void initComponent() {
        prm = new PpobOttoagPaymentRequestModel();
    }

    public void addPaymentRequestData(String productType, String productCode, String custRef, PpobOttoagInquiryResponseModel model) {
        prm = new PpobOttoagPaymentRequestModel();
        prm.setProduct_type(productType);
        prm.setProduct_code(productCode);
        prm.setCustomer_reference(custRef);

        prm.setAdmin_fee(model.getAdminfee());
        prm.setSub_amount(model.getAmount());
        prm.setAmount(model.getAmount());
        prm.setSelling_price(model.getAmount());
        prm.setInquiry_data(model.getRrn());

        //bpjs Only
        prm.setMonths(model.getMonths());
        prm.setTotal_premium(model.getTotalpremium());

        EventBus.getDefault().post(new ProductInputDoneEvent(prm));
    }

    public void addPaymentRequestData(String productType, String productCode, String custRef, PpobOttoagInquiryResponseModel model, int sellingPrice) {
        prm = new PpobOttoagPaymentRequestModel();
        prm.setProduct_type(productType);
        prm.setProduct_code(productCode);
        prm.setCustomer_reference(custRef);
        if (pcm != null)
            prm.setProduct_name(pcm.getProductName());

        prm.setAdmin_fee(model.getAdminfee());
        prm.setSub_amount(model.getAmount());
        prm.setAmount(model.getAmount());
        prm.setSelling_price(sellingPrice);
        prm.setInquiry_data(model.getRrn());

        //bpjs Only
        prm.setMonths(model.getMonths());
        prm.setTotal_premium(model.getTotalpremium());

        EventBus.getDefault().post(new ProductInputDoneEvent(prm));
    }

    public void addpaymentPriceData(long modal, long komisi, long total, String thumb) {
        ppm = new PaymentPriceModel();
        ppm.setModal(modal);
        ppm.setKomisi(komisi);
        ppm.setTotal(total);
        ppm.setThumb(thumb);
    }

    public void addPaymentConfirmationData(String prodnae, List<WidgetBuilderModel> kvl, String phone) {
        pcm = new ConfirmationModel();
        pcm.setProductName(prodnae);
        pcm.setKeyValueList(kvl);
        pcm.setPhone(phone);
    }

    public void removePaymentRequestData() {
        EventBus.getDefault().post(new ProductCanceledEvent());
    }

    public void callDenomRequest(String productPool, String custRef) {
        PpobOttoagDenomRequestModel requestModel = new PpobOttoagDenomRequestModel();
        requestModel.setPrefix(custRef);
        interactor.callProductlistInt(productPool, requestModel, this);
    }

    public void callInquiryRequest(String productPool, String productCode, String custRef) {
        PpobOttoagInquiryRequestModel requestModel = new PpobOttoagInquiryRequestModel();
        requestModel.setProduct_code(productCode);
        requestModel.setCustomer_reference(custRef);
        interactor.callInquiryInt(productPool, requestModel, this);
    }

    public void callFavoriteListRequest(String productPool) {
        interactor.callFavoriteInt(productPool, this);
    }

    public void callAddFavListRequest(String prodCode, String custRef, String prodType) {
        interactor.addFavoriteInt(prodCode, custRef, prodType, this);
    }

    public void callDelFavListRequest(int favid) {
        interactor.delFavoriteInt(favid, this);
    }

    @Override
    public void onDenomSuccess(PpobOttoagDenomResponseModel model) {
        view.doOnProductlistObtainedAction(model);
    }

    @Override
    public void onInquirySuccess(PpobOttoagInquiryResponseModel model) {
        view.doOnInquiryObtainedAction(model);
    }

    @Override
    public void onRequestFavoriteSuccess(List<FavoriteItemModel> models) {
        view.doShowFavoriteView(models);
    }

    @Override
    public void onAddFavoriteSuccess(List<FavoriteItemModel> models) {
        view.doShowMsgDialog(gContext.getString(R.string.done_favsave));
    }

    @Override
    public void onDelFavSuccess() {
        view.doShowMsgDialog(gContext.getString(R.string.done_favdel));
    }

    @Override
    public void onApiFailed(int code, BaseResponseModel model) {
        view.doOnApiFailedAction(code, model.getMeta().getMessage());
    }

    @Override
    public void onConnectionFailed(Throwable t) {
        view.doOnConnectionFailedAction(t);
    }

    public PpobOttoagPaymentRequestModel getPrm() {
        return prm;
    }

    public void setPrm(PpobOttoagPaymentRequestModel prm) {
        this.prm = prm;
    }
}
