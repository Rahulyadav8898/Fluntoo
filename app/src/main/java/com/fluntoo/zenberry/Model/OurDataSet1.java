package com.fluntoo.zenberry.Model;

public class OurDataSet1 {
    String userMail;
    String userLastName;
    String userFirstName;
    String googleId;
//    String UserProfileimagepath;
    String userName;
    String registrationType;

    json json;

    public json getJson() {
        return json;
    }

    public void setJson(json json) {
        this.json = json;
    }

    public OurDataSet1(String userMail, String userLastName, String userFirstName, String googleId,  String userName, String registrationType) {
        this.userMail = userMail;
        this.userLastName = userLastName;
        this.userFirstName = userFirstName;
        this.googleId = googleId;

        this.userName = userName;
        this.registrationType = registrationType;
    }



    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getGoogleId() {
        return googleId;
    }



    public String getUserName() {
        return userName;
    }

    public String getRegistrationType() {
        return registrationType;
    }



}
