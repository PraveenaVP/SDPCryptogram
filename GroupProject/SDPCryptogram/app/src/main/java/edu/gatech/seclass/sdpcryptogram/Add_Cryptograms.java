package edu.gatech.seclass.sdpcryptogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.text.TextUtils;

import edu.gatech.seclass.utilities.ExternalWebService;


public class Add_Cryptograms extends AppCompatActivity {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    boolean checkValidMessage;
    boolean encoded;

    DBHelper sdpdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__cryptograms);
        sdpdb = new DBHelper(this);
    }

    public void onEncodeClick(View view) {


        EditText txt = (EditText) findViewById(R.id.inputPhrase);
        String inputMessage = String.valueOf(txt.getText().toString());
        EditText number = (EditText) findViewById(R.id.shiftNumber);
        int shiftNumber = 0;
        EditText returntxt = (EditText) findViewById(R.id.encodedPhrase);


        checkValidMessage = false;

        for (int i = 0; i < inputMessage.length(); i++) {
            if (Character.isLetter(inputMessage.charAt(i))) {
                checkValidMessage = true;
            }
        }
        if (TextUtils.isEmpty(inputMessage)||!checkValidMessage){
            txt.setError("Invalid Message");
        }


        if (TextUtils.isEmpty(String.valueOf(number.getText().toString()))) {
            number.setError("Invalid Shift Number");
        }
        else {
            shiftNumber = Integer.parseInt(number.getText().toString());
        }

        if(shiftNumber<=0 || shiftNumber>=26){
            number.setError("Invalid Shift Number");

        }else {
            String encode = CasearsCipher(inputMessage, shiftNumber);
            returntxt.setText(encode);

            }
        }



    public void onSaveClick(View view) {

        EditText inputPhrase = (EditText) findViewById(R.id.inputPhrase);
        EditText encodePhrase = (EditText) findViewById(R.id.encodedPhrase);
        ExternalWebService externalWebService = ExternalWebService.getInstance();

        String strinputPhrase = inputPhrase.getText().toString();
        String strencodedPhrase = encodePhrase.getText().toString();
        TextView txtWebServiceMessage = (TextView) findViewById(R.id.message);


       if (strinputPhrase.length() == 0 || strinputPhrase == null)
        {
            txtWebServiceMessage.setText("Input Phrase is empty");

        }
        if (strencodedPhrase.length() == 0 || strencodedPhrase == null) {
            txtWebServiceMessage.setText("Encoded Phrase is empty");
        }

        if ((strinputPhrase.length() != 0) && strencodedPhrase.length() != 0)
        {
            boolean result = sdpdb.insertDataCryptograms(strencodedPhrase, strinputPhrase);
                if (!result) {
                    txtWebServiceMessage.setText("Cryptogram already exists");

                } else {
                    String ref = externalWebService.addCryptogramService(strinputPhrase, strencodedPhrase);
                    if (ref != null)
                        txtWebServiceMessage.setText("Saved & Identifier is " + ref);

                }
            }
        }




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

}


