package com.example.martinosorio.filmgrid;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.view.View;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmGridActivityViewModel implements Observable {
    boolean progressVisibility;
    boolean recyclerViewVisibility;

    public FilmGridActivityViewModel() {
        setProgressVisibility(true);
        setRecyclerViewVisibility(false);
        startController();
    }

    private void startController(){
        SnagfilmsController controller = new SnagfilmsController();
        controller.start();
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

    public boolean isRecyclerViewVisibility() {
        return recyclerViewVisibility;
    }

    @Bindable
    public int getRecyclerViewVisibility(){
        return isRecyclerViewVisibility() ? View.VISIBLE : View.GONE;
    }

    public void setRecyclerViewVisibility(boolean recyclerViewVisibility) {
        this.recyclerViewVisibility = recyclerViewVisibility;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        //TODO
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        //TODO
    }
}
