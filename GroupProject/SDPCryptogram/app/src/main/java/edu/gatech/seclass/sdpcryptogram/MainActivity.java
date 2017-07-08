package edu.gatech.seclass.sdpcryptogram;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Added for db
    DBHelper sdpcryptogram_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Calls the constructor of DBHelper that creates the db and tables
        //sdpcryptogram_db = new DBHelper(this);

        sdpcryptogram_db  = new DBHelper(this);
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
             NextActivity = new Intent(this, AdminHomePage.class);
        }
        else
        {
            NextActivity =  new Intent(this,Player_Home_Page.class);
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
