package edu.gatech.seclass.sdpcryptogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Solve_Cryptogram extends AppCompatActivity {

    DBHelper sdpdb;
    String username;
    String cryptogram;
    int cryptID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve__cryptogram);
        sdpdb = new DBHelper(this);

        Bundle bundle = getIntent().getExtras();
        cryptogram= bundle.getString("crypt");
        username= bundle.getString("username");
        cryptID = bundle.getInt("cryptID");



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
        boolean result = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,usertext.getText().toString(),"S");
        if(result)
        {
            Toast.makeText(this, "Successfully Saved",Toast.LENGTH_SHORT).show();

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
