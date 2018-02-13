package com.example.martinosorio.filmgrid;

import android.support.annotation.NonNull;

import com.example.martinosorio.filmgrid.model.SnagfilmsReply;
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

public class SnagfilmsController implements Callback<SnagfilmsReply> {
    private static final String BASE_URL = "http://www.snagfilms.com/apis/";
    private FilmGridActivityViewModel viewModel;

    void start(FilmGridActivityViewModel viewModel) {
        this.viewModel = viewModel;

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        SnagfilmsAPI snagfilmsAPI = retrofit.create(SnagfilmsAPI.class);
        Call<SnagfilmsReply> call = snagfilmsAPI.getFilms();
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<SnagfilmsReply> call, @NonNull Response<SnagfilmsReply> response) {
        if(response.isSuccessful()) {
            SnagfilmsReply reply = response.body();
            if (reply != null) {
                viewModel.onFilmsFetched(reply.getFilms());
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(@NonNull Call<SnagfilmsReply> call, @NonNull Throwable t) {
        t.printStackTrace();
    }
}
