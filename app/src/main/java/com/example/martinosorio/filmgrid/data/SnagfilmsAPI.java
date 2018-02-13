package com.example.martinosorio.filmgrid.data;

import com.example.martinosorio.filmgrid.model.SnagfilmsReply;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Martin on 2/12/2018.
 */

public interface SnagfilmsAPI {

    @GET("films.json?limit=10")
    Call<SnagfilmsReply> getFilms();
}
