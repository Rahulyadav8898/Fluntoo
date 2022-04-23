package com.fluntoo.zenberry.Model;

public class CreatePlaylist {
    String PlaylistTitle;
    String PlaylistDescription;
    String PlaylistCategory;
    String ChannelName;
    String VideoList;
    String PlaylistVideoPoster;
    String PlaylistTags;

    public CreatePlaylist(String playlistTitle, String playlistDescription, String playlistCategory, String channelName, String videoList, String playlistVideoPoster, String playlistTags) {
        PlaylistTitle = playlistTitle;
        PlaylistDescription = playlistDescription;
        PlaylistCategory = playlistCategory;
        ChannelName = channelName;
        VideoList = videoList;
        PlaylistVideoPoster = playlistVideoPoster;
        PlaylistTags = playlistTags;
    }

    public String getPlaylistTitle() {
        return PlaylistTitle;
    }

    public void setPlaylistTitle(String playlistTitle) {
        PlaylistTitle = playlistTitle;
    }

    public String getPlaylistDescription() {
        return PlaylistDescription;
    }

    public void setPlaylistDescription(String playlistDescription) {
        PlaylistDescription = playlistDescription;
    }

    public String getPlaylistCategory() {
        return PlaylistCategory;
    }

    public void setPlaylistCategory(String playlistCategory) {
        PlaylistCategory = playlistCategory;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }

    public String getVideoList() {
        return VideoList;
    }

    public void setVideoList(String videoList) {
        VideoList = videoList;
    }

    public String getPlaylistVideoPoster() {
        return PlaylistVideoPoster;
    }

    public void setPlaylistVideoPoster(String playlistVideoPoster) {
        PlaylistVideoPoster = playlistVideoPoster;
    }

    public String getPlaylistTags() {
        return PlaylistTags;
    }

    public void setPlaylistTags(String playlistTags) {
        PlaylistTags = playlistTags;
    }
}
