package com.example.android.listen_learn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

//This activity shows a user's playlist

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        //todo: show user specific list of titles, stored locally in Shared Preferences
        //todo: set up list view, fetch items from Shared Preferences
        String[] items = {"A Dream within a Dream \nby Edgar Allen Poe",            //placeholder
                           "The Blind Boy\nby Colley Cibber",
                            "Stand and sing\nJackie and Richard talk about national anthems",
                            "The Looking Glass\nby Anton Chekhov",
                            "The Cripple\nby Guy de Maupassant",
                            "The Night Moth With a Crooked Feeler\nby Clara Dillingham Pierson\n"};
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, items);
        ListView listView = (ListView) findViewById(R.id.play1);
        listView.setAdapter(itemsAdapter);

        //todo: user can delete titles from playlist, i.e. edit Shared Preferences
        //todo: user can change order of titles in playlist, e.g. via clicking on up/down arrows
        //todo: write own list item object including up/down/minus buttons, with own Adapter

        //Set click listeners and intents to go to other Activities
        View listenView = (View) findViewById(R.id.listen);
        listenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listenIntent = new Intent(PlaylistActivity.this, ListenActivity.class);
                startActivity(listenIntent);
            }
        });

        //todo explain Activity purpose
        String purpose = "The playlist is user specific and stored locally via Shared Preferences. " +
                "Titles are presented as ListView, and can be deleted, or moved up and down (use Click Listeners, " +
                "write own Adapter Class to add up, down, minus buttons). " +
                "Because this is a potentially long list, no cross-navigation to Browse and Popular is possible.";
        TextView listenPurpose = (TextView) findViewById(R.id.purpose);
        listenPurpose.setText(purpose);
    }
}
