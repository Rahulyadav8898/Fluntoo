package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LatestMusic {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("musictitle")
    @Expose
    private String musictitle;
    @SerializedName("musicid")
    @Expose
    private String musicid;
    @SerializedName("musicurl")
    @Expose
    private String musicurl;
    @SerializedName("musicposter")
    @Expose
    private String musicposter;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("singers")
    @Expose
    private Object singers;
    @SerializedName("videoid")
    @Expose
    private String videoid;
    @SerializedName("listeners")
    @Expose
    private Integer listeners;
    @SerializedName("musiclike")
    @Expose
    private List<Object> musiclike = null;
    @SerializedName("musicGenres")
    @Expose
    private List<Object> musicGenres = null;
    @SerializedName("musicdateadded")
    @Expose
    private Long musicdateadded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusictitle() {
        return musictitle;
    }

    public void setMusictitle(String musictitle) {
        this.musictitle = musictitle;
    }

    public String getMusicid() {
        return musicid;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    public String getMusicposter() {
        return musicposter;
    }

    public void setMusicposter(String musicposter) {
        this.musicposter = musicposter;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Object getSingers() {
        return singers;
    }

    public void setSingers(Object singers) {
        this.singers = singers;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public Integer getListeners() {
        return listeners;
    }

    public void setListeners(Integer listeners) {
        this.listeners = listeners;
    }

    public List<Object> getMusiclike() {
        return musiclike;
    }

    public void setMusiclike(List<Object> musiclike) {
        this.musiclike = musiclike;
    }

    public List<Object> getMusicGenres() {
        return musicGenres;
    }

    public void setMusicGenres(List<Object> musicGenres) {
        this.musicGenres = musicGenres;
    }

    public Long getMusicdateadded() {
        return musicdateadded;
    }

    public void setMusicdateadded(Long musicdateadded) {
        this.musicdateadded = musicdateadded;
    }
}
