package com.example.martinosorio.filmgrid;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.martinosorio.filmgrid.databinding.FilmViewHolderLayoutBinding;

/**
 * Created by Martin on 2/12/2018.
 */

class FilmViewHolder extends RecyclerView.ViewHolder {
    private FilmViewHolderLayoutBinding binding;
    private ImageView imageView;
    private TextView textView;

    FilmViewHolder(FilmViewHolderLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        imageView = itemView.findViewById(R.id.film_imageview);
        textView = itemView.findViewById(R.id.film_textview);
    }

    void bind(FilmViewModel viewModel) {
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
    }

    ImageView getImageView() {
        return imageView;
    }
}
