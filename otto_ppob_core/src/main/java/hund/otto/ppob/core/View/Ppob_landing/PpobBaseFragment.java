package hund.otto.ppob.core.View.Ppob_landing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import app.beelabs.com.codebase.base.BaseFragment;
import hund.otto.ppob.core.Presenter.Ppob_landing.PpobBaseLandingPresenter;
import hund.otto.ppob.core.R;
import hund.otto.ppob.core.View.Ppob_payment.PpobPaymentViewIFragment;
import hund.otto.ppob.core.View.Ppob_product.PpobBaseProductFragment;

/* PpobBaseFragment, use this as product base fragment;
 * wrapper containing product and payment fragments.
 * usage: eg. pulsaProductContainerFragment extend PpobBaseFragment
 */

public class PpobBaseFragment extends BaseFragment implements PpobBaseViewInterface {

    private Context mContext;
    private View mView;
    private LinearLayout layout_maincontainer, layout_paymentcontainer;
    private Fragment paymentFragment;
    private FragmentManager fm;
    private NestedScrollView nsv_parent;
    private childFragmentCallback listener;
    private PpobBaseLandingPresenter presenter;

    public void setListener(childFragmentCallback listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        mView = inflater.inflate(R.layout.fagment_services_base, container, false);
        initComponent();
        initContent();
        if (listener != null) {
            listener.onFragmentReady();
        }
        return mView;
    }

    private void initComponent() {
        layout_maincontainer = mView.findViewById(R.id.layout_maincontainer);
        layout_paymentcontainer = mView.findViewById(R.id.layout_paymentcontainer);
        nsv_parent = mView.findViewById(R.id.nsv_parent);
        nsv_parent.setSmoothScrollingEnabled(true);

        fm = getChildFragmentManager();

        presenter = new PpobBaseLandingPresenter(this, getContext());
    }

    private void initContent() {

    }

    //inithook for adding productFragmentPerSlot
    public void addProductFragment(PpobBaseProductFragment frag) {
        if (presenter != null)
            presenter.addProductFragment(frag);
    }

    @Override
    public void loadPaymentFragment() {
        paymentFragment = new PpobPaymentViewIFragment();
        fm.beginTransaction().replace(layout_paymentcontainer.getId(), paymentFragment).commit();
    }

    @Override
    public void loadProductFragment(PpobBaseProductFragment ppobBaseProductFragment) {
        fm.beginTransaction().replace(layout_maincontainer.getId(), ppobBaseProductFragment).commit();
    }

    @Override
    public void reLoadPaymentFragment() {
        paymentFragment = new PpobPaymentViewIFragment();
        fm.beginTransaction().replace(layout_paymentcontainer.getId(), paymentFragment).commit();
    }

    @Override
    public void reLoadProductFragment(PpobBaseProductFragment ppobBaseProductFragment) {
        fm.beginTransaction().replace(layout_maincontainer.getId(), ppobBaseProductFragment).commit();
    }

    @Override
    public void showPaymentFragment() {
        mView.findViewById(R.id.layout_paymentcontainer).setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePaymentFragment() {
        mView.findViewById(R.id.layout_paymentcontainer).setVisibility(View.GONE);
    }

    @Override
    public void nsvScrollToBottom() {
        nsv_parent.post(new Runnable() {
            @Override
            public void run() {
                nsv_parent.fullScroll(nsv_parent.FOCUS_DOWN);
            }
        });
    }

    @Override
    public void nsvScrollToTop() {
        nsv_parent.post(new Runnable() {
            @Override
            public void run() {
                nsv_parent.fullScroll(nsv_parent.FOCUS_UP);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        presenter.onStop();
        super.onStop();
    }

    public interface childFragmentCallback {
        void onFragmentReady();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (paymentFragment != null)
            paymentFragment.onActivityResult(requestCode, resultCode, data);
    }
}
