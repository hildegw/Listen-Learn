package com.example.android.booklisting;

import android.content.Context;

//This class holds the data structure for the list entries shown to user

public class BookEntry {

    private Context mContext;
    private String mTitle;
    private String mAuthor;

    public BookEntry(Context context, String title, String author){
        mContext = context;
        mTitle = title;
        mAuthor = author;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor(){
        return mAuthor;
    }
}
