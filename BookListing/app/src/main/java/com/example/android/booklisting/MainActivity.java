package com.example.android.booklisting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();
    private EditText editTextSearchEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Identify EditText field and Search button
        editTextSearchEntry = (EditText) findViewById(R.id.search_entry);
        Button searchButton = (Button) findViewById(R.id.search_button);
        //When search button is clicked, read out search string
        searchButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        String searchString = editTextSearchEntry.getText().toString().toLowerCase();
                        Intent booksIntent = new Intent(MainActivity.this, BooksActivity.class);
                        //booksIntent.putExtra("key", value); //Optional parameters todo
                        MainActivity.this.startActivity(booksIntent);
                    }
                });
    }
}