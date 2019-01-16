package hund.otto.ppob.core.Interactor.Model.KMB.RequestModel;

import hund.otto.ppob.core.Interactor.Model.RequestModel.base.BasePpobPaymentRequestModel;

public class PpobAirPaymentRequestModel extends BasePpobPaymentRequestModel {
    String biller_code;
    String product_code;
    String customer_reference;
    int wallet_id;


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

    public String getCustomer_reference() {
        return customer_reference;
    }

    public void setCustomer_reference(String customer_reference) {
        this.customer_reference = customer_reference;
    }

    public int getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(int wallet_id) {
        this.wallet_id = wallet_id;
    }
}
