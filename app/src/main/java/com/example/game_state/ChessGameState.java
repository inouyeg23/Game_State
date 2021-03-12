package com.example.game_state;

/**
 * @authors: Jonah Ingler,
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

    //booleans to work with onClick method and check if valid
    public boolean gameStarted;
    public boolean drawInitiated;
    public boolean forfeitInitiated;
    public boolean playAgainInitiated;

    //different from playerTurn, it holds the current player rather than
    //the whole game switching between players to make sure it is
    //that players turn
    public int currPlayer;

    //variables that may hold a pool of valid moves, may change to methods later
    public boolean highlightedPawnMove;
    public boolean highlightedKnightMove;
    public boolean highlightedRookMove;
    public boolean highlightedBishopMove;
    public boolean highlightedKingMove;
    public boolean highlightedQueenMove;
    

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
        //this will be implemented using game framework; not required for game
        //state assignment
        return false;
    }

    public boolean isLegal(int row, int col){
        //checking if the current player is in check
        //0 for black, 1 for white
        if((currPlayer == 0 && !isCheckedBlack) || (currPlayer == 1 && !isCheckedWhite)){
            //checking if space is empty
            if(board[row][col] == " "){
                //space is empty
                return true;
            } else {
                //space occupied by another place
                return false;
            }
        } else {
            //a player was in check so couldn't move
            return false;
        }

    }


    /**
     * selectedMove refers to something to be implemented later
     * it will return a value based on what the user selected
     * to move the piece in that spot.
     *
     * highlighted_____Move is currently a boolean but may change to
     * boolean method to list out possible moves for that specific piece
     */
    public boolean movePiece(int row, int col, int selectRow, int selectCol, String selectedPiece){
        selectedPiece = getPiece(row, col);
        if(currPlayer == playerTurn){
            //determines the piece and reflects the given player action
            switch (selectedPiece){
                case "pawn":
                    if(highlightedPawnMove) {
                        if (isLegal(selectRow, selectCol)) {
                            setPiece(selectRow, selectCol, selectedPiece);
                        }
                    }
                    break;
                case "knight":
                    if(highlightedKnightMove) {
                        if (isLegal(selectRow, selectCol)) {
                            setPiece(selectRow, selectCol, selectedPiece);
                        }
                    }
                    break;
                case "rook":
                    if(highlightedRookMove) {
                        if (isLegal(selectRow, selectCol)) {
                            setPiece(selectRow, selectCol, selectedPiece);
                        }
                    }
                    break;
                case "bishop":
                    if(highlightedBishopMove) {
                        if (isLegal(selectRow, selectCol)) {
                            setPiece(selectRow, selectCol, selectedPiece);
                        }
                    }
                    break;
                case "king":
                    if(highlightedKingMove) {
                        if(board[row][col] == " ") {
                            //space is empty
                            setPiece(selectRow, selectCol, selectedPiece);
                        }
                    }
                    break;
                case "queen":
                    if(highlightedQueenMove) {
                        if (isLegal(selectRow, selectCol)) {
                            setPiece(selectRow, selectCol, selectedPiece);
                        }
                    }
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
        //drawInitiated would turn true or false based on button onClick
        if(drawInitiated){
            //this will be implemented using game framework; not required for game
            //state assignment
            return true;
        } else {
            return false;
        }

    }

    //forfeitInitiated would turn true or false based on button onClick
    public boolean forfeitGame(){
        if(forfeitInitiated){
            //this will be implemented using game framework; not required for game
            //state assignment
            return true;
        } else {
            return false;
        }
    }

    //playAgainInitiated would turn true or false based on button onClick
    public boolean playAgain(){
        if(playAgainInitiated){
            //this will be implemented using game framework; not required for game
            //state assignment
            return true;
        } else {
            return false;
        }
    }


    //getter and setter for player turn
    public int getPlayerTurn() {
        return playerTurn;
    }
    public void setPlayerTurn(int player){
        playerTurn = player;
    }

    //getter and setter for points
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

    //getter and setter for time
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

    //set boolean checked condition, and get checked condition
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

    //set boolean checkmated condition, and get checkmated condition
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

    //set paused boolean and check paused boolean
    public boolean isPaused() {
        return isPaused;
    }
    public void setPaused(boolean paused) {
        isPaused = paused;
    }
//GameState class
}
