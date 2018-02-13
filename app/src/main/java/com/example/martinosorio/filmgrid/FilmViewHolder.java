package com.example.martinosorio.filmgrid;

import android.support.v7.widget.RecyclerView;

import com.example.martinosorio.filmgrid.databinding.FilmViewHolderLayoutBinding;

/**
 * Created by Martin on 2/12/2018.
 */

class FilmViewHolder extends RecyclerView.ViewHolder {
    private FilmViewHolderLayoutBinding binding;

    FilmViewHolder(FilmViewHolderLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(FilmViewModel viewModel) {
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
    }
}
