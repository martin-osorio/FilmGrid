package com.example.martinosorio.filmgrid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martin on 2/12/2018.
 */

public class Film {

    @SerializedName("title")
    private String title;

    @SerializedName("images")
    private Images images;

    public String getTitle() {
        return title;
    }

    public Images getImages() {
        return images;
    }
}
