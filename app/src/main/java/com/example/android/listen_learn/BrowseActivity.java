package com.example.android.listen_learn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//This activity allows users to browse for titles on the server/Internet

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse);

        //todo show categories according to difficulty


        //todo explain Activity purpose
        String purpose = "purpose of activity";
        TextView listenPurpose = (TextView) findViewById(R.id.purpose);
        listenPurpose.setText(purpose);
    }
}
