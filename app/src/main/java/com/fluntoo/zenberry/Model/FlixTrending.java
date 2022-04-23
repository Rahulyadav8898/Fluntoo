package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlixTrending {

//    @SerializedName("movieTitle")
//    @Expose
//    private String movieTitle;
//    @SerializedName("movieLogo")
//    @Expose
//    private String movieLogo;
//    @SerializedName("movieTrailer")
//    @Expose
//    private String movieTrailer;
//    @SerializedName("movieUpcoming")
//    @Expose
//    private Boolean movieUpcoming;
//    @SerializedName("movieIMDBRating")
//    @Expose
//    private String movieIMDBRating;
//    @SerializedName("movieMethod")
//    @Expose
//    private String movieMethod;
//    @SerializedName("movieUpload")
//    @Expose
//    private String movieUpload;
//    @SerializedName("movieURL")
//    @Expose
//    private String movieURL;
//    @SerializedName("movieAffiliateUrl")
//    @Expose
//    private Boolean movieAffiliateUrl;
//    @SerializedName("movieEmbedContent")
//    @Expose
//    private Object movieEmbedContent;
//    @SerializedName("movieReleaseDate")
//    @Expose
//    private String movieReleaseDate;
//    @SerializedName("movieDateadded")
//    @Expose
//    private Long movieDateadded;
//    @SerializedName("movieTimeDuration")
//    @Expose
//    private String movieTimeDuration;
//    @SerializedName("movieCensorRating")
//    @Expose
//    private String movieCensorRating;
//    @SerializedName("movieIMDBID")
//    @Expose
//    private String movieIMDBID;
//    @SerializedName("movieTMDBID")
//    @Expose
//    private String movieTMDBID;
//    @SerializedName("movieCatlogVisibility")
//    @Expose
//    private String movieCatlogVisibility;
//    @SerializedName("movieId")
//    @Expose
//    private String movieId;
//    @SerializedName("userId")
//    @Expose
//    private Integer userId;
//    @SerializedName("views")
//    @Expose
//    private Integer views;
//    @SerializedName("movieFeatured")
//    @Expose
//    private Boolean movieFeatured;
//    @SerializedName("movieLinkedMovie")
//    @Expose
//    private List<String> movieLinkedMovie = null;
//    @SerializedName("movieLinkedVideo")
//    @Expose
//    private List<String> movieLinkedVideo = null;
//    @SerializedName("movieCast")
//    @Expose
//    private List<String> movieCast = null;
//    @SerializedName("movieGenres")
//    @Expose
//    private List<String> movieGenres = null;
//    @SerializedName("movieCrew")
//    @Expose
//    private List<String> movieCrew = null;
//    @SerializedName("movieAtributes")
//    @Expose
//    private List<Object> movieAtributes = null;
//    @SerializedName("movieSources")
//    @Expose
//    private MovieSources movieSources;
//    @SerializedName("movieRestrication")
//    @Expose
//    private String movieRestrication;
//    @SerializedName("movieDisplayForLoggedUser")
//    @Expose
//    private Boolean movieDisplayForLoggedUser;
//    @SerializedName("movieEnableCustomMessage")
//    @Expose
//    private Boolean movieEnableCustomMessage;
//    @SerializedName("movieMessageForLoggedOutUser")
//    @Expose
//    private String movieMessageForLoggedOutUser;
//    @SerializedName("movieMessageForLoggedOutUserMedia")
//    @Expose
//    private String movieMessageForLoggedOutUserMedia;
//    @SerializedName("movieMessageForLoggedInNonMembera")
//    @Expose
//    private String movieMessageForLoggedInNonMembera;
//    @SerializedName("movieMessageForLoggedInNonMemberaMedia")
//    @Expose
//    private String movieMessageForLoggedInNonMemberaMedia;
//    @SerializedName("movieDescription")
//    @Expose
//    private String movieDescription;
//    @SerializedName("movieDescriptionMedia")
//    @Expose
//    private String movieDescriptionMedia;
//    @SerializedName("movieVisibility")
//    @Expose
//    private String movieVisibility;
//    @SerializedName("movieProtectedPassword")
//    @Expose
//    private String movieProtectedPassword;
//    @SerializedName("moviePublish")
//    @Expose
//    private String moviePublish;
//    @SerializedName("moviePendingReview")
//    @Expose
//    private Boolean moviePendingReview;
//    @SerializedName("movieSlug")
//    @Expose
//    private String movieSlug;
//    @SerializedName("movieImage")
//    @Expose
//    private String movieImage;
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//
//    public String getMovieTitle() {
//        return movieTitle;
//    }
//
//    public void setMovieTitle(String movieTitle) {
//        this.movieTitle = movieTitle;
//    }
//
//    public String getMovieLogo() {
//        return movieLogo;
//    }
//
//    public void setMovieLogo(String movieLogo) {
//        this.movieLogo = movieLogo;
//    }
//
//    public String getMovieTrailer() {
//        return movieTrailer;
//    }
//
//    public void setMovieTrailer(String movieTrailer) {
//        this.movieTrailer = movieTrailer;
//    }
//
//    public Boolean getMovieUpcoming() {
//        return movieUpcoming;
//    }
//
//    public void setMovieUpcoming(Boolean movieUpcoming) {
//        this.movieUpcoming = movieUpcoming;
//    }
//
//    public String getMovieIMDBRating() {
//        return movieIMDBRating;
//    }
//
//    public void setMovieIMDBRating(String movieIMDBRating) {
//        this.movieIMDBRating = movieIMDBRating;
//    }
//
//    public String getMovieMethod() {
//        return movieMethod;
//    }
//
//    public void setMovieMethod(String movieMethod) {
//        this.movieMethod = movieMethod;
//    }
//
//    public String getMovieUpload() {
//        return movieUpload;
//    }
//
//    public void setMovieUpload(String movieUpload) {
//        this.movieUpload = movieUpload;
//    }
//
//    public String getMovieURL() {
//        return movieURL;
//    }
//
//    public void setMovieURL(String movieURL) {
//        this.movieURL = movieURL;
//    }
//
//    public Boolean getMovieAffiliateUrl() {
//        return movieAffiliateUrl;
//    }
//
//    public void setMovieAffiliateUrl(Boolean movieAffiliateUrl) {
//        this.movieAffiliateUrl = movieAffiliateUrl;
//    }
//
//    public Object getMovieEmbedContent() {
//        return movieEmbedContent;
//    }
//
//    public void setMovieEmbedContent(Object movieEmbedContent) {
//        this.movieEmbedContent = movieEmbedContent;
//    }
//
//    public String getMovieReleaseDate() {
//        return movieReleaseDate;
//    }
//
//    public void setMovieReleaseDate(String movieReleaseDate) {
//        this.movieReleaseDate = movieReleaseDate;
//    }
//
//    public Long getMovieDateadded() {
//        return movieDateadded;
//    }
//
//    public void setMovieDateadded(Long movieDateadded) {
//        this.movieDateadded = movieDateadded;
//    }
//
//    public String getMovieTimeDuration() {
//        return movieTimeDuration;
//    }
//
//    public void setMovieTimeDuration(String movieTimeDuration) {
//        this.movieTimeDuration = movieTimeDuration;
//    }
//
//    public String getMovieCensorRating() {
//        return movieCensorRating;
//    }
//
//    public void setMovieCensorRating(String movieCensorRating) {
//        this.movieCensorRating = movieCensorRating;
//    }
//
//    public String getMovieIMDBID() {
//        return movieIMDBID;
//    }
//
//    public void setMovieIMDBID(String movieIMDBID) {
//        this.movieIMDBID = movieIMDBID;
//    }
//
//    public String getMovieTMDBID() {
//        return movieTMDBID;
//    }
//
//    public void setMovieTMDBID(String movieTMDBID) {
//        this.movieTMDBID = movieTMDBID;
//    }
//
//    public String getMovieCatlogVisibility() {
//        return movieCatlogVisibility;
//    }
//
//    public void setMovieCatlogVisibility(String movieCatlogVisibility) {
//        this.movieCatlogVisibility = movieCatlogVisibility;
//    }
//
//    public String getMovieId() {
//        return movieId;
//    }
//
//    public void setMovieId(String movieId) {
//        this.movieId = movieId;
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
//    public Boolean getMovieFeatured() {
//        return movieFeatured;
//    }
//
//    public void setMovieFeatured(Boolean movieFeatured) {
//        this.movieFeatured = movieFeatured;
//    }
//
//    public List<String> getMovieLinkedMovie() {
//        return movieLinkedMovie;
//    }
//
//    public void setMovieLinkedMovie(List<String> movieLinkedMovie) {
//        this.movieLinkedMovie = movieLinkedMovie;
//    }
//
//    public List<String> getMovieLinkedVideo() {
//        return movieLinkedVideo;
//    }
//
//    public void setMovieLinkedVideo(List<String> movieLinkedVideo) {
//        this.movieLinkedVideo = movieLinkedVideo;
//    }
//
//    public List<String> getMovieCast() {
//        return movieCast;
//    }
//
//    public void setMovieCast(List<String> movieCast) {
//        this.movieCast = movieCast;
//    }
//
//    public List<String> getMovieGenres() {
//        return movieGenres;
//    }
//
//    public void setMovieGenres(List<String> movieGenres) {
//        this.movieGenres = movieGenres;
//    }
//
//    public List<String> getMovieCrew() {
//        return movieCrew;
//    }
//
//    public void setMovieCrew(List<String> movieCrew) {
//        this.movieCrew = movieCrew;
//    }
//
//    public List<Object> getMovieAtributes() {
//        return movieAtributes;
//    }
//
//    public void setMovieAtributes(List<Object> movieAtributes) {
//        this.movieAtributes = movieAtributes;
//    }
//
//    public MovieSources getMovieSources() {
//        return movieSources;
//    }
//
//    public void setMovieSources(MovieSources movieSources) {
//        this.movieSources = movieSources;
//    }
//
//    public String getMovieRestrication() {
//        return movieRestrication;
//    }
//
//    public void setMovieRestrication(String movieRestrication) {
//        this.movieRestrication = movieRestrication;
//    }
//
//    public Boolean getMovieDisplayForLoggedUser() {
//        return movieDisplayForLoggedUser;
//    }
//
//    public void setMovieDisplayForLoggedUser(Boolean movieDisplayForLoggedUser) {
//        this.movieDisplayForLoggedUser = movieDisplayForLoggedUser;
//    }
//
//    public Boolean getMovieEnableCustomMessage() {
//        return movieEnableCustomMessage;
//    }
//
//    public void setMovieEnableCustomMessage(Boolean movieEnableCustomMessage) {
//        this.movieEnableCustomMessage = movieEnableCustomMessage;
//    }
//
//    public String getMovieMessageForLoggedOutUser() {
//        return movieMessageForLoggedOutUser;
//    }
//
//    public void setMovieMessageForLoggedOutUser(String movieMessageForLoggedOutUser) {
//        this.movieMessageForLoggedOutUser = movieMessageForLoggedOutUser;
//    }
//
//    public String getMovieMessageForLoggedOutUserMedia() {
//        return movieMessageForLoggedOutUserMedia;
//    }
//
//    public void setMovieMessageForLoggedOutUserMedia(String movieMessageForLoggedOutUserMedia) {
//        this.movieMessageForLoggedOutUserMedia = movieMessageForLoggedOutUserMedia;
//    }
//
//    public String getMovieMessageForLoggedInNonMembera() {
//        return movieMessageForLoggedInNonMembera;
//    }
//
//    public void setMovieMessageForLoggedInNonMembera(String movieMessageForLoggedInNonMembera) {
//        this.movieMessageForLoggedInNonMembera = movieMessageForLoggedInNonMembera;
//    }
//
//    public String getMovieMessageForLoggedInNonMemberaMedia() {
//        return movieMessageForLoggedInNonMemberaMedia;
//    }
//
//    public void setMovieMessageForLoggedInNonMemberaMedia(String movieMessageForLoggedInNonMemberaMedia) {
//        this.movieMessageForLoggedInNonMemberaMedia = movieMessageForLoggedInNonMemberaMedia;
//    }
//
//    public String getMovieDescription() {
//        return movieDescription;
//    }
//
//    public void setMovieDescription(String movieDescription) {
//        this.movieDescription = movieDescription;
//    }
//
//    public String getMovieDescriptionMedia() {
//        return movieDescriptionMedia;
//    }
//
//    public void setMovieDescriptionMedia(String movieDescriptionMedia) {
//        this.movieDescriptionMedia = movieDescriptionMedia;
//    }
//
//    public String getMovieVisibility() {
//        return movieVisibility;
//    }
//
//    public void setMovieVisibility(String movieVisibility) {
//        this.movieVisibility = movieVisibility;
//    }
//
//    public String getMovieProtectedPassword() {
//        return movieProtectedPassword;
//    }
//
//    public void setMovieProtectedPassword(String movieProtectedPassword) {
//        this.movieProtectedPassword = movieProtectedPassword;
//    }
//
//    public String getMoviePublish() {
//        return moviePublish;
//    }
//
//    public void setMoviePublish(String moviePublish) {
//        this.moviePublish = moviePublish;
//    }
//
//    public Boolean getMoviePendingReview() {
//        return moviePendingReview;
//    }
//
//    public void setMoviePendingReview(Boolean moviePendingReview) {
//        this.moviePendingReview = moviePendingReview;
//    }
//
//    public String getMovieSlug() {
//        return movieSlug;
//    }
//
//    public void setMovieSlug(String movieSlug) {
//        this.movieSlug = movieSlug;
//    }
//
//    public String getMovieImage() {
//        return movieImage;
//    }
//
//    public void setMovieImage(String movieImage) {
//        this.movieImage = movieImage;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//}

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("movieTitle")
    @Expose
    private String movieTitle;
    @SerializedName("movieLogo")
    @Expose
    private Object movieLogo;
    @SerializedName("movieTrailer")
    @Expose
    private Object movieTrailer;
    @SerializedName("movieUpcoming")
    @Expose
    private Boolean movieUpcoming;
    @SerializedName("movieIMDBRating")
    @Expose
    private Object movieIMDBRating;
    @SerializedName("movieMethod")
    @Expose
    private Object movieMethod;
    @SerializedName("movieUpload")
    @Expose
    private Object movieUpload;
    @SerializedName("movieURL")
    @Expose
    private String movieURL;
    @SerializedName("movieAffiliateUrl")
    @Expose
    private Boolean movieAffiliateUrl;
    @SerializedName("movieEmbedContent")
    @Expose
    private Object movieEmbedContent;
    @SerializedName("movieReleaseDate")
    @Expose
    private Object movieReleaseDate;
    @SerializedName("movieDateadded")
    @Expose
    private String movieDateadded;
    @SerializedName("movieTimeDuration")
    @Expose
    private Object movieTimeDuration;
    @SerializedName("movieCensorRating")
    @Expose
    private String movieCensorRating;
    @SerializedName("movieIMDBID")
    @Expose
    private Object movieIMDBID;
    @SerializedName("movieTMDBID")
    @Expose
    private Object movieTMDBID;
    @SerializedName("movieCatlogVisibility")
    @Expose
    private Object movieCatlogVisibility;
    @SerializedName("movieId")
    @Expose
    private String movieId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("movieFeatured")
    @Expose
    private Boolean movieFeatured;
    @SerializedName("movieLinkedMovie")
    @Expose
    private Object movieLinkedMovie;
    @SerializedName("movieLinkedVideo")
    @Expose
    private Object movieLinkedVideo;
    @SerializedName("movieCast")
    @Expose
    private List<String> movieCast = null;
    @SerializedName("movieGenres")
    @Expose
    private List<String> movieGenres = null;
    @SerializedName("movieCrew")
    @Expose
    private List<String> movieCrew = null;
    @SerializedName("movieAtributes")
    @Expose
    private Object movieAtributes;
    @SerializedName("movielanguages")
    @Expose
    private List<String> movielanguages = null;
    @SerializedName("movieSources")
    @Expose
    private Object movieSources;
    @SerializedName("movieRestrication")
    @Expose
    private Object movieRestrication;
    @SerializedName("movieDisplayForLoggedUser")
    @Expose
    private Boolean movieDisplayForLoggedUser;
    @SerializedName("movieEnableCustomMessage")
    @Expose
    private Boolean movieEnableCustomMessage;
    @SerializedName("movieMessageForLoggedOutUser")
    @Expose
    private Object movieMessageForLoggedOutUser;
    @SerializedName("movieMessageForLoggedOutUserMedia")
    @Expose
    private Object movieMessageForLoggedOutUserMedia;
    @SerializedName("movieMessageForLoggedInNonMembera")
    @Expose
    private Object movieMessageForLoggedInNonMembera;
    @SerializedName("movieMessageForLoggedInNonMemberaMedia")
    @Expose
    private Object movieMessageForLoggedInNonMemberaMedia;
    @SerializedName("movieDescription")
    @Expose
    private String movieDescription;
    @SerializedName("movieDescriptionMedia")
    @Expose
    private Object movieDescriptionMedia;
    @SerializedName("movieVisibility")
    @Expose
    private Object movieVisibility;
    @SerializedName("movieProtectedPassword")
    @Expose
    private Object movieProtectedPassword;
    @SerializedName("moviePublish")
    @Expose
    private Object moviePublish;
    @SerializedName("moviePendingReview")
    @Expose
    private Boolean moviePendingReview;
    @SerializedName("movieSlug")
    @Expose
    private Object movieSlug;
    @SerializedName("movieImage")
    @Expose
    private String movieImage;
    @SerializedName("newVisitor")
    @Expose
    private Integer newVisitor;
    @SerializedName("returnVisitor")
    @Expose
    private Integer returnVisitor;
    @SerializedName("moviesrtPath")
    @Expose
    private Object moviesrtPath;
    @SerializedName("subscriptionType")
    @Expose
    private Object subscriptionType;
    @SerializedName("movieUid")
    @Expose
    private Object movieUid;
    @SerializedName("movieDash")
    @Expose
    private String movieDash;
    @SerializedName("movieTrailerUid")
    @Expose
    private Object movieTrailerUid;
    @SerializedName("movieTrailerDash")
    @Expose
    private Object movieTrailerDash;
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

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Object getMovieLogo() {
        return movieLogo;
    }

    public void setMovieLogo(Object movieLogo) {
        this.movieLogo = movieLogo;
    }

    public Object getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(Object movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public Boolean getMovieUpcoming() {
        return movieUpcoming;
    }

    public void setMovieUpcoming(Boolean movieUpcoming) {
        this.movieUpcoming = movieUpcoming;
    }

    public Object getMovieIMDBRating() {
        return movieIMDBRating;
    }

    public void setMovieIMDBRating(Object movieIMDBRating) {
        this.movieIMDBRating = movieIMDBRating;
    }

    public Object getMovieMethod() {
        return movieMethod;
    }

    public void setMovieMethod(Object movieMethod) {
        this.movieMethod = movieMethod;
    }

    public Object getMovieUpload() {
        return movieUpload;
    }

    public void setMovieUpload(Object movieUpload) {
        this.movieUpload = movieUpload;
    }

    public String getMovieURL() {
        return movieURL;
    }

    public void setMovieURL(String movieURL) {
        this.movieURL = movieURL;
    }

    public Boolean getMovieAffiliateUrl() {
        return movieAffiliateUrl;
    }

    public void setMovieAffiliateUrl(Boolean movieAffiliateUrl) {
        this.movieAffiliateUrl = movieAffiliateUrl;
    }

    public Object getMovieEmbedContent() {
        return movieEmbedContent;
    }

    public void setMovieEmbedContent(Object movieEmbedContent) {
        this.movieEmbedContent = movieEmbedContent;
    }

    public Object getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(Object movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieDateadded() {
        return movieDateadded;
    }

    public void setMovieDateadded(String movieDateadded) {
        this.movieDateadded = movieDateadded;
    }

    public Object getMovieTimeDuration() {
        return movieTimeDuration;
    }

    public void setMovieTimeDuration(Object movieTimeDuration) {
        this.movieTimeDuration = movieTimeDuration;
    }

    public String getMovieCensorRating() {
        return movieCensorRating;
    }

    public void setMovieCensorRating(String movieCensorRating) {
        this.movieCensorRating = movieCensorRating;
    }

    public Object getMovieIMDBID() {
        return movieIMDBID;
    }

    public void setMovieIMDBID(Object movieIMDBID) {
        this.movieIMDBID = movieIMDBID;
    }

    public Object getMovieTMDBID() {
        return movieTMDBID;
    }

    public void setMovieTMDBID(Object movieTMDBID) {
        this.movieTMDBID = movieTMDBID;
    }

    public Object getMovieCatlogVisibility() {
        return movieCatlogVisibility;
    }

    public void setMovieCatlogVisibility(Object movieCatlogVisibility) {
        this.movieCatlogVisibility = movieCatlogVisibility;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
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

    public Boolean getMovieFeatured() {
        return movieFeatured;
    }

    public void setMovieFeatured(Boolean movieFeatured) {
        this.movieFeatured = movieFeatured;
    }

    public Object getMovieLinkedMovie() {
        return movieLinkedMovie;
    }

    public void setMovieLinkedMovie(Object movieLinkedMovie) {
        this.movieLinkedMovie = movieLinkedMovie;
    }

    public Object getMovieLinkedVideo() {
        return movieLinkedVideo;
    }

    public void setMovieLinkedVideo(Object movieLinkedVideo) {
        this.movieLinkedVideo = movieLinkedVideo;
    }

    public List<String> getMovieCast() {
        return movieCast;
    }

    public void setMovieCast(List<String> movieCast) {
        this.movieCast = movieCast;
    }

    public List<String> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(List<String> movieGenres) {
        this.movieGenres = movieGenres;
    }

    public List<String> getMovieCrew() {
        return movieCrew;
    }

    public void setMovieCrew(List<String> movieCrew) {
        this.movieCrew = movieCrew;
    }

    public Object getMovieAtributes() {
        return movieAtributes;
    }

    public void setMovieAtributes(Object movieAtributes) {
        this.movieAtributes = movieAtributes;
    }

    public List<String> getMovielanguages() {
        return movielanguages;
    }

    public void setMovielanguages(List<String> movielanguages) {
        this.movielanguages = movielanguages;
    }

    public Object getMovieSources() {
        return movieSources;
    }

    public void setMovieSources(Object movieSources) {
        this.movieSources = movieSources;
    }

    public Object getMovieRestrication() {
        return movieRestrication;
    }

    public void setMovieRestrication(Object movieRestrication) {
        this.movieRestrication = movieRestrication;
    }

    public Boolean getMovieDisplayForLoggedUser() {
        return movieDisplayForLoggedUser;
    }

    public void setMovieDisplayForLoggedUser(Boolean movieDisplayForLoggedUser) {
        this.movieDisplayForLoggedUser = movieDisplayForLoggedUser;
    }

    public Boolean getMovieEnableCustomMessage() {
        return movieEnableCustomMessage;
    }

    public void setMovieEnableCustomMessage(Boolean movieEnableCustomMessage) {
        this.movieEnableCustomMessage = movieEnableCustomMessage;
    }

    public Object getMovieMessageForLoggedOutUser() {
        return movieMessageForLoggedOutUser;
    }

    public void setMovieMessageForLoggedOutUser(Object movieMessageForLoggedOutUser) {
        this.movieMessageForLoggedOutUser = movieMessageForLoggedOutUser;
    }

    public Object getMovieMessageForLoggedOutUserMedia() {
        return movieMessageForLoggedOutUserMedia;
    }

    public void setMovieMessageForLoggedOutUserMedia(Object movieMessageForLoggedOutUserMedia) {
        this.movieMessageForLoggedOutUserMedia = movieMessageForLoggedOutUserMedia;
    }

    public Object getMovieMessageForLoggedInNonMembera() {
        return movieMessageForLoggedInNonMembera;
    }

    public void setMovieMessageForLoggedInNonMembera(Object movieMessageForLoggedInNonMembera) {
        this.movieMessageForLoggedInNonMembera = movieMessageForLoggedInNonMembera;
    }

    public Object getMovieMessageForLoggedInNonMemberaMedia() {
        return movieMessageForLoggedInNonMemberaMedia;
    }

    public void setMovieMessageForLoggedInNonMemberaMedia(Object movieMessageForLoggedInNonMemberaMedia) {
        this.movieMessageForLoggedInNonMemberaMedia = movieMessageForLoggedInNonMemberaMedia;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public Object getMovieDescriptionMedia() {
        return movieDescriptionMedia;
    }

    public void setMovieDescriptionMedia(Object movieDescriptionMedia) {
        this.movieDescriptionMedia = movieDescriptionMedia;
    }

    public Object getMovieVisibility() {
        return movieVisibility;
    }

    public void setMovieVisibility(Object movieVisibility) {
        this.movieVisibility = movieVisibility;
    }

    public Object getMovieProtectedPassword() {
        return movieProtectedPassword;
    }

    public void setMovieProtectedPassword(Object movieProtectedPassword) {
        this.movieProtectedPassword = movieProtectedPassword;
    }

    public Object getMoviePublish() {
        return moviePublish;
    }

    public void setMoviePublish(Object moviePublish) {
        this.moviePublish = moviePublish;
    }

    public Boolean getMoviePendingReview() {
        return moviePendingReview;
    }

    public void setMoviePendingReview(Boolean moviePendingReview) {
        this.moviePendingReview = moviePendingReview;
    }

    public Object getMovieSlug() {
        return movieSlug;
    }

    public void setMovieSlug(Object movieSlug) {
        this.movieSlug = movieSlug;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
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

    public Object getMoviesrtPath() {
        return moviesrtPath;
    }

    public void setMoviesrtPath(Object moviesrtPath) {
        this.moviesrtPath = moviesrtPath;
    }

    public Object getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(Object subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Object getMovieUid() {
        return movieUid;
    }

    public void setMovieUid(Object movieUid) {
        this.movieUid = movieUid;
    }

    public String getMovieDash() {
        return movieDash;
    }

    public void setMovieDash(String movieDash) {
        this.movieDash = movieDash;
    }

    public Object getMovieTrailerUid() {
        return movieTrailerUid;
    }

    public void setMovieTrailerUid(Object movieTrailerUid) {
        this.movieTrailerUid = movieTrailerUid;
    }

    public Object getMovieTrailerDash() {
        return movieTrailerDash;
    }

    public void setMovieTrailerDash(Object movieTrailerDash) {
        this.movieTrailerDash = movieTrailerDash;
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
