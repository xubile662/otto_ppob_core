package hund.otto.ppob.core.Interactor.Model.ResponseModel.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
