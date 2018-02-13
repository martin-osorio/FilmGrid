package com.example.martinosorio.filmgrid;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.martinosorio.filmgrid.databinding.FilmViewHolderLayoutBinding;
import com.example.martinosorio.filmgrid.model.Films;
import com.example.martinosorio.filmgrid.view.FilmViewHolder;
import com.example.martinosorio.filmgrid.viewModel.FilmViewModel;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmGridRecyclerViewAdapter extends RecyclerView.Adapter {
    private LayoutInflater layoutInflater;
    private Films films;
    private int nextID = 0;

    public FilmGridRecyclerViewAdapter(Context context, Films films) {
        this.films = films;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FilmViewHolderLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.film_view_holder_layout, parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FilmViewModel viewModel = new FilmViewModel(films.getFilms().get(position), nextID++);
        ((FilmViewHolder) holder).bind(viewModel);
    }

    @Override
    public int getItemCount() {
        return films.getFilms().size();
    }
}