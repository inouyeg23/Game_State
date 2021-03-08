package com.example.game_state;

public class ChessGameState {

    //8x8 array of pieces
    private String[][] board;

    //whose turn it is, player 1(white) or 2(black)
    int playerToMove;

    //variables to see if either player is "checked"
    boolean isCheckedWhite;
    boolean isCheckedBlack;

    //point tally for each player
    int pointsWhite;
    int pointsBlack;

    //time remaining for each player
    int secondsWhite;
    int secondsBlack;

    /**
     * Contructor for class ChessGameState
     */
    public ChessGameState(){

        //initialize an empty board
        board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "  ";
            }
        }


    }
}
