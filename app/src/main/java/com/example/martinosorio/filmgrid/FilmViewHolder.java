package com.example.martinosorio.filmgrid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.martinosorio.filmgrid.databinding.FilmViewHolderLayoutBinding;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmViewHolder extends RecyclerView.ViewHolder {
    FilmViewHolderLayoutBinding binding;
    ImageView imageView;
    TextView textView;

    public FilmViewHolder(FilmViewHolderLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        imageView = (ImageView) itemView.findViewById(R.id.film_imageview);
        textView = (TextView) itemView.findViewById(R.id.film_textview);
    }

    public void bind(FilmViewModel viewModel) {
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
    }
}
