package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Languages {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

}

