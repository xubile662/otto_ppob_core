package hund.otto.ppob.core.Interactor.Ppob_payment;

import android.content.Context;

import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.RequestModel.QrStringRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.QrStringResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.WalletResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;
import hund.otto.ppob.core.api.dao.MiscDao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PpobMiscInteractor {

    MiscDao dao;

    public PpobMiscInteractor(MiscDao dao) {
        this.dao = dao;
    }

    public PpobMiscInteractor(Object obj, String endpoint, Context context, AppComponent appComponent) {
        this.dao = new MiscDao(obj, endpoint, context, appComponent);
    }

    public void getQrStringInt(final PpobPaymentInteractorInterface.QrInteractorInterface callback) {
        if (dao != null)
            dao.GetQrStringDao(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BaseResponseModel br = new BaseResponseModel();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onQrStringRequestSuccess(((QrStringResponseModel) br).getQr_string());
                                break;
                            default:
                                callback.onApiFailed(br.getMeta().getCode(), br.getMeta().getMessage());
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

    public void getQrStringInt(QrStringRequestModel requestModel, final PpobPaymentInteractorInterface.QrInteractorInterface callback) {
        if (dao != null)
            dao.GetQrStringDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BaseResponseModel br = new BaseResponseModel();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onQrStringRequestSuccess(((QrStringResponseModel) br).getQr_string());
                                break;
                            default:
                                callback.onApiFailed(br.getMeta().getCode(), br.getMeta().getMessage());
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

    public void getWalletDataInt(final PpobPaymentInteractorInterface.WalletInteractorInterface callback) {
        if (dao != null) {
            dao.GetWalletDataDao(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BaseResponseModel br = (BaseResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onWalletRequestSuccess(((WalletResponseModel) br).getData());
                                break;
                            default:
                                callback.onApiFailed(br.getMeta().getCode(), br.getMeta().getMessage());
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
}
