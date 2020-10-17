package com.example.moviesapp.network;

import com.example.moviesapp.pojo.MoviesRespones;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface MoviesApiServies {

    @GET("3/movie/popular?api_key=aa88f61d3a25582173845aecd0d39979&language=en-US&page=1")
    Observable<MoviesRespones> getMovies();
}
