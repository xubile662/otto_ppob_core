package hund.otto.ppob.core.Interactor.Model.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import hund.otto.ppob.core.Interactor.Model.KMB.Misc.LogoProductModel;
import hund.otto.ppob.core.Interactor.Model.Misc.OttoagDenomModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;

public class PpobOttoagDenomResponseModel extends BaseResponseModel {

    private OttoagDenomData data;

    public OttoagDenomData getData() {
        return data;
    }

    public void setData(OttoagDenomData data) {
        this.data = data;
    }

    public PpobOttoagDenomResponseModel() {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class OttoagDenomData {
        private List<OttoagDenomModel> denomination;
        private LogoProductModel product;

        public List<OttoagDenomModel> getDenomination() {
            return denomination;
        }

        public void setDenomination(List<OttoagDenomModel> denomination) {
            this.denomination = denomination;
        }

        public LogoProductModel getProduct() {
            return product;
        }

        public void setProduct(LogoProductModel product) {
            this.product = product;
        }
    }
}
