package edu.gatech.seclass.sdpcryptogram;

import android.content.Context;

import java.util.ArrayList;

import edu.gatech.seclass.utilities.RatingsUtil;

/**
 * Created by WangZiyan on 7/14/17.
 */

public class Ratings {


    /*
    * pvp7:Created this to link to the UI page
    *
    * */
    public static  ArrayList<RatingsUtil>  getAllPlayerRatings(Context context)
    {
        DBHelper sdpdb = new DBHelper(context);
        ArrayList<RatingsUtil> ratingsList=  sdpdb.displayAllUserRatings1();
        return ratingsList;
    }

    /*
   * pvp7:Created this to link to the UI page
   *
   * */
    public static void  insertFirstRatings(Context context)
    {
        DBHelper sdpdb = new DBHelper(context);
        boolean resultplayergame = sdpdb.insertupdateDataPlayer_Games("JD",1,"ABC","ZZZ","I");
    }
}
