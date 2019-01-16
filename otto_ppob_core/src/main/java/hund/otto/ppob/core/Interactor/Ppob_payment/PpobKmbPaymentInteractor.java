package hund.otto.ppob.core.Interactor.Ppob_payment;

import android.content.Context;

import app.beelabs.com.codebase.di.component.AppComponent;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobAirPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobInsurancePaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobListrikPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobQrPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobTelkomPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.CancelQrTransactionRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BasePaymentResponseModel;
import hund.otto.ppob.core.api.KMB.KMBPaymentDao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PpobKmbPaymentInteractor {

    KMBPaymentDao dao;

    /**
     * @param dao KMBPaymentDao
     */
    public PpobKmbPaymentInteractor(KMBPaymentDao dao) {
        this.dao = dao;
    }

    /**
     * @param obj          BaseActivity/BaseFragment
     * @param endpoint
     * @param context      this/getContext()
     * @param appComponent baseApp.getAppcomponent
     */
    public PpobKmbPaymentInteractor(Object obj, String endpoint, Context context, AppComponent appComponent) {
        this.dao = new KMBPaymentDao(obj, endpoint, context, appComponent);
    }

    /**
     * @param requestModel PpobOttoagPaymentRequestModel
     * @param callback
     */
    public void callPulsaPraPayentInt(final PpobOttoagPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobPulsaPraPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobOttoagPaymentRequestModel
     * @param callback
     */
    public void callPulsaPraQrPayentInt(final PpobOttoagPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobPulsaPraPaymentQrDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobOttoagPaymentRequestModel
     * @param callback
     */
    public void callPulsaPascaPayentInt(final PpobOttoagPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobPulsaPascaPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobOttoagPaymentRequestModel
     * @param callback
     */
    public void callPulsaPascaQrPayentInt(final PpobOttoagPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobPulsaPascaPaymentQrDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobOttoagPaymentRequestModel
     * @param callback
     */
    public void callPulsaPaketPayentInt(final PpobOttoagPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobPulsaPaketDataPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobOttoagPaymentRequestModel
     * @param callback
     */
    public void callPulsaPaketQrPayentInt(final PpobOttoagPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobPulsaPaketDataQrPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobListrikPaymentRequestModel
     * @param callback
     */
    public void callListrikBillPayentInt(final PpobListrikPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobListrikBillPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobListrikPaymentRequestModel
     * @param callback
     */
    public void callListrikBillQrPayentInt(final PpobListrikPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobListrikBillQrPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobListrikPaymentRequestModel
     * @param callback
     */
    public void callListrikNonBillPayentInt(final PpobListrikPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobListrikNonBillPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobListrikPaymentRequestModel
     * @param callback
     */
    public void callListrikNonBillQrPayentInt(final PpobListrikPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobListrikNonBillQrPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobListrikPaymentRequestModel
     * @param callback
     */
    public void callListrikTokenPayentInt(final PpobListrikPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobListrikTokenPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobListrikPaymentRequestModel
     * @param callback
     */
    public void callListrikTokenQrPayentInt(final PpobListrikPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobListrikTokenQrPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobAirPaymentRequestModel
     * @param callback
     */
    public void callPdamPaymentInt(final PpobAirPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobPdamPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobAirPaymentRequestModel
     * @param callback
     */
    public void callPdamQrPayentInt(final PpobAirPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobPdamQrPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobAirPaymentRequestModel
     * @param callback
     */
    public void callTelkomPaymentInt(final PpobTelkomPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobTelkomPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobAirPaymentRequestModel
     * @param callback
     */
    public void callTelkomQrPayentInt(final PpobTelkomPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobTelkomPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobInsurancePaymentRequestModel
     * @param callback
     */
    public void callBpjsPaymentInt(final PpobInsurancePaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobBpjsPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobInsurancePaymentRequestModel
     * @param callback
     */
    public void callBpjsQrPayentInt(final PpobInsurancePaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobBpjsQrPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobInsurancePaymentRequestModel
     * @param callback
     */
    public void callInsurancePaymentInt(final PpobInsurancePaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobInsurancePaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobInsurancePaymentRequestModel
     * @param callback
     */
    public void callInsuranceQrPaymentInt(final PpobInsurancePaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobInsuranceQrPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(requestModel.getProduct_code(), requestModel.getProduct_type(), requestModel.getCustomer_reference(), "", br.getData().getKeyValueList());
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

    /**
     * @param requestModel PpobQrPaymentRequestModel
     * @param callback
     */
    public void callCheckQrPayentInt(final PpobQrPaymentRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobCheckQrPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onPaymentSuccess(null, null, null, "",br.getData().getKeyValueList());
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

    /**
     * @param requestModel CancelQrTransactionRequestModels
     * @param callback
     */
    public void callCancelQrPayentInt(final CancelQrTransactionRequestModel requestModel, final PpobPaymentInteractorInterface.PpobPaymentCallback callback) {
        if (dao != null)
            dao.ppobCancelQrPaymentDao(requestModel, new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        BasePaymentResponseModel br = (BasePaymentResponseModel) response.body();
                        switch (br.getMeta().getCode()) {
                            case 200:
                                callback.onQrPaymentCanceled();
                                break;
                            case 408:
                                //cant failed
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
