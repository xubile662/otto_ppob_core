package hund.otto.ppob.core.Interactor.Model.KMB.Misc;

import java.util.List;

public class ConfirmationModel {
    private List<WidgetBuilderModel> keyValueList;
    private String productName;
    private String phone;

    public ConfirmationModel(List<WidgetBuilderModel> keyValueList, String productName) {
        this.keyValueList = keyValueList;
        this.productName = productName;
    }

    public ConfirmationModel() {
    }

    public List<WidgetBuilderModel> getKeyValueList() {
        return keyValueList;
    }

    public void setKeyValueList(List<WidgetBuilderModel> keyValueList) {
        this.keyValueList = keyValueList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
