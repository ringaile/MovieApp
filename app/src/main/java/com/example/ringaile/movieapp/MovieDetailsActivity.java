package com.example.ringaile.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("MovieObject");

        TextView titleView = (TextView) findViewById(R.id.textView4);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        TextView descriptionView = (TextView) findViewById(R.id.textView5);
        TextView infoView = (TextView) findViewById(R.id.textView6);
        TextView somethingView = (TextView) findViewById(R.id.textView7);

        titleView.setText(movie.getMovieTitle());
        //imageView.setImageDrawable(Drawable.createFromPath(movieImages[position]));
        descriptionView.setText(movie.getMovieGenre());
        infoView.setText(movie.getTheaterId());
        somethingView.setText(movie.getTheaterName());
    }

}
