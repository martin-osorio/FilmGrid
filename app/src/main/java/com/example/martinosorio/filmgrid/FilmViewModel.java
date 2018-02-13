package com.example.martinosorio.filmgrid;

import android.databinding.Bindable;
import android.databinding.Observable;

import com.example.martinosorio.filmgrid.model.Film;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmViewModel implements Observable {
    private String title;

    FilmViewModel(FilmViewHolder holder, Film film) {
        if (film != null) {
            this.title = film.getTitle();

            if (film.getImages() != null && film.getImages().getImage() != null && film.getImages().getImage().get(0) != null) {
                String url = film.getImages().getImage().get(0).getSrc();

                if (url != null && !url.isEmpty()) {
                    new ImageDownloader(holder.getImageView()).execute(url);
                }
            }
        }
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
    }
}
