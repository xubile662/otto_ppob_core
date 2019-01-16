package hund.otto.ppob.schwein.ottoag.interactor;


import java.util.List;

import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagDenomResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagInquiryResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;

import com.otto.mart.viewmodule.viewModels.FavoriteItemModel;

public interface PpobOttoagInteractorInterface {

    interface favoriteInterface {
        void onRequestFavoriteSuccess(List<FavoriteItemModel> models);

        void onAddFavoriteSuccess(List<FavoriteItemModel> models);

        void onDelFavSuccess();

        void onApiFailed(int code, BaseResponseModel model);

        void onConnectionFailed(Throwable t);
    }

    interface denomInterface {
        void onDenomSuccess(PpobOttoagDenomResponseModel model);

        void onApiFailed(int code, BaseResponseModel model);

        void onConnectionFailed(Throwable t);
    }

    interface inquiryInterface {
        void onInquirySuccess(PpobOttoagInquiryResponseModel model);

        void onApiFailed(int code, BaseResponseModel model);

        void onConnectionFailed(Throwable t);
    }

}
