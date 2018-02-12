package com.example.martinosorio.filmgrid.model;

import com.google.gson.annotations.SerializedName;

public class Film {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("images")
    private Images images;

    @SerializedName("permaLink")
    private String permaLink;

    @SerializedName("show_title")
    private Object showTitle;

    @SerializedName("show_id")
    private Object showId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getPermaLink() {
        return permaLink;
    }

    public void setPermaLink(String permaLink) {
        this.permaLink = permaLink;
    }

    public Object getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(Object showTitle) {
        this.showTitle = showTitle;
    }

    public Object getShowId() {
        return showId;
    }

    public void setShowId(Object showId) {
        this.showId = showId;
    }
}
