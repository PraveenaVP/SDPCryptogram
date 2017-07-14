package edu.gatech.seclass.sdpcryptogram;

import android.content.Context;

/**
 * Created by WangZiyan on 7/14/17.
 */

public class Admin {



    /*
 * pvp7:Created this to link to the UI page
 *
 * */
    public static boolean addPlayer(Context context, String strFirstName, String strLastName, String strUserName)
    {
        boolean result = false;
        DBHelper sdpdb = new DBHelper(context);
        result = sdpdb.insertDataPlayer(strFirstName,strLastName,strUserName);
        return result;
    }

    /*
 * pvp7:Created this to link to the UI page
 *
 * */
    public static boolean addCryptograms(Context context, String strencodedPhrase,String strinputPhrase)
    {
        boolean result  = false;
        DBHelper sdpdb = new DBHelper(context);
        result = sdpdb.insertDataCryptograms(strencodedPhrase, strinputPhrase);
        return result;
    }

}
