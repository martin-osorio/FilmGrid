package com.example.martinosorio.filmgrid;

import android.databinding.Bindable;

import com.example.martinosorio.filmgrid.model.Film;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmViewModel {
    private FilmViewHolder holder;
    private Film film;
    private String title;
    private String url;

    public FilmViewModel(FilmViewHolder holder, Film film) {
        this.holder = holder;
        this.film = film;
        this.title = film.getTitle();
        this.url = film.getImages().getImage().get(0).getSrc();//TODO

        new ImageDownloader(holder.getImageView()).execute("https://www.google.com/images/srpr/logo11w.png");//TODO
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
