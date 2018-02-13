package com.example.martinosorio.filmgrid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martin on 2/12/2018.
 */

public class SnagfilmsReply {

    @SerializedName("films")
    private Films films;

    public Films getFilms() {
        return films;
    }
}
