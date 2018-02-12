package com.example.martinosorio.filmgrid;

import android.support.annotation.NonNull;
import android.util.Log;

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

public class SnagfilmsController implements Callback<Films> {
    public static final String TAG = "moltag";

    static final String BASE_URL = "http://www.snagfilms.com/apis/";

    public void start() {
        Log.d(TAG, "start: ");
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        SnagfilmsAPI snagfilmsAPI = retrofit.create(SnagfilmsAPI.class);

        Log.d(TAG, "start: getting films");
        Call<Films> call = snagfilmsAPI.getFilms();
        call.enqueue(this);
        Log.d(TAG, "start: Queued");

    }

    @Override
    public void onResponse(@NonNull Call<Films> call, @NonNull Response<Films> response) {
        Log.d(TAG, "onResponse: ");
        if(response.isSuccessful()) {
            Films films = response.body();
            Log.d(TAG, "onResponse: success");
        } else {
            Log.d(TAG, "onResponse: not successful");
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(@NonNull Call<Films> call, @NonNull Throwable t) {
        Log.d(TAG, "onFailure: ");
        t.printStackTrace();
    }
}
