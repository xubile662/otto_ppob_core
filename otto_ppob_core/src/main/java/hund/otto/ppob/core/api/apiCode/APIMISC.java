package hund.otto.ppob.core.api.apiCode;

import android.content.Context;

import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.RequestModel.QrStringRequestModel;
import hund.otto.ppob.core.api.KMB.ApiServicesKMB;
import retrofit2.Callback;

import static app.beelabs.com.codebase.base.BaseApi.getInstance;

public class APIMISC {

    private String endpoint, deviceId, auth;
    private Context context;
    private AppComponent appComponent;

    private ApiServices domain;

    public APIMISC(String endpoint, String deviceId, String auth, Context context, AppComponent appComponent) {
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

    synchronized public void GetQrString(QrStringRequestModel model, Callback callback) {
        initApiDomain(context, appComponent).asGetQrString(deviceId(), accessToken(), model).enqueue(callback);
    }

    synchronized public void GetQrString(Callback callback) {
        initApiDomain(context, appComponent).asGetQrString(deviceId(), accessToken()).enqueue(callback);
    }

    synchronized public void GetWalletDataAPI(Callback callback) {
        initApiDomain(context, appComponent).asGetWallet(deviceId(), accessToken()).enqueue(callback);
    }


}

