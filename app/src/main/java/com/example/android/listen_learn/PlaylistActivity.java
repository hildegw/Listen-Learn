package com.example.android.listen_learn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//This activity shows a user's playlist

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        //todo show user specific list of titles and their difficulty


        //todo explain Activity purpose
        String purpose = "purpose of activity";
        TextView listenPurpose = (TextView) findViewById(R.id.purpose);
        listenPurpose.setText(purpose);
    }
}
