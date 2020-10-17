package com.example.moviesapp.network;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {
    private Retrofit mRetrofit;
    private MoviesApiServies moviesApiServies;

    public MoviesApiServies getMovies(){
        if (mRetrofit==null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/")
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        moviesApiServies = mRetrofit.create(MoviesApiServies.class);

        return moviesApiServies;
    }
}
