package com.otto.mart.pinsec.presenter.model.misc;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthDataModel {

    int user_id;
    String access_token;
    String merchant_id;
    String name;
    String merchant_name;
    String email;
    int need_otp;
    String avatar;
    String avatar_thumb;
    String latitude;
    String longitude;
    String phone;
    String secondary_phone;
    String omset_balance;
    String wallet_balance;
    int wallet_id;
    int daily_omset;
    String business_category_name;
    String business_type_name;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNeed_otp() {
        return need_otp;
    }

    public void setNeed_otp(int need_otp) {
        this.need_otp = need_otp;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar_thumb() {
        return avatar_thumb;
    }

    public void setAvatar_thumb(String avatar_thumb) {
        this.avatar_thumb = avatar_thumb;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecondary_phone() {
        return secondary_phone;
    }

    public void setSecondary_phone(String secondary_phone) {
        this.secondary_phone = secondary_phone;
    }

    public String getOmset_balance() {
        return omset_balance;
    }

    public void setOmset_balance(String omset_balance) {
        this.omset_balance = omset_balance;
    }

    public String getWallet_balance() {
        return wallet_balance;
    }

    public void setWallet_balance(String wallet_balance) {
        this.wallet_balance = wallet_balance;
    }

    public int getDaily_omset() {
        return daily_omset;
    }

    public void setDaily_omset(int daily_omset) {
        this.daily_omset = daily_omset;
    }

    public int getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(int wallet_id) {
        this.wallet_id = wallet_id;
    }

    public String getBusiness_category_name() {
        return business_category_name;
    }

    public void setBusiness_category_name(String business_category_name) {
        this.business_category_name = business_category_name;
    }

    public String getBusiness_type_name() {
        return business_type_name;
    }

    public void setBusiness_type_name(String business_type_name) {
        this.business_type_name = business_type_name;
    }

}