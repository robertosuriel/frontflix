package com.example.frontflix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    private ImageView moviePoster;
    private TextView movieTitle;
    private TextView movieOverview;
    private Button btnTrailer;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_page);

        moviePoster = findViewById(R.id.moviePoster);
        movieTitle = findViewById(R.id.movieTitle);
        movieOverview = findViewById(R.id.movieOverview);
        btnTrailer = findViewById(R.id.btnTrailer);
        btnBack = findViewById(R.id.btnBack);

        // Get data from Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("movieTitle");
        String overview = intent.getStringExtra("movieOverview");
        String posterPath = intent.getStringExtra("moviePosterPath");

        // Set data to views
        movieTitle.setText(title);
        movieOverview.setText(overview);
        Glide.with(this).load("https://image.tmdb.org/t/p/w500" + posterPath).into(moviePoster);

        // Set click listener for the back button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to the previous activity (movie search)
                finish();
            }
        });

        // Future implementation for trailer button
        btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Future implementation to open YouTube trailer
            }
        });
    }
}
