package com.example.android.booklisting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private KeyListener editTextKeyListener;
    private EditText editTextSearchEntry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*/Set keyListener for EditText field
        editTextSearchEntry.setKeyListener(editTextKeyListener);
        editTextKeyListener = editTextSearchEntry.getKeyListener();
        //Disable text entry
        editTextSearchEntry.setKeyListener(null);
*/
        //Identify EditText field and Search button
        editTextSearchEntry = (EditText) findViewById(R.id.search_entry);
        Button searchButton = (Button) findViewById(R.id.search_button);
        //When search button is clicked, read out search string
        searchButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {String searchString = editTextSearchEntry.getText().toString().toLowerCase();}
                });

    }
}
