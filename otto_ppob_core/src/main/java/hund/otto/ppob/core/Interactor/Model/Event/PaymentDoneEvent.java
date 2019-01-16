package hund.otto.ppob.core.Interactor.Model.Event;

import java.util.List;

import hund.otto.ppob.core.Interactor.Model.Misc.WidgetBuilderModel;

public class PaymentDoneEvent {

    final List<WidgetBuilderModel> data;


    public PaymentDoneEvent(List<WidgetBuilderModel> data) {
        this.data = data;
    }

    public List<WidgetBuilderModel> getData() {
        return data;
    }
}
