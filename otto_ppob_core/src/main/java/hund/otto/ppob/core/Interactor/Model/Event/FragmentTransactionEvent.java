package hund.otto.ppob.core.Interactor.Model.Event;

import android.support.v4.app.Fragment;

public class FragmentTransactionEvent {
    private String title;
    private Class<? extends Fragment> fragmentClass;

    public FragmentTransactionEvent(String title, Class<? extends Fragment> fragmentClass) {
        this.title = title;
        this.fragmentClass = fragmentClass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }
}
