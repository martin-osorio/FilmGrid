package com.example.martinosorio.filmgrid.event;

import com.example.martinosorio.filmgrid.model.Films;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmsDownloadedEvent {
    private Films films;

    public FilmsDownloadedEvent(Films films) {
        this.films = films;
    }

    public Films getFilms() {
        return films;
    }
}
