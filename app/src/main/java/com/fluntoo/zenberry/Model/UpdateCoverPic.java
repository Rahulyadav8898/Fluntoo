package com.fluntoo.zenberry.Model;

public class UpdateCoverPic {
    long UserId;
    String CoverPic;

    public UpdateCoverPic(long userId, String coverPic) {
        UserId = userId;
        CoverPic = coverPic;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public String getCoverPic() {
        return CoverPic;
    }

    public void setCoverPic(String coverPic) {
        CoverPic = coverPic;
    }
}
