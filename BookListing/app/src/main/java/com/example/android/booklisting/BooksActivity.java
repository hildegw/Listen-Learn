package com.example.android.booklisting;

import android.app.LoaderManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class BooksActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<BookEntry>>  {

    private TextView mEmptyStateTextView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;  //comes as part of recycler view
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*/todo retrieve data if necessary
        Intent intent = getIntent();
        String value = intent.getStringExtra("key"); //if it's a string you stored.*/

        //check for Internet connection
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        //if no connection - hide loader and set TextView to "no connection"
        if (isConnected) {
            //start Background task via Loader
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(1, null, this);
        } else {
            Log.i("no Internet", "nonono");
            ProgressBar pg = (ProgressBar) findViewById(R.id.loading);
            pg.setVisibility(View.GONE);
            mEmptyStateTextView = (TextView) findViewById(R.id.no_data);
            mEmptyStateTextView.setText(R.string.no_Internet);
        }


        //start Recycler
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_entries);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    } //end of onCreate


    //Loader starts fetching data when created
    @Override
    public android.content.Loader<ArrayList<BookEntry>> onCreateLoader(int id, Bundle args) {
        Log.i("onCreateLoader", "done");
        return new BooksLoader(BooksActivity.this, this);
    }

    //UI is being populated with EQ events
    @Override
    public void onLoadFinished(android.content.Loader<ArrayList<BookEntry>> loader, ArrayList<BookEntry> events) {
        if (events == null) {
            return;
        }
        //hide loading bar
        ProgressBar pg = (ProgressBar) findViewById(R.id.loading);
        pg.setVisibility(View.GONE);
        // specify an adapter
        Log.i("onLoadFinished", "done");
        BookEntryAdapter eqEntryAdapter = new BookEntryAdapter(this, events);
        mRecyclerView.setAdapter(eqEntryAdapter);
        //in case there is no data to display, set TextView from earthquake_activity.xml
        mEmptyStateTextView = (TextView) findViewById(R.id.no_data);
        mEmptyStateTextView.setText(R.string.no_data_found);
    }

    @Override
    public void onLoaderReset(android.content.Loader<ArrayList<BookEntry>> loader) {
        // start with no data whe Activity is killed
        Log.i("onLoadReset", "done");
        BookEntryAdapter eqEntryAdapter = new BookEntryAdapter(this, null); //todo: better way to clear adapter?
        mRecyclerView.setAdapter(eqEntryAdapter);
    }
}
