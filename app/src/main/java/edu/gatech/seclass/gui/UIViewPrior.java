package edu.gatech.seclass.gui;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.seclass.sdpcryptogram.Cryptogram;
import edu.gatech.seclass.sdpcryptogram.DBHelper;
import edu.gatech.seclass.sdpcryptogram.R;
import edu.gatech.seclass.utilities.CryptogramsUtil;

import java.util.ArrayList;

/**
 * Created by praveena on 7/3/17.
 */

public class UIViewPrior extends AppCompatActivity {

    DBHelper sdpdb ;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prior);
        sdpdb = new DBHelper(this);
        Bundle bundle = getIntent().getExtras();
        username= bundle.getString("username");
        //String[] testdata = sdpdb.displayPriorGames(username);
        //ArrayList<CryptogramsUtil> priorlist= sdpdb.displayPriorGames1(username);

        ArrayList<CryptogramsUtil> priorlist= Cryptogram.getpriorlist(this,username);
        ListView lvpriortList = (ListView) findViewById(R.id.prior_listview);

        if(priorlist != null) {
            PriorAdapter cryptogramAdapter = new PriorAdapter(this,R.layout.prior_list,priorlist);
            lvpriortList.setAdapter(cryptogramAdapter);
            lvpriortList.setOnItemClickListener(new ItemList());
        }
        else
        {
            Toast.makeText(this,"No Prior Games",Toast.LENGTH_SHORT).show();
        }

    }

    class PriorAdapter extends ArrayAdapter<CryptogramsUtil>{
        private Context mcontext;
        private int mresource;


        /**
         * Constructor
         *
         * @param context  The current context.
         * @param resource The resource ID for a layout file containing a TextView to use when
         *                 instantiating views.
         * @param objects  The objects to represent in the ListView.
         */
        public PriorAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<CryptogramsUtil> objects) {
            super(context, resource, objects);
            mresource = resource;
            mcontext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            String id = getItem(position).getId();
            String puzzle = getItem(position).getCryptogram();
            String userText = getItem(position).getUserText();
            String status = getItem(position).getStatus();


            CryptogramsUtil priorcryptogram = new CryptogramsUtil(id,puzzle,userText,status,true);

            LayoutInflater inflator = LayoutInflater.from(mcontext);
            convertView = inflator.inflate(mresource,parent,false);

            TextView tvId = (TextView)convertView.findViewById(R.id.tvid);
            TextView tvpuzzle = (TextView)convertView.findViewById(R.id.tvcrypt);
            TextView tvuserText = (TextView)convertView.findViewById(R.id.tvusertext);
            TextView tvStatus = (TextView)convertView.findViewById(R.id.tvstatus);

            tvId.setText(id);
            tvpuzzle.setText(puzzle);
            tvuserText.setText(userText);
            tvStatus.setText(status);


            return convertView;




        }
    }

    class ItemList implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup viewg = (ViewGroup) view;
            TextView tvUserText = (TextView) viewg.findViewById(R.id.tvusertext);
            TextView tvcryptID=(TextView)viewg.findViewById(R.id.tvid);
            TextView tvcrypt=(TextView)viewg.findViewById(R.id.tvcrypt);
            int cryptID = Integer.parseInt (tvcryptID.getText().toString());
            String crypt  = tvcrypt.getText().toString();
            String userText = tvUserText.getText().toString();

            Intent newIntent = new Intent(UIViewPrior.this, UISolvePrior.class);

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
