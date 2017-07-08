package edu.gatech.seclass.sdpcryptogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import edu.gatech.seclass.utilities.ExternalWebService;


public class Add_Cryptograms extends AppCompatActivity {

    DBHelper sdpdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__cryptograms);
        sdpdb  = new DBHelper(this);
    }

    public void onEncodeClick(View view)
    {
        boolean binputPhrase = true;
        EditText inputPhrase = (EditText)findViewById(R.id.inputPhrase);
        EditText encodePhrase = (EditText)findViewById(R.id.encodedPhrase);

        String strinputPhrase = inputPhrase.getText().toString();
        if(strinputPhrase.length() == 0)
        {
            binputPhrase = false;
            Toast.makeText(this,"Input Phrase is empty",Toast.LENGTH_SHORT).show();
            return;
        }
        if(binputPhrase) {
            String encode = CasearsCipher(strinputPhrase,1,true);
            encodePhrase.setText(encode);
        }
    }

    public void onSaveClick(View view)
    {
        boolean binputPhrase  = true;
        boolean bencodedPhrase = true;
        EditText inputPhrase = (EditText)findViewById(R.id.inputPhrase);
        EditText encodePhrase = (EditText)findViewById(R.id.encodedPhrase);
        ExternalWebService externalWebService = ExternalWebService.getInstance();

        String strinputPhrase = inputPhrase.getText().toString();
        String strencodedPhrase = encodePhrase.getText().toString();

        if(strinputPhrase.length() == 0)
        {
            binputPhrase = false;
            Toast.makeText(this,"Input Phrase is empty",Toast.LENGTH_SHORT).show();
            return;
        }
        if(strencodedPhrase.length() == 0)
        {
            bencodedPhrase = false;
            Toast.makeText(this,"Encoded Phrase is empty",Toast.LENGTH_SHORT).show();
            return;
        }
        if(bencodedPhrase && binputPhrase)
        {
            boolean result = sdpdb.insertDataCryptograms(strencodedPhrase,strinputPhrase);
            if(!result)
            {
                String ref = externalWebService.addCryptogramService(strinputPhrase,strencodedPhrase);
                TextView txtWebServiceMessage = (TextView)findViewById(R.id.playerUserName);
                if(ref != null)
                    txtWebServiceMessage.setText(ref);
                else
                    txtWebServiceMessage.setText("");
                Toast.makeText(this,"Cryptogram already exists",Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(this,"Cryptogram successfully added"  ,Toast.LENGTH_SHORT).show();

            }
        }
    }

    public static  String CasearsCipher(String input,int shift_digit, boolean isEncode)
    {
        //Creates an arrays with ASCII values of lower and upper case alphabets
        List<Integer> uppercase = FillArray(65,90,1);
        List<Integer> lowercase = FillArray(97,122,1);

        //Converts the string to a char array
        char[] inputAsCharArray = input.toCharArray();
        //length of input message
        int inputLength = inputAsCharArray.length;
        //Creates an output array of same size
        char[] outputAsCharArray = new char[inputLength];

        //loops through every input character
        for(int i =0;i <inputLength;i++ )
        {
            char c = inputAsCharArray[i];
            //Checks for character is alphabet
            if(Character.isLetter(c))
            {
                //Checks for character is lower case alphabet
                if(Character.isLowerCase(c)) {
                    outputAsCharArray[i] = (char)ReturnNext(isEncode, lowercase,(int)c ,shift_digit);
                }
                //Checks for character is upper case alphabet
                else if(Character.isUpperCase(c))
                {
                    outputAsCharArray[i] = (char)ReturnNext(isEncode, uppercase,(int)c ,shift_digit);

                }

            }
            //else use the same character in output
            else
            {
                outputAsCharArray[i] = inputAsCharArray[i];
            }
        }

        return String.valueOf(outputAsCharArray);
    }


    public static int ReturnNext(boolean isEncode,List<Integer> lsAlphabets,int currentvalue, int shift_digit)
    {
        int next = 0;
        //gets the length of alphabets array
        int len = lsAlphabets.size();
        //gets the index of current character
        int indexCurrent = lsAlphabets.indexOf(currentvalue);

        //encode
        if(isEncode)
        {
            //calculates the index
            next = indexCurrent-shift_digit;
            //for circular indexing
            if (next < 0)
            {
                next = len+(indexCurrent-shift_digit);
            }

        }
        else
        {
            //calculates the index
            next = indexCurrent+shift_digit;
            //for circular indexing
            if(next >= len)
            {
                next = (indexCurrent+shift_digit)-len;
            }
        }

        //returns the ASCII value of result character
        return lsAlphabets.get(next);
    }

    //Creates the array for alphabtes(lower and upper cases)
    public static List<Integer> FillArray(int start,int stop, int increment)
    {
        int size = stop-start+1;
        List<Integer> lsAlphabets = new ArrayList<Integer>();
        int[] array = new int[size];
        start = start-1;
        for(int k = 0; k < array.length; k++) {
            start = start + increment;
            lsAlphabets.add(start);
        }

        return lsAlphabets;
    }

    public void onReturnClick(View view)
    {
        super.onBackPressed();
    }


}
