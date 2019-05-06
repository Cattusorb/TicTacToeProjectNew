package com.example.tictactoe;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    /** drawable for player one icon*/
    private Drawable idOne;
    private String iconNameOne;

    /** drawable for player two icon*/
    private Drawable idTwo;
    private String iconNameTwo;

    /** mode of the game, pvp, pvceasy, pvcmed, pvchard */
    private String gamemode; 

    /**
     * gamePlay is an array with 9 elements, one for each place in tictactoe
     * 0 is no one has played there
     * 1 is player one has played there
     * 2 is player two have played there
     */
    private int[] gamePlays = {0,0,0,0,0,0,0,0,0};

    /** ArrayList of the Image Buttons */
    private View[] numbers = new View[9];


    /** Number of turns that have gone by */
    private int turnNumber;

    /**If the game has a winner then true, if not, then false */
    private boolean winner;

    /**Updates to have all possible moves if in AI mode*/
    private List<View> unsetNumbers;

    /** true if ai mode is enabled, false if not. */ 
    private boolean ai; 

    TextView output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String mode = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //To change later for custom icons
        idOne = getResources().getDrawable(R.drawable.x);
        idTwo = getResources().getDrawable(R.drawable.o);

        // To change later based on a feature
        iconNameOne = "X";
        iconNameTwo = "O";

        turnNumber = 0;
        winner = false;

        numbers[0] = findViewById(R.id.one);
        numbers[1] = findViewById(R.id.two);
        numbers[2] = findViewById(R.id.three);
        numbers[3] = findViewById(R.id.four);
        numbers[4] = findViewById(R.id.five);
        numbers[5] = findViewById(R.id.six);
        numbers[6] = findViewById(R.id.seven);
        numbers[7] = findViewById(R.id.eight);
        numbers[8] = findViewById(R.id.nine);

        unsetNumbers = new LinkedList<>(Arrays.asList(numbers));
        output = findViewById(R.id.game_state);

        setMode(mode);
    }

    /**  Method to set the mode for the game.  
     * @param mode - String from the intent to tell which mode the user(s) picked
     */
    private void setMode(String mode) {

        if (mode.equals("pvp")) {
             gamemode = mode; 
	         ai = false;
         }
         if (mode.equals("pvceasy")) {
             gamemode = mode; 
             ai = true; 
         }
        if (mode.equals("pvcmed")) {
            gamemode = mode; 
             ai = true; 
        }
        if (mode.equals("pvchard")) {
            gamemode = mode; 
             ai = true; 
        }
}
    /** Method to play a turn on the tictactoe board, once someone has 
     * touched a tile, it will change to the players symbol accordingly.
     */
    public void buttonClick(View view) {

        // Make a way to try again/play again

            turnNumber++;

            // Player one's turn
            if ((turnNumber % 2) == 1) {
                view.setBackgroundResource(R.drawable.x);
                unsetNumbers.remove(view);
                for (int i = 0; i < 9; i++) {
                    if (view == numbers[i]) {
                        gamePlays[i] = 1;
                        unsetNumbers.remove(view);
                    }
                }
                output.setText(iconNameTwo + "'s turn to play!");

                view.setEnabled(false);
                checkWin();
                if(ai == true && winner==false) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            aiPlay();
                        }
                    }, 1000); // Millisecond 1000 = 1 sec
                    // this will change depending on the ai, make methods to do
			      // easy ai, med ai(can call hard and easy randomly) and hard ai. 
                }
            }
            // Player two's turn
            else if (((turnNumber % 2) == 0) && ai == false) {
                view.setBackgroundResource(R.drawable.o);

                for (int i = 0; i < 9; i++) {
                    if (view == numbers[i]) {
                        gamePlays[i] = 2;
                        //unsetNumbers.remove(view);
                    }
                }
                view.setEnabled(false);
                output.setText(iconNameOne + "'s turn to play!");
                checkWin();
            }
    }

    /** Method to check who the winner is, upon finding out it will disable 
     * all the tiles on the board that are not already and the output text will display 
     * the winner
     */ 
    private void checkWin() {
        checkWinPlayerOne();

        checkWinPlayerTwo();

        checkTie();
    }

    private void checkWinPlayerOne () {
        TextView output = findViewById(R.id.game_state);
        if (gamePlays[0] == 1 && gamePlays[1] == 1 && gamePlays[2] == 1) {
            output.setText("The winner is X!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[0] == 1 && gamePlays[3] == 1 && gamePlays[6] == 1) {
            output.setText("The winner is X!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[2] == 1 && gamePlays[5] == 1 && gamePlays[8] == 1) {
            output.setText("The winner is X!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[6] == 1 && gamePlays[7] == 1 && gamePlays[8] == 1) {
            output.setText("The winner is X!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[3] == 1 && gamePlays[4] == 1 && gamePlays[5] == 1) {
            output.setText("The winner is X!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[1] == 1 && gamePlays[4] == 1 && gamePlays[7] == 1) {
            output.setText("The winner is X!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[0] == 1 && gamePlays[4] == 1 && gamePlays[8] == 1) {
            output.setText("The winner is X!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[6] == 1 && gamePlays[4] == 1 && gamePlays[2] == 1) {
            output.setText("The winner is X!");
            winner = true;
            disableTiles();
        }
    }

    private void checkWinPlayerTwo() {
        TextView output = findViewById(R.id.game_state);
        if (gamePlays[0] == 2 &&  gamePlays[1] == 2 && gamePlays[2] == 2) {
            output.setText("The winner is 0!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[0] == 2 && gamePlays[3] == 2 && gamePlays[6] == 2) {
            output.setText("The winner is O!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[2] == 2 && gamePlays[5] == 2 && gamePlays[8] == 2) {
            output.setText("The winner is O!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[6] == 2 && gamePlays[7] == 2 && gamePlays[8] == 2) {
            output.setText("The winner is O!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[3] == 2 && gamePlays[4] == 2 && gamePlays[5] == 2) {
            output.setText("The winner is O!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[1] == 2 && gamePlays[4] == 2 && gamePlays[7] == 2) {
            output.setText("The winner is O!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[0] == 2 && gamePlays[4] == 2 && gamePlays[8] == 2) {
            output.setText("The winner is O!");
            winner = true;
            disableTiles();
        }
        if(gamePlays[6] == 2 && gamePlays[4] == 2 && gamePlays[2] == 2) {
            output.setText("The winner is O!");
            winner = true;
            disableTiles();
        }
    }

    private void checkTie() {
        TextView output = findViewById(R.id.game_state);
        if(gamePlays[0] != 0 && gamePlays[1] != 0 && gamePlays[2] != 0 && gamePlays[3] != 0 && gamePlays[4] != 0
                && gamePlays[5] != 0 && gamePlays[6] != 0 && gamePlays[7] != 0 && gamePlays[8] != 0 && !winner) {
            output.setText("Tie game!");
        }
    }

     /** This method disables all tiles on the board. */
    private void disableTiles() {
        for(int i = 0; i < 9; i++) {
            numbers[i].setEnabled(false);
        }
    }

    /** Exit Button Method, takes the user back one screen.  
     * @param view - view that the input game from
     */
    public void exit(View view) {
	// Make sure that exit button in the activity_game.xml has an onClick of exit.
        finish(); 
    }

    public void resetGame(View view) {
        turnNumber = 0;
        unsetNumbers = new LinkedList<>(Arrays.asList(numbers));
        winner = false;

        for(int a = 0; a < 9; a++) {
            gamePlays[a] = 0;
            numbers[a].setEnabled(true);
            numbers[a].setBackgroundResource(R.drawable.tile);
        }

        Toast.makeText(this, "New Game is Ready!", Toast.LENGTH_SHORT).show();
    }

    /*
    By default player two is the AI in AI mode.
    Easy mode: Choose random open game space.
     */
    private void aiPlay() {
        turnNumber++;
        Collections.shuffle(unsetNumbers);
        unsetNumbers.get(0).setBackgroundResource(R.drawable.o);
        unsetNumbers.get(0).setEnabled(false);
        for (int i = 0; i < 9; i++) {
            if (unsetNumbers.get(0) == numbers[i]) {
                gamePlays[i] = 2;
            }
        }
        unsetNumbers.remove(0);
        output.setText(iconNameOne + "'s turn to play!");
        checkWin();
    }
}