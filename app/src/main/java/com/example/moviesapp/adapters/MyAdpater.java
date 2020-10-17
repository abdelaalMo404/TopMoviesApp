package com.example.moviesapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesapp.R;
import com.example.moviesapp.pojo.MovieModel;
import com.example.moviesapp.adapters.MyAdpater.*;


import java.util.ArrayList;

public class MyAdpater extends RecyclerView.Adapter<MyAdpater.MyHolder> {

    ArrayList<MovieModel> movieModel ;
    Context context ;

    public MyAdpater(ArrayList<MovieModel> movieModel, Context context) {
        this.movieModel = movieModel;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item , parent , false);
        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvName.setText(movieModel.get(position).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"+movieModel.get(position).getPoster_path()).into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        return movieModel.size();
    }



    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvName ;
        ImageView ivPoster;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            ivPoster = itemView.findViewById(R.id.ivPoster);

        }
    }
}
