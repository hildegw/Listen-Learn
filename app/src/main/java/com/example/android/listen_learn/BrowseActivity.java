package com.example.android.listen_learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//This activity allows users to browse for titles on the server/Internet

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse);

        //todo: click listeners for categories
        //todo: lists of available content for each category


        //Set click listeners and intents to go to other Activities
        View listenView = (View) findViewById(R.id.listen);
        listenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrowseActivity.this, ListenActivity.class)); //inline Intent
            }
        });
        View popularView = (View) findViewById(R.id.popular);
        popularView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent popularIntent = new Intent(BrowseActivity.this, PopularActivity.class);
                startActivity(popularIntent);
            }
        });
        View playlistView = (View) findViewById(R.id.playlist);
        playlistView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(BrowseActivity.this, PlaylistActivity.class);
                startActivity(listenIntent);
            }
        });

        //todo explain Activity purpose
        String purpose = "Students can choose between three categories of content. " +
                "Clicking on a category leads to a list of available content (fetched via JSON from server) " +
                "within a new Activity. Titles from each category can then be added to the student's playlist.";
        TextView listenPurpose = (TextView) findViewById(R.id.purpose);
        listenPurpose.setText(purpose);
    }
}
