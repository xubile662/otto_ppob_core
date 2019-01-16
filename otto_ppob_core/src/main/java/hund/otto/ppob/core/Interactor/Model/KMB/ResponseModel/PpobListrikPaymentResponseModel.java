package hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BasePaymentResponseModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PpobListrikPaymentResponseModel extends BasePaymentResponseModel {

    public PpobListrikPaymentResponseModel() {
    }
}
