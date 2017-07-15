package edu.gatech.seclass.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.gatech.seclass.sdpcryptogram.R;

/**
 * Created by praveena on 7/3/17.
 */

public class UIAdminHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
    }


    public void onSubmitClick(View view)
    {
        RadioGroup rbg = (RadioGroup)findViewById(R.id.rbgAdminOptions);
        Intent AdminActivity;
        if(rbg.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this,"Please select an option",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            int rbID= rbg.getCheckedRadioButtonId();
            RadioButton rb = (RadioButton)findViewById(rbID);
            String rbText = rb.getText().toString();
            if(rbText.contains("Crypto"))
            {
                AdminActivity = new Intent(this,UIAddCryptograms.class);
            }
            else
            {
                AdminActivity = new Intent(this,UIAddPlayer.class);
            }

            startActivity(AdminActivity);

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
        Intent newIntent = new Intent(this, UIMainActivity.class);
        startActivity(newIntent);
    }}
