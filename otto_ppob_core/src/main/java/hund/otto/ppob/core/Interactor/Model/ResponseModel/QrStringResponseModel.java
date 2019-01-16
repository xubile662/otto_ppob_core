package hund.otto.ppob.core.Interactor.Model.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QrStringResponseModel extends BaseResponseModel {

    QrStringDataModel data;

    public QrStringDataModel getData() {
        return data;
    }

    public void setData(QrStringDataModel data) {
        this.data = data;
    }

    public String getQr_string() {
        return data.qr_string;
    }

    public void setQr_string(String qr_string) {
        data.qr_string = qr_string;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class QrStringDataModel {
    String qr_string;

    public String getQr_string() {
        return qr_string;
    }

    public void setQr_string(String qr_string) {
        this.qr_string = qr_string;
    }
}
