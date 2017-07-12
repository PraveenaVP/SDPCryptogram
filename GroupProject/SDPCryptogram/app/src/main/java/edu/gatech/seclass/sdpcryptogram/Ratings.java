package edu.gatech.seclass.sdpcryptogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Ratings extends AppCompatActivity {

    DBHelper sdpdb ;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        Bundle bundle = getIntent().getExtras();
        username= bundle.getString("username");
        sdpdb = new DBHelper(this);
        String[] test = sdpdb.displayAllUserRatings();
        if(test != null) {
            ListView ratingsList = (ListView) findViewById(R.id.ratings_listview);
            ArrayAdapter<String> ratingslistAdapter = new ArrayAdapter<String>(this, R.layout.ratings, R.id.ratings_xml, test);
            ratingsList.setAdapter(ratingslistAdapter);
            ratingsList.setOnItemClickListener(new RatingsList());
        }
        else
        {
            Toast.makeText(this,"No Records Found !!..",Toast.LENGTH_SHORT);
            return;
        }


    }


    class RatingsList implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup viewg = (ViewGroup) view;
            TextView prior_text = (TextView) viewg.findViewById(R.id.ratings_xml);
            String selected = prior_text.getText().toString();

            String[] userselectedlist = selected.split("\\s*:\\s*");
            String userName = userselectedlist[0].toString();


            Toast.makeText(Ratings.this,"Ratings of user",Toast.LENGTH_SHORT).show();




        }
    }


    public void onReturnClick(View view)
    {
        super.onBackPressed();
    }
}
