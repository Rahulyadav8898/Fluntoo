package com.fluntoo.zenberry.Model;

public class Comments {
    private long userId;
    private String VideoId;
    private String Comments;

    public Comments(String comments) {

        this.Comments = comments;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getVideoId() {
        return VideoId;
    }

    public void setVideoId(String videoId) {
        VideoId = videoId;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "userId=" + userId +
                ", VideoId='" + VideoId + '\'' +
                ", Comments='" + Comments + '\'' +
                '}';
    }
}
