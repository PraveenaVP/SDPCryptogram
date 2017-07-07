package edu.gatech.seclass.sdpcryptogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class View_Prior extends AppCompatActivity {

    DBHelper sdpdb ;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__prior);
        sdpdb = new DBHelper(this);
        Bundle bundle = getIntent().getExtras();
        username= bundle.getString("username");
        String[] testdata = sdpdb.displayPriorGames(username);
        ListView priortList = (ListView)findViewById(R.id.prior_listview);
        ArrayAdapter<String> priorlistAdapter = new ArrayAdapter<String>(this,R.layout.prior_list,R.id.prior_text,testdata);
        priortList.setAdapter(priorlistAdapter);
        priortList.setOnItemClickListener(new ItemList());

    }

    class ItemList implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup viewg = (ViewGroup) view;
            TextView prior_text = (TextView) viewg.findViewById(R.id.prior_text);
            String selected = prior_text.getText().toString();

            String[] userselectedlist = selected.split("\\s*:\\s*");
            int cryptID = Integer.parseInt(userselectedlist[0]);
            String crypt = userselectedlist[1].toString();
            String userText = userselectedlist[2].toString();;

           Intent newIntent = new Intent(View_Prior.this, Solve_Prior.class);

           Bundle bundle = new Bundle();
            bundle.putString("cryptogram", crypt);
            bundle.putInt("cryptID", cryptID);
            bundle.putString("username",username);
            bundle.putString("userText",userText);
            newIntent.putExtras(bundle);
            startActivity(newIntent);



        }
    }

    public void onReturnClick(View view)
    {
        super.onBackPressed();
    }
}
