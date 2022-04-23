package com.fluntoo.zenberry.Model;

public class OurDataSet {
    String userName;
    String userMail;
    String userPhonenumber;
    String userPassword;
    String registrationType;
    String userGender;

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    json json;

    public json getJson() {
        return json;
    }

    public void setJson(json json) {
        this.json = json;
    }

    public OurDataSet() {
    }

    public OurDataSet(String userName, String userMail, String userPhonenumber, String userPassword, String registrationType,String userGender) {
        this.userName = userName;
        this.userMail = userMail;
        this.userPhonenumber = userPhonenumber;
        this.userPassword = userPassword;
        this.registrationType = registrationType;
        this.userGender=userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }
}
