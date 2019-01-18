package com.otto.hund.pinsec.API.api;

import android.content.Context;

import com.otto.hund.pinsec.presenter.model.RequestModel.ReauthRequestModel;
import com.otto.hund.pinsec.presenter.model.ResponseModel.ReauthResponseModel;

import java.util.HashMap;
import java.util.Map;

import app.beelabs.com.codebase.di.component.AppComponent;
import retrofit2.Callback;

import static app.beelabs.com.codebase.base.BaseApi.getInstance;

public class API {

    private String endpoint, deviceId, auth;
    private Context context;
    private AppComponent appComponent;

    public API(String endpoint, String deviceId, String auth, Context context, AppComponent appComponent) {
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

    synchronized public void GetReauthAPI(ReauthRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asReauth(deviceId(), accessToken(), requestModel).enqueue((Callback<ReauthResponseModel>) callback);
    }
}
