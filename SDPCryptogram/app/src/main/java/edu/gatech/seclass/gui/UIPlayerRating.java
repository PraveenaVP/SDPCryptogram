package edu.gatech.seclass.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.seclass.sdpcryptogram.DBHelper;
import edu.gatech.seclass.sdpcryptogram.R;
import edu.gatech.seclass.sdpcryptogram.Player;
import edu.gatech.seclass.sdpcryptogram.WebServiceHelper;
import edu.gatech.seclass.utilities.ExternalWebService;

/**
 * Created by WangZiyan on 7/14/17.
 */

public class UIPlayerRating extends AppCompatActivity {
    DBHelper sdpdb ;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_rating);
        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        sdpdb = new DBHelper(this);

        TextView user = (TextView) findViewById(R.id.tvUsername);
        user.setText(username);

        //onCreateDisplayUserRating();   <----------------- // FIXME: 7/14/17 
    }


    public void onReturnClick(View view)
    {
        super.onBackPressed();
    }

    public void onRequestClick(View view) {
        TextView started = (TextView) findViewById(R.id.tvStarted);
        TextView solved = (TextView) findViewById(R.id.tvSolved);
        TextView incorrect = (TextView) findViewById(R.id.tvIncorrect);

        int[] rating = Player.requestUserRatingFromServer(username);

        started.setText(String.valueOf(rating[2]));
        solved.setText(String.valueOf(rating[0]));
        incorrect.setText(String.valueOf(rating[1]));
    }

    private void onCreateDisplayUserRating() {
        //int[] rating = sdpdb.RetrieveUserRating(username);
        int[] rating = Player.playerRating(this,username);
        TextView started = (TextView) findViewById(R.id.tvStarted);
        TextView solved = (TextView) findViewById(R.id.tvSolved);
        TextView incorrect = (TextView) findViewById(R.id.tvIncorrect);

        started.setText(String.valueOf(rating[2]));
        incorrect.setText(String.valueOf(rating[1]));
        solved.setText(String.valueOf(rating[0]));
    }
}
