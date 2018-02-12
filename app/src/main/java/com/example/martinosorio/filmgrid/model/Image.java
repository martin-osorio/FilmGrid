package com.example.martinosorio.filmgrid.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("height")
    private Object height;
    @SerializedName("src")
    private String src;
    @SerializedName("type")
    private String type;
    @SerializedName("width")
    private Object width;
    @SerializedName("rokuSrc")
    private Object rokuSrc;

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getWidth() {
        return width;
    }

    public void setWidth(Object width) {
        this.width = width;
    }

    public Object getRokuSrc() {
        return rokuSrc;
    }

    public void setRokuSrc(Object rokuSrc) {
        this.rokuSrc = rokuSrc;
    }

}
