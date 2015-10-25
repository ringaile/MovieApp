package com.example.ringaile.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import retrofit.RestAdapter;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> movieList =new ArrayList<Movie>();
    String API = "http://pocketibk.sengaro.com/cinema/performance/today.json";
    //String movieTitle2 = "t";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        jsonString jstr = new jsonString();
        String content = jstr.getContent();



        parseToJsonObjects(content);

        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API).build();

        IApiMethods apiService = restAdapter.create(IApiMethods.class);



        final String[] movieTitles = new String[movieList.size()];
        String[] imageFiles = new String[movieList.size()];
        String[] movieDescriptions = new String[movieList.size()];
        String[] movieTimes = new String[movieList.size()];

        for (int i = 0; i < movieList.size(); i++){
            movieTitles[i] = movieList.get(i).getMovieTitle();
            imageFiles[i] = movieList.get(i).getMovieImageUrl();
            movieDescriptions[i] = movieList.get(i).getMovieGenre();
            movieTimes[i] = movieList.get(i).getMovieDuration();
        }


        CustomMovieAdapter adapter=new CustomMovieAdapter(this, movieTitles, imageFiles, movieDescriptions, movieTimes);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Movie movie = movieList.get(position);
                Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
                intent.putExtra("MovieObject", movie);
                startActivity(intent);

            }
        });

    }

    public void parseToJsonObjects(String content){

            try {
                JSONArray jsonArrayMovies = null;
                jsonArrayMovies = new JSONArray(content);
                int length = jsonArrayMovies.length();

                for (int i = 0; i < length; i++){

                    JSONObject jo = jsonArrayMovies.getJSONObject(i);
                    String theaterId = jo.getString("theaterId");
                    String theaterName = jo.getString("theaterName");
                    String movieId = jo.getString("movieId");
                    String movieTitle = jo.getString("movieTitle");
                    String movieGenre = jo.getString("movieGenre");
                    String movieRating = jo.getString("movieRating");
                    String movieImageUrl = jo.getString("movieImageUrl");
                    String movieDuration = jo.getString("movieDuration");
                    String time = jo.getString("time");
                    String info = jo.getString("info");

                    Movie m = new Movie (theaterId, theaterName, movieId, movieTitle, movieGenre, movieRating, movieImageUrl, movieDuration, time, info);
                    movieList.add(m);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
    }

    //reading file ,not needed here
    public String readJsonFIle(String filePath){
        File file = new File(filePath);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            String line;

            while ((line = r.readLine()) != null) {
                total.append(line);
            }

            return String.valueOf(total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
