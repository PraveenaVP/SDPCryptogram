package edu.gatech.seclass.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.seclass.sdpcryptogram.Cryptogram;
import edu.gatech.seclass.sdpcryptogram.DBHelper;
import edu.gatech.seclass.sdpcryptogram.Player;
import edu.gatech.seclass.sdpcryptogram.R;
import edu.gatech.seclass.sdpcryptogram.Ratings;

/**
 * Created by praveena on 7/3/17.
 */

public class UIMainActivity extends AppCompatActivity {

    //Added for db
    DBHelper sdpcryptogram_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Calls the constructor of DBHelper that creates the db and tables
        Ratings.insertFirstRatings(this);
        Cryptogram.insertFirstCryptogram(this);
        Player.insertFirstPlayer(this);
    }


    public void onLoginClick(View view)
    {
        EditText username = ((EditText)findViewById(R.id.username));
        Intent NextActivity;
        
        if(username.getText().toString().equals(""))
        {
            Toast.makeText(this, "Please enter a username",Toast.LENGTH_SHORT).show();
            return;

        }

        if(username.getText().toString().contains("admin"))
        {
             NextActivity = new Intent(this, UIAdminHomePage.class);
        }
        else
        {
            NextActivity =  new Intent(this,UIPlayerHomePage.class);
        }

        Bundle bundle = new Bundle();
        bundle.putString("username",username.getText().toString());
        NextActivity.putExtras(bundle);
        startActivity(NextActivity);
    }

    public void onLogoutClick(View view)
    {
        System.exit(0);
    }
}
