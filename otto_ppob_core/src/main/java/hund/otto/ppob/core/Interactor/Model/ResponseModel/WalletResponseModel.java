package hund.otto.ppob.core.Interactor.Model.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import hund.otto.ppob.core.Interactor.Model.Misc.WalletDataModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletResponseModel extends BaseResponseModel {

    List<WalletDataModel> data;

    public List<WalletDataModel> getData() {
        return data;
    }

    public void setData(List<WalletDataModel> data) {
        this.data = data;
    }
}
