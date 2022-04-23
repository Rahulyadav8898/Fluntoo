package com.fluntoo.zenberry.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class Video implements Parcelable {

    @SerializedName("watchTime")
    @Expose
    private Integer watchTime;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("videoTags")
    @Expose
    private String videoTags;
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
    @SerializedName("videoFilepath")
    @Expose
    private String videoFilepath;
    @SerializedName("videoGifPath")
    @Expose
    private String videoGifPath;
    @SerializedName("videoCategory")
    @Expose
    private String videoCategory;
    @SerializedName("dislikes")
    @Expose
    private Integer dislikes;
    @SerializedName("videoId")
    @Expose
    private String videoId;
    @SerializedName("subscribed")
    @Expose
    private Object subscribed;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("videoDateadded")
    @Expose
    private Long videoDateadded;
    @SerializedName("videoTitle")
    @Expose
    private String videoTitle;
    @SerializedName("videoUserId")
    @Expose
    private Integer videoUserId;
    @SerializedName("videoSId")
    @Expose
    private Integer videoSId;

    protected Video(Parcel in) {
        if (in.readByte() == 0) {
            watchTime = null;
        } else {
            watchTime = in.readInt();
        }
        if (in.readByte() == 0) {
            views = null;
        } else {
            views = in.readInt();
        }
        videoTags = in.readString();
        videoDescription = in.readString();
        videoChannelName = in.readString();
        if (in.readByte() == 0) {
            videoChannelId = null;
        } else {
            videoChannelId = in.readInt();
        }
        videoChannelImage = in.readString();
        videoPosterpath = in.readString();
        videoFilepath = in.readString();
        videoGifPath = in.readString();
        videoCategory = in.readString();
        if (in.readByte() == 0) {
            dislikes = null;
        } else {
            dislikes = in.readInt();
        }
        videoId = in.readString();
        if (in.readByte() == 0) {
            likes = null;
        } else {
            likes = in.readInt();
        }
        if (in.readByte() == 0) {
            videoDateadded = null;
        } else {
            videoDateadded = in.readLong();
        }
        videoTitle = in.readString();
        if (in.readByte() == 0) {
            videoUserId = null;
        } else {
            videoUserId = in.readInt();
        }
        if (in.readByte() == 0) {
            videoSId = null;
        } else {
            videoSId = in.readInt();
        }
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public Integer getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(Integer watchTime) {
        this.watchTime = watchTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getVideoTags() {
        return videoTags;
    }

    public void setVideoTags(String videoTags) {
        this.videoTags = videoTags;
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

    public String getVideoFilepath() {
        return videoFilepath;
    }

    public void setVideoFilepath(String videoFilepath) {
        this.videoFilepath = videoFilepath;
    }

    public String getVideoGifPath() {
        return videoGifPath;
    }

    public void setVideoGifPath(String videoGifPath) {
        this.videoGifPath = videoGifPath;
    }

    public String getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(String videoCategory) {
        this.videoCategory = videoCategory;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Long getVideoDateadded() {
        return videoDateadded;
    }

    public void setVideoDateadded(Long videoDateadded) {
        this.videoDateadded = videoDateadded;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Integer getVideoUserId() {
        return videoUserId;
    }

    public void setVideoUserId(Integer videoUserId) {
        this.videoUserId = videoUserId;
    }

    public Integer getVideoSId() {
        return videoSId;
    }

    @Override
    public String toString() {
        return "Video{" +
                "watchTime=" + watchTime +
                ", views=" + views +
                ", videoTags='" + videoTags + '\'' +
                ", videoDescription='" + videoDescription + '\'' +
                ", videoChannelName='" + videoChannelName + '\'' +
                ", videoChannelId=" + videoChannelId +
                ", videoChannelImage='" + videoChannelImage + '\'' +
                ", videoPosterpath='" + videoPosterpath + '\'' +
                ", videoFilepath='" + videoFilepath + '\'' +
                ", videoGifPath='" + videoGifPath + '\'' +
                ", videoCategory='" + videoCategory + '\'' +
                ", dislikes=" + dislikes +
                ", videoId='" + videoId + '\'' +
                ", subscribed=" + subscribed +
                ", likes=" + likes +
                ", videoDateadded=" + videoDateadded +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoUserId=" + videoUserId +
                ", videoSId=" + videoSId +
                '}';
    }

    public void setVideoSId(Integer videoSId) {
        this.videoSId = videoSId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (watchTime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(watchTime);
        }
        if (views == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(views);
        }
        dest.writeString(videoTags);
        dest.writeString(videoDescription);
        dest.writeString(videoChannelName);
        if (videoChannelId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(videoChannelId);
        }
        dest.writeString(videoChannelImage);
        dest.writeString(videoPosterpath);
        dest.writeString(videoFilepath);
        dest.writeString(videoGifPath);
        dest.writeString(videoCategory);
        if (dislikes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dislikes);
        }
        dest.writeString(videoId);
        if (likes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(likes);
        }
        if (videoDateadded == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(videoDateadded);
        }
        dest.writeString(videoTitle);
        if (videoUserId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(videoUserId);
        }
        if (videoSId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(videoSId);
        }
    }
}
