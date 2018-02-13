package com.example.martinosorio.filmgrid.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Martin on 2/12/2018.
 */

public class Images {

    @SerializedName("image")
    private List<Image> image = null;

    public List<Image> getImage() {
        return image;
    }
}
