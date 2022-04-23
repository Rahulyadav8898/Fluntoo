package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WebTrending {

//    @SerializedName("webSeriesTitle")
//    @Expose
//    private String webSeriesTitle;
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
//    @SerializedName("webSeriesIMDBID")
//    @Expose
//    private String webSeriesIMDBID;
//    @SerializedName("webSeriesTMDBID")
//    @Expose
//    private String webSeriesTMDBID;
//    @SerializedName("webSeriesCatlogVisibility")
//    @Expose
//    private String webSeriesCatlogVisibility;
//    @SerializedName("webSeriesId")
//    @Expose
//    private String webSeriesId;
//    @SerializedName("webseriesGenres")
//    @Expose
//    private List<String> webseriesGenres = null;
//    @SerializedName("webSeriesFeatured")
//    @Expose
//    private Boolean webSeriesFeatured;
//    @SerializedName("userId")
//    @Expose
//    private Integer userId;
//    @SerializedName("views")
//    @Expose
//    private Integer views;
//    @SerializedName("webSeriesCast")
//    @Expose
//    private List<String> webSeriesCast = null;
//    @SerializedName("webSeriesCrew")
//    @Expose
//    private List<String> webSeriesCrew = null;
//    @SerializedName("webSeriesAtributes")
//    @Expose
//    private List<Object> webSeriesAtributes = null;
//    @SerializedName("webSeason")
//    @Expose
//    private List<String> webSeason = null;
//    @SerializedName("webSeriesRestrication")
//    @Expose
//    private String webSeriesRestrication;
//    @SerializedName("webSeriesDisplayForLoggedUser")
//    @Expose
//    private Boolean webSeriesDisplayForLoggedUser;
//    @SerializedName("webSeriesEnableCustomMessage")
//    @Expose
//    private Boolean webSeriesEnableCustomMessage;
//    @SerializedName("webSeriesMessageForLoggedOutUser")
//    @Expose
//    private Object webSeriesMessageForLoggedOutUser;
//    @SerializedName("webSeriesMessageForLoggedOutUserMedia")
//    @Expose
//    private String webSeriesMessageForLoggedOutUserMedia;
//    @SerializedName("webSeriesMessageForLoggedInNonMembera")
//    @Expose
//    private Object webSeriesMessageForLoggedInNonMembera;
//    @SerializedName("webSeriesMessageForLoggedInNonMemberaMedia")
//    @Expose
//    private String webSeriesMessageForLoggedInNonMemberaMedia;
//    @SerializedName("webSeriesDescription")
//    @Expose
//    private String webSeriesDescription;
//    @SerializedName("webSeriesDescriptionMedia")
//    @Expose
//    private String webSeriesDescriptionMedia;
//    @SerializedName("webseriesView")
//    @Expose
//    private Object webseriesView;
//    @SerializedName("webseriesReleaseDate")
//    @Expose
//    private Object webseriesReleaseDate;
//    @SerializedName("webSeriesDateadded")
//    @Expose
//    private Long webSeriesDateadded;
//    @SerializedName("webSeriesVisibility")
//    @Expose
//    private Object webSeriesVisibility;
//    @SerializedName("webSeriesProtectedPassword")
//    @Expose
//    private Object webSeriesProtectedPassword;
//    @SerializedName("webSeriesPublish")
//    @Expose
//    private Object webSeriesPublish;
//    @SerializedName("webSeriesPendingReview")
//    @Expose
//    private Boolean webSeriesPendingReview;
//    @SerializedName("webSeriesSlug")
//    @Expose
//    private Object webSeriesSlug;
//    @SerializedName("webSeriesImage")
//    @Expose
//    private String webSeriesImage;
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
//    public String getWebSeriesId() {
//        return webSeriesId;
//    }
//
//    public void setWebSeriesId(String webSeriesId) {
//        this.webSeriesId = webSeriesId;
//    }
//
//    public List<String> getWebseriesGenres() {
//        return webseriesGenres;
//    }
//
//    public void setWebseriesGenres(List<String> webseriesGenres) {
//        this.webseriesGenres = webseriesGenres;
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
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Integer getViews() {
//        return views;
//    }
//
//    public void setViews(Integer views) {
//        this.views = views;
//    }
//
//    public List<String> getWebSeriesCast() {
//        return webSeriesCast;
//    }
//
//    public void setWebSeriesCast(List<String> webSeriesCast) {
//        this.webSeriesCast = webSeriesCast;
//    }
//
//    public List<String> getWebSeriesCrew() {
//        return webSeriesCrew;
//    }
//
//    public void setWebSeriesCrew(List<String> webSeriesCrew) {
//        this.webSeriesCrew = webSeriesCrew;
//    }
//
//    public List<Object> getWebSeriesAtributes() {
//        return webSeriesAtributes;
//    }
//
//    public void setWebSeriesAtributes(List<Object> webSeriesAtributes) {
//        this.webSeriesAtributes = webSeriesAtributes;
//    }
//
//    public List<String> getWebSeason() {
//        return webSeason;
//    }
//
//    public void setWebSeason(List<String> webSeason) {
//        this.webSeason = webSeason;
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
//    public Object getWebSeriesMessageForLoggedOutUser() {
//        return webSeriesMessageForLoggedOutUser;
//    }
//
//    public void setWebSeriesMessageForLoggedOutUser(Object webSeriesMessageForLoggedOutUser) {
//        this.webSeriesMessageForLoggedOutUser = webSeriesMessageForLoggedOutUser;
//    }
//
//    public String getWebSeriesMessageForLoggedOutUserMedia() {
//        return webSeriesMessageForLoggedOutUserMedia;
//    }
//
//    public void setWebSeriesMessageForLoggedOutUserMedia(String webSeriesMessageForLoggedOutUserMedia) {
//        this.webSeriesMessageForLoggedOutUserMedia = webSeriesMessageForLoggedOutUserMedia;
//    }
//
//    public Object getWebSeriesMessageForLoggedInNonMembera() {
//        return webSeriesMessageForLoggedInNonMembera;
//    }
//
//    public void setWebSeriesMessageForLoggedInNonMembera(Object webSeriesMessageForLoggedInNonMembera) {
//        this.webSeriesMessageForLoggedInNonMembera = webSeriesMessageForLoggedInNonMembera;
//    }
//
//    public String getWebSeriesMessageForLoggedInNonMemberaMedia() {
//        return webSeriesMessageForLoggedInNonMemberaMedia;
//    }
//
//    public void setWebSeriesMessageForLoggedInNonMemberaMedia(String webSeriesMessageForLoggedInNonMemberaMedia) {
//        this.webSeriesMessageForLoggedInNonMemberaMedia = webSeriesMessageForLoggedInNonMemberaMedia;
//    }
//
//    public String getWebSeriesDescription() {
//        return webSeriesDescription;
//    }
//
//    public void setWebSeriesDescription(String webSeriesDescription) {
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
//    public Object getWebseriesView() {
//        return webseriesView;
//    }
//
//    public void setWebseriesView(Object webseriesView) {
//        this.webseriesView = webseriesView;
//    }
//
//    public Object getWebseriesReleaseDate() {
//        return webseriesReleaseDate;
//    }
//
//    public void setWebseriesReleaseDate(Object webseriesReleaseDate) {
//        this.webseriesReleaseDate = webseriesReleaseDate;
//    }
//
//    public Long getWebSeriesDateadded() {
//        return webSeriesDateadded;
//    }
//
//    public void setWebSeriesDateadded(Long webSeriesDateadded) {
//        this.webSeriesDateadded = webSeriesDateadded;
//    }
//
//    public Object getWebSeriesVisibility() {
//        return webSeriesVisibility;
//    }
//
//    public void setWebSeriesVisibility(Object webSeriesVisibility) {
//        this.webSeriesVisibility = webSeriesVisibility;
//    }
//
//    public Object getWebSeriesProtectedPassword() {
//        return webSeriesProtectedPassword;
//    }
//
//    public void setWebSeriesProtectedPassword(Object webSeriesProtectedPassword) {
//        this.webSeriesProtectedPassword = webSeriesProtectedPassword;
//    }
//
//    public Object getWebSeriesPublish() {
//        return webSeriesPublish;
//    }
//
//    public void setWebSeriesPublish(Object webSeriesPublish) {
//        this.webSeriesPublish = webSeriesPublish;
//    }
//
//    public Boolean getWebSeriesPendingReview() {
//        return webSeriesPendingReview;
//    }
//
//    public void setWebSeriesPendingReview(Boolean webSeriesPendingReview) {
//        this.webSeriesPendingReview = webSeriesPendingReview;
//    }
//
//    public Object getWebSeriesSlug() {
//        return webSeriesSlug;
//    }
//
//    public void setWebSeriesSlug(Object webSeriesSlug) {
//        this.webSeriesSlug = webSeriesSlug;
//    }
//
//    public String getWebSeriesImage() {
//        return webSeriesImage;
//    }
//
//    public void setWebSeriesImage(String webSeriesImage) {
//        this.webSeriesImage = webSeriesImage;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//}

//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("webSeriesTitle")
//    @Expose
//    private String webSeriesTitle;
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
//    @SerializedName("webSeriesIMDBID")
//    @Expose
//    private String webSeriesIMDBID;
//    @SerializedName("webSeriesTMDBID")
//    @Expose
//    private String webSeriesTMDBID;
//    @SerializedName("webSeriesCatlogVisibility")
//    @Expose
//    private String webSeriesCatlogVisibility;
//    @SerializedName("webSeriesId")
//    @Expose
//    private String webSeriesId;
//    @SerializedName("webseriesGenres")
//    @Expose
//    private List<String> webseriesGenres = null;
//    @SerializedName("webSeriesFeatured")
//    @Expose
//    private Boolean webSeriesFeatured;
//    @SerializedName("userId")
//    @Expose
//    private String userId;
//    @SerializedName("views")
//    @Expose
//    private Integer views;
//    @SerializedName("webSeriesCast")
//    @Expose
//    private List<String> webSeriesCast = null;
//    @SerializedName("webSeriesCrew")
//    @Expose
//    private List<String> webSeriesCrew = null;
//    @SerializedName("webserieslanguages")
//    @Expose
//    private Object webserieslanguages;
//    @SerializedName("webSeriesAtributes")
//    @Expose
//    private Object webSeriesAtributes;
//    @SerializedName("webSeason")
//    @Expose
//    private List<String> webSeason = null;
//    @SerializedName("webSeriesRestrication")
//    @Expose
//    private String webSeriesRestrication;
//    @SerializedName("webSeriesDisplayForLoggedUser")
//    @Expose
//    private Boolean webSeriesDisplayForLoggedUser;
//    @SerializedName("webSeriesEnableCustomMessage")
//    @Expose
//    private Boolean webSeriesEnableCustomMessage;
//    @SerializedName("webSeriesMessageForLoggedOutUser")
//    @Expose
//    private Object webSeriesMessageForLoggedOutUser;
//    @SerializedName("webSeriesMessageForLoggedOutUserMedia")
//    @Expose
//    private String webSeriesMessageForLoggedOutUserMedia;
//    @SerializedName("webSeriesMessageForLoggedInNonMembera")
//    @Expose
//    private Object webSeriesMessageForLoggedInNonMembera;
//    @SerializedName("webSeriesMessageForLoggedInNonMemberaMedia")
//    @Expose
//    private String webSeriesMessageForLoggedInNonMemberaMedia;
//    @SerializedName("webSeriesDescription")
//    @Expose
//    private String webSeriesDescription;
//    @SerializedName("webSeriesDescriptionMedia")
//    @Expose
//    private String webSeriesDescriptionMedia;
//    @SerializedName("webseriesView")
//    @Expose
//    private Object webseriesView;
//    @SerializedName("webseriesReleaseDate")
//    @Expose
//    private Object webseriesReleaseDate;
//    @SerializedName("webSeriesDateadded")
//    @Expose
//    private String webSeriesDateadded;
//    @SerializedName("webSeriesVisibility")
//    @Expose
//    private Object webSeriesVisibility;
//    @SerializedName("webSeriesProtectedPassword")
//    @Expose
//    private Object webSeriesProtectedPassword;
//    @SerializedName("webSeriesPublish")
//    @Expose
//    private Object webSeriesPublish;
//    @SerializedName("webSeriesPendingReview")
//    @Expose
//    private Boolean webSeriesPendingReview;
//    @SerializedName("webSeriesSlug")
//    @Expose
//    private Object webSeriesSlug;
//    @SerializedName("webSeriesImage")
//    @Expose
//    private String webSeriesImage;
//    @SerializedName("newVisitor")
//    @Expose
//    private Integer newVisitor;
//    @SerializedName("returnVisitor")
//    @Expose
//    private Integer returnVisitor;
//    @SerializedName("companyname")
//    @Expose
//    private String companyname;
//    @SerializedName("active")
//    @Expose
//    private Boolean active;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getWebSeriesTitle() {
//        return webSeriesTitle;
//    }
//
//    public void setWebSeriesTitle(String webSeriesTitle) {
//        this.webSeriesTitle = webSeriesTitle;
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
//    public String getWebSeriesId() {
//        return webSeriesId;
//    }
//
//    public void setWebSeriesId(String webSeriesId) {
//        this.webSeriesId = webSeriesId;
//    }
//
//    public List<String> getWebseriesGenres() {
//        return webseriesGenres;
//    }
//
//    public void setWebseriesGenres(List<String> webseriesGenres) {
//        this.webseriesGenres = webseriesGenres;
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
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public Integer getViews() {
//        return views;
//    }
//
//    public void setViews(Integer views) {
//        this.views = views;
//    }
//
//    public List<String> getWebSeriesCast() {
//        return webSeriesCast;
//    }
//
//    public void setWebSeriesCast(List<String> webSeriesCast) {
//        this.webSeriesCast = webSeriesCast;
//    }
//
//    public List<String> getWebSeriesCrew() {
//        return webSeriesCrew;
//    }
//
//    public void setWebSeriesCrew(List<String> webSeriesCrew) {
//        this.webSeriesCrew = webSeriesCrew;
//    }
//
//    public Object getWebserieslanguages() {
//        return webserieslanguages;
//    }
//
//    public void setWebserieslanguages(Object webserieslanguages) {
//        this.webserieslanguages = webserieslanguages;
//    }
//
//    public Object getWebSeriesAtributes() {
//        return webSeriesAtributes;
//    }
//
//    public void setWebSeriesAtributes(Object webSeriesAtributes) {
//        this.webSeriesAtributes = webSeriesAtributes;
//    }
//
//    public List<String> getWebSeason() {
//        return webSeason;
//    }
//
//    public void setWebSeason(List<String> webSeason) {
//        this.webSeason = webSeason;
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
//    public Object getWebSeriesMessageForLoggedOutUser() {
//        return webSeriesMessageForLoggedOutUser;
//    }
//
//    public void setWebSeriesMessageForLoggedOutUser(Object webSeriesMessageForLoggedOutUser) {
//        this.webSeriesMessageForLoggedOutUser = webSeriesMessageForLoggedOutUser;
//    }
//
//    public String getWebSeriesMessageForLoggedOutUserMedia() {
//        return webSeriesMessageForLoggedOutUserMedia;
//    }
//
//    public void setWebSeriesMessageForLoggedOutUserMedia(String webSeriesMessageForLoggedOutUserMedia) {
//        this.webSeriesMessageForLoggedOutUserMedia = webSeriesMessageForLoggedOutUserMedia;
//    }
//
//    public Object getWebSeriesMessageForLoggedInNonMembera() {
//        return webSeriesMessageForLoggedInNonMembera;
//    }
//
//    public void setWebSeriesMessageForLoggedInNonMembera(Object webSeriesMessageForLoggedInNonMembera) {
//        this.webSeriesMessageForLoggedInNonMembera = webSeriesMessageForLoggedInNonMembera;
//    }
//
//    public String getWebSeriesMessageForLoggedInNonMemberaMedia() {
//        return webSeriesMessageForLoggedInNonMemberaMedia;
//    }
//
//    public void setWebSeriesMessageForLoggedInNonMemberaMedia(String webSeriesMessageForLoggedInNonMemberaMedia) {
//        this.webSeriesMessageForLoggedInNonMemberaMedia = webSeriesMessageForLoggedInNonMemberaMedia;
//    }
//
//    public String getWebSeriesDescription() {
//        return webSeriesDescription;
//    }
//
//    public void setWebSeriesDescription(String webSeriesDescription) {
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
//    public Object getWebseriesView() {
//        return webseriesView;
//    }
//
//    public void setWebseriesView(Object webseriesView) {
//        this.webseriesView = webseriesView;
//    }
//
//    public Object getWebseriesReleaseDate() {
//        return webseriesReleaseDate;
//    }
//
//    public void setWebseriesReleaseDate(Object webseriesReleaseDate) {
//        this.webseriesReleaseDate = webseriesReleaseDate;
//    }
//
//    public String getWebSeriesDateadded() {
//        return webSeriesDateadded;
//    }
//
//    public void setWebSeriesDateadded(String webSeriesDateadded) {
//        this.webSeriesDateadded = webSeriesDateadded;
//    }
//
//    public Object getWebSeriesVisibility() {
//        return webSeriesVisibility;
//    }
//
//    public void setWebSeriesVisibility(Object webSeriesVisibility) {
//        this.webSeriesVisibility = webSeriesVisibility;
//    }
//
//    public Object getWebSeriesProtectedPassword() {
//        return webSeriesProtectedPassword;
//    }
//
//    public void setWebSeriesProtectedPassword(Object webSeriesProtectedPassword) {
//        this.webSeriesProtectedPassword = webSeriesProtectedPassword;
//    }
//
//    public Object getWebSeriesPublish() {
//        return webSeriesPublish;
//    }
//
//    public void setWebSeriesPublish(Object webSeriesPublish) {
//        this.webSeriesPublish = webSeriesPublish;
//    }
//
//    public Boolean getWebSeriesPendingReview() {
//        return webSeriesPendingReview;
//    }
//
//    public void setWebSeriesPendingReview(Boolean webSeriesPendingReview) {
//        this.webSeriesPendingReview = webSeriesPendingReview;
//    }
//
//    public Object getWebSeriesSlug() {
//        return webSeriesSlug;
//    }
//
//    public void setWebSeriesSlug(Object webSeriesSlug) {
//        this.webSeriesSlug = webSeriesSlug;
//    }
//
//    public String getWebSeriesImage() {
//        return webSeriesImage;
//    }
//
//    public void setWebSeriesImage(String webSeriesImage) {
//        this.webSeriesImage = webSeriesImage;
//    }
//
//    public Integer getNewVisitor() {
//        return newVisitor;
//    }
//
//    public void setNewVisitor(Integer newVisitor) {
//        this.newVisitor = newVisitor;
//    }
//
//    public Integer getReturnVisitor() {
//        return returnVisitor;
//    }
//
//    public void setReturnVisitor(Integer returnVisitor) {
//        this.returnVisitor = returnVisitor;
//    }
//
//    public String getCompanyname() {
//        return companyname;
//    }
//
//    public void setCompanyname(String companyname) {
//        this.companyname = companyname;
//    }
//
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("webSeriesTitle")
    @Expose
    private String webSeriesTitle;
    @SerializedName("webSeriesLogo")
    @Expose
    private Object webSeriesLogo;
    @SerializedName("webSeriesTrailer")
    @Expose
    private String webSeriesTrailer;
    @SerializedName("webSeriesUpcoming")
    @Expose
    private Boolean webSeriesUpcoming;
    @SerializedName("webSeriesIMDBRating")
    @Expose
    private Object webSeriesIMDBRating;
    @SerializedName("webSeriesIMDBID")
    @Expose
    private Object webSeriesIMDBID;
    @SerializedName("webSeriesTMDBID")
    @Expose
    private Object webSeriesTMDBID;
    @SerializedName("webSeriesCatlogVisibility")
    @Expose
    private Object webSeriesCatlogVisibility;
    @SerializedName("webSeriesId")
    @Expose
    private String webSeriesId;
    @SerializedName("webseriesGenres")
    @Expose
    private List<String> webseriesGenres = null;
    @SerializedName("webSeriesFeatured")
    @Expose
    private Boolean webSeriesFeatured;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("webSeriesCast")
    @Expose
    private List<String> webSeriesCast = null;
    @SerializedName("webSeriesCrew")
    @Expose
    private Object webSeriesCrew;
    @SerializedName("webserieslanguages")
    @Expose
    private Object webserieslanguages;
    @SerializedName("webSeriesAtributes")
    @Expose
    private Object webSeriesAtributes;
    @SerializedName("webSeason")
    @Expose
    private List<String> webSeason = null;
    @SerializedName("webSeriesRestrication")
    @Expose
    private Object webSeriesRestrication;
    @SerializedName("webSeriesDisplayForLoggedUser")
    @Expose
    private Boolean webSeriesDisplayForLoggedUser;
    @SerializedName("webSeriesEnableCustomMessage")
    @Expose
    private Boolean webSeriesEnableCustomMessage;
    @SerializedName("webSeriesMessageForLoggedOutUser")
    @Expose
    private Object webSeriesMessageForLoggedOutUser;
    @SerializedName("webSeriesMessageForLoggedOutUserMedia")
    @Expose
    private Object webSeriesMessageForLoggedOutUserMedia;
    @SerializedName("webSeriesMessageForLoggedInNonMembera")
    @Expose
    private Object webSeriesMessageForLoggedInNonMembera;
    @SerializedName("webSeriesMessageForLoggedInNonMemberaMedia")
    @Expose
    private Object webSeriesMessageForLoggedInNonMemberaMedia;
    @SerializedName("webSeriesDescription")
    @Expose
    private String webSeriesDescription;
    @SerializedName("webSeriesDescriptionMedia")
    @Expose
    private Object webSeriesDescriptionMedia;
    @SerializedName("webseriesView")
    @Expose
    private String webseriesView;
    @SerializedName("webseriesReleaseDate")
    @Expose
    private Object webseriesReleaseDate;
    @SerializedName("webSeriesDateadded")
    @Expose
    private Object webSeriesDateadded;
    @SerializedName("webSeriesVisibility")
    @Expose
    private Object webSeriesVisibility;
    @SerializedName("webSeriesProtectedPassword")
    @Expose
    private Object webSeriesProtectedPassword;
    @SerializedName("webSeriesPublish")
    @Expose
    private Object webSeriesPublish;
    @SerializedName("webSeriesPendingReview")
    @Expose
    private Boolean webSeriesPendingReview;
    @SerializedName("webSeriesSlug")
    @Expose
    private Object webSeriesSlug;
    @SerializedName("webSeriesImage")
    @Expose
    private String webSeriesImage;
    @SerializedName("newVisitor")
    @Expose
    private Integer newVisitor;
    @SerializedName("returnVisitor")
    @Expose
    private Integer returnVisitor;
    @SerializedName("companyname")
    @Expose
    private Object companyname;
    @SerializedName("active")
    @Expose
    private Boolean active;

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

    public Object getWebSeriesLogo() {
        return webSeriesLogo;
    }

    public void setWebSeriesLogo(Object webSeriesLogo) {
        this.webSeriesLogo = webSeriesLogo;
    }

    public String getWebSeriesTrailer() {
        return webSeriesTrailer;
    }

    public void setWebSeriesTrailer(String webSeriesTrailer) {
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

    public String getWebSeriesId() {
        return webSeriesId;
    }

    public void setWebSeriesId(String webSeriesId) {
        this.webSeriesId = webSeriesId;
    }

    public List<String> getWebseriesGenres() {
        return webseriesGenres;
    }

    public void setWebseriesGenres(List<String> webseriesGenres) {
        this.webseriesGenres = webseriesGenres;
    }

    public Boolean getWebSeriesFeatured() {
        return webSeriesFeatured;
    }

    public void setWebSeriesFeatured(Boolean webSeriesFeatured) {
        this.webSeriesFeatured = webSeriesFeatured;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public List<String> getWebSeriesCast() {
        return webSeriesCast;
    }

    public void setWebSeriesCast(List<String> webSeriesCast) {
        this.webSeriesCast = webSeriesCast;
    }

    public Object getWebSeriesCrew() {
        return webSeriesCrew;
    }

    public void setWebSeriesCrew(Object webSeriesCrew) {
        this.webSeriesCrew = webSeriesCrew;
    }

    public Object getWebserieslanguages() {
        return webserieslanguages;
    }

    public void setWebserieslanguages(Object webserieslanguages) {
        this.webserieslanguages = webserieslanguages;
    }

    public Object getWebSeriesAtributes() {
        return webSeriesAtributes;
    }

    public void setWebSeriesAtributes(Object webSeriesAtributes) {
        this.webSeriesAtributes = webSeriesAtributes;
    }

    public List<String> getWebSeason() {
        return webSeason;
    }

    public void setWebSeason(List<String> webSeason) {
        this.webSeason = webSeason;
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

    public Object getWebSeriesMessageForLoggedOutUser() {
        return webSeriesMessageForLoggedOutUser;
    }

    public void setWebSeriesMessageForLoggedOutUser(Object webSeriesMessageForLoggedOutUser) {
        this.webSeriesMessageForLoggedOutUser = webSeriesMessageForLoggedOutUser;
    }

    public Object getWebSeriesMessageForLoggedOutUserMedia() {
        return webSeriesMessageForLoggedOutUserMedia;
    }

    public void setWebSeriesMessageForLoggedOutUserMedia(Object webSeriesMessageForLoggedOutUserMedia) {
        this.webSeriesMessageForLoggedOutUserMedia = webSeriesMessageForLoggedOutUserMedia;
    }

    public Object getWebSeriesMessageForLoggedInNonMembera() {
        return webSeriesMessageForLoggedInNonMembera;
    }

    public void setWebSeriesMessageForLoggedInNonMembera(Object webSeriesMessageForLoggedInNonMembera) {
        this.webSeriesMessageForLoggedInNonMembera = webSeriesMessageForLoggedInNonMembera;
    }

    public Object getWebSeriesMessageForLoggedInNonMemberaMedia() {
        return webSeriesMessageForLoggedInNonMemberaMedia;
    }

    public void setWebSeriesMessageForLoggedInNonMemberaMedia(Object webSeriesMessageForLoggedInNonMemberaMedia) {
        this.webSeriesMessageForLoggedInNonMemberaMedia = webSeriesMessageForLoggedInNonMemberaMedia;
    }

    public String getWebSeriesDescription() {
        return webSeriesDescription;
    }

    public void setWebSeriesDescription(String webSeriesDescription) {
        this.webSeriesDescription = webSeriesDescription;
    }

    public Object getWebSeriesDescriptionMedia() {
        return webSeriesDescriptionMedia;
    }

    public void setWebSeriesDescriptionMedia(Object webSeriesDescriptionMedia) {
        this.webSeriesDescriptionMedia = webSeriesDescriptionMedia;
    }

    public String getWebseriesView() {
        return webseriesView;
    }

    public void setWebseriesView(String webseriesView) {
        this.webseriesView = webseriesView;
    }

    public Object getWebseriesReleaseDate() {
        return webseriesReleaseDate;
    }

    public void setWebseriesReleaseDate(Object webseriesReleaseDate) {
        this.webseriesReleaseDate = webseriesReleaseDate;
    }

    public Object getWebSeriesDateadded() {
        return webSeriesDateadded;
    }

    public void setWebSeriesDateadded(Object webSeriesDateadded) {
        this.webSeriesDateadded = webSeriesDateadded;
    }

    public Object getWebSeriesVisibility() {
        return webSeriesVisibility;
    }

    public void setWebSeriesVisibility(Object webSeriesVisibility) {
        this.webSeriesVisibility = webSeriesVisibility;
    }

    public Object getWebSeriesProtectedPassword() {
        return webSeriesProtectedPassword;
    }

    public void setWebSeriesProtectedPassword(Object webSeriesProtectedPassword) {
        this.webSeriesProtectedPassword = webSeriesProtectedPassword;
    }

    public Object getWebSeriesPublish() {
        return webSeriesPublish;
    }

    public void setWebSeriesPublish(Object webSeriesPublish) {
        this.webSeriesPublish = webSeriesPublish;
    }

    public Boolean getWebSeriesPendingReview() {
        return webSeriesPendingReview;
    }

    public void setWebSeriesPendingReview(Boolean webSeriesPendingReview) {
        this.webSeriesPendingReview = webSeriesPendingReview;
    }

    public Object getWebSeriesSlug() {
        return webSeriesSlug;
    }

    public void setWebSeriesSlug(Object webSeriesSlug) {
        this.webSeriesSlug = webSeriesSlug;
    }

    public String getWebSeriesImage() {
        return webSeriesImage;
    }

    public void setWebSeriesImage(String webSeriesImage) {
        this.webSeriesImage = webSeriesImage;
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


}