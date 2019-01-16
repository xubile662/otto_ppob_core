package hund.otto.ppob.core.Interactor.Model.Event;

public class UiUpdateEvent {

    boolean isNsvScrollDown;
    boolean isShowPayment;

    public UiUpdateEvent(boolean isNsvScrollDown, boolean isShowPayment) {
        this.isNsvScrollDown = isNsvScrollDown;
        this.isShowPayment = isShowPayment;
    }

    public boolean isNsvScrollDown() {
        return isNsvScrollDown;
    }

    public void setNsvScrollDown(boolean nsvScrollDown) {
        isNsvScrollDown = nsvScrollDown;
    }

    public boolean isShowPayment() {
        return isShowPayment;
    }

    public void setShowPayment(boolean showPayment) {
        isShowPayment = showPayment;
    }
}
