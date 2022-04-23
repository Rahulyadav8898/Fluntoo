package com.fluntoo.zenberry.Model;

public class OurDataSet4 {
    String registrationType;
    String facebookEmail;
    String facebookId;

    String userName;
    String userPhonenumber;
    String userPassword;



    json json;

    public json getJson() {
        return json;
    }

    public void setJson(json json) {
        this.json = json;
    }

    public OurDataSet4() {
    }

    public OurDataSet4(String userName, String userPhonenumber,String userPassword, String registrationType) {
        this.userName = userName;
        this.userPhonenumber = userPhonenumber;
        this.userPassword = userPassword;
        this.registrationType=registrationType;

    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }
}