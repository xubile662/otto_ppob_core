package com.otto.mart.pinsec.API;

import android.content.Context;

import com.otto.mart.pinsec.API.api.API;
import com.otto.mart.pinsec.presenter.SessionManager;
import com.otto.mart.pinsec.presenter.model.RequestModel.ReauthRequestModel;

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