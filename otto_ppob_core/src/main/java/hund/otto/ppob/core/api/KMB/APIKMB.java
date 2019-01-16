package hund.otto.ppob.core.api.KMB;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobAirPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobInsurancePaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobListrikPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobQrPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobTelkomPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.CancelQrTransactionRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.CancelQrTransactionResponseModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.PPobPaymentQrResponseModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.PpobAirPaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.PpobListrikPaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.PpobPulsaPaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.base.BasePpobPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagPaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BasePaymentResponseModel;
import retrofit2.Callback;

import static app.beelabs.com.codebase.base.BaseApi.getInstance;

public class APIKMB {
    private String endpoint, deviceId, auth;
    private Context context;
    private AppComponent appComponent;

    public APIKMB(String endpoint, String deviceId, String auth, Context context, AppComponent appComponent) {
        this.endpoint = endpoint;
        this.deviceId = deviceId;
        this.auth = auth;
        this.context = context;
        this.appComponent = appComponent;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    private Map<String, String> deviceId() {
        Map<String, String> map = new HashMap<>();
        map.put("Device-Id", deviceId);
        return map;
    }

    private Map<String, String> accessToken() {
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + auth);
        return map;
    }

    private ApiServicesKMB initApiDomain(Context context, AppComponent appComponent) {
        this.appComponent = appComponent;
        this.context = context;
        getInstance().setApiDomain(endpoint);
        return (ApiServicesKMB) getInstance().setupApi(appComponent, ApiServicesKMB.class, false, 120);
    }

    synchronized public void GetPpobPulsapraPaymentAPI(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobPulsaPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobPulsaPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobPulsapraQrPaymentAPI(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobPulsaQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void GetPpobPulsaPascaPayentAPI(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobPulsaPascaPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobPulsaPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobPulsaPascaQrPaymentAPI(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobPulsaPascaQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void GetPpobPulsaPaketdataPaymentAPI(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobPaketDataPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobPulsaPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobPulsaPakedataQrPaymentAPI(PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobPaketDataQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void GetPpobListrikTokenPaymentAPI(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobListrikTokenPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobListrikPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobListrikTokenQrPaymentAPI(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobListrikTokenPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobListrikPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobListrikNgutangPaymentAPI(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobListrikNgutangPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobListrikPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobListrikNgutangQrPaymentAPI(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobListrikNgutangQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void GetPpobListrikTidakNgutangPaymentAPI(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobListrikTdkNgutangPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobListrikPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobListrikTidakNgutangQrPaymentAPI(PpobListrikPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobListrikTdkNgutangQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void GetPpobPdamPaymentAPI(PpobAirPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobAirPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobAirPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobPdamQrPaymentAPI(PpobAirPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobAirQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void GetPpobTelkomPaymentAPI(PpobTelkomPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobTelkomPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobOttoagPaymentResponseModel>) callback);
    }

    synchronized public void GetPPobTelkomQrPaymentAPI(PpobQrPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobTelkomQRPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void GetPpobBpjsPaymentAPI(PpobInsurancePaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobBPJSPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PpobOttoagPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobBpjsQrPaymentAPI(PpobInsurancePaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobBPJSQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void GetPpobAsuPaymentAPI(PpobInsurancePaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobAsuPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<BasePaymentResponseModel>) callback);
    }

    synchronized public void GetPpobAsuQrPaymentAPI(PpobInsurancePaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobAsuQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void PpobQrPaymentCheckApi(PpobQrPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<BasePaymentResponseModel>) callback);
    }

    synchronized public void PpobQrPaymentCancelApi(CancelQrTransactionRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asQrCancelPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<CancelQrTransactionResponseModel>) callback);
    }
}
