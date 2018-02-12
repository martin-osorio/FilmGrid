package com.example.martinosorio.filmgrid.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("image")
    private List<Image> image = null;

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

}
