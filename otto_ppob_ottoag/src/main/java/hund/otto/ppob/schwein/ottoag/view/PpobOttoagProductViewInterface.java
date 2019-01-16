package hund.otto.ppob.schwein.ottoag.view;

import com.otto.mart.viewmodule.viewModels.FavoriteItemModel;

import java.util.List;

import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagDenomResponseModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.PpobOttoagInquiryResponseModel;

public interface PpobOttoagProductViewInterface {

    void doOnProductlistObtainedAction(PpobOttoagDenomResponseModel model);

    void doOnInquiryObtainedAction(PpobOttoagInquiryResponseModel model);

    void doShowFavoriteView(List<FavoriteItemModel> odel);

    void doShowMsgDialog(String message);

    void doOnApiFailedAction(int code, String message);

    void doOnConnectionFailedAction(Throwable t);

    void doReset();

}
