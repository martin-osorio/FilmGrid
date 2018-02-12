package com.example.martinosorio.filmgrid;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.view.View;

import com.example.martinosorio.filmgrid.model.Film;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmViewModel implements Observable {
    private FilmViewHolder holder;
    private Film film;
    private String title;
    private String url;
    boolean progressVisibility;
    boolean imageViewVisibility;

    public FilmViewModel(FilmViewHolder holder, Film film) {
        this.holder = holder;
        this.film = film;
        setTitle(film.getTitle());
        //this.url = film.getImages().getImage().get(0).getSrc();//TODO
        setImageViewVisibility(true);
        setProgressVisibility(false);//TODO

        new ImageDownloader(holder.getImageView()).execute("https://www.google.com/images/srpr/logo11w.png");//TODO
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public boolean isProgressVisibility() {
        return progressVisibility;
    }

    @Bindable
    public int getProgressVisibility(){
        return isProgressVisibility() ? View.VISIBLE : View.GONE;
    }

    public void setProgressVisibility(boolean progressVisibility) {
        this.progressVisibility = progressVisibility;
    }

    public boolean isImageViewVisibility() {
        return imageViewVisibility;
    }

    @Bindable
    public int getImageVisibility(){
        return isImageViewVisibility() ? View.VISIBLE : View.GONE;
    }

    public void setImageViewVisibility(boolean imageViewVisibility) {
        this.imageViewVisibility = imageViewVisibility;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {

    }
}
