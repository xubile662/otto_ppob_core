package hund.otto.ppob.schwein.ottoag.api;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.di.component.AppComponent;
import glenn.base.util.SystemUtil;
import hund.otto.ppob.core.Interactor.DataManager;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagDenomRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagInquiryRequestModel;
import hund.otto.ppob.schwein.ottoag.interactor.model.requestModel.FavoriteAddRequestModel;
import retrofit2.Callback;

public class OttoagProductDao extends BaseDao {

    private API API;
    private DataManager sessionManager;

    public OttoagProductDao(Object obj, String endpoint, Context context, AppComponent appComponent) {
        super(obj);
        this.API = new API(endpoint, SystemUtil.getImei(context), sessionManager.getAccessToken(), context, appComponent);
    }

    public void PpobOttoagProductlistDao(String productPool, PpobOttoagDenomRequestModel requestModel, Callback callback) {
        API.GetPPobProductlistAPI(productPool, requestModel, callback);
    }

    public void PpobOttaogInquiryDao(String productPool, PpobOttoagInquiryRequestModel requestModel, Callback callback) {
        API.GetPPobInquiryAPI(productPool, requestModel, callback);
    }

    public void PpobOttoagFavlistDao(String productPool, Callback callback) {
        API.GetFavAPI(productPool, callback);
    }

    public void PpobOttoagFavAddDao(FavoriteAddRequestModel requestModel, Callback callback) {
        API.GetSaveFavAPI(requestModel, callback);
    }

    public void PpobOttoagFavDelDao(int favId, Callback callback) {
        API.GetDeleteFavAPI(favId, callback);
    }
}
