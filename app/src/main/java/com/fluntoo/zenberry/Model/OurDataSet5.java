package com.fluntoo.zenberry.Model;

public class OurDataSet5 {

    String userMail;
    String userPassword;

    String userId;
    String token;

    json json;

    public json getJson() {
        return json;
    }

    public void setJson(json json) {
        this.json = json;
    }

    public OurDataSet5() {
    }

    public OurDataSet5(String userMail, String userPassword) {
        this.userMail = userMail;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}
