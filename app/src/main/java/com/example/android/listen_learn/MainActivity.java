package com.example.android.listen_learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    public String currentTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set click listeners and intents for all Activities
        View listenView = (View) findViewById(R.id.listen);
        listenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(MainActivity.this, ListenActivity.class);
                startActivity(listenIntent);
            }
        });
        View popularView = (View) findViewById(R.id.popular);
        popularView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent popularIntent = new Intent(MainActivity.this, PopularActivity.class);
                startActivity(popularIntent);
            }
        });
        View playlistView = (View) findViewById(R.id.playlist);
        playlistView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(listenIntent);
            }
        });
        View browseView = (View) findViewById(R.id.browse);
        browseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(MainActivity.this, BrowseActivity.class);
                startActivity(listenIntent);
            }
        });


    }
}
