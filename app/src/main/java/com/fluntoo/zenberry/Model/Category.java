package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {


//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("slug")
//    @Expose
//    private String slug;
//    @SerializedName("parrentCategory")
//    @Expose
//    private String parrentCategory;
//    @SerializedName("description")
//    @Expose
//    private String description;
//    @SerializedName("image")
//    @Expose
//    private String image;
//    @SerializedName("video")
//    @Expose
//    private List<Video> video = null;
//    @SerializedName("count")
//    @Expose
//    private Integer count;
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSlug() {
//        return slug;
//    }
//
//    public void setSlug(String slug) {
//        this.slug = slug;
//    }
//
//    public String getParrentCategory() {
//        return parrentCategory;
//    }
//
//    public void setParrentCategory(String parrentCategory) {
//        this.parrentCategory = parrentCategory;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public List<Video> getVideo() {
//        return video;
//    }
//
//    public void setVideo(List<Video> video) {
//        this.video = video;
//    }
//
//    public Integer getCount() {
//        return count;
//    }
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    @Override
//    public String toString() {
//        return "Category{" +
//                "name='" + name + '\'' +
//                ", slug='" + slug + '\'' +
//                ", parrentCategory='" + parrentCategory + '\'' +
//                ", description='" + description + '\'' +
//                ", image='" + image + '\'' +
//                ", video=" + video +
//                ", count=" + count +
//                ", id=" + id +
//                '}';
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("parrentCategory")
    @Expose
    private String parrentCategory;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("video")
    @Expose
    private List<Video> video = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getParrentCategory() {
        return parrentCategory;
    }

    public void setParrentCategory(String parrentCategory) {
        this.parrentCategory = parrentCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }



public class Video {

    @SerializedName("videoSId")
    @Expose
    private Integer videoSId;
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
    private Object videosrtPath;
    @SerializedName("live")
    @Expose
    private Boolean live;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("complain")
    @Expose
    private Object complain;
    @SerializedName("ipaddress")
    @Expose
    private Object ipaddress;
    @SerializedName("videoprivate")
    @Expose
    private Boolean videoprivate;
    @SerializedName("livevideo")
    @Expose
    private Boolean livevideo;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("videoDescription")
    @Expose
    private String videoDescription;
    @SerializedName("videoChannelName")
    @Expose
    private String videoChannelName;
    @SerializedName("videoDateadded")
    @Expose
    private String videoDateadded;
    @SerializedName("videoChannelId")
    @Expose
    private Integer videoChannelId;
    @SerializedName("videoChannelImage")
    @Expose
    private String videoChannelImage;
    @SerializedName("videoUserId")
    @Expose
    private Integer videoUserId;
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
    private Object subscribed;
    @SerializedName("videoCategory")
    @Expose
    private String videoCategory;
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

    public Integer getVideoSId() {
        return videoSId;
    }

    public void setVideoSId(Integer videoSId) {
        this.videoSId = videoSId;
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

    public Object getVideosrtPath() {
        return videosrtPath;
    }

    public void setVideosrtPath(Object videosrtPath) {
        this.videosrtPath = videosrtPath;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getComplain() {
        return complain;
    }

    public void setComplain(Object complain) {
        this.complain = complain;
    }

    public Object getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(Object ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Boolean getVideoprivate() {
        return videoprivate;
    }

    public void setVideoprivate(Boolean videoprivate) {
        this.videoprivate = videoprivate;
    }

    public Boolean getLivevideo() {
        return livevideo;
    }

    public void setLivevideo(Boolean livevideo) {
        this.livevideo = livevideo;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
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

    public String getVideoDateadded() {
        return videoDateadded;
    }

    public void setVideoDateadded(String videoDateadded) {
        this.videoDateadded = videoDateadded;
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

    public Integer getVideoUserId() {
        return videoUserId;
    }

    public void setVideoUserId(Integer videoUserId) {
        this.videoUserId = videoUserId;
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

    public Object getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Object subscribed) {
        this.subscribed = subscribed;
    }

    public String getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(String videoCategory) {
        this.videoCategory = videoCategory;
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
}





