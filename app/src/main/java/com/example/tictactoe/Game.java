package com.example.tictactoe;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    private Button exit;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

         turnNumber = 0;
         winner = false;

        exit = findViewById(R.id.exit);

        numbers[0] = findViewById(R.id.one);
        numbers[1] = findViewById(R.id.two);
        numbers[2] = findViewById(R.id.three);
        numbers[3] = findViewById(R.id.four);
        numbers[4] = findViewById(R.id.five);
        numbers[5] = findViewById(R.id.six);
        numbers[6] = findViewById(R.id.seven);
        numbers[7] = findViewById(R.id.eight);
        numbers[8] = findViewById(R.id.nine);

    }

    public void buttonClick(View view) {

        if(view == exit) {
            finish();
        }

        TextView output = findViewById(R.id.game_state);

        turnNumber++;

        // Player one's turn
        if (turnNumber == 1 || turnNumber == 3 || turnNumber == 5 || turnNumber == 7 || turnNumber == 9) {
            view.setBackgroundResource(R.drawable.cat);

            for(int i = 0; i < 9; i++) {
                if (view == numbers[i]) {
                    gamePlays[i] = 1;
                }
            }

            view.setEnabled(false);
            output.setText("O's turn to play!");
            checkWin();
        }

        // Player two's turn
        if (turnNumber == 2 || turnNumber == 4 || turnNumber == 6 || turnNumber == 8) {
            view.setBackgroundResource(R.drawable.dog);

            for(int i = 0; i < 9; i++) {
                if (view == numbers[i]) {
                    gamePlays[i] = 2;
                }
            }
            view.setEnabled(false);
            output.setText("X's turn to play!");
            checkWin();
        }
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
        }
        if(gamePlays[0] == 1 && gamePlays[3] == 1 && gamePlays[6] == 1) {
            output.setText("The winner is X!");
            winner = true;
        }
        if(gamePlays[2] == 1 && gamePlays[5] == 1 && gamePlays[8] == 1) {
            output.setText("The winner is X!");
            winner = true;
        }
        if(gamePlays[6] == 1 && gamePlays[7] == 1 && gamePlays[8] == 1) {
            output.setText("The winner is X!");
            winner = true;
        }
        if(gamePlays[3] == 1 && gamePlays[4] == 1 && gamePlays[5] == 1) {
            output.setText("The winner is X!");
            winner = true;
        }
        if(gamePlays[1] == 1 && gamePlays[4] == 1 && gamePlays[7] == 1) {
            output.setText("The winner is X!");
            winner = true;
        }
        if(gamePlays[0] == 1 && gamePlays[4] == 1 && gamePlays[8] == 1) {
            output.setText("The winner is X!");
            winner = true;
        }
        if(gamePlays[6] == 1 && gamePlays[4] == 1 && gamePlays[2] == 1) {
            output.setText("The winner is X!");
            winner = true;
        }
    }

    private void checkWinPlayerTwo() {
        TextView output = findViewById(R.id.game_state);
        if (gamePlays[0] == 2 &&  gamePlays[1] == 2 && gamePlays[2] == 2) {
            output.setText("The winner is 0!");
            winner = true;
        }
        if(gamePlays[0] == 2 && gamePlays[3] == 2 && gamePlays[6] == 2) {
            output.setText("The winner is O!");
            winner = true;
        }
        if(gamePlays[2] == 2 && gamePlays[5] == 2 && gamePlays[8] == 2) {
            output.setText("The winner is O!");
            winner = true;
        }
        if(gamePlays[6] == 2 && gamePlays[7] == 2 && gamePlays[8] == 2) {
            output.setText("The winner is O!");
            winner = true;
        }
        if(gamePlays[3] == 2 && gamePlays[4] == 2 && gamePlays[5] == 2) {
            output.setText("The winner is O!");
            winner = true;
        }
        if(gamePlays[1] == 2 && gamePlays[4] == 2 && gamePlays[7] == 2) {
            output.setText("The winner is O!");
            winner = true;
        }
        if(gamePlays[0] == 2 && gamePlays[4] == 2 && gamePlays[8] == 2) {
            output.setText("The winner is O!");
            winner = true;
        }
        if(gamePlays[6] == 2 && gamePlays[4] == 2 && gamePlays[2] == 2) {
            output.setText("The winner is O!");
            winner = true;
        }
    }

    private void checkTie() {
        TextView output = findViewById(R.id.game_state);
        if(gamePlays[0] != 0 && gamePlays[1] != 0 && gamePlays[2] != 0 && gamePlays[3] != 0 && gamePlays[4] != 0
                && gamePlays[5] != 0 && gamePlays[6] != 0 && gamePlays[7] != 0 && gamePlays[8] != 0 && !winner) {
            output.setText("Tie game!");
        }
    }
}
