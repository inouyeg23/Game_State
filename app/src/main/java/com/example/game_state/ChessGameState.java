package com.example.game_state;

/**
 * @authors: Jonah Ingler, Garrett Inouye, Logan Machida, Connor Morgan
 *
 *
 */

public class ChessGameState {

    //8x8 array of pieces
    private String[][] board;

    //whose turn it is
    private int playerTurn;

    //variables to see if either player is "checked"
    private boolean isCheckedWhite;
    private boolean isCheckedBlack;

    //point tally for each player
    private int pointsWhite;
    private int pointsBlack;

    //time remaining for each player
    private int secondsWhite;
    private int secondsBlack;

    //is the game paused
    private boolean isPaused;

    //is there a checkmate
    private boolean isCheckedmateWhite;
    private boolean isCheckedmateBlack;

    // new variables
    public boolean gameStarted;
    public boolean drawInitiated;
    public boolean forfeitInitiated;
    public boolean playAgainInitiated;

    public int currPlayer;

    public boolean highlightedPawnMove;
    public boolean highlightedKnightMove;
    public boolean highlightedRookMove;
    public boolean highlightedBishopMove;
    public boolean highlightedKingMove;
    public boolean highlightedQueenMove;

    /**
     * Constructor for class ChessGameState
     */
    public ChessGameState(){
        //initialize an empty board
        board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "  ";
            }
        }
        //starts at 0
        playerTurn = 0;

        //nobody starts checked
        isCheckedBlack = false;
        isCheckedWhite = false;

        //nobody starts with checkmate
        isCheckedmateBlack = false;
        isCheckedmateWhite = false;

        //point tally for each starts at 0
        pointsBlack = 0;
        pointsWhite = 0;

        //time starts at 10 minutes, or 600 seconds
        secondsBlack = 600;
        secondsWhite = 600;

        //game starts paused
        isPaused = true;

        // new variables
        gameStarted = false;
        drawInitiated = false;
        forfeitInitiated = false;
        playAgainInitiated = false;

        currPlayer = 0;

        highlightedPawnMove = false;
        highlightedKnightMove = false;
        highlightedRookMove = false;
        highlightedBishopMove = false;
        highlightedKingMove = false;
        highlightedQueenMove = false;
    }//constructor

    /**
     * Copy Constructor for class ChessGameState
     *
     *  @param original
     * 	    the ChessGameState object to be cloned
     */
      public ChessGameState(ChessGameState original){
          // copy the values from original array
          board = new String[8][8];
          for (int i = 0; i < 8; i++) {
              for (int j = 0; j < 8; j++) {
                  board[i][j] = original.board[i][j];
              }
          }
          // copy player information

          // update which player's turn it is
          playerTurn = original.playerTurn;

          // update whether a player is in check
          isCheckedBlack = original.isCheckedBlack;
          isCheckedWhite = original.isCheckedWhite;

          // update whether a player is in checkmate
          isCheckedmateBlack = original.isCheckedmateBlack;
          isCheckedmateWhite = original.isCheckedmateWhite;

          // update number of points for each player
          pointsBlack = original.pointsBlack;
          pointsWhite = original.pointsWhite;

          // update game clock for each player
          secondsBlack = original.secondsBlack;
          secondsWhite = original.secondsWhite;

          // update whether game is paused
          isPaused = original.isPaused;

          // new variables
          gameStarted = original.gameStarted;
          drawInitiated = original.drawInitiated;
          forfeitInitiated = original.forfeitInitiated;
          playAgainInitiated = original.playAgainInitiated;

          currPlayer = original.currPlayer;

          highlightedPawnMove = original.highlightedPawnMove;
          highlightedKnightMove = original.highlightedKnightMove;
          highlightedRookMove = original.highlightedRookMove;
          highlightedBishopMove = original.highlightedBishopMove;
          highlightedKingMove = original.highlightedKingMove;
          highlightedQueenMove = original.highlightedQueenMove;
      }// copy constructor


    public String getPiece(int row, int col){
        if(board == null|| row < 0 || col < 0) {
            return "Out of Bounds";
        }
        if(row >= board.length || col >= board[row].length){
            return "Out of Bounds";
        }
        return board[row][col];
    }

    public void setPiece(int row, int col, String piece){
        if(board == null|| row < 0 || col < 0) {
            return;
        }
        if(row >= board.length || col >= board[row].length) {
            return;
        }
        board[row][col] = piece;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }
    public void setPlayerTurn(int player){
        playerTurn = player;
    }

    public int getPointsBlack() {
        return pointsBlack;
    }
    public void setPointsBlack(int pointsBlack) {
        this.pointsBlack = pointsBlack;
    }

    public int getPointsWhite() {
        return pointsWhite;
    }
    public void setPointsWhite(int pointsWhite) {
        this.pointsWhite = pointsWhite;
    }

    public int getSecondsBlack() {
        return secondsBlack;
    }
    public void setSecondsBlack(int secondsBlack) {
        this.secondsBlack = secondsBlack;
    }

    public int getSecondsWhite() {
        return secondsWhite;
    }
    public void setSecondsWhite(int secondsWhite) {
        this.secondsWhite = secondsWhite;
    }

    public boolean isCheckedBlack() {
        return isCheckedBlack;
    }
    public void setCheckedBlack(boolean checkedBlack) {
        isCheckedBlack = checkedBlack;
    }

    public boolean isCheckedWhite() {
        return isCheckedWhite;
    }
    public void setCheckedWhite(boolean checkedWhite) {
        isCheckedBlack = checkedWhite;
    }

    public boolean isCheckedmateBlack() {
        return isCheckedmateBlack;
    }
    public void setCheckedmateBlack(boolean checkedmateBlack) {
        isCheckedmateBlack = checkedmateBlack;
    }

    public boolean isCheckedmateWhite() {
        return isCheckedmateWhite;
    }
    public void setCheckedmateWhite(boolean checkedmateWhite) {
        isCheckedmateWhite = checkedmateWhite;
    }

    public boolean isPaused() {
        return isPaused;
    }
    public void setPaused(boolean paused) {
        isPaused = paused;
    }
}//class ChessGameState
