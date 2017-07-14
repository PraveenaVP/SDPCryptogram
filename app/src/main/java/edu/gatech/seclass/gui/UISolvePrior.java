package edu.gatech.seclass.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.seclass.sdpcryptogram.Cryptogram;
import edu.gatech.seclass.sdpcryptogram.DBHelper;
import edu.gatech.seclass.sdpcryptogram.R;

/**
 * Created by praveena on 7/3/17.
 */

public class UISolvePrior extends AppCompatActivity {

    String username;
    String cryptogram;
    int cryptID;
    String userText;
    DBHelper sdpdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_prior);

        sdpdb = new DBHelper(this);

        Bundle bundle = getIntent().getExtras();
        cryptogram= bundle.getString("cryptogram");
        username= bundle.getString("username");
        userText= bundle.getString("userText");
        cryptID = bundle.getInt("cryptID");

        TextView txtPuzzle = (TextView)findViewById(R.id.textView3);
        txtPuzzle.setText(cryptogram);

        EditText txtUserText = (EditText)findViewById(R.id.txtUserSolution);
        txtUserText.setText(userText);


    }

    public void onSaveclick(View view)
    {
        EditText usertext = (EditText)findViewById(R.id.txtUserSolution);
       // boolean result = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,usertext.getText().toString(),"S");
        boolean result = Cryptogram.saveCryptograms(this,username,cryptID,cryptogram,usertext.getText().toString());
        if(result)
        {
            Toast.makeText(this, "Successfully Saved",Toast.LENGTH_SHORT).show();
            return;

        }
        else
        {
            Toast.makeText(this, "Unable to save.",Toast.LENGTH_SHORT).show();
            return;
        }

    }

    public void onSolveclick(View view){

        EditText usertext = (EditText)findViewById(R.id.txtUserSolution);

//        String solution = sdpdb.CryptogramSolution(cryptID,true);
//        if(solution.equals(usertext.getText().toString()))
//        {
//            boolean result = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,usertext.getText().toString(),"C");
//            Toast.makeText(this, "Correct Solution",Toast.LENGTH_SHORT).show();
//
//
//        }
//        else
//        {
//            boolean result = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,usertext.getText().toString(),"I");
//            Toast.makeText(this, "Incorrect Solution",Toast.LENGTH_SHORT).show();
//
//        }



         /*pvp7 : Fix to integrate class diagram change
        * */
        boolean result = Cryptogram.solveCryptograms(this,username,cryptID,cryptogram,usertext.getText().toString());
        if(result)
        {
            Toast.makeText(this, "Correct Solution",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            Toast.makeText(this, "Incorrect Solution",Toast.LENGTH_SHORT).show();
            return;
        }



    }

    public void onReturnClick(View view)
    {
        onBackPressed();
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {



        Intent prevActivity = new Intent(this,UIViewPrior.class);
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        prevActivity.putExtras(bundle);
        startActivity(prevActivity);

    }

}
