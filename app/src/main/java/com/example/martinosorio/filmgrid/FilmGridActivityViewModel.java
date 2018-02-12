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
    Context context;
    FilmGridRecyclerViewAdapter adapter;
    boolean progressVisibility;
    boolean recyclerViewVisibility;

    public FilmGridActivityViewModel(Context context) {
        this.context = context;
        setProgressVisibility(false);
        setRecyclerViewVisibility(true);

        startController();//TODO

        setupRecyclerView();//TODO
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

    private void setupRecyclerView(){//TODO
        RecyclerView recyclerView = (RecyclerView) ((Activity) context).findViewById(R.id.recyclerView);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(context, numberOfColumns));

        Films films = new Films();
        List<Film> filmList = new ArrayList<Film>();
        filmList.add(new Film());
        filmList.add(new Film());
        filmList.add(new Film());
        filmList.add(new Film());
        filmList.add(new Film());
        films.setFilms(filmList);

        adapter = new FilmGridRecyclerViewAdapter(context, films);//TODO
        recyclerView.setAdapter(adapter);
    }
}
