package com.example.android.booklisting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private KeyListener editTextKeyListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set keyListener for EditText field
        EditText editTextSearchEntry = (EditText) findViewById(R.id.search_entry);
        editTextSearchEntry.setKeyListener(editTextKeyListener);

        editTextKeyListener = editTextSearchEntry.getKeyListener();

        //Disable text entry
        editTextSearchEntry.setKeyListener(null);

        //Read out EditText field, i.e. search string
        String searchString = editTextSearchEntry.getText().toString().toLowerCase();

    }
}
