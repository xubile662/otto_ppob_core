package hund.otto.ppob.core.Interactor.Ppob_payment;

public interface aBaseIteractorInterface {

    void onConnectionFailed(Throwable t);

    void onApiFailed(int code, String message);
}
