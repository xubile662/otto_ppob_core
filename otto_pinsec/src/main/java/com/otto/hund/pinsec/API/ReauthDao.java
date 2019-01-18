package com.otto.hund.pinsec.API;

import android.content.Context;

import com.otto.hund.pinsec.presenter.model.RequestModel.ReauthRequestModel;
import com.otto.hund.pinsec.API.api.API;
import com.otto.hund.pinsec.presenter.SessionManager;

import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.di.component.AppComponent;
import glenn.base.util.SystemUtil;
import retrofit2.Callback;

public class ReauthDao extends BaseDao {
    private API API;

    public ReauthDao(Object obj, String endpoint, Context context, AppComponent appComponent) {
        super(obj);
        this.API = new API(endpoint, SystemUtil.getImei(context), SessionManager.getAccessToken(), context, appComponent);
    }

    public void GetReauthDao(ReauthRequestModel requestModel, Callback callback) {
        API.GetReauthAPI(requestModel, callback);
    }
}