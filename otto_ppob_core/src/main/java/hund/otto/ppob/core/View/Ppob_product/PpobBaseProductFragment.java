package hund.otto.ppob.core.View.Ppob_product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import app.beelabs.com.codebase.base.BaseFragment;
import hund.otto.ppob.core.Interactor.Model.RequestModel.base.BasePpobPaymentRequestModel;

public class PpobBaseProductFragment extends BaseFragment {
    public PpobBaseProductCallback listener;
    private final String TAG = "BASE";

    public void setListener(PpobBaseProductCallback listener) {
        this.listener = listener;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        try {
            super.onViewStateRestored(null);

        } catch (Exception e) {
            Log.e(TAG, "onViewStateRestored: " + e.getMessage());
        }
    }

    public PpobBaseProductCallback getListener() {
        return listener;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (listener != null)
            listener.onProductInputUnDone();
    }


    public interface PpobBaseProductCallback {
        void onProductInputDone(int productType, BasePpobPaymentRequestModel model);
        void onProductInputUnDone();
    }

    public void hideKeyboard() {
        if (getActivity() != null && getActivity().getCurrentFocus() != null)
            ((InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
