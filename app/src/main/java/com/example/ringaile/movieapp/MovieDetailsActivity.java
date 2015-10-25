package com.example.ringaile.movieapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button fab = (Button) findViewById(R.id.button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieDetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("MovieObject");

        TextView cinemaView = (TextView) findViewById(R.id.textView8);
        TextView titleView = (TextView) findViewById(R.id.textView4);
        imageView = (ImageView) findViewById(R.id.imageView2);
        TextView genreView = (TextView) findViewById(R.id.textView5);
        TextView ratingsView = (TextView) findViewById(R.id.textView6);
        TextView descriptionView = (TextView) findViewById(R.id.textView7);

        cinemaView.setText(movie.getMovieDuration() + " " +movie.getTheaterName());
        titleView.setText(movie.getMovieTitle());

        //LoadImageFromURL loadImage = new LoadImageFromURL(movie.getMovieImageUrl());
        //loadImage.execute();
        //imageView.setImageDrawable(Drawable.createFromPath(movie.getMovieImageUrl());
        genreView.setText(movie.getMovieGenre());
        ratingsView.setText(movie.getMovieRating());
        descriptionView.setText(movie.getInfo());
    }

    public class LoadImageFromURL extends AsyncTask<String, Void, Bitmap> {
        URL url;

        public LoadImageFromURL(String movieImage) {
            try {
                url = new URL(movieImage);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            // TODO Auto-generated method stub

            try {
                InputStream is = url.openConnection().getInputStream();
                Bitmap bitMap = BitmapFactory.decodeStream(is);
                return bitMap;

            }  catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            imageView.setImageBitmap(result);
        }

    }

}
