package com.fluntoo.zenberry.Model;

public class CreateChannel {
    String ChannelDescription;
    String ChannelName;
    String Profilepic;
    String Coverpic;
    String Facebook;
    String Twitter;
    String Linkedin;
    String GoogleBusiness;
    String Instagram;

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public String getLinkedin() {
        return Linkedin;
    }

    public void setLinkedin(String linkedin) {
        Linkedin = linkedin;
    }

    public String getGoogleBusiness() {
        return GoogleBusiness;
    }

    public void setGoogleBusiness(String googleBusiness) {
        GoogleBusiness = googleBusiness;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String instagram) {
        Instagram = instagram;
    }

    public CreateChannel(String channelDescription, String channelName, String profilepic, String coverpic, String facebook, String twitter, String linkedin, String googleBusiness, String instagram) {
        ChannelDescription = channelDescription;
        ChannelName = channelName;
        Profilepic = profilepic;
        Coverpic = coverpic;
        Facebook = facebook;
        Twitter = twitter;
        Linkedin = linkedin;
        GoogleBusiness = googleBusiness;
        Instagram = instagram;
    }




//        public CreateChannel(String channelDescription, String channelName, String profilepic, String coverpic) {
//        ChannelDescription = channelDescription;
//        ChannelName = channelName;
//        Profilepic = profilepic;
//        Coverpic = coverpic;
//    }

    public String getChannelDescription() {
        return ChannelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        ChannelDescription = channelDescription;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }

    public String getProfilepic() {
        return Profilepic;
    }

    public void setProfilepic(String profilepic) {
        Profilepic = profilepic;
    }

    public String getCoverpic() {
        return Coverpic;
    }

    public void setCoverpic(String coverpic) {
        Coverpic = coverpic;
    }
}
