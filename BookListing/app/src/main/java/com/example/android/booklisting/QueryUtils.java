package com.example.android.booklisting;

import android.app.Activity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */
public final class QueryUtils {

    private static String test =
            //"https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2017-06-01&endtime=2017-06-03&minmagnitude=4";
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=4&limit=20";

    public static final String LOG_TAG = QueryUtils.class.getSimpleName();

    //private constructor, is not called
    private QueryUtils() {
    }


    //Return a list of BookEntry objects that has been built up from parsing a JSON response.
    public static ArrayList<BookEntry> searchGoogleBooks(Activity context, String searchString) {

        /*/todo-remove: slow down loading for testing
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<BookEntry> books = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        //todo: extract title and auther from Google Books search
        try {
            JSONObject jsonEQRoot = new JSONObject(searchString);
            JSONArray jsonEQFeatureArray = jsonEQRoot.getJSONArray("features");
            // looping through all Feature entries
            for (int i = 0; i < jsonEQFeatureArray.length(); i++) {
                JSONObject jsonEQfeature = jsonEQFeatureArray.getJSONObject(i);
                JSONObject jsonEQproperties = jsonEQfeature.getJSONObject("properties");
                String place = jsonEQproperties.getString("place");
                String time = jsonEQproperties.getString("time");
                //add each earthquake event to data set
                books.add(new BookEntry(context,place, time)); //todo: title, author instead place, time
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing JSON results", e);
        }
        // Return the list of books
        return books;
    }


    //fetch data from Google Books
    public static ArrayList<BookEntry> fetchBooks(Activity context) {
        // Create URL object
        URL url = createUrl(test);
        if (url == null) {
            Log.e("url == null", "error!!!");
            return null;
        }
        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        // Call searchGoogleBooks QueryUtils method to extract relevant fields and return BookEntry array
        ArrayList<BookEntry> books = searchGoogleBooks(context, jsonResponse);
        return books;
    }

    //todo: Create query Url, redundant to fetchBooks????
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
            return null;        //todo how to handle the error????
        }
        return url;
    }

    //Request data via HTTP and return as JSON
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    //Receive data via buffered stream
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
}
