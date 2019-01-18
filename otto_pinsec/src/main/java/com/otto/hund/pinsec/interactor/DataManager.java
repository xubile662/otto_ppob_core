package com.otto.hund.pinsec.interactor;


import android.content.SharedPreferences;

public class DataManager {

    static SharedPreferences pref;

    final static String KEY_IS_LOGIN_KEY = "LOGINKEY_021394gruehbfjkowp20ir39ug";
    final static String KEY_USERNAME = "USERNAME_j23u489eijrwokqpi2u43hreknf";
    final static String KEY_NAME = "PAN_012398uiehrwkjip123908fgdjh";
    final static String KEY_STORENAME = "PAYEE_pio23rhuelwxpq[oijfkndlm";
    final static String KEY_USERID = "PROMO_3245rtegfjdweqr32t423453th";
    final static String KEY_WALLETID = "PROMO_3245rtegfjdweqr32t423453wl";
    final static String KEY_MERCHID = "STD_129308u4ihtbjwefknlqdk2ruhteig";
    final static String KEY_ACCESS_TOKEN = "POS_023948uthiregfjwiep082uy3tier";
    final static String KEY_HASSOFTBUTTON = "TEMP_Derq3124t2r413gwe23gwbeg23geb";



    public static String getAccessToken() {
        return pref.getString(KEY_ACCESS_TOKEN, null);
    }



}