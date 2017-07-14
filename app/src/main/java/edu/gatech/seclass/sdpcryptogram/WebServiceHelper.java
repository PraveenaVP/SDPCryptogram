package edu.gatech.seclass.sdpcryptogram;

import android.content.Context;

import edu.gatech.seclass.utilities.ExternalWebService;

/**
 * Created by praveena on 7/14/17.
 */

public class WebServiceHelper {

    /*
   * pvp7:Created this to link to the UI page
   *
   * */
    public  static  boolean ratingsupdate(Context context,String username) {
        boolean result = false;
        DBHelper sdpdb = new DBHelper(context);
        ExternalWebService server = ExternalWebService.getInstance();
        String[] names = {"", ""};
        String namesdb = sdpdb.displayPlayerData(username);
        if (namesdb != "")
        {names = namesdb.split("\\s+");}
        int[] ratings = sdpdb.RetrieveUserRating(username);
        result = server.updateRatingService(username, names[0], names[1], ratings[0], ratings[1], ratings[2]);
        return result;
    }


    /*
   * pvp7:Created this to link to the UI page
   *
   * */
    public  static String addCryptograms(String strinputPhrase, String strencodedPhrase)
    {
        ExternalWebService server = ExternalWebService.getInstance();
        return (server.addCryptogramService(strinputPhrase, strencodedPhrase));

    }
}
