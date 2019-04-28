package com.example.tictactoe;

import android.graphics.drawable.Drawable;
import android.view.View;

import java.util.List;

public abstract class Player {

    /**
     * Places a tile in the space in which the player chooses
     * @param id - drawable id to place (icon of player)
     * @param view - what view to change
     */
    public abstract void move(Drawable id, View view, List<View> spacesLeft, int[] gamePlays, View[] tiles);
}
