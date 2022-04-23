package com.fluntoo.zenberry.Model;

public class OtpVerify {
    String Token;

    public OtpVerify(String token) {
        Token = token;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
