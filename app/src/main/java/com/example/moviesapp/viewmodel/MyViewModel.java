package com.example.moviesapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesapp.pojo.MovieModel;
import com.example.moviesapp.pojo.MoviesRespones;
import com.example.moviesapp.repo.Repo;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ArrayListSupplier;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MyViewModel extends ViewModel {
    private static final String TAG = "MyViewModel";
    private Repo repo = new Repo();
    private MutableLiveData<ArrayList<MovieModel>> movieMutable = new MutableLiveData<>();


    public void getMovies(){
        repo.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<MoviesRespones, ArrayList<MovieModel>>() {
                    @Override
                    public ArrayList<MovieModel> apply(MoviesRespones moviesRespones) throws Throwable {
                        ArrayList<MovieModel> arrayList = moviesRespones.getResults();
                        return arrayList;
                    }
                })
                .subscribe(res -> movieMutable.setValue(res)
                , error -> Log.d(TAG, "getMovies: " + error.getMessage()));
    }


    public MutableLiveData<ArrayList<MovieModel>> getmovieMutable() {
        return movieMutable;
    }
}
