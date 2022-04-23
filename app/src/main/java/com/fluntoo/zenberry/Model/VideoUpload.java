package com.fluntoo.zenberry.Model;

public class VideoUpload {
    String VideoTitle;
    String VideoDescription;
    String VideoTags;
    String VideoCategory;
    String VideoFile;
    String VideoPoster;
//    String languages;
//    String Videopath;
//    String uid;
//    String private;
//    String kids;




    public VideoUpload(String videoTitle, String videoDescription, String videoTags, String videoCategory, String videoFile, String videoPoster) {
        VideoTitle = videoTitle;
        VideoDescription = videoDescription;
        VideoTags = videoTags;
        VideoCategory = videoCategory;
        VideoFile = videoFile;
        VideoPoster = videoPoster;
    }

    public String getVideoTitle() {
        return VideoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        VideoTitle = videoTitle;
    }

    public String getVideoDescription() {
        return VideoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        VideoDescription = videoDescription;
    }

    public String getVideoTags() {
        return VideoTags;
    }

    public void setVideoTags(String videoTags) {
        VideoTags = videoTags;
    }

    public String getVideoCategory() {
        return VideoCategory;
    }

    public void setVideoCategory(String videoCategory) {
        VideoCategory = videoCategory;
    }

    public String getVideoFile() {
        return VideoFile;
    }

    public void setVideoFile(String videoFile) {
        VideoFile = videoFile;
    }

    public String getVideoPoster() {
        return VideoPoster;
    }

    public void setVideoPoster(String videoPoster) {
        VideoPoster = videoPoster;
    }
}
