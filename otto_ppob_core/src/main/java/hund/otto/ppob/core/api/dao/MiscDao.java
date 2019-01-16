package hund.otto.ppob.core.api.dao;


import android.content.Context;

import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.di.component.AppComponent;
import glenn.base.util.SystemUtil;
import hund.otto.ppob.core.Interactor.DataManager;
import hund.otto.ppob.core.Interactor.Model.RequestModel.QrStringRequestModel;
import hund.otto.ppob.core.api.apiCode.APIMISC;
import retrofit2.Callback;

public class MiscDao extends BaseDao {

    private APIMISC API;
    private DataManager sessionManager;

    public MiscDao(Object obj, String endpoint, Context context, AppComponent appComponent) {
        super(obj);
        this.API = new APIMISC(endpoint, SystemUtil.getImei(context), sessionManager.getAccessToken(), context, appComponent);
    }

    public void GetQrStringDao(Callback callback) {
        API.GetQrString(callback);
    }

    public void GetQrStringDao(QrStringRequestModel requestModel, Callback callback) {
        API.GetQrString(requestModel, callback);
    }

    public void GetWalletDataDao(Callback callback) {
        API.GetWalletDataAPI(callback);
    }

}
