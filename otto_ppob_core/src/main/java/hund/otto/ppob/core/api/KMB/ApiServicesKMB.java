package hund.otto.ppob.core.api.KMB;

import java.util.Map;

import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobAirPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobInsurancePaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobListrikPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobQrPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.RequestModel.PpobTelkomPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.CancelQrTransactionRequestModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.CancelQrTransactionResponseModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.PPobPaymentQrResponseModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.PpobAirPaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.PpobListrikPaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.KMB.ResponseModel.PpobPulsaPaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagPaymentRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagPaymentResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BasePaymentResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;


// for payment kmb api,
// delete and replace on done

//pulsa, pasca bayar, data, pdam, listrik (semua)
public interface ApiServicesKMB {

    //ppob
    //pulsa
//    @POST("ppob/denom-list/phone-prepaid")
//    Call<PpobOttoagDenomResponseModel> asGetPpobPulsaDenom(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobPulsaDenomRequestModel model);
//
//    @POST("ppob/inquiry/phone-prepaid")
//    Call<PpobPulsaInquiryResponseModel> asGetPpobPulsaInquiry(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobPulsaInquiryRequestModel model);

    @POST("ppob/payment/phone-prepaid")
    Call<PpobPulsaPaymentResponseModel> asGetPpobPulsaPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagPaymentRequestModel model);

    @POST("ppob/qr/phone-prepaid")
    Call<PPobPaymentQrResponseModel> asGetPpobPulsaQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagPaymentRequestModel model);

//    @POST("ppob/inquiry/phone-postpaid")
//    Call<PpobPulsaPascaInquiryResponseModel> asGetPpobPulsaPascaInquiry(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobPulsaInquiryRequestModel model);

    @POST("ppob/payment/phone-postpaid")
    Call<PpobPulsaPaymentResponseModel> asGetPpobPulsaPascaPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagPaymentRequestModel model);

    @POST("ppob/qr/phone-postpaid")
    Call<PPobPaymentQrResponseModel> asGetPpobPulsaPascaQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagPaymentRequestModel model);

    //paket
//    @POST("ppob/denom-list/phone-data")
//    Call<PpobOttoagDenomResponseModel> asGetPpobPaketdataDenom(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobPulsaDenomRequestModel model);
//
//    @POST("ppob/inquiry/phone-data")
//    Call<PpobOttoagInquiryResponseModel> asGetPpobPaketdataInquiry(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobPulsaInquiryRequestModel model);

    @POST("ppob/payment/phone-data")
    Call<PpobPulsaPaymentResponseModel> asGetPpobPaketDataPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagPaymentRequestModel model);

    @POST("ppob/qr/phone-data")
    Call<PPobPaymentQrResponseModel> asGetPpobPaketDataQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagPaymentRequestModel model);

    //listrik-token
//    @POST("ppob/denom-list/electricity-token")
//    Call<PpobListrikDenomResponseModel> asGetPpobListrikTokenDenom(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikDenomRequestModel model);
//
//    @POST("ppob/inquiry/electricity-token")
//    Call<PpobListrikInquiryResponseModel> asGetPpobListrikTokenInquiry(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikInquiryRequestModel model);

    @POST("ppob/payment/electricity-token")
    Call<PpobListrikPaymentResponseModel> asGetPpobListrikTokenPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikPaymentRequestModel model);

    @POST("ppob/qr/electricity-token")
    Call<PPobPaymentQrResponseModel> asGetPpobListrikTokenQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikPaymentRequestModel model);

    //listrik-tagihan
//    @POST("ppob/inquiry/electricity-bill")
//    Call<PpobListrikInquiryResponseModel> asGetPpobListrikNgutangInquiry(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikInquiryRequestModel model);

    @POST("ppob/payment/electricity-bill")
    Call<PpobListrikPaymentResponseModel> asGetPpobListrikNgutangPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikPaymentRequestModel model);

    @POST("ppob/qr/electricity-bill")
    Call<PPobPaymentQrResponseModel> asGetPpobListrikNgutangQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikPaymentRequestModel model);

    //listrik-!tagihan
//    @POST("ppob/inquiry/electricity-nonbill")
//    Call<PpobListrikInquiryResponseModel> asGetPpobListrikTdkNgutangInquiry(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikInquiryRequestModel model);

    @POST("ppob/payment/electricity-nonbill")
    Call<PpobListrikPaymentResponseModel> asGetPpobListrikTdkNgutangPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikPaymentRequestModel model);

    @POST("ppob/qr/electricity-nonbill")
    Call<PPobPaymentQrResponseModel> asGetPpobListrikTdkNgutangQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobListrikPaymentRequestModel model);

    //air
//    @POST("ppob/product-list/80")
//    Call<PpobAirProductlistResponseModel> asGetPpobAirDenom(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobProductlistRequestModel odel);
//
//    @POST("ppob/inquiry/water")
//    Call<PpobAirInquiryResponseModel> asGetPpobAirInquiry(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobAirInquiryRequestModel model);

    @POST("ppob/payment/water")
    Call<PpobAirPaymentResponseModel> asGetPpobAirPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobAirPaymentRequestModel model);

    @POST("ppob/qr/water")
    Call<PPobPaymentQrResponseModel> asGetPpobAirQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobAirPaymentRequestModel model);

    //telkom
    @POST("ppob/payment/telkom-bill")
    Call<PpobOttoagPaymentResponseModel> asGetPpobTelkomPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobTelkomPaymentRequestModel model);

    @POST("ppob/qr/telkom-bill")
    Call<PPobPaymentQrResponseModel> asGetPpobTelkomQRPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobTelkomPaymentRequestModel model);

    //bpjs
    @POST("ppob/payment/bpjs")
    Call<PpobOttoagPaymentResponseModel> asGetPpobBPJSPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobInsurancePaymentRequestModel model);

    @POST("ppob/qr/bpjs")
    Call<PPobPaymentQrResponseModel> asGetPpobBPJSQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobInsurancePaymentRequestModel model);

    //insurance
    @POST("ppob/payment/insurance")
    Call<BasePaymentResponseModel> asGetPpobAsuPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobInsurancePaymentRequestModel model);

    @POST("ppob/qr/insurance")
    Call<PPobPaymentQrResponseModel> asGetPpobAsuQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobInsurancePaymentRequestModel model);


    @POST("qr/payment")
    Call<BasePaymentResponseModel> asQrPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobQrPaymentRequestModel model);

    @POST("qr/cancel")
    Call<CancelQrTransactionResponseModel> asQrCancelPayment(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body CancelQrTransactionRequestModel model);

}
