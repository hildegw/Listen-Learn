package com.example.android.listen_learn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//This activity shows a varying list of popular titles

public class PopularActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popular);

        //todo show list of titles and their difficulty

        //todo: titles can be added to playlist


        //todo explain Activity purpose
        String purpose = "purpose of activity";
        TextView listenPurpose = (TextView) findViewById(R.id.purpose);
        listenPurpose.setText(purpose);
    }
}
