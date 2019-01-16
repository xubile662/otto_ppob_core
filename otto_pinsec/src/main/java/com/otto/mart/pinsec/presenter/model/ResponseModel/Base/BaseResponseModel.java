package com.otto.mart.pinsec.presenter.model.ResponseModel.Base;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.otto.mart.pinsec.presenter.model.misc.MetaModel;

import app.beelabs.com.codebase.base.response.BaseResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponseModel extends BaseResponse {

    private MetaModel meta;

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

}
