package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrendingMusic {
//
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("musictitle")
//    @Expose
//    private String musictitle;
//    @SerializedName("musicid")
//    @Expose
//    private String musicid;
//    @SerializedName("musicurl")
//    @Expose
//    private String musicurl;
//    @SerializedName("musicposter")
//    @Expose
//    private String musicposter;
//    @SerializedName("language")
//    @Expose
//    private String language;
//    @SerializedName("singers")
//    @Expose
//    private Object singers;
//    @SerializedName("videoid")
//    @Expose
//    private String videoid;
//    @SerializedName("listeners")
//    @Expose
//    private Integer listeners;
//    @SerializedName("musiclike")
//    @Expose
//    private List<Object> musiclike = null;
//    @SerializedName("musicGenres")
//    @Expose
//    private List<Object> musicGenres = null;
//    @SerializedName("musicdateadded")
//    @Expose
//    private Long musicdateadded;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getMusictitle() {
//        return musictitle;
//    }
//
//    public void setMusictitle(String musictitle) {
//        this.musictitle = musictitle;
//    }
//
//    public String getMusicid() {
//        return musicid;
//    }
//
//    public void setMusicid(String musicid) {
//        this.musicid = musicid;
//    }
//
//    public String getMusicurl() {
//        return musicurl;
//    }
//
//    public void setMusicurl(String musicurl) {
//        this.musicurl = musicurl;
//    }
//
//    public String getMusicposter() {
//        return musicposter;
//    }
//
//    public void setMusicposter(String musicposter) {
//        this.musicposter = musicposter;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//    public Object getSingers() {
//        return singers;
//    }
//
//    public void setSingers(Object singers) {
//        this.singers = singers;
//    }
//
//    public String getVideoid() {
//        return videoid;
//    }
//
//    public void setVideoid(String videoid) {
//        this.videoid = videoid;
//    }
//
//    public Integer getListeners() {
//        return listeners;
//    }
//
//    public void setListeners(Integer listeners) {
//        this.listeners = listeners;
//    }
//
//    public List<Object> getMusiclike() {
//        return musiclike;
//    }
//
//    public void setMusiclike(List<Object> musiclike) {
//        this.musiclike = musiclike;
//    }
//
//    public List<Object> getMusicGenres() {
//        return musicGenres;
//    }
//
//    public void setMusicGenres(List<Object> musicGenres) {
//        this.musicGenres = musicGenres;
//    }
//
//    public Long getMusicdateadded() {
//        return musicdateadded;
//    }
//
//    public void setMusicdateadded(Long musicdateadded) {
//        this.musicdateadded = musicdateadded;
//    }
@SerializedName("id")
@Expose
private Integer id;
    @SerializedName("songTitle")
    @Expose
    private String songTitle;
    @SerializedName("singer")
    @Expose
    private List<Object> singer = null;
    @SerializedName("actors")
    @Expose
    private List<Object> actors = null;
    @SerializedName("genres")
    @Expose
    private Object genres;
    @SerializedName("composer")
    @Expose
    private String composer;
    @SerializedName("fluntooVideoUrl")
    @Expose
    private String fluntooVideoUrl;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("lyrics")
    @Expose
    private String lyrics;
    @SerializedName("songFile")
    @Expose
    private String songFile;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("companyId")
    @Expose
    private Integer companyId;
    @SerializedName("musicDateadded")
    @Expose
    private Long musicDateadded;
    @SerializedName("newVistor")
    @Expose
    private Object newVistor;
    @SerializedName("returnVisitor")
    @Expose
    private Object returnVisitor;
    @SerializedName("totalVisitor")
    @Expose
    private Object totalVisitor;
    @SerializedName("views")
    @Expose
    private Integer views;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public List<Object> getSinger() {
        return singer;
    }

    public void setSinger(List<Object> singer) {
        this.singer = singer;
    }

    public List<Object> getActors() {
        return actors;
    }

    public void setActors(List<Object> actors) {
        this.actors = actors;
    }

    public Object getGenres() {
        return genres;
    }

    public void setGenres(Object genres) {
        this.genres = genres;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getFluntooVideoUrl() {
        return fluntooVideoUrl;
    }

    public void setFluntooVideoUrl(String fluntooVideoUrl) {
        this.fluntooVideoUrl = fluntooVideoUrl;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getSongFile() {
        return songFile;
    }

    public void setSongFile(String songFile) {
        this.songFile = songFile;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Long getMusicDateadded() {
        return musicDateadded;
    }

    public void setMusicDateadded(Long musicDateadded) {
        this.musicDateadded = musicDateadded;
    }

    public Object getNewVistor() {
        return newVistor;
    }

    public void setNewVistor(Object newVistor) {
        this.newVistor = newVistor;
    }

    public Object getReturnVisitor() {
        return returnVisitor;
    }

    public void setReturnVisitor(Object returnVisitor) {
        this.returnVisitor = returnVisitor;
    }

    public Object getTotalVisitor() {
        return totalVisitor;
    }

    public void setTotalVisitor(Object totalVisitor) {
        this.totalVisitor = totalVisitor;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }


}

