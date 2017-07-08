package edu.gatech.seclass.sdpcryptogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Player_Home_Page extends AppCompatActivity {
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player__home__page);
        Bundle bundle = getIntent().getExtras();
        username= bundle.getString("username");
    }


    public  void onSubmit(View view)
    {
        RadioGroup rbg = (RadioGroup)findViewById(R.id.rbgPlayerOptions);

        if(rbg.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this,"Please select an option, to proceed",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            int selectedrbID = rbg.getCheckedRadioButtonId();
            RadioButton rb = (RadioButton)findViewById(selectedrbID);
            Intent PlayerSelectedActivity;
            String rb_text = rb.getText().toString();
            if(rb_text.contains("Rating"))
            {
                PlayerSelectedActivity = new Intent(this,Ratings.class);
            }
            else if(rb_text.contains("Previously"))
            {
                PlayerSelectedActivity = new Intent(this,View_Prior.class);
            }
            else
            {
                PlayerSelectedActivity = new Intent(this,Cryptogram_List.class);
            }

            Bundle bundle = new Bundle();
            bundle.putString("username",username);
            PlayerSelectedActivity.putExtras(bundle);
            startActivity(PlayerSelectedActivity);
        }
    }

    public void onReturnClick(View view)
    {
        super.onBackPressed();
    }
}
