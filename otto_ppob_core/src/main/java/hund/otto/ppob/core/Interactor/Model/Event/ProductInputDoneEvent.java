package hund.otto.ppob.core.Interactor.Model.Event;

import hund.otto.ppob.core.Interactor.Model.RequestModel.base.BasePpobPaymentRequestModel;

public class ProductInputDoneEvent {

    public final BasePpobPaymentRequestModel requestModel;

    public ProductInputDoneEvent(BasePpobPaymentRequestModel requestModel) {
        this.requestModel = requestModel;
    }
}
