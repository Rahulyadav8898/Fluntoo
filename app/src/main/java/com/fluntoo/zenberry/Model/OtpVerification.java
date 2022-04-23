package com.fluntoo.zenberry.Model;

public class OtpVerification {
    String OTP;
    String password;

    public OtpVerification(String OTP, String password) {
        this.OTP = OTP;
        this.password = password;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
