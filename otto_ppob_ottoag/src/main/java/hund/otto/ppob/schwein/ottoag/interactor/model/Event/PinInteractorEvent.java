package hund.otto.ppob.schwein.ottoag.interactor.model.Event;

public class PinInteractorEvent {
    Boolean pinInteractorEvent;
    String pin;

    public PinInteractorEvent(Boolean pinInteractorEvent, String pin) {
        this.pinInteractorEvent = pinInteractorEvent;
        this.pin = pin;
    }
}
