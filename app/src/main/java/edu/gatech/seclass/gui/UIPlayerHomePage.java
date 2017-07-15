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

public class UIPlayerHomePage extends AppCompatActivity {
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_home_page);
        Bundle bundle = getIntent().getExtras();
        username= bundle.getString("username");
    }


    public void onSubmit(View view)
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

            if(rb_text.contains("Current"))
            {
                PlayerSelectedActivity = new Intent(this,UIPlayerRating.class);
            }
            else if(rb_text.contains("All Players Ratings"))
            {
                PlayerSelectedActivity = new Intent(this,UIRatingList.class);
            }
            else if(rb_text.contains("Previously"))
            {
                PlayerSelectedActivity = new Intent(this,UIViewPrior.class);
            }
            else
            {
                PlayerSelectedActivity = new Intent(this,UICryptogramList.class);
            }

            Bundle bundle = new Bundle();
            bundle.putString("username",username);
            PlayerSelectedActivity.putExtras(bundle);
            startActivity(PlayerSelectedActivity);
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
    }
}
