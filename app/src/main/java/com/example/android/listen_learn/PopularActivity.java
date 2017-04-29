package com.example.android.listen_learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//This activity shows a varying list of popular titles

public class PopularActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popular);

        //todo: fetch 3 most popular titles from server via GSON
        String[] mostPopular = {"A wall in Naples \nby Andrew Motion",      //placeholder
                "The Blind Boy \nby Colley Cibber",
                "The Sick Child \nby Robert Louis Stevenson"};

        //show most popular titles
        TextView popular1Text = (TextView) findViewById(R.id.popular1);
        popular1Text.setText(mostPopular[0]);
        TextView popular2Text = (TextView) findViewById(R.id.popular2);
        popular2Text.setText(mostPopular[1]);
        TextView popular3Text = (TextView) findViewById(R.id.popular3);
        popular3Text.setText(mostPopular[2]);

        //Set click listeners to add titles to playlist
        //todo: add titles to playlist via shared preferences
        View popular1View = (View) findViewById(R.id.popular1);
        popular1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView plus1Image = (ImageView) findViewById(R.id.plus1);
                plus1Image.setImageResource(R.drawable.ic_add_black_24dp_grey);
            }
        });
        View popular2View = (View) findViewById(R.id.popular2);
        popular2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView plus2Image = (ImageView) findViewById(R.id.plus2);
                plus2Image.setImageResource(R.drawable.ic_add_black_24dp_grey);
            }
        });
        View popular3View = (View) findViewById(R.id.popular3);
        popular3View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView plus3Image = (ImageView) findViewById(R.id.plus3);
                plus3Image.setImageResource(R.drawable.ic_add_black_24dp_grey);
            }
        });


        //Set click listeners and intents tp go to other Activities
        View listenView = (View) findViewById(R.id.listen);
        listenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(PopularActivity.this, ListenActivity.class);
                startActivity(listenIntent);
            }
        });
        View playlistView = (View) findViewById(R.id.playlist);
        playlistView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(PopularActivity.this, PlaylistActivity.class);
                startActivity(listenIntent);
            }
        });
        View browseView = (View) findViewById(R.id.browse);
        browseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(PopularActivity.this, BrowseActivity.class);
                startActivity(listenIntent);
            }
        });

        //todo explain Activity purpose
        String purpose = "Popular shows a list of the most popular titles on server. " +
                "Titles are fetched from server using JSON, i.e. GSON library. " +
                "Titles can be selected to be added to Playlist via Shared Preferences";
        TextView listenPurpose = (TextView) findViewById(R.id.purpose);
        listenPurpose.setText(purpose);
    }
}
