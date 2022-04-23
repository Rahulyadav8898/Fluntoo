package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotificationModel {

    @SerializedName("duration")
    @Expose
    private Object duration;
    @SerializedName("size")
    @Expose
    private Object size;
    @SerializedName("channeldynamicid")
    @Expose
    private String channeldynamicid;
    @SerializedName("watchTime")
    @Expose
    private Integer watchTime;
    @SerializedName("totalcomments")
    @Expose
    private Integer totalcomments;
    @SerializedName("watchtimes")
    @Expose
    private Object watchtimes;
    @SerializedName("newVisitor")
    @Expose
    private Integer newVisitor;
    @SerializedName("returnVisitor")
    @Expose
    private Integer returnVisitor;
    @SerializedName("videoStrike")
    @Expose
    private Object videoStrike;
    @SerializedName("videolanguages")
    @Expose
    private List<String> videolanguages = null;
    @SerializedName("videosrtPath")
    @Expose
    private String videosrtPath;
    @SerializedName("live")
    @Expose
    private Boolean live;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("videoUserId")
    @Expose
    private Integer videoUserId;
    @SerializedName("videoDescription")
    @Expose
    private String videoDescription;
    @SerializedName("videoChannelName")
    @Expose
    private String videoChannelName;
    @SerializedName("videoChannelId")
    @Expose
    private Integer videoChannelId;
    @SerializedName("videoChannelImage")
    @Expose
    private String videoChannelImage;
    @SerializedName("videoPosterpath")
    @Expose
    private String videoPosterpath;
    @SerializedName("videoGifPath")
    @Expose
    private String videoGifPath;
    @SerializedName("videoFilepath")
    @Expose
    private String videoFilepath;
    @SerializedName("videoId")
    @Expose
    private String videoId;
    @SerializedName("subscribed")
    @Expose
    private String subscribed;
    @SerializedName("videoCategory")
    @Expose
    private String videoCategory;
    @SerializedName("videoDateadded")
    @Expose
    private Long videoDateadded;
    @SerializedName("videoSId")
    @Expose
    private Integer videoSId;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("dislikes")
    @Expose
    private Integer dislikes;
    @SerializedName("videoTitle")
    @Expose
    private String videoTitle;
    @SerializedName("videoTags")
    @Expose
    private String videoTags;

    public Object getDuration() {
        return duration;
    }

    public void setDuration(Object duration) {
        this.duration = duration;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public String getChanneldynamicid() {
        return channeldynamicid;
    }

    public void setChanneldynamicid(String channeldynamicid) {
        this.channeldynamicid = channeldynamicid;
    }

    public Integer getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(Integer watchTime) {
        this.watchTime = watchTime;
    }

    public Integer getTotalcomments() {
        return totalcomments;
    }

    public void setTotalcomments(Integer totalcomments) {
        this.totalcomments = totalcomments;
    }

    public Object getWatchtimes() {
        return watchtimes;
    }

    public void setWatchtimes(Object watchtimes) {
        this.watchtimes = watchtimes;
    }

    public Integer getNewVisitor() {
        return newVisitor;
    }

    public void setNewVisitor(Integer newVisitor) {
        this.newVisitor = newVisitor;
    }

    public Integer getReturnVisitor() {
        return returnVisitor;
    }

    public void setReturnVisitor(Integer returnVisitor) {
        this.returnVisitor = returnVisitor;
    }

    public Object getVideoStrike() {
        return videoStrike;
    }

    public void setVideoStrike(Object videoStrike) {
        this.videoStrike = videoStrike;
    }

    public List<String> getVideolanguages() {
        return videolanguages;
    }

    public void setVideolanguages(List<String> videolanguages) {
        this.videolanguages = videolanguages;
    }

    public String getVideosrtPath() {
        return videosrtPath;
    }

    public void setVideosrtPath(String videosrtPath) {
        this.videosrtPath = videosrtPath;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getVideoUserId() {
        return videoUserId;
    }

    public void setVideoUserId(Integer videoUserId) {
        this.videoUserId = videoUserId;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public String getVideoChannelName() {
        return videoChannelName;
    }

    public void setVideoChannelName(String videoChannelName) {
        this.videoChannelName = videoChannelName;
    }

    public Integer getVideoChannelId() {
        return videoChannelId;
    }

    public void setVideoChannelId(Integer videoChannelId) {
        this.videoChannelId = videoChannelId;
    }

    public String getVideoChannelImage() {
        return videoChannelImage;
    }

    public void setVideoChannelImage(String videoChannelImage) {
        this.videoChannelImage = videoChannelImage;
    }

    public String getVideoPosterpath() {
        return videoPosterpath;
    }

    public void setVideoPosterpath(String videoPosterpath) {
        this.videoPosterpath = videoPosterpath;
    }

    public String getVideoGifPath() {
        return videoGifPath;
    }

    public void setVideoGifPath(String videoGifPath) {
        this.videoGifPath = videoGifPath;
    }

    public String getVideoFilepath() {
        return videoFilepath;
    }

    public void setVideoFilepath(String videoFilepath) {
        this.videoFilepath = videoFilepath;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(String subscribed) {
        this.subscribed = subscribed;
    }

    public String getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(String videoCategory) {
        this.videoCategory = videoCategory;
    }

    public Long getVideoDateadded() {
        return videoDateadded;
    }

    public void setVideoDateadded(Long videoDateadded) {
        this.videoDateadded = videoDateadded;
    }

    public Integer getVideoSId() {
        return videoSId;
    }

    public void setVideoSId(Integer videoSId) {
        this.videoSId = videoSId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoTags() {
        return videoTags;
    }

    public void setVideoTags(String videoTags) {
        this.videoTags = videoTags;
    }
}
