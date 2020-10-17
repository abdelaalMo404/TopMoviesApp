package com.example.moviesapp.repo;

import com.example.moviesapp.network.MoviesApiServies;
import com.example.moviesapp.network.RetrofitClint;
import com.example.moviesapp.pojo.MovieModel;
import com.example.moviesapp.pojo.MoviesRespones;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;

public class Repo {
    private RetrofitClint clint;
    private MoviesApiServies moviesApiServies;


    public Observable<MoviesRespones> getMovies(){
        clint = new RetrofitClint();
        moviesApiServies = clint.getMovies();

        return moviesApiServies.getMovies();
    }


}
