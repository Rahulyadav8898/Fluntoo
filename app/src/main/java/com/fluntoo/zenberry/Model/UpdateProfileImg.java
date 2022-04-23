package com.fluntoo.zenberry.Model;

public class UpdateProfileImg {
    long UserId;
    String ProfilePic;

    public UpdateProfileImg(long userId, String profilePic) {
        UserId = userId;
        ProfilePic = profilePic;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(String profilePic) {
        ProfilePic = profilePic;
    }
}
