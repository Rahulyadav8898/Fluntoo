package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Search {

//    String keyword;
//    @SerializedName("duration")
//    @Expose
//    private Object duration;
//    @SerializedName("size")
//    @Expose
//    private Object size;
//    @SerializedName("watchTime")
//    @Expose
//    private Integer watchTime;
//    @SerializedName("watchtimes")
//    @Expose
//    private Object watchtimes;
//    @SerializedName("videoChannelImage")
//    @Expose
//    private String videoChannelImage;
//    @SerializedName("dislikes")
//    @Expose
//    private Integer dislikes;
//    @SerializedName("videoGifPath")
//    @Expose
//    private String videoGifPath;
//    @SerializedName("videoDateadded")
//    @Expose
//    private Long videoDateadded;
//    @SerializedName("videoId")
//    @Expose
//    private String videoId;
//    @SerializedName("videoTags")
//    @Expose
//    private String videoTags;
//    @SerializedName("videoCategory")
//    @Expose
//    private String videoCategory;
//    @SerializedName("videoTitle")
//    @Expose
//    private String videoTitle;
//    @SerializedName("videoUserId")
//    @Expose
//    private Integer videoUserId;
//    @SerializedName("videoDescription")
//    @Expose
//    private String videoDescription;
//    @SerializedName("videoChannelName")
//    @Expose
//    private String videoChannelName;
//    @SerializedName("videoChannelId")
//    @Expose
//    private Integer videoChannelId;
//    @SerializedName("views")
//    @Expose
//    private Integer views;
//    @SerializedName("videoPosterpath")
//    @Expose
//    private String videoPosterpath;
//    @SerializedName("videoFilepath")
//    @Expose
//    private String videoFilepath;
//    @SerializedName("subscribed")
//    @Expose
//    private Object subscribed;
//    @SerializedName("likes")
//    @Expose
//    private Integer likes;
//    @SerializedName("videoSId")
//    @Expose
//    private Integer videoSId;
//
//
//    public String getKeyword() {
//        return keyword;
//    }
//
//    public void setKeyword(String keyword) {
//        this.keyword = keyword;
//    }
//
//    public Search(String keyword) {
//        this.keyword = keyword;
//    }
//
//    public Object getDuration() {
//        return duration;
//    }
//
//    public void setDuration(Object duration) {
//        this.duration = duration;
//    }
//
//    public Object getSize() {
//        return size;
//    }
//
//    public void setSize(Object size) {
//        this.size = size;
//    }
//
//    public Integer getWatchTime() {
//        return watchTime;
//    }
//
//    public void setWatchTime(Integer watchTime) {
//        this.watchTime = watchTime;
//    }
//
//    public Object getWatchtimes() {
//        return watchtimes;
//    }
//
//    public void setWatchtimes(Object watchtimes) {
//        this.watchtimes = watchtimes;
//    }
//
//    public String getVideoChannelImage() {
//        return videoChannelImage;
//    }
//
//    public void setVideoChannelImage(String videoChannelImage) {
//        this.videoChannelImage = videoChannelImage;
//    }
//
//    public Integer getDislikes() {
//        return dislikes;
//    }
//
//    public void setDislikes(Integer dislikes) {
//        this.dislikes = dislikes;
//    }
//
//    public String getVideoGifPath() {
//        return videoGifPath;
//    }
//
//    public void setVideoGifPath(String videoGifPath) {
//        this.videoGifPath = videoGifPath;
//    }
//
//    public Long getVideoDateadded() {
//        return videoDateadded;
//    }
//
//    public void setVideoDateadded(Long videoDateadded) {
//        this.videoDateadded = videoDateadded;
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
//    public String getVideoTags() {
//        return videoTags;
//    }
//
//    public void setVideoTags(String videoTags) {
//        this.videoTags = videoTags;
//    }
//
//    public String getVideoCategory() {
//        return videoCategory;
//    }
//
//    public void setVideoCategory(String videoCategory) {
//        this.videoCategory = videoCategory;
//    }
//
//    public String getVideoTitle() {
//        return videoTitle;
//    }
//
//    public void setVideoTitle(String videoTitle) {
//        this.videoTitle = videoTitle;
//    }
//
//    public Integer getVideoUserId() {
//        return videoUserId;
//    }
//
//    public void setVideoUserId(Integer videoUserId) {
//        this.videoUserId = videoUserId;
//    }
//
//    public String getVideoDescription() {
//        return videoDescription;
//    }
//
//    public void setVideoDescription(String videoDescription) {
//        this.videoDescription = videoDescription;
//    }
//
//    public String getVideoChannelName() {
//        return videoChannelName;
//    }
//
//    public void setVideoChannelName(String videoChannelName) {
//        this.videoChannelName = videoChannelName;
//    }
//
//    public Integer getVideoChannelId() {
//        return videoChannelId;
//    }
//
//    public void setVideoChannelId(Integer videoChannelId) {
//        this.videoChannelId = videoChannelId;
//    }
//
//    public Integer getViews() {
//        return views;
//    }
//
//    public void setViews(Integer views) {
//        this.views = views;
//    }
//
//    public String getVideoPosterpath() {
//        return videoPosterpath;
//    }
//
//    public void setVideoPosterpath(String videoPosterpath) {
//        this.videoPosterpath = videoPosterpath;
//    }
//
//    public String getVideoFilepath() {
//        return videoFilepath;
//    }
//
//    public void setVideoFilepath(String videoFilepath) {
//        this.videoFilepath = videoFilepath;
//    }
//
//    public Object getSubscribed() {
//        return subscribed;
//    }
//
//    public void setSubscribed(Object subscribed) {
//        this.subscribed = subscribed;
//    }
//
//    public Integer getLikes() {
//        return likes;
//    }
//
//    public void setLikes(Integer likes) {
//        this.likes = likes;
//    }
//
//    public Integer getVideoSId() {
//        return videoSId;
//    }
//
//    public void setVideoSId(Integer videoSId) {
//        this.videoSId = videoSId;
//    }


    @SerializedName("dataType")
    @Expose
    private String dataType;
    @SerializedName("duration")
    @Expose
    private Object duration;
    @SerializedName("size")
    @Expose
    private Object size;
    @SerializedName("watchTime")
    @Expose
    private Integer watchTime;
    @SerializedName("totalcomments")
    @Expose
    private Integer totalcomments;
    @SerializedName("watchtimes")
    @Expose
    private Object watchtimes;
    @SerializedName("channeldynamicid")
    @Expose
    private String channeldynamicid;
    @SerializedName("channeldynamicId")
    @Expose
    private Object channeldynamicId;
    @SerializedName("channelwebsitelink")
    @Expose
    private Object channelwebsitelink;
    @SerializedName("myChannel")
    @Expose
    private Object myChannel;
    @SerializedName("bellicon")
    @Expose
    private Object bellicon;
    @SerializedName("totalviews")
    @Expose
    private Integer totalviews;
    @SerializedName("totalvideos")
    @Expose
    private Integer totalvideos;
    @SerializedName("playListTitle")
    @Expose
    private Object playListTitle;
    @SerializedName("playListStatus")
    @Expose
    private Object playListStatus;
    @SerializedName("playListVisibility")
    @Expose
    private Object playListVisibility;
    @SerializedName("playListProtectedPassword")
    @Expose
    private Object playListProtectedPassword;
    @SerializedName("playListPublish")
    @Expose
    private Object playListPublish;
    @SerializedName("playlistViews")
    @Expose
    private Integer playlistViews;
    @SerializedName("playlistcreateDate")
    @Expose
    private Object playlistcreateDate;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("videoTitle")
    @Expose
    private String videoTitle;
    @SerializedName("channelDescription")
    @Expose
    private Object channelDescription;
    @SerializedName("channelProfileimagepath")
    @Expose
    private Object channelProfileimagepath;
    @SerializedName("channelProfilecoverpath")
    @Expose
    private Object channelProfilecoverpath;
    @SerializedName("channelFacebookAccount")
    @Expose
    private Object channelFacebookAccount;
    @SerializedName("channeltwitterAccount")
    @Expose
    private Object channeltwitterAccount;
    @SerializedName("channelLinkedInAccount")
    @Expose
    private Object channelLinkedInAccount;
    @SerializedName("channelGoogleBussinessAccount")
    @Expose
    private Object channelGoogleBussinessAccount;
    @SerializedName("channelInstagramAccount")
    @Expose
    private Object channelInstagramAccount;
    @SerializedName("subscribers")
    @Expose
    private Integer subscribers;
    @SerializedName("subscribe")
    @Expose
    private Object subscribe;
    @SerializedName("channelDateadded")
    @Expose
    private Object channelDateadded;
    @SerializedName("channelName")
    @Expose
    private Object channelName;
    @SerializedName("channelUserId")
    @Expose
    private Object channelUserId;
    @SerializedName("videoId")
    @Expose
    private String videoId;
    @SerializedName("videoChannelId")
    @Expose
    private Integer videoChannelId;
    @SerializedName("videoUserId")
    @Expose
    private Integer videoUserId;
    @SerializedName("videoDescription")
    @Expose
    private String videoDescription;
    @SerializedName("videoTags")
    @Expose
    private String videoTags;
    @SerializedName("videoCategory")
    @Expose
    private String videoCategory;
    @SerializedName("videoFilepath")
    @Expose
    private String videoFilepath;
    @SerializedName("videoPosterpath")
    @Expose
    private String videoPosterpath;
    @SerializedName("videoDateadded")
    @Expose
    private String videoDateadded;
    @SerializedName("videoGifPath")
    @Expose
    private String videoGifPath;
    @SerializedName("videoChannelName")
    @Expose
    private String videoChannelName;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("dislikes")
    @Expose
    private Integer dislikes;
    @SerializedName("subscribed")
    @Expose
    private Object subscribed;
    @SerializedName("videoChannelImage")
    @Expose
    private String videoChannelImage;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

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

    public String getChanneldynamicid() {
        return channeldynamicid;
    }

    public void setChanneldynamicid(String channeldynamicid) {
        this.channeldynamicid = channeldynamicid;
    }

    public Object getChanneldynamicId() {
        return channeldynamicId;
    }

    public void setChanneldynamicId(Object channeldynamicId) {
        this.channeldynamicId = channeldynamicId;
    }

    public Object getChannelwebsitelink() {
        return channelwebsitelink;
    }

    public void setChannelwebsitelink(Object channelwebsitelink) {
        this.channelwebsitelink = channelwebsitelink;
    }

    public Object getMyChannel() {
        return myChannel;
    }

    public void setMyChannel(Object myChannel) {
        this.myChannel = myChannel;
    }

    public Object getBellicon() {
        return bellicon;
    }

    public void setBellicon(Object bellicon) {
        this.bellicon = bellicon;
    }

    public Integer getTotalviews() {
        return totalviews;
    }

    public void setTotalviews(Integer totalviews) {
        this.totalviews = totalviews;
    }

    public Integer getTotalvideos() {
        return totalvideos;
    }

    public void setTotalvideos(Integer totalvideos) {
        this.totalvideos = totalvideos;
    }

    public Object getPlayListTitle() {
        return playListTitle;
    }

    public void setPlayListTitle(Object playListTitle) {
        this.playListTitle = playListTitle;
    }

    public Object getPlayListStatus() {
        return playListStatus;
    }

    public void setPlayListStatus(Object playListStatus) {
        this.playListStatus = playListStatus;
    }

    public Object getPlayListVisibility() {
        return playListVisibility;
    }

    public void setPlayListVisibility(Object playListVisibility) {
        this.playListVisibility = playListVisibility;
    }

    public Object getPlayListProtectedPassword() {
        return playListProtectedPassword;
    }

    public void setPlayListProtectedPassword(Object playListProtectedPassword) {
        this.playListProtectedPassword = playListProtectedPassword;
    }

    public Object getPlayListPublish() {
        return playListPublish;
    }

    public void setPlayListPublish(Object playListPublish) {
        this.playListPublish = playListPublish;
    }

    public Integer getPlaylistViews() {
        return playlistViews;
    }

    public void setPlaylistViews(Integer playlistViews) {
        this.playlistViews = playlistViews;
    }

    public Object getPlaylistcreateDate() {
        return playlistcreateDate;
    }

    public void setPlaylistcreateDate(Object playlistcreateDate) {
        this.playlistcreateDate = playlistcreateDate;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Object getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(Object channelDescription) {
        this.channelDescription = channelDescription;
    }

    public Object getChannelProfileimagepath() {
        return channelProfileimagepath;
    }

    public void setChannelProfileimagepath(Object channelProfileimagepath) {
        this.channelProfileimagepath = channelProfileimagepath;
    }

    public Object getChannelProfilecoverpath() {
        return channelProfilecoverpath;
    }

    public void setChannelProfilecoverpath(Object channelProfilecoverpath) {
        this.channelProfilecoverpath = channelProfilecoverpath;
    }

    public Object getChannelFacebookAccount() {
        return channelFacebookAccount;
    }

    public void setChannelFacebookAccount(Object channelFacebookAccount) {
        this.channelFacebookAccount = channelFacebookAccount;
    }

    public Object getChanneltwitterAccount() {
        return channeltwitterAccount;
    }

    public void setChanneltwitterAccount(Object channeltwitterAccount) {
        this.channeltwitterAccount = channeltwitterAccount;
    }

    public Object getChannelLinkedInAccount() {
        return channelLinkedInAccount;
    }

    public void setChannelLinkedInAccount(Object channelLinkedInAccount) {
        this.channelLinkedInAccount = channelLinkedInAccount;
    }

    public Object getChannelGoogleBussinessAccount() {
        return channelGoogleBussinessAccount;
    }

    public void setChannelGoogleBussinessAccount(Object channelGoogleBussinessAccount) {
        this.channelGoogleBussinessAccount = channelGoogleBussinessAccount;
    }

    public Object getChannelInstagramAccount() {
        return channelInstagramAccount;
    }

    public void setChannelInstagramAccount(Object channelInstagramAccount) {
        this.channelInstagramAccount = channelInstagramAccount;
    }

    public Integer getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Integer subscribers) {
        this.subscribers = subscribers;
    }

    public Object getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Object subscribe) {
        this.subscribe = subscribe;
    }

    public Object getChannelDateadded() {
        return channelDateadded;
    }

    public void setChannelDateadded(Object channelDateadded) {
        this.channelDateadded = channelDateadded;
    }

    public Object getChannelName() {
        return channelName;
    }

    public void setChannelName(Object channelName) {
        this.channelName = channelName;
    }

    public Object getChannelUserId() {
        return channelUserId;
    }

    public void setChannelUserId(Object channelUserId) {
        this.channelUserId = channelUserId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Integer getVideoChannelId() {
        return videoChannelId;
    }

    public void setVideoChannelId(Integer videoChannelId) {
        this.videoChannelId = videoChannelId;
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

    public String getVideoTags() {
        return videoTags;
    }

    public void setVideoTags(String videoTags) {
        this.videoTags = videoTags;
    }

    public String getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(String videoCategory) {
        this.videoCategory = videoCategory;
    }

    public String getVideoFilepath() {
        return videoFilepath;
    }

    public void setVideoFilepath(String videoFilepath) {
        this.videoFilepath = videoFilepath;
    }

    public String getVideoPosterpath() {
        return videoPosterpath;
    }

    public void setVideoPosterpath(String videoPosterpath) {
        this.videoPosterpath = videoPosterpath;
    }

    public String getVideoDateadded() {
        return videoDateadded;
    }

    public void setVideoDateadded(String videoDateadded) {
        this.videoDateadded = videoDateadded;
    }

    public String getVideoGifPath() {
        return videoGifPath;
    }

    public void setVideoGifPath(String videoGifPath) {
        this.videoGifPath = videoGifPath;
    }

    public String getVideoChannelName() {
        return videoChannelName;
    }

    public void setVideoChannelName(String videoChannelName) {
        this.videoChannelName = videoChannelName;
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

    public Object getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Object subscribed) {
        this.subscribed = subscribed;
    }

    public String getVideoChannelImage() {
        return videoChannelImage;
    }

    public void setVideoChannelImage(String videoChannelImage) {
        this.videoChannelImage = videoChannelImage;
    }

}



