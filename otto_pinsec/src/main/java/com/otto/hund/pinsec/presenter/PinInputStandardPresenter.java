package com.otto.hund.pinsec.presenter;

import com.otto.hund.pinsec.view.PinInputViewInterface;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseFragment;
import app.beelabs.com.codebase.di.component.AppComponent;

public class PinInputStandardPresenter extends PinInputBasePresenter {

    public PinInputStandardPresenter(PinInputViewInterface viewParent, AppComponent appComponent, BaseFragment parent, String endpoint) {
        super(viewParent, appComponent, parent, endpoint);
    }

    public PinInputStandardPresenter(PinInputViewInterface viewParent, AppComponent appComponent, BaseActivity parent, String endpoint) {
        super(viewParent, appComponent, parent, endpoint);
    }
}
