package com.example.martinosorio.filmgrid;

import com.example.martinosorio.filmgrid.model.Films;

/**
 * Created by Martin on 2/12/2018.
 */

class FilmsDownloadedEvent {
    Films films;

    FilmsDownloadedEvent(Films films) {
        this.films = films;
    }
}
