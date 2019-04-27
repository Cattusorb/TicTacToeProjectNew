package com.example.tictactoe;

public abstract class Player {

    /**
     * Places a tile in the space in which the player chooses
     * @param id - drawable id to place (icon of player)
     * @param tile - tile space/ number to play tile
     */
    public abstract void move(int id, int tile);
}
