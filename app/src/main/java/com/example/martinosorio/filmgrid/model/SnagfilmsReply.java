package com.example.martinosorio.filmgrid.model;

import com.google.gson.annotations.SerializedName;

public class SnagfilmsReply {

    @SerializedName("films")
    private Films films;

    public Films getFilms() {
        return films;
    }

    public void setFilms(Films films) {
        this.films = films;
    }

}
