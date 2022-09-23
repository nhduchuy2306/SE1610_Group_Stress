/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.utils;

import java.util.UUID;

public class Constants {
    // Captcha
    public static String CAPTCHA_SITE_KEY = "6LcFThUiAAAAAEZk9isOhp_hFXnYQpQPjQtRdU17";
    public static String CAPTCHA_SECRET_KEY = "6LcFThUiAAAAAD4Mk080Gff2rY7Oob57GrgA8Ohv";
    // Google
    public static String GOOGLE_CLIENT_ID = "275645487476-tl7da6qfftelhssckl825fv51ahida12.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "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";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/login";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
    //MoMo
    public static String PARTNER_CODE = "MOMOI3J920220921";
    public static String ACCESS_KEY = "yzp3lsHbJJifAkNU";
    public static String SECRET_KEY = "CJLOBZMb1CpjqpDl9bhA9zqnCTv2ThSY";
    public static String END_POINT = "https://test-payment.momo.vn/v2/gateway/api/create";
    public static String RETURN_URL = "http://localhost:8080/demo/MoMoResponse";
//    public static final String NOTIFY_URL = "https://cc09-8-39-127-165.ngrok.io/demo/MoMoNotify";
    public static String NOTIFY_URL = "http://localhost:8080/demo/MoMoNotify";
    public static String ORDER_ID = UUID.randomUUID().toString();
    public static String AMOUNT = "30000";
    public static String ORDER_INFOR = "PAY WITH MOMO";
    public static String REQUEST_ID = UUID.randomUUID().toString();
    public static String REQUEST_TYPE = "captureWallet";
    public static String EXTRA_DATA = "";
}
