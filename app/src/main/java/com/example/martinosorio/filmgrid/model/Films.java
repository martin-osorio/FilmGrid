package com.example.martinosorio.filmgrid.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martin on 2/12/2018.
 */

public class Films {

    @SerializedName("film")
    private List<Film> films = null;

    public List<Film> getFilms() {
        return films;
    }
}
