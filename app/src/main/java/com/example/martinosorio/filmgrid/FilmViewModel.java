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

        downloadImage();
    }

    private void downloadImage(){//TODO
        new ImageDownloader(holder.imageView).execute("http://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png");
    }
}
