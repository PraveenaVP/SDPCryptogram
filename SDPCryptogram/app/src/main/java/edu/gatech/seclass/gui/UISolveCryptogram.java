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
import edu.gatech.seclass.sdpcryptogram.Player;
import edu.gatech.seclass.sdpcryptogram.R;

/**
 * Created by praveena on 7/3/17.
 */

public class UISolveCryptogram extends AppCompatActivity {

    //DBHelper sdpdb;
    String username;
    String cryptogram;
    int cryptID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_cryptogram);
       // sdpdb = new DBHelper(this);

        Bundle bundle = getIntent().getExtras();
        cryptogram= bundle.getString("crypt");
        username= bundle.getString("username");
        cryptID = bundle.getInt("cryptID");

       // String prior = sdpdb.getlastUserText(username,cryptID);
        String prior = Player.recentPlayerAttempt(this,username,cryptID);
        EditText txtPrior = (EditText)findViewById(R.id.txtUserSolution);
        txtPrior.setText(prior);

        TextView txt1 = (TextView)findViewById(R.id.textView3);
        txt1.setText(cryptogram);
    }

    public void onSaveclick(View view)
    {
        EditText usertext = (EditText)findViewById(R.id.txtUserSolution);
        
          //Bug fix test case9
        if(usertext.getText().toString().equals(""))
        {
            Toast.makeText(this, "Solution text is empty",Toast.LENGTH_SHORT).show();
            return;

        }
        //boolean result = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,usertext.getText().toString(),"S");
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
        
          //Bug fix test case9
        if(usertext.getText().toString().equals(""))
        {
            Toast.makeText(this, "Solution text is empty",Toast.LENGTH_SHORT).show();
            return;

        }

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
       // super.onBackPressed();


        Intent prevActivity = new Intent(this,UICryptogramList.class);
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        prevActivity.putExtras(bundle);
        startActivity(prevActivity);

    }
}
