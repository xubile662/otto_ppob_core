package hund.otto.ppob.core.Interactor.Ppob_payment;

import android.content.Context;

import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BasePaymentResponseModel;
import hund.otto.ppob.core.api.dao.OttoagDao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PpobPaymentInteractor {

    OttoagDao dao;

    public PpobPaymentInteractor(OttoagDao dao) {
        this.dao = dao;
    }

    public PpobPaymentInteractor(Object obj, String endpoint, Context context, AppComponent appComponent) {
        this.dao = new OttoagDao(obj, endpoint, context, appComponent);
    }

    public void callPaymentInt(String productPool, final PpobOttoagPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobOttoagPaymentDao(productPool, requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), requestModel.getUimsg(), br.getData().getKeyValueList());
                                break;
                            case 408:
                                callback.onRequestAdvice(requestModel.getProduct_type());
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

    public void callPaymentQrInt(String productPool, final PpobOttoagPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.PpobOttoagQrPaymentDao(productPool, requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), requestModel.getUimsg(), br.getData().getKeyValueList());
                                break;
                            case 408:
                                callback.onRequestAdvice(requestModel.getProduct_type());
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

    public void callAdviceInt(String productPool, final PpobOttoagPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.PpobOttoagAdviceDao(productPool, requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), requestModel.getUimsg(), br.getData().getKeyValueList());
                                break;
                            case 408:
                                callback.onRequestAdvice(requestModel.getProduct_type());
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
