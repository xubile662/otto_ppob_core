package hund.otto.ppob.core.api.apiCode;

import java.util.Map;

import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobQrPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.QrStringRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PPobPaymentQrResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagPaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.QrStringResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.WalletResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BasePaymentResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {

    //payment
    @POST("ppob/payment/{pool}")
    Call<PpobOttoagPaymentResponseModel> asGetPpobOttoagPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagPaymentRequestModel model, @Path(value = "pool") String pool);

    //paymentqr
    @POST("ppob/qr/education/{pool}")
    Call<PPobPaymentQrResponseModel> asGetPpobOttoagQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagPaymentRequestModel model, @Path(value = "pool") String pool);

    //advice
    @POST("ppob/advice/{pool}")
    Call<PpobOttoagPaymentResponseModel> asGetPpobOttoagAdvice(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagPaymentRequestModel model, @Path(value = "pool") String pool);

    //qr
    @POST("qrstring")
    Call<QrStringResponseModel> asGetQrString(@HeaderMap Map<String, String> token, @HeaderMap Map<String, String> accessToken, @Body QrStringRequestModel model);

    @POST("qrstring")
    Call<QrStringResponseModel> asGetQrString(@HeaderMap Map<String, String> token, @HeaderMap Map<String, String> accessToken);

    @POST("qr/payment")
    Call<BasePaymentResponseModel> asQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobQrPaymentRequestModel model);


    //wallet
    @GET("wallet")
    Call<WalletResponseModel> asGetWallet(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken);



}
