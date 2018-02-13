package com.example.martinosorio.filmgrid;

import android.app.Activity;
import android.content.Context;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.martinosorio.filmgrid.model.Film;
import com.example.martinosorio.filmgrid.model.Films;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmGridActivityViewModel implements Observable {
    static int numberOfColumns = 2;
    Context context;
    FilmGridRecyclerViewAdapter adapter;
    boolean progressVisibility;
    boolean recyclerViewVisibility;
    Films films;

    public FilmGridActivityViewModel(Context context) {
        this.context = context;
        setProgressVisibility(false);
        setRecyclerViewVisibility(true);

        SnagfilmsController controller = new SnagfilmsController();
        controller.start(this);
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
        synchronized(this){//TODO
            this.notifyAll();
        }
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
        synchronized(this){//TODO
            this.notifyAll();
        }
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        //TODO
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        //TODO
    }

    private void setupRecyclerView(){
        adapter = new FilmGridRecyclerViewAdapter(context, films);

        RecyclerView recyclerView = ((Activity) context).findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, numberOfColumns));
        recyclerView.setAdapter(adapter);

        setRecyclerViewVisibility(true);
        setProgressVisibility(false);
    }

    public void onFilmsFetched(Films films){
        this.films = films;
        setupRecyclerView();
    }
}
