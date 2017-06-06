package com.example.android.booklisting;

import android.content.Context;


/**
 * Created by hildegw on 5/19/17.
 */

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
