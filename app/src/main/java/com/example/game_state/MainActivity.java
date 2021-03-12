package com.example.game_state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button runTestButton = (Button) findViewById((R.id.runtest));
        EditText multiLineText = (EditText) findViewById(R.id.editTextTextMultiLine);
        runTestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multiLineText.clearComposingText();

                ChessGameState firstInstance = new ChessGameState();
                ChessGameState secondInstance = new ChessGameState(firstInstance);

                String text = "";

                firstInstance.gameStart();
                text += "Started Game";
                multiLineText.setText(text);

                firstInstance.setPaused(true);
                text += "\nPaused Game";
                multiLineText.setText(text);

                firstInstance.setPiece(1,0,"pawn");
                text += "\nPlaced a pawn at 1,0";
                multiLineText.setText(text);

                firstInstance.movePiece(1,0,3,0,"pawn");
                text += "\nmoved pawn from 1,0 to 3,0";
                multiLineText.setText(text);

                text += "\nChecked what piece was at 3,0" + firstInstance.getPiece(0,0);
                multiLineText.setText(text);

                firstInstance.drawOffered();
                text += "\nDraw offered";
                multiLineText.setText(text);

                firstInstance.forfeitGame();
                text += "\nForfieted";
                multiLineText.setText(text);

                firstInstance.playAgain();
                text += "\nCalled the play again method";
                multiLineText.setText(text);

                ChessGameState thirdInstance = new ChessGameState();
                ChessGameState fourthInstance = new ChessGameState(thirdInstance);

                text += "\n" + secondInstance.toString();
                multiLineText.setText(text);

                text += "\n" + fourthInstance.toString();
                multiLineText.setText(text);

            }
        });

    }

}
