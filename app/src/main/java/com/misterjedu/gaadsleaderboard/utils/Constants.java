package com.misterjedu.gaadsleaderboard.utils;

public class Constants {

    private static String BaseURL = null;

    public static void setBaseURL(String url) {
        if (url.equals("gadurl")) {
            BaseURL = "https://gadsapi.herokuapp.com";
        } else if (url.equals("docurl")) {
            BaseURL = "https://docs.google.com/forms/d/e";
        }
    }

    public static String getBaseURL() {
        return BaseURL;
    }

}
