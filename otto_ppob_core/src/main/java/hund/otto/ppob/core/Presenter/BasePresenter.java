package hund.otto.ppob.core.Presenter;


import glenn.base.viewmodule.dialog.ErrorDialog;
import hund.otto.ppob.core.Interactor.Ppob_payment.aBaseIteractorInterface;

public class BasePresenter implements aBaseIteractorInterface {

    @Override
    public void onConnectionFailed(Throwable t) {

    }

    @Override
    public void onApiFailed(int code, String message) {

    }
}
