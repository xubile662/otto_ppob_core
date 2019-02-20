package hund.otto.ppob.core.View;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.component.ProgressDialogComponent;
import glenn.base.viewmodule.dialog.ErrorDialog;

public class aBaseViewActivity extends BaseActivity implements aBaseViewInterface {
    @Override
    public void showLoading() {
        ProgressDialogComponent.showProgressDialog(this, "Mohon menunggu",false);
    }

    @Override
    public void hideLoading() {
        ProgressDialogComponent.dismissProgressDialog(this);
    }

    @Override
    public void showErrorDialog(String title, String msg) {
        ErrorDialog ed = new ErrorDialog(this, this, true, true, title, msg);
        ed.show();
    }

    @Override
    public void terminate() {
        finish();
    }
}
