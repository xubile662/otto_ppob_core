package hund.otto.ppob.core;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.Event.FragmentTransactionEvent;


public class CORE {

    public static AppComponent appComponent;
    public static String endpoint;
    public static SharedPreferences pref;
    public static Context callerContext;

    public static List<FragmentTransactionEvent> events = new ArrayList<>();

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    /**
     * get dagger app component, assuming coconut base is used
     *
     * @param appComponent (? extend baseApp).getAppComponent() in activity or
     */
    public static void setAppComponent(AppComponent appComponent) {
        CORE.appComponent = appComponent;
    }

    public static String getEndpoint() {
        return endpoint;
    }

    public static void setEndpoint(String endpoint) {
        CORE.endpoint = endpoint;
    }

    /**
     * session pref from session manager
     *
     * @param preferences SessionManager.getSharedPreference()
     */
    public static void setSessionManager(SharedPreferences preferences) {
        pref = preferences;
    }

    public static SharedPreferences sessionManager() {
        return pref;
    }

    public static void addPage(String title, Class fragment) {
        events.add(new FragmentTransactionEvent(title, fragment));
    }

    public static List<FragmentTransactionEvent> getPages() {
        return events;
    }

    public static Context getCallerContext() {
        return callerContext;
    }

    public static void setCallerContext(Context cntx) {
        callerContext = cntx;

    }
}
