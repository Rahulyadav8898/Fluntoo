package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WebEpisodes {
//    @SerializedName("webSeriesTitle")
//    @Expose
//    private String webSeriesTitle;
//    @SerializedName("episodeName")
//    @Expose
//    private String episodeName;
//    @SerializedName("webSeriesLogo")
//    @Expose
//    private String webSeriesLogo;
//    @SerializedName("webSeriesTrailer")
//    @Expose
//    private String webSeriesTrailer;
//    @SerializedName("webSeriesUpcoming")
//    @Expose
//    private Boolean webSeriesUpcoming;
//    @SerializedName("webSeriesIMDBRating")
//    @Expose
//    private String webSeriesIMDBRating;
//    @SerializedName("webSeriesEpisodeNumber")
//    @Expose
//    private String webSeriesEpisodeNumber;
//    @SerializedName("webSeriesEpisodeMethod")
//    @Expose
//    private String webSeriesEpisodeMethod;
//    @SerializedName("webSeriesUploadVideo")
//    @Expose
//    private String webSeriesUploadVideo;
//    @SerializedName("webSeriesReleaseDate")
//    @Expose
//    private String webSeriesReleaseDate;
//    @SerializedName("webSeriesDuration")
//    @Expose
//    private String webSeriesDuration;
//    @SerializedName("webSeriesIMDBID")
//    @Expose
//    private String webSeriesIMDBID;
//    @SerializedName("webSeriesTMDBID")
//    @Expose
//    private String webSeriesTMDBID;
//    @SerializedName("webSeriesCatlogVisibility")
//    @Expose
//    private String webSeriesCatlogVisibility;
//    @SerializedName("webSeriesEpisodeUrl")
//    @Expose
//    private String webSeriesEpisodeUrl;
//    @SerializedName("webSeriesFeatured")
//    @Expose
//    private Boolean webSeriesFeatured;
//    @SerializedName("webSeriesSources")
//    @Expose
//    private Object webSeriesSources;
//    @SerializedName("webSeriesRestrication")
//    @Expose
//    private String webSeriesRestrication;
//    @SerializedName("webSeriesDisplayForLoggedUser")
//    @Expose
//    private Boolean webSeriesDisplayForLoggedUser;
//    @SerializedName("webSeriesEnableCustomMessage")
//    @Expose
//    private Boolean webSeriesEnableCustomMessage;
//    @SerializedName("webSerieMessageForLoggedOutUser")
//    @Expose
//    private String webSerieMessageForLoggedOutUser;
//    @SerializedName("webSerieMessageForLoggedOutUserMedia")
//    @Expose
//    private String webSerieMessageForLoggedOutUserMedia;
//    @SerializedName("webSerieMessageForLoggedInNonMembera")
//    @Expose
//    private Object webSerieMessageForLoggedInNonMembera;
//    @SerializedName("webSerieMessageForLoggedInNonMemberaMedia")
//    @Expose
//    private String webSerieMessageForLoggedInNonMemberaMedia;
//    @SerializedName("webSeriesEnableCustomRedirectUrl")
//    @Expose
//    private Boolean webSeriesEnableCustomRedirectUrl;
//    @SerializedName("webSeriesCustomRedirectUrl")
//    @Expose
//    private Object webSeriesCustomRedirectUrl;
//    @SerializedName("webSeriesCustomNonMemberRedirectUrl")
//    @Expose
//    private Object webSeriesCustomNonMemberRedirectUrl;
//    @SerializedName("webSeriesDescription")
//    @Expose
//    private Object webSeriesDescription;
//    @SerializedName("webSeriesDescriptionMedia")
//    @Expose
//    private String webSeriesDescriptionMedia;
//    @SerializedName("episodeVisibility")
//    @Expose
//    private Object episodeVisibility;
//    @SerializedName("episodeVisibilityPassword")
//    @Expose
//    private Object episodeVisibilityPassword;
//    @SerializedName("episodePublish")
//    @Expose
//    private Object episodePublish;
//    @SerializedName("episodePendingReview")
//    @Expose
//    private Boolean episodePendingReview;
//    @SerializedName("episodeSlug")
//    @Expose
//    private Object episodeSlug;
//    @SerializedName("episodeImage")
//    @Expose
//    private String episodeImage;
//    @SerializedName("episodeExcerpt")
//    @Expose
//    private Object episodeExcerpt;
//    @SerializedName("userId")
//    @Expose
//    private Integer userId;
//    @SerializedName("episodeAllowComments")
//    @Expose
//    private Boolean episodeAllowComments;
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//
//    public String getWebSeriesTitle() {
//        return webSeriesTitle;
//    }
//
//    public void setWebSeriesTitle(String webSeriesTitle) {
//        this.webSeriesTitle = webSeriesTitle;
//    }
//
//    public String getEpisodeName() {
//        return episodeName;
//    }
//
//    public void setEpisodeName(String episodeName) {
//        this.episodeName = episodeName;
//    }
//
//    public String getWebSeriesLogo() {
//        return webSeriesLogo;
//    }
//
//    public void setWebSeriesLogo(String webSeriesLogo) {
//        this.webSeriesLogo = webSeriesLogo;
//    }
//
//    public String getWebSeriesTrailer() {
//        return webSeriesTrailer;
//    }
//
//    public void setWebSeriesTrailer(String webSeriesTrailer) {
//        this.webSeriesTrailer = webSeriesTrailer;
//    }
//
//    public Boolean getWebSeriesUpcoming() {
//        return webSeriesUpcoming;
//    }
//
//    public void setWebSeriesUpcoming(Boolean webSeriesUpcoming) {
//        this.webSeriesUpcoming = webSeriesUpcoming;
//    }
//
//    public String getWebSeriesIMDBRating() {
//        return webSeriesIMDBRating;
//    }
//
//    public void setWebSeriesIMDBRating(String webSeriesIMDBRating) {
//        this.webSeriesIMDBRating = webSeriesIMDBRating;
//    }
//
//    public String getWebSeriesEpisodeNumber() {
//        return webSeriesEpisodeNumber;
//    }
//
//    public void setWebSeriesEpisodeNumber(String webSeriesEpisodeNumber) {
//        this.webSeriesEpisodeNumber = webSeriesEpisodeNumber;
//    }
//
//    public String getWebSeriesEpisodeMethod() {
//        return webSeriesEpisodeMethod;
//    }
//
//    public void setWebSeriesEpisodeMethod(String webSeriesEpisodeMethod) {
//        this.webSeriesEpisodeMethod = webSeriesEpisodeMethod;
//    }
//
//    public String getWebSeriesUploadVideo() {
//        return webSeriesUploadVideo;
//    }
//
//    public void setWebSeriesUploadVideo(String webSeriesUploadVideo) {
//        this.webSeriesUploadVideo = webSeriesUploadVideo;
//    }
//
//    public String getWebSeriesReleaseDate() {
//        return webSeriesReleaseDate;
//    }
//
//    public void setWebSeriesReleaseDate(String webSeriesReleaseDate) {
//        this.webSeriesReleaseDate = webSeriesReleaseDate;
//    }
//
//    public String getWebSeriesDuration() {
//        return webSeriesDuration;
//    }
//
//    public void setWebSeriesDuration(String webSeriesDuration) {
//        this.webSeriesDuration = webSeriesDuration;
//    }
//
//    public String getWebSeriesIMDBID() {
//        return webSeriesIMDBID;
//    }
//
//    public void setWebSeriesIMDBID(String webSeriesIMDBID) {
//        this.webSeriesIMDBID = webSeriesIMDBID;
//    }
//
//    public String getWebSeriesTMDBID() {
//        return webSeriesTMDBID;
//    }
//
//    public void setWebSeriesTMDBID(String webSeriesTMDBID) {
//        this.webSeriesTMDBID = webSeriesTMDBID;
//    }
//
//    public String getWebSeriesCatlogVisibility() {
//        return webSeriesCatlogVisibility;
//    }
//
//    public void setWebSeriesCatlogVisibility(String webSeriesCatlogVisibility) {
//        this.webSeriesCatlogVisibility = webSeriesCatlogVisibility;
//    }
//
//    public String getWebSeriesEpisodeUrl() {
//        return webSeriesEpisodeUrl;
//    }
//
//    public void setWebSeriesEpisodeUrl(String webSeriesEpisodeUrl) {
//        this.webSeriesEpisodeUrl = webSeriesEpisodeUrl;
//    }
//
//    public Boolean getWebSeriesFeatured() {
//        return webSeriesFeatured;
//    }
//
//    public void setWebSeriesFeatured(Boolean webSeriesFeatured) {
//        this.webSeriesFeatured = webSeriesFeatured;
//    }
//
//    public Object getWebSeriesSources() {
//        return webSeriesSources;
//    }
//
//    public void setWebSeriesSources(Object webSeriesSources) {
//        this.webSeriesSources = webSeriesSources;
//    }
//
//    public String getWebSeriesRestrication() {
//        return webSeriesRestrication;
//    }
//
//    public void setWebSeriesRestrication(String webSeriesRestrication) {
//        this.webSeriesRestrication = webSeriesRestrication;
//    }
//
//    public Boolean getWebSeriesDisplayForLoggedUser() {
//        return webSeriesDisplayForLoggedUser;
//    }
//
//    public void setWebSeriesDisplayForLoggedUser(Boolean webSeriesDisplayForLoggedUser) {
//        this.webSeriesDisplayForLoggedUser = webSeriesDisplayForLoggedUser;
//    }
//
//    public Boolean getWebSeriesEnableCustomMessage() {
//        return webSeriesEnableCustomMessage;
//    }
//
//    public void setWebSeriesEnableCustomMessage(Boolean webSeriesEnableCustomMessage) {
//        this.webSeriesEnableCustomMessage = webSeriesEnableCustomMessage;
//    }
//
//    public String getWebSerieMessageForLoggedOutUser() {
//        return webSerieMessageForLoggedOutUser;
//    }
//
//    public void setWebSerieMessageForLoggedOutUser(String webSerieMessageForLoggedOutUser) {
//        this.webSerieMessageForLoggedOutUser = webSerieMessageForLoggedOutUser;
//    }
//
//    public String getWebSerieMessageForLoggedOutUserMedia() {
//        return webSerieMessageForLoggedOutUserMedia;
//    }
//
//    public void setWebSerieMessageForLoggedOutUserMedia(String webSerieMessageForLoggedOutUserMedia) {
//        this.webSerieMessageForLoggedOutUserMedia = webSerieMessageForLoggedOutUserMedia;
//    }
//
//    public Object getWebSerieMessageForLoggedInNonMembera() {
//        return webSerieMessageForLoggedInNonMembera;
//    }
//
//    public void setWebSerieMessageForLoggedInNonMembera(Object webSerieMessageForLoggedInNonMembera) {
//        this.webSerieMessageForLoggedInNonMembera = webSerieMessageForLoggedInNonMembera;
//    }
//
//    public String getWebSerieMessageForLoggedInNonMemberaMedia() {
//        return webSerieMessageForLoggedInNonMemberaMedia;
//    }
//
//    public void setWebSerieMessageForLoggedInNonMemberaMedia(String webSerieMessageForLoggedInNonMemberaMedia) {
//        this.webSerieMessageForLoggedInNonMemberaMedia = webSerieMessageForLoggedInNonMemberaMedia;
//    }
//
//    public Boolean getWebSeriesEnableCustomRedirectUrl() {
//        return webSeriesEnableCustomRedirectUrl;
//    }
//
//    public void setWebSeriesEnableCustomRedirectUrl(Boolean webSeriesEnableCustomRedirectUrl) {
//        this.webSeriesEnableCustomRedirectUrl = webSeriesEnableCustomRedirectUrl;
//    }
//
//    public Object getWebSeriesCustomRedirectUrl() {
//        return webSeriesCustomRedirectUrl;
//    }
//
//    public void setWebSeriesCustomRedirectUrl(Object webSeriesCustomRedirectUrl) {
//        this.webSeriesCustomRedirectUrl = webSeriesCustomRedirectUrl;
//    }
//
//    public Object getWebSeriesCustomNonMemberRedirectUrl() {
//        return webSeriesCustomNonMemberRedirectUrl;
//    }
//
//    public void setWebSeriesCustomNonMemberRedirectUrl(Object webSeriesCustomNonMemberRedirectUrl) {
//        this.webSeriesCustomNonMemberRedirectUrl = webSeriesCustomNonMemberRedirectUrl;
//    }
//
//    public Object getWebSeriesDescription() {
//        return webSeriesDescription;
//    }
//
//    public void setWebSeriesDescription(Object webSeriesDescription) {
//        this.webSeriesDescription = webSeriesDescription;
//    }
//
//    public String getWebSeriesDescriptionMedia() {
//        return webSeriesDescriptionMedia;
//    }
//
//    public void setWebSeriesDescriptionMedia(String webSeriesDescriptionMedia) {
//        this.webSeriesDescriptionMedia = webSeriesDescriptionMedia;
//    }
//
//    public Object getEpisodeVisibility() {
//        return episodeVisibility;
//    }
//
//    public void setEpisodeVisibility(Object episodeVisibility) {
//        this.episodeVisibility = episodeVisibility;
//    }
//
//    public Object getEpisodeVisibilityPassword() {
//        return episodeVisibilityPassword;
//    }
//
//    public void setEpisodeVisibilityPassword(Object episodeVisibilityPassword) {
//        this.episodeVisibilityPassword = episodeVisibilityPassword;
//    }
//
//    public Object getEpisodePublish() {
//        return episodePublish;
//    }
//
//    public void setEpisodePublish(Object episodePublish) {
//        this.episodePublish = episodePublish;
//    }
//
//    public Boolean getEpisodePendingReview() {
//        return episodePendingReview;
//    }
//
//    public void setEpisodePendingReview(Boolean episodePendingReview) {
//        this.episodePendingReview = episodePendingReview;
//    }
//
//    public Object getEpisodeSlug() {
//        return episodeSlug;
//    }
//
//    public void setEpisodeSlug(Object episodeSlug) {
//        this.episodeSlug = episodeSlug;
//    }
//
//    public String getEpisodeImage() {
//        return episodeImage;
//    }
//
//    public void setEpisodeImage(String episodeImage) {
//        this.episodeImage = episodeImage;
//    }
//
//    public Object getEpisodeExcerpt() {
//        return episodeExcerpt;
//    }
//
//    public void setEpisodeExcerpt(Object episodeExcerpt) {
//        this.episodeExcerpt = episodeExcerpt;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Boolean getEpisodeAllowComments() {
//        return episodeAllowComments;
//    }
//
//    public void setEpisodeAllowComments(Boolean episodeAllowComments) {
//        this.episodeAllowComments = episodeAllowComments;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("webSeriesTitle")
    @Expose
    private String webSeriesTitle;
    @SerializedName("episodeName")
    @Expose
    private String episodeName;
    @SerializedName("webSeriesLogo")
    @Expose
    private Object webSeriesLogo;
    @SerializedName("webSeriesTrailer")
    @Expose
    private Object webSeriesTrailer;
    @SerializedName("webSeriesUpcoming")
    @Expose
    private Boolean webSeriesUpcoming;
    @SerializedName("webSeriesIMDBRating")
    @Expose
    private Object webSeriesIMDBRating;
    @SerializedName("webSeriesEpisodeNumber")
    @Expose
    private String webSeriesEpisodeNumber;
    @SerializedName("webSeriesEpisodeMethod")
    @Expose
    private Object webSeriesEpisodeMethod;
    @SerializedName("webSeriesUploadVideo")
    @Expose
    private String webSeriesUploadVideo;
    @SerializedName("webSeriesReleaseDate")
    @Expose
    private Object webSeriesReleaseDate;
    @SerializedName("webSeriesDuration")
    @Expose
    private Object webSeriesDuration;
    @SerializedName("webSeriesIMDBID")
    @Expose
    private Object webSeriesIMDBID;
    @SerializedName("webSeriesTMDBID")
    @Expose
    private Object webSeriesTMDBID;
    @SerializedName("webSeriesCatlogVisibility")
    @Expose
    private Object webSeriesCatlogVisibility;
    @SerializedName("webSeriesEpisodeUrl")
    @Expose
    private String webSeriesEpisodeUrl;
    @SerializedName("webSeriesFeatured")
    @Expose
    private Boolean webSeriesFeatured;
    @SerializedName("webSeriesSources")
    @Expose
    private Object webSeriesSources;
    @SerializedName("webSeriesRestrication")
    @Expose
    private Object webSeriesRestrication;
    @SerializedName("webSeriesDisplayForLoggedUser")
    @Expose
    private Boolean webSeriesDisplayForLoggedUser;
    @SerializedName("webSeriesEnableCustomMessage")
    @Expose
    private Boolean webSeriesEnableCustomMessage;
    @SerializedName("webSerieMessageForLoggedOutUser")
    @Expose
    private Object webSerieMessageForLoggedOutUser;
    @SerializedName("webSerieMessageForLoggedOutUserMedia")
    @Expose
    private Object webSerieMessageForLoggedOutUserMedia;
    @SerializedName("webSerieMessageForLoggedInNonMembera")
    @Expose
    private Object webSerieMessageForLoggedInNonMembera;
    @SerializedName("webSerieMessageForLoggedInNonMemberaMedia")
    @Expose
    private Object webSerieMessageForLoggedInNonMemberaMedia;
    @SerializedName("webSeriesEnableCustomRedirectUrl")
    @Expose
    private Boolean webSeriesEnableCustomRedirectUrl;
    @SerializedName("webSeriesCustomRedirectUrl")
    @Expose
    private Object webSeriesCustomRedirectUrl;
    @SerializedName("webSeriesCustomNonMemberRedirectUrl")
    @Expose
    private Object webSeriesCustomNonMemberRedirectUrl;
    @SerializedName("webSeriesDescription")
    @Expose
    private Object webSeriesDescription;
    @SerializedName("webSeriesDescriptionMedia")
    @Expose
    private Object webSeriesDescriptionMedia;
    @SerializedName("episodeVisibility")
    @Expose
    private Object episodeVisibility;
    @SerializedName("episodeVisibilityPassword")
    @Expose
    private Object episodeVisibilityPassword;
    @SerializedName("episodePublish")
    @Expose
    private Object episodePublish;
    @SerializedName("episodePendingReview")
    @Expose
    private Boolean episodePendingReview;
    @SerializedName("episodeSlug")
    @Expose
    private Object episodeSlug;
    @SerializedName("episodeImage")
    @Expose
    private String episodeImage;
    @SerializedName("episodeExcerpt")
    @Expose
    private Object episodeExcerpt;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("episodeAllowComments")
    @Expose
    private Boolean episodeAllowComments;
    @SerializedName("webseriesEpisodesrtPath")
    @Expose
    private String webseriesEpisodesrtPath;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("returnVisitor")
    @Expose
    private Integer returnVisitor;
    @SerializedName("newVisitor")
    @Expose
    private Integer newVisitor;
    @SerializedName("episodeId")
    @Expose
    private String episodeId;
    @SerializedName("episodeUid")
    @Expose
    private String episodeUid;
    @SerializedName("episodeDash")
    @Expose
    private String episodeDash;
    @SerializedName("episodeTrailerUid")
    @Expose
    private String episodeTrailerUid;
    @SerializedName("episodeTrailerDash")
    @Expose
    private String episodeTrailerDash;
    @SerializedName("subscriptionType")
    @Expose
    private List<String> subscriptionType = null;
    @SerializedName("episodelanguages")
    @Expose
    private Object episodelanguages;
    @SerializedName("date")
    @Expose
    private Object date;
    @SerializedName("companyname")
    @Expose
    private Object companyname;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("seasonprice")
    @Expose
    private Integer seasonprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebSeriesTitle() {
        return webSeriesTitle;
    }

    public void setWebSeriesTitle(String webSeriesTitle) {
        this.webSeriesTitle = webSeriesTitle;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public Object getWebSeriesLogo() {
        return webSeriesLogo;
    }

    public void setWebSeriesLogo(Object webSeriesLogo) {
        this.webSeriesLogo = webSeriesLogo;
    }

    public Object getWebSeriesTrailer() {
        return webSeriesTrailer;
    }

    public void setWebSeriesTrailer(Object webSeriesTrailer) {
        this.webSeriesTrailer = webSeriesTrailer;
    }

    public Boolean getWebSeriesUpcoming() {
        return webSeriesUpcoming;
    }

    public void setWebSeriesUpcoming(Boolean webSeriesUpcoming) {
        this.webSeriesUpcoming = webSeriesUpcoming;
    }

    public Object getWebSeriesIMDBRating() {
        return webSeriesIMDBRating;
    }

    public void setWebSeriesIMDBRating(Object webSeriesIMDBRating) {
        this.webSeriesIMDBRating = webSeriesIMDBRating;
    }

    public String getWebSeriesEpisodeNumber() {
        return webSeriesEpisodeNumber;
    }

    public void setWebSeriesEpisodeNumber(String webSeriesEpisodeNumber) {
        this.webSeriesEpisodeNumber = webSeriesEpisodeNumber;
    }

    public Object getWebSeriesEpisodeMethod() {
        return webSeriesEpisodeMethod;
    }

    public void setWebSeriesEpisodeMethod(Object webSeriesEpisodeMethod) {
        this.webSeriesEpisodeMethod = webSeriesEpisodeMethod;
    }

    public String getWebSeriesUploadVideo() {
        return webSeriesUploadVideo;
    }

    public void setWebSeriesUploadVideo(String webSeriesUploadVideo) {
        this.webSeriesUploadVideo = webSeriesUploadVideo;
    }

    public Object getWebSeriesReleaseDate() {
        return webSeriesReleaseDate;
    }

    public void setWebSeriesReleaseDate(Object webSeriesReleaseDate) {
        this.webSeriesReleaseDate = webSeriesReleaseDate;
    }

    public Object getWebSeriesDuration() {
        return webSeriesDuration;
    }

    public void setWebSeriesDuration(Object webSeriesDuration) {
        this.webSeriesDuration = webSeriesDuration;
    }

    public Object getWebSeriesIMDBID() {
        return webSeriesIMDBID;
    }

    public void setWebSeriesIMDBID(Object webSeriesIMDBID) {
        this.webSeriesIMDBID = webSeriesIMDBID;
    }

    public Object getWebSeriesTMDBID() {
        return webSeriesTMDBID;
    }

    public void setWebSeriesTMDBID(Object webSeriesTMDBID) {
        this.webSeriesTMDBID = webSeriesTMDBID;
    }

    public Object getWebSeriesCatlogVisibility() {
        return webSeriesCatlogVisibility;
    }

    public void setWebSeriesCatlogVisibility(Object webSeriesCatlogVisibility) {
        this.webSeriesCatlogVisibility = webSeriesCatlogVisibility;
    }

    public String getWebSeriesEpisodeUrl() {
        return webSeriesEpisodeUrl;
    }

    public void setWebSeriesEpisodeUrl(String webSeriesEpisodeUrl) {
        this.webSeriesEpisodeUrl = webSeriesEpisodeUrl;
    }

    public Boolean getWebSeriesFeatured() {
        return webSeriesFeatured;
    }

    public void setWebSeriesFeatured(Boolean webSeriesFeatured) {
        this.webSeriesFeatured = webSeriesFeatured;
    }

    public Object getWebSeriesSources() {
        return webSeriesSources;
    }

    public void setWebSeriesSources(Object webSeriesSources) {
        this.webSeriesSources = webSeriesSources;
    }

    public Object getWebSeriesRestrication() {
        return webSeriesRestrication;
    }

    public void setWebSeriesRestrication(Object webSeriesRestrication) {
        this.webSeriesRestrication = webSeriesRestrication;
    }

    public Boolean getWebSeriesDisplayForLoggedUser() {
        return webSeriesDisplayForLoggedUser;
    }

    public void setWebSeriesDisplayForLoggedUser(Boolean webSeriesDisplayForLoggedUser) {
        this.webSeriesDisplayForLoggedUser = webSeriesDisplayForLoggedUser;
    }

    public Boolean getWebSeriesEnableCustomMessage() {
        return webSeriesEnableCustomMessage;
    }

    public void setWebSeriesEnableCustomMessage(Boolean webSeriesEnableCustomMessage) {
        this.webSeriesEnableCustomMessage = webSeriesEnableCustomMessage;
    }

    public Object getWebSerieMessageForLoggedOutUser() {
        return webSerieMessageForLoggedOutUser;
    }

    public void setWebSerieMessageForLoggedOutUser(Object webSerieMessageForLoggedOutUser) {
        this.webSerieMessageForLoggedOutUser = webSerieMessageForLoggedOutUser;
    }

    public Object getWebSerieMessageForLoggedOutUserMedia() {
        return webSerieMessageForLoggedOutUserMedia;
    }

    public void setWebSerieMessageForLoggedOutUserMedia(Object webSerieMessageForLoggedOutUserMedia) {
        this.webSerieMessageForLoggedOutUserMedia = webSerieMessageForLoggedOutUserMedia;
    }

    public Object getWebSerieMessageForLoggedInNonMembera() {
        return webSerieMessageForLoggedInNonMembera;
    }

    public void setWebSerieMessageForLoggedInNonMembera(Object webSerieMessageForLoggedInNonMembera) {
        this.webSerieMessageForLoggedInNonMembera = webSerieMessageForLoggedInNonMembera;
    }

    public Object getWebSerieMessageForLoggedInNonMemberaMedia() {
        return webSerieMessageForLoggedInNonMemberaMedia;
    }

    public void setWebSerieMessageForLoggedInNonMemberaMedia(Object webSerieMessageForLoggedInNonMemberaMedia) {
        this.webSerieMessageForLoggedInNonMemberaMedia = webSerieMessageForLoggedInNonMemberaMedia;
    }

    public Boolean getWebSeriesEnableCustomRedirectUrl() {
        return webSeriesEnableCustomRedirectUrl;
    }

    public void setWebSeriesEnableCustomRedirectUrl(Boolean webSeriesEnableCustomRedirectUrl) {
        this.webSeriesEnableCustomRedirectUrl = webSeriesEnableCustomRedirectUrl;
    }

    public Object getWebSeriesCustomRedirectUrl() {
        return webSeriesCustomRedirectUrl;
    }

    public void setWebSeriesCustomRedirectUrl(Object webSeriesCustomRedirectUrl) {
        this.webSeriesCustomRedirectUrl = webSeriesCustomRedirectUrl;
    }

    public Object getWebSeriesCustomNonMemberRedirectUrl() {
        return webSeriesCustomNonMemberRedirectUrl;
    }

    public void setWebSeriesCustomNonMemberRedirectUrl(Object webSeriesCustomNonMemberRedirectUrl) {
        this.webSeriesCustomNonMemberRedirectUrl = webSeriesCustomNonMemberRedirectUrl;
    }

    public Object getWebSeriesDescription() {
        return webSeriesDescription;
    }

    public void setWebSeriesDescription(Object webSeriesDescription) {
        this.webSeriesDescription = webSeriesDescription;
    }

    public Object getWebSeriesDescriptionMedia() {
        return webSeriesDescriptionMedia;
    }

    public void setWebSeriesDescriptionMedia(Object webSeriesDescriptionMedia) {
        this.webSeriesDescriptionMedia = webSeriesDescriptionMedia;
    }

    public Object getEpisodeVisibility() {
        return episodeVisibility;
    }

    public void setEpisodeVisibility(Object episodeVisibility) {
        this.episodeVisibility = episodeVisibility;
    }

    public Object getEpisodeVisibilityPassword() {
        return episodeVisibilityPassword;
    }

    public void setEpisodeVisibilityPassword(Object episodeVisibilityPassword) {
        this.episodeVisibilityPassword = episodeVisibilityPassword;
    }

    public Object getEpisodePublish() {
        return episodePublish;
    }

    public void setEpisodePublish(Object episodePublish) {
        this.episodePublish = episodePublish;
    }

    public Boolean getEpisodePendingReview() {
        return episodePendingReview;
    }

    public void setEpisodePendingReview(Boolean episodePendingReview) {
        this.episodePendingReview = episodePendingReview;
    }

    public Object getEpisodeSlug() {
        return episodeSlug;
    }

    public void setEpisodeSlug(Object episodeSlug) {
        this.episodeSlug = episodeSlug;
    }

    public String getEpisodeImage() {
        return episodeImage;
    }

    public void setEpisodeImage(String episodeImage) {
        this.episodeImage = episodeImage;
    }

    public Object getEpisodeExcerpt() {
        return episodeExcerpt;
    }

    public void setEpisodeExcerpt(Object episodeExcerpt) {
        this.episodeExcerpt = episodeExcerpt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getEpisodeAllowComments() {
        return episodeAllowComments;
    }

    public void setEpisodeAllowComments(Boolean episodeAllowComments) {
        this.episodeAllowComments = episodeAllowComments;
    }

    public String getWebseriesEpisodesrtPath() {
        return webseriesEpisodesrtPath;
    }

    public void setWebseriesEpisodesrtPath(String webseriesEpisodesrtPath) {
        this.webseriesEpisodesrtPath = webseriesEpisodesrtPath;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getReturnVisitor() {
        return returnVisitor;
    }

    public void setReturnVisitor(Integer returnVisitor) {
        this.returnVisitor = returnVisitor;
    }

    public Integer getNewVisitor() {
        return newVisitor;
    }

    public void setNewVisitor(Integer newVisitor) {
        this.newVisitor = newVisitor;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    public String getEpisodeUid() {
        return episodeUid;
    }

    public void setEpisodeUid(String episodeUid) {
        this.episodeUid = episodeUid;
    }

    public String getEpisodeDash() {
        return episodeDash;
    }

    public void setEpisodeDash(String episodeDash) {
        this.episodeDash = episodeDash;
    }

    public String getEpisodeTrailerUid() {
        return episodeTrailerUid;
    }

    public void setEpisodeTrailerUid(String episodeTrailerUid) {
        this.episodeTrailerUid = episodeTrailerUid;
    }

    public String getEpisodeTrailerDash() {
        return episodeTrailerDash;
    }

    public void setEpisodeTrailerDash(String episodeTrailerDash) {
        this.episodeTrailerDash = episodeTrailerDash;
    }

    public List<String> getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(List<String> subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Object getEpisodelanguages() {
        return episodelanguages;
    }

    public void setEpisodelanguages(Object episodelanguages) {
        this.episodelanguages = episodelanguages;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public Object getCompanyname() {
        return companyname;
    }

    public void setCompanyname(Object companyname) {
        this.companyname = companyname;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getSeasonprice() {
        return seasonprice;
    }

    public void setSeasonprice(Integer seasonprice) {
        this.seasonprice = seasonprice;
    }

}
