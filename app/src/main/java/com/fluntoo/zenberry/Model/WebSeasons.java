package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WebSeasons {

    @SerializedName("seasonName")
    @Expose
    private String seasonName;
    @SerializedName("seasonImage")
    @Expose
    private String seasonImage;
    @SerializedName("seasonEpisodes")
    @Expose
    private List<String> seasonEpisodes = null;
    @SerializedName("seasonYear")
    @Expose
    private Integer seasonYear;
    @SerializedName("seasonDescription")
    @Expose
    private String seasonDescription;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonImage() {
        return seasonImage;
    }

    public void setSeasonImage(String seasonImage) {
        this.seasonImage = seasonImage;
    }

    public List<String> getSeasonEpisodes() {
        return seasonEpisodes;
    }

    public void setSeasonEpisodes(List<String> seasonEpisodes) {
        this.seasonEpisodes = seasonEpisodes;
    }

    public Integer getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(Integer seasonYear) {
        this.seasonYear = seasonYear;
    }

    public String getSeasonDescription() {
        return seasonDescription;
    }

    public void setSeasonDescription(String seasonDescription) {
        this.seasonDescription = seasonDescription;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
