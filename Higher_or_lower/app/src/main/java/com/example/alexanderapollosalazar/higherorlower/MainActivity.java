package com.example.alexanderapollosalazar.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNum;

    //method to be called and to generate a new random number /
    public void generateRandomNumber(){
        Random rand = new Random();
        randomNum = rand.nextInt(20) + 1;

    }

    public void guessMe(View view) {
        //check if button works
        Log.i("Info", "Button pressed");

        //make random varaible
        //String randomnumber = String.valueOf(n);

        //make user guess until his guess is correct

        int userInput;

        //grab input
        EditText editText = (EditText) findViewById(R.id.editText);
        //parse to a string
        String userGuess = editText.getText().toString();
        //parse into a number
        //int guess = Integer.parseInt(userGuess);
        //check for correct answer


        int guess = Integer.parseInt(userGuess);

            try {// if is number
                //guesses might be thr problem
                Integer.parseInt(userGuess);

                //Toast.makeText(this, "The number is " +n, Toast.LENGTH_LONG).show();
                if (guess <= 0) {
                    Toast.makeText(this, " Guesses cannot be less than or equal to zero ", Toast.LENGTH_LONG).show();
                } else if (guess < randomNum) {
                    Toast.makeText(this, " Guess Higer you almost have  it ", Toast.LENGTH_LONG).show();

                } else if (guess > randomNum) {
                    Toast.makeText(this, " Guess lower you almost have it ", Toast.LENGTH_LONG).show();
                } else if (guess == randomNum) {
                    String randomNumber = String.valueOf(randomNum);
                    Toast.makeText(this, "Your guess was correct the number is " + randomNumber, Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Your guess was correct Try again! " + randomNumber, Toast.LENGTH_LONG).show()
                    generateRandomNumber();
                }

            } catch (NumberFormatException e) {

                Toast.makeText(this, "Your entry can only be numbers not letters or words", Toast.LENGTH_LONG).show();


            }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}
