package com.otto.hund.pinsec.presenter;

import android.content.Context;

import com.otto.hund.pinsec.interactor.PinInputInteractor;
import com.otto.hund.pinsec.interactor.PinInputInteractorInterface;
import com.otto.hund.pinsec.presenter.model.RequestModel.ReauthRequestModel;
import com.otto.hund.pinsec.presenter.model.ResponseModel.ReauthResponseModel;
import com.otto.hund.pinsec.view.PinInputViewInterface;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseFragment;
import app.beelabs.com.codebase.di.component.AppComponent;

public class PinInputBasePresenter implements PinInputInteractorInterface {


    private Context gContext;
    private Boolean isWaitingForResult = false;
    private PinInputInteractor interactor;

    private PinInputViewInterface view;
    private String pin = "";

    private boolean isInputDone = false;


    public PinInputBasePresenter(PinInputViewInterface viewParent,
                                 AppComponent appComponent,
                                 BaseFragment parent,
                                 String endpoint) {
        gContext = parent.getContext();
        this.interactor = new PinInputInteractor(parent, endpoint, gContext, appComponent);
        this.view = viewParent;
        initComponent();
        initDataContent();
    }

    public PinInputBasePresenter(PinInputViewInterface viewParent,
                                 AppComponent appComponent,
                                 BaseActivity parent,
                                 String endpoint) {
        gContext = parent;
        this.interactor = new PinInputInteractor(parent, endpoint, gContext, appComponent);
        view = viewParent;
        initComponent();
        initDataContent();
    }


    private void initComponent() {

    }

    private void initDataContent() {

    }


    public void addPinString(String x) {
        if (!isInputDone) {
            pin += x;
            if (pin.length() == 6) {
                onInputDone(pin);
            }
            view.setPinstate(pin.length());
        }
    }

    public void delPinString() {
        if (pin != null && pin.length() > 0)
            pin = pin.substring(0, pin.length() - 1);
        else if (pin != null && pin.length() == 1)
            pin = "";
    }

    public void delAllPinString() {
        pin = "";
    }

    public void onInputDone(String pin) {
        isInputDone = true;
        view.doInputDoneState(pin);
        ReauthRequestModel requestModel = new ReauthRequestModel();
        requestModel.setPin(pin);
        interactor.getReauthInt(requestModel, this);
    }

    @Override
    public void onSuccess(ReauthResponseModel model) {
        view.doSuccessState(pin);
    }

    @Override
    public void onApiFailed(int code, String message) {
        view.doFailState();
    }

    @Override
    public void onConnectionFailed(Throwable t) {
        view.doNoConnectionState();
    }
}
