package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification extends android.app.Notification {

//    @SerializedName("notificationId")
//    @Expose
//    private Integer notificationId;
//    @SerializedName("userId")
//    @Expose
//    private Integer userId;
//    @SerializedName("image1")
//    @Expose
//    private String image1;
//    @SerializedName("text")
//    @Expose
//    private String text;
//    @SerializedName("image2")
//    @Expose
//    private String image2;
//    @SerializedName("video")
//    @Expose
//    private String video;
//    @SerializedName("title")
//    @Expose
//    private String title;
//    @SerializedName("notificationDate")
//    @Expose
//    private Long notificationDate;
//
//    public Integer getNotificationId() {
//        return notificationId;
//    }
//
//    public void setNotificationId(Integer notificationId) {
//        this.notificationId = notificationId;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getImage1() {
//        return image1;
//    }
//
//    public void setImage1(String image1) {
//        this.image1 = image1;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public String getImage2() {
//        return image2;
//    }
//
//    public void setImage2(String image2) {
//        this.image2 = image2;
//    }
//
//    public String getVideo() {
//        return video;
//    }
//
//    public void setVideo(String video) {
//        this.video = video;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Long getNotificationDate() {
//        return notificationDate;
//    }
//
//    public void setNotificationDate(Long notificationDate) {
//        this.notificationDate = notificationDate;
//    }

    @SerializedName("notificationId")
    @Expose
    private Integer notificationId;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("image1")
    @Expose
    private String image1;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("image2")
    @Expose
    private String image2;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("notificationDate")
    @Expose
    private Object notificationDate;

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Object notificationDate) {
        this.notificationDate = notificationDate;
    }

}
