package com.example.tictactoe;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    /** Set based on mode */
    private Player playerOne;
    /** drawable for player one icon*/
    private Drawable idOne;
    private String iconNameOne;

    /** Set based on mode */
    private Player playerTwo;
    /** drawable for player two icon*/
    private Drawable idTwo;
    private String iconNameTwo;

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

        setPlayers(mode);
    }

    private void setPlayers(String mode) {

        playerOne = new HumanPlayer();

        if (mode.equals("pvp")) {
             playerTwo = new HumanPlayer();
         }
         if (mode.equals("pvceasy")) {
             playerTwo = new EasyPlayer();
         }
        if (mode.equals("pvcmed")) {
            playerTwo = new MediumPlayer();
        }
        if (mode.equals("pvchard")) {
            playerTwo = new HardPlayer();
        }
    }

    public void buttonClick(View view) {
        turnNumber++;

        // X goes first

        // Player one's turn
        if ((turnNumber % 2) == 1) {
            playerOne.move(idOne, view, getSpacesAvailable(), getGamePlays(), getNumbers());
            unsetNumbers.remove(view);
            for (int i = 0; i < 9; i++) {
                if (view == numbers[i]) {
                    gamePlays[i] = 1;
                    unsetNumbers.remove(view);
                }
            }
            output.setText(iconNameOne + "'s turn to play!");
            checkWin();
        }
        // Player two's turn
        if (((turnNumber % 2) == 0)) {
            playerTwo.move(idTwo, view, getSpacesAvailable(), getGamePlays(), getNumbers());
            for (int i = 0; i < 9; i++) {
                if (view == numbers[i]) {
                    gamePlays[i] = 2;
                    unsetNumbers.remove(view);
                }
            }
            output.setText(iconNameTwo + "'s turn to play!");
            checkWin();
        }
    }

    public List<View> getSpacesAvailable() {
        return unsetNumbers;
    }

    public View[] getNumbers() {
        return numbers;
    }

    public int[] getGamePlays() {
        return gamePlays;
    }

    public void exitButton(View view) {
        finish();
    }

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

    /**
     * Disables all tiles after there is a winner.
     * Then runs the playAgain() method
     */
    private void disableTiles() {
        for(int i = 0; i < 9; i++) {
            numbers[i].setEnabled(false);
        }

        playAgain();
    }

    /**
     * Method to ask the user if they want to play again,
     * should bring up a button that asks if you want to play again
     */
    public void playAgain() {

    }
}
