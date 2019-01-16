package com.otto.mart.pinsec.interactor;


import com.otto.mart.pinsec.presenter.model.ResponseModel.ReauthResponseModel;

public interface PinInputInteractorInterface {

    void onSuccess(ReauthResponseModel model);

    void onApiFailed(int code, String message);

    void onConnectionFailed(Throwable t);


}
