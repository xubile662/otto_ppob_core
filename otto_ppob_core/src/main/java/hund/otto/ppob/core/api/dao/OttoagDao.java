package hund.otto.ppob.core.api.dao;

import android.content.Context;

import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.di.component.AppComponent;
import glenn.base.util.SystemUtil;
import hund.otto.ppob.core.Interactor.DataManager;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.api.apiCode.APIOTTOAG;
import retrofit2.Callback;

public class OttoagDao extends BaseDao {

    private APIOTTOAG API;
    private DataManager sessionManager;

    public OttoagDao(Object obj, String endpoint, Context context, AppComponent appComponent) {
        super(obj);
        this.API = new APIOTTOAG(endpoint, SystemUtil.getImei(context), sessionManager.getAccessToken(), context, appComponent);
    }

    public void ppobOttoagPaymentDao(String productPool, PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobOttoagPaymentApi(productPool, requestModel, callback);
    }

    public void PpobOttoagQrPaymentDao(String productPool, PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobOttoagQrPaymentAPI(productPool, requestModel, callback);
    }

    public void PpobOttoagAdviceDao(String productPool, PpobOttoagPaymentRequestModel requestModel, Callback callback) {
        API.GetPpobOttoagAdviceAPI(productPool, requestModel, callback);
    }
}