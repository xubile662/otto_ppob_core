package hund.otto.ppob.core.Interactor.Model.KMB.RequestModel;


import hund.otto.ppob.core.Interactor.Model.RequestModel.base.BasePpobPaymentRequestModel;

public class PpobPulsaPaymentRequestModel extends BasePpobPaymentRequestModel {
    String biller_code;
    String product_code;
    String provider_code;
    int fee;
    int admin_fee;
    int sub_amount;
    int amount;
    String inquiry_data;

    public String getBiller_code() {
        return biller_code;
    }

    public void setBiller_code(String biller_code) {
        this.biller_code = biller_code;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProvider_code() {
        return provider_code;
    }

    public void setProvider_code(String provider_code) {
        this.provider_code = provider_code;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int price) {
        this.fee = price;
    }

    public int getAdmin_fee() {
        return admin_fee;
    }

    public void setAdmin_fee(int admin_fee) {
        this.admin_fee = admin_fee;
    }

    public int getSub_amount() {
        return sub_amount;
    }

    public void setSub_amount(int sub_amount) {
        this.sub_amount = sub_amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInquiry_data() {
        return inquiry_data;
    }

    public void setInquiry_data(String inquiry_data) {
        this.inquiry_data = inquiry_data;
    }
}
