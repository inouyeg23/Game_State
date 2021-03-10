package com.example.game_state;

/**
 * @authors: Jonah Ingler,
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

    public boolean gameStarted;
    public boolean drawInitiated;
    public boolean forfeitInitiated;
    public boolean playagainInitiated;

    public int currPlayer;

    public int selectedPiece;

    public boolean movedPawn;
    public boolean movedKnight;
    public boolean movedRook;
    public boolean movedBishop;
    public boolean movedKing;
    public boolean movedQueen;

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
        //starts at 0
        //  0 for black, 1 for white
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

    }//constructor

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


    /**
     * toString method
     * prints the values for all the variables
     * defined in this class
     */

    @Override
    public String toString(){
        return "Player turn: " + playerTurn + "\n" +
                "Black points: " + pointsBlack + "\n" +
                "White points: " + pointsWhite + "\n" +
                "Black seconds: " + secondsBlack + "\n" +
                "White seconds: " + secondsWhite + "\n" +
                "Black checked: " + isCheckedBlack + "\n" +
                "White checked: " + isCheckedWhite + "\n" +
                "Black checkmated: " + isCheckedmateBlack + "\n" +
                "White checkmated: " + isCheckedmateWhite + "\n" +
                "Game paused: " + isPaused + "\n";
    }

    /**
     * all methods for each of the actions defined in
     * the actions.txt text file. Each method returns a
     * boolean and verifies whether the move is legal and
     * modifies the gamestate to reflect the taken action
     */
    public boolean gameStart(){
        gameStarted = true;
        return true;
    }

    public boolean gamePaused(){
        if(isPaused){
            return true;
        } else {
            return false;
        }
    }

    public boolean movePiece(){
        if(currPlayer == playerTurn){
            //determines the piece and reflects the given player action
            switch (selectedPiece){
                case 0:
                    movedPawn = true;
                    break;
                case 1:
                    movedKnight = true;
                    break;
                case 2:
                    movedRook = true;
                    break;
                case 3:
                    movedBishop = true;
                    break;
                case 4:
                    movedKing = true;
                    break;
                case 5:
                    movedQueen = true;
                    break;
            }
            //moves on the next player
            switch (playerTurn) {
                case 0:
                    playerTurn = 1;
                    break;
                case 1:
                    playerTurn = 0;
                    break;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean drawOffered(){
        if(drawInitiated){
            return true;
        } else {
            return false;
        }

    }

    public boolean forfeitGame(){
        if(forfeitInitiated){
            return true;
        } else {
            return false;
        }
    }

    public boolean playAgain(){
        if(playagainInitiated){
            return true;
        } else {
            return false;
        }
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
