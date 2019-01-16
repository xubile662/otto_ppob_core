package hund.otto.ppob.core.Interactor.Model.KMB.Misc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OttoagDenomModel {
    private String provider_code;
    private int denomination;
    private int price;
    private int fee;
    private int promo;
    private String product_code;
    private String biller_code;
    private String description;
    private String product_name;
    private String logo;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getBiller_code() {
        return biller_code;
    }

    public void setBiller_code(String biller_code) {
        this.biller_code = biller_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

