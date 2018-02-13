package com.example.martinosorio.filmgrid.view;

import android.support.v7.widget.RecyclerView;

import com.example.martinosorio.filmgrid.databinding.FilmViewHolderLayoutBinding;
import com.example.martinosorio.filmgrid.viewModel.FilmViewModel;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmViewHolder extends RecyclerView.ViewHolder {
    private FilmViewHolderLayoutBinding binding;

    public FilmViewHolder(FilmViewHolderLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(FilmViewModel viewModel) {
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
    }
}
