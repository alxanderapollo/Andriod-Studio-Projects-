package com.example.alexanderapollosalazar.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view){

        //check if button was pressed
        Log.i("Info","Button pressed");

        //get string edit text
        EditText editText  = (EditText) findViewById(R.id.editText);

        //change input and put into a string
        String euroExchange = editText.getText().toString();

        //parse String into a double
        double euro = Double.parseDouble(euroExchange);

        //dont take negative input
        if(euro <= 0){
            //prompt user
            Toast.makeText(this, "unacceptable input, no negative values", Toast.LENGTH_LONG).show();
        }else {

            //american dollar exchange
            double ameroExChange = euro * 1.16;

            String result = String.format("%.2f", ameroExChange);

            //display the results in logcat
            Log.i("amount in $ ", result);
            //display on screen
            Toast.makeText(this, "€" + euro + " is $" + ameroExChange, Toast.LENGTH_LONG).show();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
