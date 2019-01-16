package hund.otto.ppob.core.Interactor.Model.ResponseModel.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import hund.otto.ppob.core.Interactor.Model.Misc.PaymentData;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class BasePaymentResponseModel extends BaseResponseModel {

    private PaymentData data;

    public PaymentData getData() {
        return data;
    }

    public void setData(PaymentData data) {
        this.data = data;
    }
}




