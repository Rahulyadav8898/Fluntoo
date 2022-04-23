package com.fluntoo.zenberry.Model;

public class OurDataSetLogin {

    String userMail;
    String userPassword;
    String userId;
    String token;
    String loginType;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    json json;

    public json getJson() {
        return json;
    }

    public void setJson(json json) {
        this.json = json;
    }

    public OurDataSetLogin() {
    }

    public OurDataSetLogin(String userMail, String loginType) {
        this.userMail = userMail;
        this.loginType=loginType;
    }



    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
