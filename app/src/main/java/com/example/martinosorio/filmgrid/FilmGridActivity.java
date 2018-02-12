package com.example.martinosorio.filmgrid;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.martinosorio.filmgrid.databinding.FilmGridActivityLayoutBinding;

public class FilmGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FilmGridActivityLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.film_grid_activity_layout);
        FilmGridActivityViewModel viewModel = new FilmGridActivityViewModel(this);
        binding.setViewModel(viewModel);
    }
}
