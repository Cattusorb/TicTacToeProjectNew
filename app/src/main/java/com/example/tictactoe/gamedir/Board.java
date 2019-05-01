package com.example.tictactoe.gamedir;

public class Board {
    /** List of Integers from 1 - 9 */ 
    private List<Integer> places;
    /** Moves that players have made
        0 means no one has taken the space
        1 means player one has taken the space
        2 means player two has taken the space*/ 
    private int[] playerMoves; 
    
    public Board() { 
        places = new ArrayList()<>; 
        for(int i = 0; i < 9; i++) { 
            places.add(i + 1);  
        }
    } 
    
    public int[] getPlaces() { 
        return places; 
    } 
    
    public int[] getMoves() { 
        return playerMoves;
    } 
    
    /** 
    * Places a move on the board
    * @param i - place the player will move
    * @param playerNum - the player who is playing the move
    */ 
    public void playMove(int i, int playerNum) { 
        if (playerNum == 1) { 
            if (playerMoves[i] == 0) { 
                 playermoves[i] = 1; 
                 places.remove(i); 
            } else { 
                System.out.print"Someone already moved here, cannot play here"); 
            }
        } 
        if (playerNum == 2) { 
            if (playerMoves[i] == 0) { 
                 playermoves[i] = 2; 
            } else { 
                System.out.print"Someone already moved here, cannot play here, try another space!"); 
            }
        } 
    }
    
    // Put checkWin() in here
        
}
