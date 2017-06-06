package com.example.android.booklisting;

import android.app.Activity;
import android.content.AsyncTaskLoader;
import android.content.Context;
import java.util.ArrayList;

//AsyncTask Loader for fetching the data from Google Books
public class BooksLoader extends AsyncTaskLoader<ArrayList<BookEntry>> {

    private Activity mAContext;
    private String mSearchString;

    public BooksLoader(Context context, Activity aContext, String searchString) {
        super(context);
        mAContext = aContext;
        mSearchString = searchString;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<BookEntry> loadInBackground() {
        ArrayList<BookEntry> books = QueryUtils.fetchBooks(mAContext, mSearchString);
        return books;
    }
}
