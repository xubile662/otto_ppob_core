package com.otto.hund.pinsec.view;

public interface PinInputViewInterface {

    void doInputDoneState(String value);

    void doSuccessState(String returnValue);

    void doFailState();

    void doNoConnectionState();

    void showLoading();

    void hideLoading();

    /**
     * @param state number of active dots
     */
    void setPinstate(int state);
}
