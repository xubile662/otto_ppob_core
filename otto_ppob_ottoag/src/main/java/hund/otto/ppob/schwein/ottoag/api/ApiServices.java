package hund.otto.ppob.schwein.ottoag.api;

import java.util.Map;

import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagDenomRequestModel;
import hund.otto.ppob.core.Interactor.Model.RequestModel.PpobOttoagInquiryRequestModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagDenomResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagInquiryResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;
import hund.otto.ppob.schwein.ottoag.interactor.model.requestModel.FavoriteAddRequestModel;
import hund.otto.ppob.schwein.ottoag.interactor.model.responseModel.FavoriteResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {

    @POST("ppob/product-list/{pool}")
    Call<PpobOttoagDenomResponseModel> asGetPpobOttoagDenom(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagDenomRequestModel model, @Path(value = "pool") String pool);

    @POST("ppob/inquiry/{pool}")
    Call<PpobOttoagInquiryResponseModel> asGetPpobOttoagInquiry(@HeaderMap Map<String, String> key, @HeaderMap Map<String, String> accessToken, @Body PpobOttoagInquiryRequestModel model, @Path(value = "pool") String pool);

    //ppob favorite
    @GET("favourite/ppob/{target}")
    Call<FavoriteResponseModel> asGetFav(@HeaderMap Map<String, String> token, @HeaderMap Map<String, String> accessToken, @Path("target") String target);

    @POST("favourite/ppob/create")
    Call<FavoriteResponseModel> asSaveFav(@HeaderMap Map<String, String> token, @HeaderMap Map<String, String> accessToken, @Body FavoriteAddRequestModel requestModel);

    @POST("favourite/ppob/delete/{id}")
    Call<BaseResponseModel> asDeleteFav(@HeaderMap Map<String, String> token, @HeaderMap Map<String, String> accessToken, @Path("id") int itemid);

}
