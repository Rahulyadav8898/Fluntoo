package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlixGenres {

    @SerializedName("genresName")
    @Expose
    private String genresName;
    @SerializedName("genresSlug")
    @Expose
    private String genresSlug;
    @SerializedName("genresParent")
    @Expose
    private String genresParent;
    @SerializedName("genresDescription")
    @Expose
    private String genresDescription;
    @SerializedName("genresThumbnail")
    @Expose
    private String genresThumbnail;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getGenresName() {
        return genresName;
    }

    public void setGenresName(String genresName) {
        this.genresName = genresName;
    }

    public String getGenresSlug() {
        return genresSlug;
    }

    public void setGenresSlug(String genresSlug) {
        this.genresSlug = genresSlug;
    }

    public String getGenresParent() {
        return genresParent;
    }

    public void setGenresParent(String genresParent) {
        this.genresParent = genresParent;
    }

    public String getGenresDescription() {
        return genresDescription;
    }

    public void setGenresDescription(String genresDescription) {
        this.genresDescription = genresDescription;
    }

    public String getGenresThumbnail() {
        return genresThumbnail;
    }

    public void setGenresThumbnail(String genresThumbnail) {
        this.genresThumbnail = genresThumbnail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FlixGenres{" +
                "genresName='" + genresName + '\'' +
                ", genresSlug='" + genresSlug + '\'' +
                ", genresParent='" + genresParent + '\'' +
                ", genresDescription='" + genresDescription + '\'' +
                ", genresThumbnail='" + genresThumbnail + '\'' +
                ", id=" + id +
                '}';
    }
}
