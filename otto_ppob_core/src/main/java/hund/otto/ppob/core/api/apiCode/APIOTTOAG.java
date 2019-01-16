package hund.otto.ppob.core.api.apiCode;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobQrPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BasePaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PPobPaymentQrResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagPaymentResponseModel;
import retrofit2.Callback;

import static app.beelabs.com.codebase.base.BaseApi.getInstance;

public class APIOTTOAG {

    private String endpoint, deviceId, auth;
    private Context context;
    private AppComponent appComponent;

    public APIOTTOAG(String endpoint, String deviceId, String auth, Context context, AppComponent appComponent) {
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

    private ApiServices initApiDomain(Context context, AppComponent appComponent) {
        this.appComponent = appComponent;
        this.context = context;
        getInstance().setApiDomain(endpoint + "x/");
        getInstance().setupApi(appComponent, ApiServices.class);
        getInstance().setApiDomain(endpoint);
        return (ApiServices) getInstance().setupApi(appComponent, ApiServices.class, false, 120);
    }

    synchronized public void GetPpobOttoagPaymentApi(String productPool, PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobOttoagPayment(deviceId(), accessToken(), requestModel, productPool).enqueue((Callback<PpobOttoagPaymentResponseModel>) callback);
    }

    synchronized public void GetPpobOttoagQrPaymentAPI(String productPool, PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobOttoagQrPayment(deviceId(), accessToken(), requestModel, productPool).enqueue((Callback<PPobPaymentQrResponseModel>) callback);
    }

    synchronized public void GetPpobOttoagAdviceAPI(String productPool, PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobOttoagAdvice(deviceId(), accessToken(), requestModel, productPool).enqueue((Callback<PpobOttoagPaymentResponseModel>) callback);
    }

    synchronized public void GetQrPayment(String productPool, PpobQrPaymentRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asQrPayment(deviceId(), accessToken(), requestModel).enqueue((Callback<BasePaymentResponseModel>) callback);
    }

}
