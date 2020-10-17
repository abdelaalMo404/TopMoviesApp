package com.example.moviesapp.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.moviesapp.R;
import com.example.moviesapp.adapters.MyAdpater;
import com.example.moviesapp.pojo.MovieModel;
import com.example.moviesapp.viewmodel.MyViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    MyAdpater adpater;
    MyViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));


        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getMovies();

        viewModel.getmovieMutable().observe(this, new Observer<ArrayList<MovieModel>>() {
            @Override
            public void onChanged(ArrayList<MovieModel> movieModels) {
                adpater = new MyAdpater(movieModels , getApplicationContext());
                rv.setAdapter(adpater);
            }
        });
    }
}