package com.example.randonnumbergame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText enterNumber;
    TextView displayMsg, attemptsLeft, level, limit;
    int noToGuess, noOfAttempts;
    Animation fading;
    Button tryThis;
    String levelChoosen;
    int allowedAttempts;
    int usersGuess;


    public static boolean validateInput(String randomNumber) {
        try {
            Integer.parseInt(randomNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_activity);

        Intent intent = getIntent();
        levelChoosen = intent.getStringExtra("levelChoosn");


        enterNumber = findViewById(R.id.enternumber);
        displayMsg = findViewById(R.id.displayMsg);
        attemptsLeft = findViewById(R.id.attemptsLeft);
        level = findViewById(R.id.level);
        limit = findViewById(R.id.limitTextViev);

        level.setText("Level : " + levelChoosen);

        fading = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_up);
        tryThis = findViewById(R.id.trythisbutton);


        noToGuess = createRandomNumber();
        noOfAttempts = 0;
    }

    private int createRandomNumber() {

        int bound = 0;

        if (levelChoosen.equals("Easy")) {
            bound = 100;
            allowedAttempts = 7;
            attemptsLeft.setText("Attempts left :" + allowedAttempts);
            limit.setText("Guess the number between 1 to " + bound);
        } else if (levelChoosen.equals("Medium")) {
            bound = 500;
            allowedAttempts = 10;
            attemptsLeft.setText("Attempts left :" + allowedAttempts);
            limit.setText("Guess the number between 1 to " + bound);
        } else {
            bound = 1000;
            allowedAttempts = 12;
            attemptsLeft.setText("Attempts left :" + allowedAttempts);
            limit.setText("Guess the number between 1 to " + bound);
        }


        Random rand = new Random();
        int randomNumber = rand.nextInt(bound);

        return randomNumber;
    }

    public void tryThisNumber(View view) {


        if (TextUtils.isEmpty(enterNumber.getText().toString())) {
            enterNumber.setError("Cannot be empty");
            return;
        } else {
            usersGuess = Integer.parseInt(enterNumber.getText().toString().trim());
            attemptsLeft.setText("Attempts left :" + (allowedAttempts - noOfAttempts - 1));
            noOfAttempts++;

        }

        if (usersGuess == noToGuess) {
            displayMsg.setVisibility(View.INVISIBLE);
            displayAlertBox();
        } else if (usersGuess < noToGuess) {
            displayMsg.startAnimation(fading);
            displayMsg.setText("Your guess is smaller");
        } else {
            displayMsg.startAnimation(fading);
            displayMsg.setText("Your guess is bigger");
        }


        if (noOfAttempts == allowedAttempts) {
            AlertDialog.Builder displayMsg = new AlertDialog.Builder(MainActivity.this);

            displayMsg.setTitle("Sorry!! better luck next time");
            displayMsg.setMessage("Correct number was : " + noToGuess + "\nNo of Attempts : " + noOfAttempts).setCancelable(false)
                    .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(MainActivity.this, ChooseLevel.class));
                            finish();

                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            System.exit(0);
                        }
                    });


            AlertDialog alertDialog = displayMsg.create();
            alertDialog.show();

        }
    }


    private void displayAlertBox() {

        AlertDialog.Builder displayMsg = new AlertDialog.Builder(MainActivity.this);

        displayMsg.setTitle("Congratulations!!");
        displayMsg.setMessage("Correct Number : " + noToGuess + "\nNo of Attempts : " + noOfAttempts).setCancelable(false)
                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(MainActivity.this, ChooseLevel.class));
                        finish();

                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                });


        AlertDialog alertDialog = displayMsg.create();
        alertDialog.show();
    }
}