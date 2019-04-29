package com.example.tictactoe.gamedir;

public abstract class HumanPlayer extends Player {

    public void move() {
        humanMove();
    }

    public abstract void humanMove();
}
