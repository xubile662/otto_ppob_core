package hund.otto.ppob.core.Interactor.Model.RequestModel;

public class PpobOttoagInquiryRequestModel {
    String biller_code;
    String product_code;
    String provider_code;
    int denomination;
    String customer_reference;

    public String getBiller_code() {
        return biller_code;
    }

    public void setBiller_code(String biller_cpde) {
        this.biller_code = biller_cpde;
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

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public String getCustomer_reference() {
        return customer_reference;
    }

    public void setCustomer_reference(String customer_reference) {
        this.customer_reference = customer_reference;
    }
}