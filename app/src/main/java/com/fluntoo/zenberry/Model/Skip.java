package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Skip {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("skipUserId")
    @Expose
    private Integer skipUserId;
    @SerializedName("deviceType")
    @Expose
    private Object deviceType;
    @SerializedName("skipUserIp")
    @Expose
    private Object skipUserIp;
    @SerializedName("alreadyExist")
    @Expose
    private String alreadyExist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSkipUserId() {
        return skipUserId;
    }

    public void setSkipUserId(Integer skipUserId) {
        this.skipUserId = skipUserId;
    }

    public Object getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Object deviceType) {
        this.deviceType = deviceType;
    }

    public Object getSkipUserIp() {
        return skipUserIp;
    }

    public void setSkipUserIp(Object skipUserIp) {
        this.skipUserIp = skipUserIp;
    }

    public String getAlreadyExist() {
        return alreadyExist;
    }

    public void setAlreadyExist(String alreadyExist) {
        this.alreadyExist = alreadyExist;
    }
}
