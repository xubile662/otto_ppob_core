package hund.otto.ppob.core.Interactor.Model.RequestModel.base;

import hund.otto.ppob.core.Interactor.Model.KMB.Misc.PaymentConfirmationModel;

public class BasePpobPaymentRequestModel {

    int selling_price;
    String pin;
    int wallet_id;
    int denomination;
    String customer_reference;
    String product_name;
    PaymentConfirmationModel confirmationModel;
    String product_code;
    String product_type;


    public PaymentConfirmationModel getConfirmationModel() {
        return confirmationModel;
    }

    public void setConfirmationModel(PaymentConfirmationModel confirmationModel) {
        this.confirmationModel = confirmationModel;
    }

    public int getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(int selling_price) {
        this.selling_price = selling_price;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(int wallet_id) {
        this.wallet_id = wallet_id;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
}

