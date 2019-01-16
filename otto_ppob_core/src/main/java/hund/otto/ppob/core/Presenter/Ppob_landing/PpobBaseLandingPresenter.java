package hund.otto.ppob.core.Presenter.Ppob_landing;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hund.otto.ppob.core.Interactor.Model.Event.ProductInputDoneEvent;
import hund.otto.ppob.core.Interactor.Model.Event.UiUpdateEvent;
import hund.otto.ppob.core.View.Ppob_landing.PpobBaseViewInterface;
import hund.otto.ppob.core.View.Ppob_product.PpobBaseProductFragment;

/**
 * PpobBaseLandingPresenter
 * presenter for PPobBaseViews
 */
public class PpobBaseLandingPresenter {

    private Context mContext;
    private PpobBaseViewInterface view;

    public PpobBaseLandingPresenter(PpobBaseViewInterface view, Context mContext) {
        this.mContext = mContext;
        this.view = view;
        initContent();
    }

    private void initContent() {
        view.loadPaymentFragment();
        view.hidePaymentFragment();
    }

    public void addProductFragment(PpobBaseProductFragment frag) {
        view.loadProductFragment(frag);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUiUpdateEvent(UiUpdateEvent event) {
        if (event.isShowPayment())
            view.showPaymentFragment();
        else
            view.hidePaymentFragment();

        if (event.isNsvScrollDown())
            view.nsvScrollToBottom();
        else
            view.nsvScrollToTop();
    }


    public void onStart() {
        EventBus.getDefault().register(this);
    }

    public void onPause() {
        //what do on pause
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
    }
}
