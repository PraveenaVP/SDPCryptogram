package edu.gatech.seclass.sdpcryptogram;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cryptogram_List extends AppCompatActivity {

    DBHelper sdpdb ;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sdpdb = new DBHelper(this);
        Bundle bundle = getIntent().getExtras();
        username= bundle.getString("username");
        setContentView(R.layout.activity_cryptogram__list);
        String[] testdata = sdpdb.displayCryptograms(0,10);
        String[]test = sdpdb.displayCryptogramsWithStatus(username);
        if(test != null) {
            ListView cryptList = (ListView) findViewById(R.id.crypt_list);
            ArrayAdapter<String> cryptlistAdapter = new ArrayAdapter<String>(this, R.layout.cryptogram_list, R.id.list_cryptogram, test);
            cryptList.setAdapter(cryptlistAdapter);
            cryptList.setOnItemClickListener(new ItemList());
        }
        else
        {
            Toast.makeText(this,"No Cryptograms found", Toast.LENGTH_SHORT).show();
        }

    }

    class ItemList implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup viewg=(ViewGroup)view;
            TextView crypt_text=(TextView)viewg.findViewById(R.id.list_cryptogram);
            String selected  = crypt_text.getText().toString();
            int index = selected.indexOf(':');
            int cryptID = Integer.parseInt (selected.substring(0,index));
            String crypt  = sdpdb.CryptogramSolution(cryptID,false);

            Intent newIntent = new Intent(Cryptogram_List.this, Solve_Cryptogram.class);

            Bundle bundle = new Bundle();
            bundle.putString("crypt", crypt);
            bundle.putInt("cryptID", cryptID);
            bundle.putString("username",username);
            newIntent.putExtras(bundle);
            startActivity(newIntent);



        }
    }

    public void onReturnClick(View view)
    {
        onBackPressed();
    }


}



