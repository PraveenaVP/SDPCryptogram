package edu.gatech.seclass.sdpcryptogram;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gatech.seclass.utilities.RatingsUtil;
import edu.gatech.seclass.utilities.ExternalWebService;

public class Ratings extends AppCompatActivity {

    DBHelper sdpdb ;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        Bundle bundle = getIntent().getExtras();
        username= bundle.getString("username");
        sdpdb = new DBHelper(this);
        ListView ratingsList = (ListView) findViewById(R.id.ratings_listview);
        ArrayList<RatingsUtil> getRatings= sdpdb.displayAllUserRatings1();

        if(getRatings != null) {
            RatingsAdpater ratingsAdapter = new RatingsAdpater(this, R.layout.ratings, getRatings);
            ratingsList.setAdapter(ratingsAdapter);
        }
        else
        {
            Toast.makeText(this,"No Records Found !!..",Toast.LENGTH_SHORT);
            return;
        }


    }


   public class RatingsAdpater extends ArrayAdapter<RatingsUtil>
   {
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
       public RatingsAdpater(@NonNull Context context, @LayoutRes int resource,
                             @NonNull ArrayList<RatingsUtil> objects)
       {
           super(context, resource, objects);
           mcontext = context;
           mresource = resource;

       }

       @NonNull
       @Override
       public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
       {
           String username = getItem(position).getUsername();
           String solved = getItem(position).getSolved();
           String incorrect = getItem(position).getIncorrect();
           String started = getItem(position).getStarted();

           RatingsUtil displayRatings = new RatingsUtil(username,solved,incorrect,started);

           //Create a new Layout inflater

           LayoutInflater inflater = LayoutInflater.from(mcontext);
           convertView = inflater.inflate(mresource,parent,false);

           TextView txtUsername = (TextView)convertView.findViewById(R.id.tvusername);
           TextView txtSolved = (TextView)convertView.findViewById(R.id.tvsolved);
           TextView txtIncorrect = (TextView)convertView.findViewById(R.id.tvincorrect);
           TextView txtStarted = (TextView)convertView.findViewById(R.id.tvstarted);

           txtUsername.setText(username);
           if(solved == null)
           {
               solved = "0";
           }
           txtSolved.setText("Solved: " +solved);
           if(incorrect == null)
           {
               incorrect = "0";
           }
           txtIncorrect.setText("Incorrect: "+incorrect);
           if(started == null)
           {
               started = "0";
           }
           txtStarted.setText("Started: "+started);


           return convertView;



       }
   }


    public void onReturnClick(View view)
    {
        super.onBackPressed();
    }

    public void onUploadClick(View view) {
        ExternalWebService server = ExternalWebService.getInstance();
        DBHelper localDB = new DBHelper(this);

        // updateRatingService(String username,	String firstname, String lastname, int solved, int started,	int incorrect)
        //server.updateRatingService();
    }
}
