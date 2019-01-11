package com.example.alexanderapollosalazar.connect_3_game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //0: yellow, 1: red, 2: empty
    int activePlayer = 0;// zero for yellow, 1 for red.
    //this is the game state of the game 2: represent that the board is empty.
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    // the game will be active as long as no one has won
    boolean gameActive = true;

    //will allow the game to know based on the users playing which one has one.
    //all the winning postions are added to the array(diagonal and vertical postions etc
    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    //dropin
    public void dropin(View view){
        //will be our counter
        ImageView counter = (ImageView) view;

        //the tag is specfic label that was placed to each spot on the game, where all the images sit
        //Log.i("Tag",counter.getTag().toString());

        //tapped counter
        // will get the state of the counter
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        //if the game space is empty we can add counters to play, gameactve while no one has one
        //we can continue to play.
        if(gameState[tappedCounter] ==2 && gameActive) {

            //set game state to equal active player.

            gameState[tappedCounter] = activePlayer;

            //will move the image off the screen
            counter.setTranslationY(-1500);

            //if the counter is zero  set the image to yellow
            if (activePlayer == 0) {
                //set the image to yellow.
                counter.setImageResource(R.drawable.yellow);
                //setting player to one will make it red counter falls next.
                activePlayer = 1;
            } else { //otherwie set it to red:1
                counter.setImageResource(R.drawable.red);
                //will set back to yellow
                activePlayer = 0;


            }
            counter.animate().translationYBy(1500).rotation(8000).setDuration(300);

            //loop through all the winning postions
            //we want the yeilds to be all zeros or ones (yellows or red)
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                    //someone has won

                    gameActive = false;

                    String winner = "";

                    if (activePlayer == 1) {

                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }
                    //Toast.makeText(this, winner + " has won!", Toast.LENGTH_LONG).show();
                    // will make the button visable once a player wins
                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                    winnerTextView.setText(winner + " has won!");
                    //make the buttons visible and text view visable
                    playAgainButton.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view){
        //this method will restart the game first make the button and text view invisable again
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

        //make the buttons visible and text view visable
        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);

        //set all the image views empty again, whcih means it will clear the image source counters from the screens

        //get our gridlayout

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i = 0; i <gridLayout.getChildCount(); i++){
            ImageView  counter = (ImageView) gridLayout.getChildAt(i);
            //now remove images
            counter.setImageDrawable(null);

        }

        //reset our game states
        for(int i=0; i <gameState.length; i++ ){
            gameState[i] = 2;

        }
        //0: yellow, 1: red, 2: empty
        activePlayer = 0;// zero for yellow, 1 for red.
        //this is the game state of the game 2: represent that the board is empty.
        // the game will be active as long as no one has won
        gameActive = true;




    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
