
package com.example.martinosorio.filmgrid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("films")
    @Expose
    private Films films;

    public Films getFilms() {
        return films;
    }

    public void setFilms(Films films) {
        this.films = films;
    }

}
