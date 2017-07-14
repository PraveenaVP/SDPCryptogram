package edu.gatech.seclass.sdpcryptogram;

import android.content.Context;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;


import edu.gatech.seclass.utilities.CryptogramsUtil;
import edu.gatech.seclass.utilities.ExternalWebService;

/**
 * Created by WangZiyan on 7/14/17.
 */

public class Cryptogram {


    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public Cryptogram() {}

    public static String CasearsCipher(String input, int number) {
        String inputMsg = input.toLowerCase();
        String resultMessage = "";


        if (number > 0 && number < 26) {

            for (int i = 0; i < inputMsg.length(); i++) {
                if (ALPHABET.indexOf(inputMsg.charAt(i)) > -1) {
                    int charPosition = ALPHABET.indexOf(inputMsg.charAt(i));
                    int keyval = (number + charPosition) % 26;
                    char replaceVal = ALPHABET.charAt(keyval);
                    if (input.charAt(i) - inputMsg.charAt(i) < 0)
                        resultMessage += Character.toUpperCase(replaceVal);
                    else
                        resultMessage += replaceVal;
                } else {
                    resultMessage += inputMsg.charAt(i);
                }
            }
        }
        return resultMessage;
    }




    /*pvp7 : Place here from UICryptogramList class
    *pvp7: Changed the signature as it utilizes DBHelper ,
    *pvp7: Which needs the Context to initialize*/
    private void requestCryptograms(Context context) {
        ExternalWebService server = ExternalWebService.getInstance();
        int addedNum = 0;
        DBHelper sdpdb = new DBHelper(context);

        List<String[]> webCryptograms = server.syncCryptogramService();

        for(String[] crypt: webCryptograms) {
            if (sdpdb.insertDataCryptograms(crypt[0], crypt[1]))
                addedNum++;
        }

        // display number of cryptograms added

    }


    /*pvp7: Created this to integrate the class structure
    * */
    public static boolean solveCryptograms(Context context, String username, int cryptID,String cryptogram,String userText)
    {
        boolean result = false;
        boolean dbStatus  = false;

        DBHelper sdpdb = new DBHelper(context);
        String dbSolution  = sdpdb.CryptogramSolution(cryptID,true);

        if(dbSolution.equals(userText))
        {
            dbStatus = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,userText,"C");
            result = true;


        }
        else
        {
            dbStatus = sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,userText,"I");
            result = false;

        }

        return result;
    }


    /*pvp7: Created this to integrate the class structure
 * */
    public static boolean saveCryptograms(Context context, String username, int cryptID,String cryptogram,String userText)
    {
      DBHelper sdpdb = new DBHelper(context);
      return (sdpdb.insertupdateDataPlayer_Games(username,cryptID,cryptogram,userText,"S"));

    }




    /*pvp7: Created this to integrate the class structure
    * */
    public static ArrayList<CryptogramsUtil> getCryptograms(Context context, String username)
    {
        DBHelper sdpdb = new DBHelper(context);
        ArrayList<CryptogramsUtil> cryptList = sdpdb.displayCryptogramsWithStatus1(username);
        return  cryptList;
    }


    /*pvp7: Created this to integrate the class structure
    * */
    public static ArrayList<CryptogramsUtil> getpriorlist(Context context, String username)
    {
        DBHelper sdpdb = new DBHelper(context);
        ArrayList<CryptogramsUtil> priorList = sdpdb.displayPriorGames1(username);
        return  priorList;
    }


}
