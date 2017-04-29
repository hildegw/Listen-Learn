package com.example.android.listen_learn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//This activity provides the media player UI and info about the current title being played

public class ListenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listen);

        //show and play current title
        String currentTitle = "A Dream Within A Dream";  //just a placeholder
        TextView listenView = (TextView) findViewById(R.id.listen);
        listenView.setText(currentTitle);
        //show info for current title
        String listenInfo = "by Edgar Allan Poe (level: difficult)\n\n" +       //placeholder
                "The poem questions the way one can distinguish between reality and fantasy, asking, " +
                "\"Is all that we see or seem but a dream within a dream?\"";
        TextView listenTextView = (TextView) findViewById(R.id.listen_info);
        listenTextView.setText(listenInfo);
        //todo: implement player buttons to stream title using MediaPlayer
        //todo: select title from earlier session, playlist, or popular. Make available as shared preferences

        //todo: link to other Activities, add Listener

        //explain Activity purpose
        String purpose = "The Listen Activity provides the play/stop/next buttons to stream titles. " +
                "It also shows information about the current title streamed from server. \n" +
                "The current title is either the last title played, or, if not available, the next title " +
                "from playlist, or a title form popular. The current title variable can be provided " +
                "by either Activity via shared preferences as public String variable.";
        TextView listenPurpose = (TextView) findViewById(R.id.purpose);
        listenPurpose.setText(purpose);
    }
}
