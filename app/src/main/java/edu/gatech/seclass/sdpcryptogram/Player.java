package edu.gatech.seclass.sdpcryptogram;

import android.content.Context;

import edu.gatech.seclass.utilities.ExternalWebService;

/**
 * Created by WangZiyan on 7/14/17.
 */

public class Player {

    public static int[] requestUserRatingFromServer(String username) {
        // reqeuest current user's rating

        ExternalWebService server = ExternalWebService.getInstance();

        int[] resultRating = new int[3];

        ExternalWebService.PlayerRating rating = server.requestPlayerRating(username);

        if (!rating.getFirstname().equals("")){
            // display activity_user_rating
            resultRating[2] = rating.getStarted();
            resultRating[1] = rating.getIncorrect();
            resultRating[0] = rating.getSolved();
        }

        return resultRating;
    }

 /*
   * pvp7:Created this to link to the UI page
   *
   * */

 public static String recentPlayerAttempt(Context context,String username,int cryptID)
 {
     DBHelper sdpdb = new DBHelper(context);
     return (sdpdb.getlastUserText(username,cryptID));

 }

 public static int[] playerRating(Context context,String username)
 {
     DBHelper sdpdb = new DBHelper(context);
     return( sdpdb.RetrieveUserRating(username));
 }

    /*
     * pvp7:Created this to link to the UI page
     *
     * */
    public static void  insertFirstPlayer(Context context)
    {
        DBHelper sdpdb = new DBHelper(context);
        boolean resultplayer = sdpdb.insertDataPlayer("Jane","Doe","JD");
    }

}
