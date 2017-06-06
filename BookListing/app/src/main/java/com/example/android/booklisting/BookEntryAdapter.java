package com.example.android.booklisting;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

//This RecyclerView Adapter lists Author and Title results from the search

public class BookEntryAdapter extends RecyclerView.Adapter<BookEntryAdapter.ViewHolder>  {

    private ArrayList<BookEntry> mBooks;
    private LayoutInflater mInflator;
    private Context mContext;

    //ViewHolder class with constructor
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private View mView;
        private TextView authorView;
        private TextView titleView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
        }
    }

    // Constructor based on each book entry
    public BookEntryAdapter(Activity context, ArrayList<BookEntry> books) {
        mContext = context;
        mInflator = LayoutInflater.from(context);
        mBooks = books;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BookEntryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view (equals convertView)
        View view = mInflator.inflate(R.layout.book_entry, parent, false);

        //create ViewHolder instance and find its views
        final ViewHolder vh = new ViewHolder(view);
        vh.titleView = (TextView)view.findViewById(R.id.title);
        vh.authorView = (TextView)view.findViewById(R.id.author);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder vh, int position) {
        //get element from dataset at this position and replace the contents of the view with that element
        final BookEntry currentEntry = mBooks.get(position);
        vh.titleView.setText(currentEntry.getTitle());
        vh.authorView.setText(currentEntry.getAuthor());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mBooks.size();
    }
}



