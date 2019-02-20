package hund.otto.ppob.core.View;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseFragment;
import app.beelabs.com.codebase.component.ProgressDialogComponent;
import glenn.base.viewmodule.dialog.ErrorDialog;

public class aBaseViewFragment extends BaseFragment implements aBaseViewInterface{
    @Override
    public void showLoading() {
        ProgressDialogComponent.showProgressDialog(getContext(), "Mohon menunggu",false);
    }

    @Override
    public void hideLoading() {
        ProgressDialogComponent.dismissProgressDialog((BaseActivity) getActivity());
    }

    @Override
    public void showErrorDialog(String title, String msg) {
        ErrorDialog ed = new ErrorDialog(getContext(), getActivity(), true, true, title, msg);
        ed.show();
    }

    @Override
    public void terminate() {
        getActivity().finish();
    }
}
