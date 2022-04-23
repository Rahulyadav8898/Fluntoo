package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetComments {

//    @SerializedName("commentsId")
//    @Expose
//    private Integer commentsId;
//    @SerializedName("videoId")
//    @Expose
//    private String videoId;
//    @SerializedName("commentUserId")
//    @Expose
//    private Integer commentUserId;
//    @SerializedName("commentsUserName")
//    @Expose
//    private String commentsUserName;
//    @SerializedName("commentsUserProfile")
//    @Expose
//    private String commentsUserProfile;
//    @SerializedName("userComment")
//    @Expose
//    private String userComment;
//    @SerializedName("userCommentDate")
//    @Expose
//    private List<Integer> userCommentDate = null;
//    @SerializedName("likes")
//    @Expose
//    private Integer likes;
//
//    public Integer getCommentsId() {
//        return commentsId;
//    }
//
//    public void setCommentsId(Integer commentsId) {
//        this.commentsId = commentsId;
//    }
//
//    public String getVideoId() {
//        return videoId;
//    }
//
//    public void setVideoId(String videoId) {
//        this.videoId = videoId;
//    }
//
//    public Integer getCommentUserId() {
//        return commentUserId;
//    }
//
//    public void setCommentUserId(Integer commentUserId) {
//        this.commentUserId = commentUserId;
//    }
//
//    public String getCommentsUserName() {
//        return commentsUserName;
//    }
//
//    public void setCommentsUserName(String commentsUserName) {
//        this.commentsUserName = commentsUserName;
//    }
//
//    public String getCommentsUserProfile() {
//        return commentsUserProfile;
//    }
//
//    public void setCommentsUserProfile(String commentsUserProfile) {
//        this.commentsUserProfile = commentsUserProfile;
//    }
//
//    public String getUserComment() {
//        return userComment;
//    }
//
//    public void setUserComment(String userComment) {
//        this.userComment = userComment;
//    }
//
//    public List<Integer> getUserCommentDate() {
//        return userCommentDate;
//    }
//
//    public void setUserCommentDate(List<Integer> userCommentDate) {
//        this.userCommentDate = userCommentDate;
//    }
//
//    public Integer getLikes() {
//        return likes;
//    }
//
//    public void setLikes(Integer likes) {
//        this.likes = likes;
//    }

    @SerializedName("commentsId")
    @Expose
    private Integer commentsId;
    @SerializedName("videoId")
    @Expose
    private String videoId;
    @SerializedName("commentUserId")
    @Expose
    private Integer commentUserId;
    @SerializedName("commentsUserName")
    @Expose
    private String commentsUserName;
    @SerializedName("commentsUserProfile")
    @Expose
    private String commentsUserProfile;
    @SerializedName("userComment")
    @Expose
    private String userComment;
    @SerializedName("userCommentDate")
    @Expose
    private String userCommentDate;
    @SerializedName("likes")
    @Expose
    private Integer likes;

    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentsUserName() {
        return commentsUserName;
    }

    public void setCommentsUserName(String commentsUserName) {
        this.commentsUserName = commentsUserName;
    }

    public String getCommentsUserProfile() {
        return commentsUserProfile;
    }

    public void setCommentsUserProfile(String commentsUserProfile) {
        this.commentsUserProfile = commentsUserProfile;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getUserCommentDate() {
        return userCommentDate;
    }

    public void setUserCommentDate(String userCommentDate) {
        this.userCommentDate = userCommentDate;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
