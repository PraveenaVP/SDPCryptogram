package edu.gatech.seclass.sdpcryptogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Player extends AppCompatActivity {

    DBHelper sdpdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__player);
         sdpdb  = new DBHelper(this);

    }


    public void OnRegisterClick(View view)
    {
        EditText firstname = (EditText)findViewById(R.id.playerFirstName);
        EditText lastname = (EditText)findViewById(R.id.playerLastName);
        EditText username = (EditText)findViewById(R.id.message);

        boolean bfirstName = true;
        boolean  blastName = true;
        boolean  buserName = true;

        String strFirstName = firstname.getText().toString();
        if(strFirstName.length() == 0)
        {
            bfirstName = false;
            Toast.makeText(this,"First Name is empty",Toast.LENGTH_SHORT).show();
            return;
        }
        String strLastName = lastname.getText().toString();
        if(strLastName.length() == 0)
        {
            blastName = false;
            Toast.makeText(this,"Last Name is empty",Toast.LENGTH_SHORT).show();
            return;
        }
        String strUserName = username.getText().toString();
        if(strUserName.length() == 0)
        {
            buserName = false;
            Toast.makeText(this,"User Name is empty",Toast.LENGTH_SHORT).show();
            return;
        }

        if(bfirstName && blastName && buserName)
        {
            boolean result = sdpdb.insertDataPlayer(strFirstName,strLastName,strUserName);
            if(!result)
            {
                Toast.makeText(this,"User Name already exists",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"User Name registered successfully",Toast.LENGTH_SHORT).show();

            }
        }



    }

    public void onReturnClick(View view)
    {
        super.onBackPressed();
    }
}
