package com.example.ringaile.movieapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ringaile on 22/10/15.
 */
public class CustomMovieAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] movieTitles;
    private final String[] movieImages;
    private final String[] movieDescription;
    private final String[] movieInformation;


    public CustomMovieAdapter(Activity context, String[] movieTitles, String[] movieImages, String[] movieDescription, String[] movieInformation) {
        super(context, R.layout.movie_list, movieTitles);
        this.context = context;
        this.movieTitles = movieTitles;
        this.movieImages = movieImages;
        this.movieDescription = movieDescription;
        this.movieInformation = movieInformation;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.movie_list, null, true);

        TextView titleView = (TextView) rowView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView descriptionView = (TextView) rowView.findViewById(R.id.textView2);
        TextView infoView = (TextView) rowView.findViewById(R.id.textView3);

        titleView.setText(movieTitles[position]);
        //imageView.setImageDrawable(Drawable.createFromPath(movieImages[position]));
        descriptionView.setText(movieDescription[position]);
        infoView.setText(movieInformation[position]);
        return rowView;

    };

}
