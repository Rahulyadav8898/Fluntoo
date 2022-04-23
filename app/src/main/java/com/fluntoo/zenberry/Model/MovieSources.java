package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieSources {

    @SerializedName("sourceName")
    @Expose
    private String sourceName;
    @SerializedName("sourceMethod")
    @Expose
    private String sourceMethod;
    @SerializedName("sourceEmbedMovie")
    @Expose
    private String sourceEmbedMovie;
    @SerializedName("sourceQuality")
    @Expose
    private String sourceQuality;
    @SerializedName("sourceLanguage")
    @Expose
    private String sourceLanguage;
    @SerializedName("sourcePlayer")
    @Expose
    private String sourcePlayer;
    @SerializedName("sourceDate")
    @Expose
    private Object sourceDate;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceMethod() {
        return sourceMethod;
    }

    public void setSourceMethod(String sourceMethod) {
        this.sourceMethod = sourceMethod;
    }

    public String getSourceEmbedMovie() {
        return sourceEmbedMovie;
    }

    public void setSourceEmbedMovie(String sourceEmbedMovie) {
        this.sourceEmbedMovie = sourceEmbedMovie;
    }

    public String getSourceQuality() {
        return sourceQuality;
    }

    public void setSourceQuality(String sourceQuality) {
        this.sourceQuality = sourceQuality;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public String getSourcePlayer() {
        return sourcePlayer;
    }

    public void setSourcePlayer(String sourcePlayer) {
        this.sourcePlayer = sourcePlayer;
    }

    public Object getSourceDate() {
        return sourceDate;
    }

    public void setSourceDate(Object sourceDate) {
        this.sourceDate = sourceDate;
    }

    @Override
    public String toString() {
        return "MovieSources{" +
                "sourceName='" + sourceName + '\'' +
                ", sourceMethod='" + sourceMethod + '\'' +
                ", sourceEmbedMovie='" + sourceEmbedMovie + '\'' +
                ", sourceQuality='" + sourceQuality + '\'' +
                ", sourceLanguage='" + sourceLanguage + '\'' +
                ", sourcePlayer='" + sourcePlayer + '\'' +
                ", sourceDate=" + sourceDate +
                '}';
    }
}

