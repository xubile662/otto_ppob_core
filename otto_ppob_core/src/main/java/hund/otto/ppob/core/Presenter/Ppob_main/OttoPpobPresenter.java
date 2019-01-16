package hund.otto.ppob.core.Presenter.Ppob_main;

import android.content.SharedPreferences;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hund.otto.ppob.core.Interactor.Model.Event.PinInteractorCallEvent;
import hund.otto.ppob.core.View.Ppob_Main.PpobMainViewInterface;

public class OttoPpobPresenter {

    private boolean isPinActivityCanceled, isPinActivityTriggered;
    private int selectedItemIndex;
    private PpobMainViewInterface view;

    public OttoPpobPresenter(PpobMainViewInterface view) {
        this.view = view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPinInteractorCallEvent(PinInteractorCallEvent event) {
        view.callCheckPinActivity();
    }


    public void onStart() {
        EventBus.getDefault().register(this);
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
    }


    public boolean isPinActivityCanceled() {
        return isPinActivityCanceled;
    }

    public void setPinActivityCanceled(boolean pinActivityCanceled) {
        isPinActivityCanceled = pinActivityCanceled;
    }

    public boolean isPinActivityTriggered() {
        return isPinActivityTriggered;
    }

    public void setPinActivityTriggered(boolean pinActivityTriggered) {
        isPinActivityTriggered = pinActivityTriggered;
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public void initSessionData(SharedPreferences mainSharedPref) {
//        SessionManager sm = new SessionManager();
//        sm.setModuleSharedReferences(mainSharedPref);
    }


}
