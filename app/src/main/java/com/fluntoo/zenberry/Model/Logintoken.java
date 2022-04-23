package com.fluntoo.zenberry.Model;

public class Logintoken {
    String userMail;
    String userPassword;
    String token;
    json json;
    String userId;

    public Logintoken(String userMail, String userPassword, String token, com.fluntoo.zenberry.Model.json json, String userId) {
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.token = token;
        this.json = json;
        this.userId=userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public com.fluntoo.zenberry.Model.json getJson() {
        return json;
    }

    public void setJson(com.fluntoo.zenberry.Model.json json) {
        this.json = json;
    }


}
