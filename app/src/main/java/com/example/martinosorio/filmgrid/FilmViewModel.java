package com.example.martinosorio.filmgrid;

import android.widget.ImageView;

import com.example.martinosorio.filmgrid.model.Film;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmViewModel {
    FilmViewHolder holder;
    Film film;

    public FilmViewModel(FilmViewHolder holder, Film film) {
        this.holder = holder;
        this.film = film;
    }
}
