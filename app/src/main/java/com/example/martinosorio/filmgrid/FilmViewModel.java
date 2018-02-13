package com.example.martinosorio.filmgrid;

import android.databinding.Bindable;
import android.databinding.Observable;

import com.example.martinosorio.filmgrid.model.Film;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmViewModel implements Observable {
    private String title;
    private FilmViewHolder holder;
    private int id;

    FilmViewModel(FilmViewHolder holder, Film film, int id) {
        EventBus.getDefault().register(this);

        this.holder = holder;
        this.id = id;

        if (film != null) {
            this.title = film.getTitle();

            if (film.getImages() != null && film.getImages().getImage() != null && film.getImages().getImage().get(0) != null) {
                String url = film.getImages().getImage().get(0).getSrc();

                if (url != null && !url.isEmpty()) {
                    new ImageDownloader(id).execute(url);
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onImageDownloadedEvent(ImageDownloadedEvent event) {
        if (this.id == event.id) {
            holder.getImageView().setImageBitmap(event.image);
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
