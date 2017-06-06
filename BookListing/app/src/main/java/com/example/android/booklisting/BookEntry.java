package com.example.android.booklisting;

import android.content.Context;

//This class holds the data structure for the list entries shown to user

public class BookEntry {

    private Context mContext;
    private String mTitle;
    private String mAuthors;

    public BookEntry(Context context, String title, String authors){
        mContext = context;
        mTitle = title;
        mAuthors = authors;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthors(){
        return mAuthors;
    }
}
