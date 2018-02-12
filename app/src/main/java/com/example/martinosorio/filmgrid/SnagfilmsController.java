package com.example.martinosorio.filmgrid;

import android.support.annotation.NonNull;

import com.example.martinosorio.filmgrid.model.Example;
import com.example.martinosorio.filmgrid.model.Films;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Martin on 2/12/2018.
 */

public class SnagfilmsController implements Callback<Example> {
    private static final String BASE_URL = "http://www.snagfilms.com/apis/";
    private FilmGridActivityViewModel viewModel;

    public void start(FilmGridActivityViewModel viewModel) {
        this.viewModel = viewModel;

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        SnagfilmsAPI snagfilmsAPI = retrofit.create(SnagfilmsAPI.class);

        Call<Example> call = snagfilmsAPI.getFilms();
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<Example> call, @NonNull Response<Example> response) {
        if(response.isSuccessful()) {
            Example films = response.body();
            viewModel.onFilmsFetched(films.getFilms());
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(@NonNull Call<Example> call, @NonNull Throwable t) {
        t.printStackTrace();
    }
}
