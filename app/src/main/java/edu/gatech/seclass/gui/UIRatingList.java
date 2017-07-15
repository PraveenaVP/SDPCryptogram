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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.sdpcryptogram.DBHelper;
import edu.gatech.seclass.sdpcryptogram.R;
import edu.gatech.seclass.sdpcryptogram.Ratings;
import edu.gatech.seclass.sdpcryptogram.Player;
import edu.gatech.seclass.sdpcryptogram.WebServiceHelper;
import edu.gatech.seclass.utilities.RatingsUtil;
import edu.gatech.seclass.utilities.ExternalWebService;
import static edu.gatech.seclass.sdpcryptogram.R.layout.ratings;

/**
 * Created by praveena on 7/3/17.
 */

public class UIRatingList extends AppCompatActivity {

    //DBHelper sdpdb ;
    String username;
    ArrayList<RatingsUtil> getRatings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        Bundle bundle = getIntent().getExtras();
        username= bundle.getString("username");
       // sdpdb = new DBHelper(this);
        ListView ratingsList = (ListView) findViewById(R.id.ratings_listview);

       // ArrayList<RatingsUtil> getRatings= sdpdb.displayAllUserRatings1();
       // ArrayList<RatingsUtil> getRatings= Ratings.getAllPlayerRatings(this);
        int[] rating = Player.requestUserRatingFromServer(username); //retrieve the current user data
        RatingsUtil currentplayerrating =
                new RatingsUtil(username,String.valueOf(rating[2]),String.valueOf(rating[0]),String.valueOf(rating[1]));
        getRatings= Ratings.getAllPlayerRatings(this);
        //getRatings.add(currentplayerrating);
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
        onBackPressed();
    }


    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {

        Intent newIntent = new Intent(this, UIPlayerHomePage.class);
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        newIntent.putExtras(bundle);
        startActivity(newIntent);
    }

    public void onUploadClick(View view) {
//        ExternalWebService server = ExternalWebService.getInstance();
//
//        String[] names = sdpdb.displayPlayerData(username).split("\\s+");
//        int[] ratings = sdpdb.RetrieveUserRating(username);
//
//        boolean result = server.updateRatingService(username, names[0], names[1], ratings[0], ratings[1], ratings[2]);
        int size = 0;
        boolean result = false;
        if(getRatings != null)
        {
         size = getRatings.size();
            for(int i = 0 ; i < size;i++)
            {
                result = WebServiceHelper.ratingsupdate(this, getRatings.get(i).getUsername());
            }
        }

            else
        {

            result = WebServiceHelper.ratingsupdate(this, username);
        }

        if (!result) {
            // error message
        } else {
            // message
        }
    }
}
