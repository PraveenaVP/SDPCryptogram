package edu.gatech.seclass.sdpcryptogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Solve_Prior extends AppCompatActivity {

    String username;
    String cryptogram;
    int cryptID;
    String userText;
    DBHelper sdpdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve__prior);

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
        boolean result = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,usertext.getText().toString(),"S");
        if(result)
        {
            Toast.makeText(this, "Successfully Saved",Toast.LENGTH_SHORT).show();
        }

    }

    public void onSolveclick(View view){

        EditText usertext = (EditText)findViewById(R.id.txtUserSolution);

        String solution = sdpdb.CryptogramSolution(cryptID,true);
        if(solution.equals(usertext.getText().toString()))
        {
            boolean result = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,usertext.getText().toString(),"C");
            Toast.makeText(this, "Correct Solution",Toast.LENGTH_SHORT).show();


        }
        else
        {
            boolean result = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,usertext.getText().toString(),"I");
            Toast.makeText(this, "Incorrect Solution",Toast.LENGTH_SHORT).show();

        }
    }

    public void onReturnClick(View view)
    {
        super.onBackPressed();
    }

}
