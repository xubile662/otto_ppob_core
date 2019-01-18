package com.otto.hund.pinsec.presenter.model.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.otto.hund.pinsec.presenter.model.ResponseModel.Base.BaseResponseModel;
import com.otto.hund.pinsec.presenter.model.misc.AuthDataModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReauthResponseModel extends BaseResponseModel {
    private AuthDataModel data;

    public AuthDataModel getData() {
        return data;
    }

    public void setData(AuthDataModel data) {
        this.data = data;
    }
}
