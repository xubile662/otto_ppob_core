package hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelQrTransactionResponseModel extends BaseResponseModel {
    Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
