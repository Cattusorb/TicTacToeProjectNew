package com.example.tictactoe.tictactoe;

public abstract class HumanPlayer extends Player {

    public void move() {
        humanMove();
    }

    public abstract void humanMove();
}
