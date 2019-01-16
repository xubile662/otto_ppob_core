package hund.otto.ppob.schwein.ottoag.interactor.model.responseModel;

import com.otto.mart.viewmodule.viewModels.FavoriteItemModel;

import java.util.List;

import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;

public class FavoriteResponseModel extends BaseResponseModel {

    FavoriteDataModel data;

    public FavoriteDataModel getData() {
        return data;
    }

    public void setData(FavoriteDataModel data) {
        this.data = data;
    }

    public List<FavoriteItemModel> getPpob_favourites() {
        return data.ppob_favourites;
    }

    public void setPpob_favourites(List<FavoriteItemModel> ppob_favourites) {
        data.ppob_favourites = ppob_favourites;
    }
}

class FavoriteDataModel {
    List<FavoriteItemModel> ppob_favourites;

    public List<FavoriteItemModel> getPpob_favourites() {
        return ppob_favourites;
    }

    public void setPpob_favourites(List<FavoriteItemModel> ppob_favourites) {
        this.ppob_favourites = ppob_favourites;
    }
}


