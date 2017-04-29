package com.example.android.listen_learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//This activity shows a user's playlist

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        //todo show user specific list of titles and their difficulty

        //Set click listeners and intents to go to other Activities
        View listenView = (View) findViewById(R.id.listen);
        listenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(PlaylistActivity.this, ListenActivity.class);
                startActivity(listenIntent);
            }
        });
        View popularView = (View) findViewById(R.id.popular);
        popularView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent popularIntent = new Intent(PlaylistActivity.this, PopularActivity.class);
                startActivity(popularIntent);
            }
        });
        View browseView = (View) findViewById(R.id.browse);
        browseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(PlaylistActivity.this, BrowseActivity.class);
                startActivity(listenIntent);
            }
        });

        //todo explain Activity purpose
        String purpose = "purpose of activity";
        TextView listenPurpose = (TextView) findViewById(R.id.purpose);
        listenPurpose.setText(purpose);
    }
}
