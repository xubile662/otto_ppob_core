package hund.otto.ppob.core.api.KMB;

import android.content.Context;

import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.di.component.AppComponent;
import glenn.base.util.SystemUtil;
import hund.otto.ppob.core.Interactor.DataManager;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobAirPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobInsurancePaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobListrikPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobQrPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobTelkomPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.CancelQrTransactionRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import retrofit2.Callback;

public class KMBPaymentDao extends BaseDao {

    private APIKMB API;
    private DataManager sessionManager;

    public KMBPaymentDao(Object obj, String endpoint, Context context, AppComponent appComponent) {
        super(obj);
        this.API = new APIKMB(endpoint, SystemUtil.getImei(context), sessionManager.getAccessToken(), context, appComponent);
    }

    public void ppobPulsaPraPaymentDao(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobPulsapraPaymentAPI(requestModel, callback);
    }

    public void ppobPulsaPraPaymentQrDao(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobPulsapraQrPaymentAPI(requestModel, callback);
    }

    public void ppobPulsaPascaPaymentDao(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobPulsaPascaPayentAPI(requestModel, callback);
    }

    public void ppobPulsaPascaPaymentQrDao(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobPulsaPascaQrPaymentAPI(requestModel, callback);
    }

    public void ppobPulsaPaketDataPaymentDao(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobPulsaPaketdataPaymentAPI(requestModel, callback);
    }

    public void ppobPulsaPaketDataQrPaymentDao(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobPulsaPakedataQrPaymentAPI(requestModel, callback);
    }

    public void ppobListrikTokenPaymentDao(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobListrikTokenPaymentAPI(requestModel, callback);
    }

    public void ppobListrikTokenQrPaymentDao(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobListrikTokenQrPaymentAPI(requestModel, callback);
    }

    public void ppobListrikBillPaymentDao(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobListrikNgutangPaymentAPI(requestModel, callback);
    }

    public void ppobListrikBillQrPaymentDao(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobListrikNgutangQrPaymentAPI(requestModel, callback);
    }

    public void ppobListrikNonBillPaymentDao(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobListrikTidakNgutangPaymentAPI(requestModel, callback);
    }

    public void ppobListrikNonBillQrPaymentDao(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobListrikTidakNgutangQrPaymentAPI(requestModel, callback);
    }

    public void ppobPdamPaymentDao(PpobAirPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobPdamPaymentAPI(requestModel, callback);
    }

    public void ppobPdamQrPaymentDao(PpobAirPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobPdamQrPaymentAPI(requestModel, callback);
    }

    public void ppobTelkomPaymentDao(PpobTelkomPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobTelkomPaymentAPI(requestModel, callback);
    }

    public void ppobBpjsPaymentDao(PpobInsurancePaymentRequestModel requestModel, Callback callback) {
        API.GetPpobBpjsPaymentAPI(requestModel, callback);
    }

    public void ppobBpjsQrPaymentDao(PpobInsurancePaymentRequestModel requestModel, Callback callback) {
        API.GetPpobBpjsQrPaymentAPI(requestModel, callback);
    }

    public void ppobInsurancePaymentDao(PpobInsurancePaymentRequestModel requestModel, Callback callback) {
        API.GetPpobAsuPaymentAPI(requestModel, callback);
    }

    public void ppobInsuranceQrPaymentDao(PpobInsurancePaymentRequestModel requestModel, Callback callback) {
        API.GetPpobAsuQrPaymentAPI(requestModel, callback);
    }

    public void ppobCheckQrPaymentDao(PpobQrPaymentRequestModel requestModel, Callback callback) {
        API.GetPPobTelkomQrPaymentAPI(requestModel, callback);
    }

    public void ppobCancelQrPaymentDao(CancelQrTransactionRequestModel requestModel, Callback callback) {
        API.PpobQrPaymentCancelApi(requestModel, callback);
    }

}
