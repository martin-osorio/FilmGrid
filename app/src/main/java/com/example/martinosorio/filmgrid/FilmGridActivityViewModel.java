package com.example.martinosorio.filmgrid;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.martinosorio.filmgrid.model.Films;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmGridActivityViewModel extends BaseObservable {
    private static int numberOfColumns = 2;
    private Context context;
    private FilmGridRecyclerViewAdapter adapter;
    private boolean progressVisibility;
    private boolean recyclerViewVisibility;
    private Films films;

    FilmGridActivityViewModel(Context context) {
        EventBus.getDefault().register(this);

        this.context = context;
        setProgressVisibility(true);
        setRecyclerViewVisibility(false);

        SnagfilmsController controller = new SnagfilmsController();
        controller.start();
    }

    @Bindable
    public boolean isProgressVisibility() {
        return progressVisibility;
    }

    @Bindable
    private void setProgressVisibility(boolean progressVisibility) {
        this.progressVisibility = progressVisibility;
        notifyPropertyChanged(BR.progressVisibility);
    }

    @Bindable
    public boolean isRecyclerViewVisibility() {
        return recyclerViewVisibility;
    }

    @Bindable
    private void setRecyclerViewVisibility(boolean recyclerViewVisibility) {
        this.recyclerViewVisibility = recyclerViewVisibility;
        notifyPropertyChanged(BR.recyclerViewVisibility);
    }

    private void setupRecyclerView(){
        adapter = new FilmGridRecyclerViewAdapter(context, films);

        RecyclerView recyclerView = ((Activity) context).findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, numberOfColumns));
        recyclerView.setAdapter(adapter);

        setRecyclerViewVisibility(true);
        setProgressVisibility(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFilmsDownloadedEvent(FilmsDownloadedEvent event) {
        this.films = event.films;
        setupRecyclerView();
    }
}
