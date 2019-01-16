package com.otto.mart.pinsec.interactor;

import android.content.Context;

import com.otto.mart.pinsec.API.ReauthDao;
import com.otto.mart.pinsec.presenter.model.RequestModel.ReauthRequestModel;
import com.otto.mart.pinsec.presenter.model.ResponseModel.Base.BaseResponseModel;
import com.otto.mart.pinsec.presenter.model.ResponseModel.ReauthResponseModel;

import app.beelabs.com.codebase.di.component.AppComponent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PinInputInteractor {

    ReauthDao dao;

    public PinInputInteractor(ReauthDao dao) {
        this.dao = dao;
    }

    public PinInputInteractor(Object obj, String endpoint, Context context, AppComponent appComponent) {
        this.dao = new ReauthDao(obj, endpoint, context, appComponent);
    }

    public void getReauthInt(ReauthRequestModel requestModel, final PinInputInteractorInterface callback) {
        if (dao != null)
            dao.GetReauthDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BaseResponseModel br = (BaseResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onSuccess((ReauthResponseModel) br);
                                break;
                            default:
                                callback.onApiFailed(br.getMeta().getCode(), br.getMeta().getMessage());
                                break;
                        }
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    callback.onConnectionFailed(t);
                }
            });
    }


}
