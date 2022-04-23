package com.fluntoo.zenberry.Model;

public class OurDataSet2 {

    String userMail;

    String userName;
    String userFirstName;
    String userLastName;
    String facebookId;
    String registrationType;
    json json;

    public OurDataSet2(String userMail, String userName, String userFirstName, String userLastName, String facebookId, String registrationType) {
        this.userMail = userMail;
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;

        this.facebookId = facebookId;
        this.registrationType = registrationType;
    }

    public OurDataSet2(String registerationType, String facebookEmail, String facebookId, String userName, String userProfileimagepath) {
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }



    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public com.fluntoo.zenberry.Model.json getJson() {
        return json;
    }

    public void setJson(com.fluntoo.zenberry.Model.json json) {
        this.json = json;
    }
    //    public json getJson() {
//        return json;
//    }
//
//    public void setJson(json json) {
//        this.json = json;
//    }
//
//    public OurDataSet2(String registrationType, String facebookEmail, String facebookId, String userName, String userProfileimagepath) {
//        this.registrationType = registrationType;
//        this.facebookEmail = facebookEmail;
//        this.facebookId = facebookId;
//        this.userName = userName;
//        UserProfileimagepath = userProfileimagepath;
//
//    }
//
//    public String getRegisterationType() {
//        return registrationType;
//    }
//
//    public void setRegisterationType(String registerationType) {
//        this.registrationType = registerationType;
//    }
//
//    public String getFacebookEmail() {
//        return facebookEmail;
//    }
//
//    public void setFacebookEmail(String facebookEmail) {
//        this.facebookEmail = facebookEmail;
//    }
//
//    public String getFacebookId() {
//        return facebookId;
//    }
//
//    public void setFacebookId(String facebookId) {
//        this.facebookId = facebookId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserProfileimagepath() {
//        return UserProfileimagepath;
//    }
//
//    public void setUserProfileimagepath(String userProfileimagepath) {
//        UserProfileimagepath = userProfileimagepath;
//    }
}
