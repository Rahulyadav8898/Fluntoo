package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Videoc {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("errors")
    @Expose
    private List<Object> errors = null;
    @SerializedName("messages")
    @Expose
    private List<Object> messages = null;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public List<Object> getMessages() {
        return messages;
    }

    public void setMessages(List<Object> messages) {
        this.messages = messages;
    }


public class Input {

    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}

public class Meta {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

public class Playback {

    @SerializedName("hls")
    @Expose
    private String hls;
    @SerializedName("dash")
    @Expose
    private String dash;

    public String getHls() {
        return hls;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }

    public String getDash() {
        return dash;
    }

    public void setDash(String dash) {
        this.dash = dash;
    }

}

public class Result {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("thumbnailTimestampPct")
    @Expose
    private Integer thumbnailTimestampPct;
    @SerializedName("readyToStream")
    @Expose
    private Boolean readyToStream;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("preview")
    @Expose
    private String preview;
    @SerializedName("allowedOrigins")
    @Expose
    private List<Object> allowedOrigins = null;
    @SerializedName("requireSignedURLs")
    @Expose
    private Boolean requireSignedURLs;
    @SerializedName("uploaded")
    @Expose
    private String uploaded;
    @SerializedName("uploadExpiry")
    @Expose
    private Object uploadExpiry;
    @SerializedName("maxSizeBytes")
    @Expose
    private Object maxSizeBytes;
    @SerializedName("maxDurationSeconds")
    @Expose
    private Object maxDurationSeconds;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("input")
    @Expose
    private Input input;
    @SerializedName("playback")
    @Expose
    private Playback playback;
    @SerializedName("watermark")
    @Expose
    private Object watermark;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getThumbnailTimestampPct() {
        return thumbnailTimestampPct;
    }

    public void setThumbnailTimestampPct(Integer thumbnailTimestampPct) {
        this.thumbnailTimestampPct = thumbnailTimestampPct;
    }

    public Boolean getReadyToStream() {
        return readyToStream;
    }

    public void setReadyToStream(Boolean readyToStream) {
        this.readyToStream = readyToStream;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public List<Object> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<Object> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public Boolean getRequireSignedURLs() {
        return requireSignedURLs;
    }

    public void setRequireSignedURLs(Boolean requireSignedURLs) {
        this.requireSignedURLs = requireSignedURLs;
    }

    public String getUploaded() {
        return uploaded;
    }

    public void setUploaded(String uploaded) {
        this.uploaded = uploaded;
    }

    public Object getUploadExpiry() {
        return uploadExpiry;
    }

    public void setUploadExpiry(Object uploadExpiry) {
        this.uploadExpiry = uploadExpiry;
    }

    public Object getMaxSizeBytes() {
        return maxSizeBytes;
    }

    public void setMaxSizeBytes(Object maxSizeBytes) {
        this.maxSizeBytes = maxSizeBytes;
    }

    public Object getMaxDurationSeconds() {
        return maxDurationSeconds;
    }

    public void setMaxDurationSeconds(Object maxDurationSeconds) {
        this.maxDurationSeconds = maxDurationSeconds;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Playback getPlayback() {
        return playback;
    }

    public void setPlayback(Playback playback) {
        this.playback = playback;
    }

    public Object getWatermark() {
        return watermark;
    }

    public void setWatermark(Object watermark) {
        this.watermark = watermark;
    }

}

public class Status {

    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("errorReasonCode")
    @Expose
    private String errorReasonCode;
    @SerializedName("errorReasonText")
    @Expose
    private String errorReasonText;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getErrorReasonCode() {
        return errorReasonCode;
    }

    public void setErrorReasonCode(String errorReasonCode) {
        this.errorReasonCode = errorReasonCode;
    }

    public String getErrorReasonText() {
        return errorReasonText;
    }

    public void setErrorReasonText(String errorReasonText) {
        this.errorReasonText = errorReasonText;
    }

}
}