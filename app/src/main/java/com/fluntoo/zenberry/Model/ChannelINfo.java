package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChannelINfo {
//    @SerializedName("channeldynamicId")
//    @Expose
//    private String channeldynamicId;
//    @SerializedName("myChannel")
//    @Expose
//    private String myChannel;
//    @SerializedName("bellicon")
//    @Expose
//    private Object bellicon;
//    @SerializedName("totalviews")
//    @Expose
//    private Integer totalviews;
//    @SerializedName("totalvideos")
//    @Expose
//    private Integer totalvideos;
//    @SerializedName("lastupdate")
//    @Expose
//    private Object lastupdate;
//    @SerializedName("channelProfileimagepath")
//    @Expose
//    private String channelProfileimagepath;
//    @SerializedName("channelDescription")
//    @Expose
//    private String channelDescription;
//    @SerializedName("channelName")
//    @Expose
//    private String channelName;
//    @SerializedName("channelProfilecoverpath")
//    @Expose
//    private String channelProfilecoverpath;
//    @SerializedName("channelUserId")
//    @Expose
//    private Integer channelUserId;
//    @SerializedName("channelId")
//    @Expose
//    private Integer channelId;
//    @SerializedName("subscribe")
//    @Expose
//    private String subscribe;
//    @SerializedName("subscribers")
//    @Expose
//    private Integer subscribers;
//    @SerializedName("channelFacebookAccount")
//    @Expose
//    private String channelFacebookAccount;
//    @SerializedName("channelLinkedInAccount")
//    @Expose
//    private String channelLinkedInAccount;
//    @SerializedName("channelGoogleBussinessAccount")
//    @Expose
//    private String channelGoogleBussinessAccount;
//    @SerializedName("channelInstagramAccount")
//    @Expose
//    private String channelInstagramAccount;
//    @SerializedName("channeltwitterAccount")
//    @Expose
//    private String channeltwitterAccount;
//    @SerializedName("channelDateadded")
//    @Expose
//    private Long channelDateadded;
//
//    public String getChanneldynamicId() {
//        return channeldynamicId;
//    }
//
//    public void setChanneldynamicId(String channeldynamicId) {
//        this.channeldynamicId = channeldynamicId;
//    }
//
//    public String getMyChannel() {
//        return myChannel;
//    }
//
//    public void setMyChannel(String myChannel) {
//        this.myChannel = myChannel;
//    }
//
//    public Object getBellicon() {
//        return bellicon;
//    }
//
//    public void setBellicon(Object bellicon) {
//        this.bellicon = bellicon;
//    }
//
//    public Integer getTotalviews() {
//        return totalviews;
//    }
//
//    public void setTotalviews(Integer totalviews) {
//        this.totalviews = totalviews;
//    }
//
//    public Integer getTotalvideos() {
//        return totalvideos;
//    }
//
//    public void setTotalvideos(Integer totalvideos) {
//        this.totalvideos = totalvideos;
//    }
//
//    public Object getLastupdate() {
//        return lastupdate;
//    }
//
//    public void setLastupdate(Object lastupdate) {
//        this.lastupdate = lastupdate;
//    }
//
//    public String getChannelProfileimagepath() {
//        return channelProfileimagepath;
//    }
//
//    public void setChannelProfileimagepath(String channelProfileimagepath) {
//        this.channelProfileimagepath = channelProfileimagepath;
//    }
//
//    public String getChannelDescription() {
//        return channelDescription;
//    }
//
//    public void setChannelDescription(String channelDescription) {
//        this.channelDescription = channelDescription;
//    }
//
//    public String getChannelName() {
//        return channelName;
//    }
//
//    public void setChannelName(String channelName) {
//        this.channelName = channelName;
//    }
//
//    public String getChannelProfilecoverpath() {
//        return channelProfilecoverpath;
//    }
//
//    public void setChannelProfilecoverpath(String channelProfilecoverpath) {
//        this.channelProfilecoverpath = channelProfilecoverpath;
//    }
//
//    public Integer getChannelUserId() {
//        return channelUserId;
//    }
//
//    public void setChannelUserId(Integer channelUserId) {
//        this.channelUserId = channelUserId;
//    }
//
//    public Integer getChannelId() {
//        return channelId;
//    }
//
//    public void setChannelId(Integer channelId) {
//        this.channelId = channelId;
//    }
//
//    public String getSubscribe() {
//        return subscribe;
//    }
//
//    public void setSubscribe(String subscribe) {
//        this.subscribe = subscribe;
//    }
//
//    public Integer getSubscribers() {
//        return subscribers;
//    }
//
//    public void setSubscribers(Integer subscribers) {
//        this.subscribers = subscribers;
//    }
//
//    public String getChannelFacebookAccount() {
//        return channelFacebookAccount;
//    }
//
//    public void setChannelFacebookAccount(String channelFacebookAccount) {
//        this.channelFacebookAccount = channelFacebookAccount;
//    }
//
//    public String getChannelLinkedInAccount() {
//        return channelLinkedInAccount;
//    }
//
//    public void setChannelLinkedInAccount(String channelLinkedInAccount) {
//        this.channelLinkedInAccount = channelLinkedInAccount;
//    }
//
//    public String getChannelGoogleBussinessAccount() {
//        return channelGoogleBussinessAccount;
//    }
//
//    public void setChannelGoogleBussinessAccount(String channelGoogleBussinessAccount) {
//        this.channelGoogleBussinessAccount = channelGoogleBussinessAccount;
//    }
//
//    public String getChannelInstagramAccount() {
//        return channelInstagramAccount;
//    }
//
//    public void setChannelInstagramAccount(String channelInstagramAccount) {
//        this.channelInstagramAccount = channelInstagramAccount;
//    }
//
//    public String getChanneltwitterAccount() {
//        return channeltwitterAccount;
//    }
//
//    public void setChanneltwitterAccount(String channeltwitterAccount) {
//        this.channeltwitterAccount = channeltwitterAccount;
//    }
//
//    public Long getChannelDateadded() {
//        return channelDateadded;
//    }
//
//    public void setChannelDateadded(Long channelDateadded) {
//        this.channelDateadded = channelDateadded;
//    }


    @SerializedName("channelId")
    @Expose
    private Integer channelId;
    @SerializedName("channeldynamicId")
    @Expose
    private String channeldynamicId;
    @SerializedName("channelwebsitelink")
    @Expose
    private Object channelwebsitelink;
    @SerializedName("myChannel")
    @Expose
    private String myChannel;
    @SerializedName("bellicon")
    @Expose
    private Object bellicon;
    @SerializedName("totalviews")
    @Expose
    private Integer totalviews;
    @SerializedName("totalvideos")
    @Expose
    private Integer totalvideos;
    @SerializedName("copyrightclaim")
    @Expose
    private Integer copyrightclaim;
    @SerializedName("lastupdate")
    @Expose
    private Object lastupdate;
    @SerializedName("complain")
    @Expose
    private Object complain;
    @SerializedName("copyrightStatus")
    @Expose
    private Object copyrightStatus;
    @SerializedName("channelFacebookAccount")
    @Expose
    private String channelFacebookAccount;
    @SerializedName("channeltwitterAccount")
    @Expose
    private Object channeltwitterAccount;
    @SerializedName("channelLinkedInAccount")
    @Expose
    private Object channelLinkedInAccount;
    @SerializedName("channelGoogleBussinessAccount")
    @Expose
    private String channelGoogleBussinessAccount;
    @SerializedName("channelInstagramAccount")
    @Expose
    private String channelInstagramAccount;
    @SerializedName("subscribers")
    @Expose
    private Integer subscribers;
    @SerializedName("subscribe")
    @Expose
    private String subscribe;
    @SerializedName("channelDateadded")
    @Expose
    private String channelDateadded;
    @SerializedName("channelName")
    @Expose
    private String channelName;
    @SerializedName("channelDescription")
    @Expose
    private String channelDescription;
    @SerializedName("channelProfileimagepath")
    @Expose
    private String channelProfileimagepath;
    @SerializedName("channelProfilecoverpath")
    @Expose
    private String channelProfilecoverpath;
    @SerializedName("channelUserId")
    @Expose
    private Integer channelUserId;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChanneldynamicId() {
        return channeldynamicId;
    }

    public void setChanneldynamicId(String channeldynamicId) {
        this.channeldynamicId = channeldynamicId;
    }

    public Object getChannelwebsitelink() {
        return channelwebsitelink;
    }

    public void setChannelwebsitelink(Object channelwebsitelink) {
        this.channelwebsitelink = channelwebsitelink;
    }

    public String getMyChannel() {
        return myChannel;
    }

    public void setMyChannel(String myChannel) {
        this.myChannel = myChannel;
    }

    public Object getBellicon() {
        return bellicon;
    }

    public void setBellicon(Object bellicon) {
        this.bellicon = bellicon;
    }

    public Integer getTotalviews() {
        return totalviews;
    }

    public void setTotalviews(Integer totalviews) {
        this.totalviews = totalviews;
    }

    public Integer getTotalvideos() {
        return totalvideos;
    }

    public void setTotalvideos(Integer totalvideos) {
        this.totalvideos = totalvideos;
    }

    public Integer getCopyrightclaim() {
        return copyrightclaim;
    }

    public void setCopyrightclaim(Integer copyrightclaim) {
        this.copyrightclaim = copyrightclaim;
    }

    public Object getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Object lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Object getComplain() {
        return complain;
    }

    public void setComplain(Object complain) {
        this.complain = complain;
    }

    public Object getCopyrightStatus() {
        return copyrightStatus;
    }

    public void setCopyrightStatus(Object copyrightStatus) {
        this.copyrightStatus = copyrightStatus;
    }

    public String getChannelFacebookAccount() {
        return channelFacebookAccount;
    }

    public void setChannelFacebookAccount(String channelFacebookAccount) {
        this.channelFacebookAccount = channelFacebookAccount;
    }

    public Object getChanneltwitterAccount() {
        return channeltwitterAccount;
    }

    public void setChanneltwitterAccount(Object channeltwitterAccount) {
        this.channeltwitterAccount = channeltwitterAccount;
    }

    public Object getChannelLinkedInAccount() {
        return channelLinkedInAccount;
    }

    public void setChannelLinkedInAccount(Object channelLinkedInAccount) {
        this.channelLinkedInAccount = channelLinkedInAccount;
    }

    public String getChannelGoogleBussinessAccount() {
        return channelGoogleBussinessAccount;
    }

    public void setChannelGoogleBussinessAccount(String channelGoogleBussinessAccount) {
        this.channelGoogleBussinessAccount = channelGoogleBussinessAccount;
    }

    public String getChannelInstagramAccount() {
        return channelInstagramAccount;
    }

    public void setChannelInstagramAccount(String channelInstagramAccount) {
        this.channelInstagramAccount = channelInstagramAccount;
    }

    public Integer getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Integer subscribers) {
        this.subscribers = subscribers;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getChannelDateadded() {
        return channelDateadded;
    }

    public void setChannelDateadded(String channelDateadded) {
        this.channelDateadded = channelDateadded;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        this.channelDescription = channelDescription;
    }

    public String getChannelProfileimagepath() {
        return channelProfileimagepath;
    }

    public void setChannelProfileimagepath(String channelProfileimagepath) {
        this.channelProfileimagepath = channelProfileimagepath;
    }

    public String getChannelProfilecoverpath() {
        return channelProfilecoverpath;
    }

    public void setChannelProfilecoverpath(String channelProfilecoverpath) {
        this.channelProfilecoverpath = channelProfilecoverpath;
    }

    public Integer getChannelUserId() {
        return channelUserId;
    }

    public void setChannelUserId(Integer channelUserId) {
        this.channelUserId = channelUserId;
    }

}

