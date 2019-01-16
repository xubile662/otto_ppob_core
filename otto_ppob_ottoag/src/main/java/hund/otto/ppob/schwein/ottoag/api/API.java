package hund.otto.ppob.schwein.ottoag.api;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import app.beelabs.com.codebase.base.BaseApi;
import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagDenomRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagInquiryRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagDenomResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagInquiryResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;
import hund.otto.ppob.schwein.ottoag.interactor.model.requestModel.FavoriteAddRequestModel;
import hund.otto.ppob.schwein.ottoag.interactor.model.responseModel.FavoriteResponseModel;
import retrofit2.Callback;

public class API extends BaseApi {
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

    synchronized public void GetPPobProductlistAPI(String productPool, PpobOttoagDenomRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobOttoagDenom(deviceId(), accessToken(), requestModel, productPool).enqueue((Callback<PpobOttoagDenomResponseModel>) callback);
    }

    synchronized public void GetPPobInquiryAPI(String productPool, PpobOttoagInquiryRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asGetPpobOttoagInquiry(deviceId(), accessToken(), requestModel, productPool).enqueue((Callback<PpobOttoagInquiryResponseModel>) callback);
    }

    synchronized public void GetFavAPI(String productPool, Callback callback) {
        initApiDomain(context, appComponent).asGetFav(deviceId(), accessToken(), productPool).enqueue((Callback<FavoriteResponseModel>) callback);
    }

    synchronized public void GetSaveFavAPI(FavoriteAddRequestModel requestModel, Callback callback) {
        initApiDomain(context, appComponent).asSaveFav(deviceId(), accessToken(), requestModel).enqueue((Callback<FavoriteResponseModel>) callback);
    }

    synchronized public void GetDeleteFavAPI(int id, Callback callback) {
        initApiDomain(context, appComponent).asDeleteFav(deviceId(), accessToken(), id).enqueue((Callback<BaseResponseModel>) callback);
    }

}
