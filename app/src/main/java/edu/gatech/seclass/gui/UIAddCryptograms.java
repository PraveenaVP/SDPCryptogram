package edu.gatech.seclass.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;

import edu.gatech.seclass.sdpcryptogram.Admin;
import edu.gatech.seclass.sdpcryptogram.DBHelper;
import edu.gatech.seclass.sdpcryptogram.R;
import edu.gatech.seclass.sdpcryptogram.Cryptogram;
import edu.gatech.seclass.sdpcryptogram.WebServiceHelper;
import edu.gatech.seclass.utilities.ExternalWebService;

/**
 * Created by praveena on 7/3/17.
 */
public class UIAddCryptograms extends AppCompatActivity {

    boolean checkValidMessage;
    boolean encoded;

    //DBHelper sdpdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cryptograms);
        //sdpdb = new DBHelper(this);
    }

    public void onEncodeClick(View view) {

        int shiftNumber = 0;
        checkValidMessage = false;

        EditText txt = (EditText) findViewById(R.id.inputPhrase);
        String inputMessage = String.valueOf(txt.getText().toString());

        EditText number = (EditText) findViewById(R.id.shiftNumber);
        EditText returntxt = (EditText) findViewById(R.id.encodedPhrase);

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
            String encode = Cryptogram.CasearsCipher(inputMessage, shiftNumber);
            returntxt.setText(encode);

            }
        }



    public void onSaveClick(View view) {

        EditText inputPhrase = (EditText) findViewById(R.id.inputPhrase);
        EditText encodePhrase = (EditText) findViewById(R.id.encodedPhrase);
        //ExternalWebService externalWebService = ExternalWebService.getInstance();

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
            //boolean result = sdpdb.insertDataCryptograms(strencodedPhrase, strinputPhrase);
             /* pvp7:Created this to link to the UI page * */
            boolean result = Admin.addCryptograms(this,strencodedPhrase, strinputPhrase);
                if (!result) {
                    txtWebServiceMessage.setText("Cryptogram already exists");
                } else {
                    //String ref = externalWebService.addCryptogramService(strinputPhrase, strencodedPhrase);
                    String ref = WebServiceHelper.addCryptograms(strinputPhrase, strencodedPhrase);
                    if (ref != null)
                        txtWebServiceMessage.setText("Saved & Identifier is " + ref);
                    else
                        txtWebServiceMessage.setText("Error. Could not add it to external web server.");
                }
            }
        }



}


