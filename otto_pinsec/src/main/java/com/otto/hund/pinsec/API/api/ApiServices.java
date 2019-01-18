package com.otto.hund.pinsec.API.api;

import com.otto.hund.pinsec.presenter.model.RequestModel.ReauthRequestModel;
import com.otto.hund.pinsec.presenter.model.ResponseModel.ReauthResponseModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("auth/re-auth")
    Call<ReauthResponseModel> asReauth(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body ReauthRequestModel model);

}
