package edu.gatech.seclass.sdpcryptogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AdminHomePage extends AppCompatActivity {

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
            //none of the radio button was checked.
        }
        else
        {
            int rbID= rbg.getCheckedRadioButtonId();
            RadioButton rb = (RadioButton)findViewById(rbID);
            String rbText = rb.getText().toString();
            if(rbText.contains("Crypto"))
            {
                AdminActivity = new Intent(this,Add_Cryptograms.class);
            }
            else
            {
                AdminActivity = new Intent(this,Add_Player.class);
            }

            startActivity(AdminActivity);

        }
    }

    public void onReturnClick(View view)
    {
        super.onBackPressed();
    }
}
