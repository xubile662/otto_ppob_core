package com.otto.mart.pinsec.presenter;

public class SessionManager {

    private static String accessToken;

    public static void setAccessToken(String accessToken) {
        SessionManager.accessToken = accessToken;
    }

    public static String getAccessToken() {
        return accessToken;
    }


}
