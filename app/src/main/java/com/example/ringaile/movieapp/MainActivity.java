package com.example.ringaile.movieapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String jsonFile = "/Users/ringaile/Downloads/MovieApp/app/src/main/java/com/example/ringaile/movieapp/movies.json";
    ArrayList<Movie> movieList =new ArrayList<Movie>();
    //String movieTitle2 = "t";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //have to implement read file on android
        //String content = readJsonFIle();

        jsonString jstr = new jsonString();
        String content = jstr.getContent();


        //TextView textView = (TextView) findViewById(R.id.textView);
        //textView.setText(content);
        parseToJsonObjects(content);

        //textView.setText(movieTitle2);

        String[] movieTitles = new String[movieList.size()];
        String[] imageFiles = new String[movieList.size()];

        for (int i = 0; i < movieList.size(); i++){
            movieTitles[i] = movieList.get(i).getMovieTitle();
            imageFiles[i] = movieList.get(i).getMovieImageUrl();
        }

        //textView.setText(movieTitles[1]);


        //ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_main,movieTitles);
        ListView listView = (ListView) findViewById(R.id.listView);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movieTitles);

        listView.setAdapter(new ArrayAdapter<String>(
                this, R.layout.movie_list,
                R.id.text1,movieTitles));


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

    public String readJsonFIle(){
        String json = null;
        try {
            InputStream is = getAssets().open(jsonFile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
