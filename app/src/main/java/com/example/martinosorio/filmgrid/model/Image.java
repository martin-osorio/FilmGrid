package com.example.martinosorio.filmgrid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martin on 2/12/2018.
 */

public class Image {

    @SerializedName("src")
    private String src;

    public String getSrc() {
        return src;
    }
}
