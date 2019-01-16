package hund.otto.ppob.schwein.ottoag.interactor;

import android.content.Context;

import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagDenomRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagInquiryRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagDenomResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagInquiryResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;
import hund.otto.ppob.schwein.ottoag.api.OttoagProductDao;
import hund.otto.ppob.schwein.ottoag.interactor.model.requestModel.FavoriteAddRequestModel;
import hund.otto.ppob.schwein.ottoag.interactor.model.responseModel.FavoriteResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PpobOttoagInteractor {

    OttoagProductDao dao;

    public PpobOttoagInteractor(OttoagProductDao dao) {
        this.dao = dao;
    }

    public PpobOttoagInteractor(Object obj, String endpoint, Context context, AppComponent appComponent) {
        this.dao = new OttoagProductDao(obj, endpoint, context, appComponent);
    }

    public void callProductlistInt(String productPool,
                                   final PpobOttoagDenomRequestModel requestModel,
                                   final PpobOttoagInteractorInterface.denomInterface callback) {
        if (dao != null)
            dao.PpobOttoagProductlistDao(productPool, requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        PpobOttoagDenomResponseModel br = (PpobOttoagDenomResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onDenomSuccess(br);
                                break;
                            default:
                                callback.onApiFailed(br.getMeta().getCode(), br);
                                break;
                        }
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    callback.onConnectionFailed(t);
                }
            });
    }

    public void callInquiryInt(String productPool,
                               final PpobOttoagInquiryRequestModel requestModel,
                               final PpobOttoagInteractorInterface.inquiryInterface callback) {

        if (dao != null)
            dao.PpobOttaogInquiryDao(productPool, requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        PpobOttoagInquiryResponseModel br = (PpobOttoagInquiryResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onInquirySuccess(br);
                                break;
                            default:
                                callback.onApiFailed(br.getMeta().getCode(), br);
                                break;
                        }
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    callback.onConnectionFailed(t);
                }
            });
    }

    public void callFavoriteInt(String productPool,
                                final PpobOttoagInteractorInterface.favoriteInterface callback) {
        if (dao != null)
            dao.PpobOttoagFavlistDao(productPool, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        FavoriteResponseModel br = (FavoriteResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onRequestFavoriteSuccess(br.getPpob_favourites());
                                break;
                            default:
                                callback.onApiFailed(br.getMeta().getCode(), br);
                                break;
                        }
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    callback.onConnectionFailed(t);
                }
            });

    }

    public void addFavoriteInt(String prodCode, String custRef, String prodType,
                               final PpobOttoagInteractorInterface.favoriteInterface callback) {
        FavoriteAddRequestModel model = new FavoriteAddRequestModel();
        model.setProduct_code(prodCode);
        model.setCustomer_reference(custRef);
        model.setProduct_type(prodType);

        if (dao != null)
            dao.PpobOttoagFavAddDao(model, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        FavoriteResponseModel br = (FavoriteResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onRequestFavoriteSuccess(br.getPpob_favourites());
                                break;
                            default:
                                callback.onApiFailed(br.getMeta().getCode(), br);
                                break;
                        }
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    callback.onConnectionFailed(t);
                }
            });
    }

    public void delFavoriteInt(int id,
                               final PpobOttoagInteractorInterface.favoriteInterface callback) {
        if (dao != null)
            dao.PpobOttoagFavDelDao(id, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BaseResponseModel br = (BaseResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onDelFavSuccess();
                                break;
                            default:
                                callback.onApiFailed(br.getMeta().getCode(), br);
                                break;
                        }
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    callback.onConnectionFailed(t);
                }
            });
    }


}
