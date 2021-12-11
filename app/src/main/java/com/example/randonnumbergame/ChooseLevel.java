package com.example.randonnumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseLevel extends AppCompatActivity {

    String levelChoosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);


    }

    public void Easy(View view) {
        levelChoosen = "Easy";
        Intent intent = new Intent(ChooseLevel.this,MainActivity.class);
        intent.putExtra("levelChoosn", levelChoosen);
        startActivity(intent);
        finish();
    }

    public void Medium(View view) {
        levelChoosen = "Medium";
        Intent intent = new Intent(ChooseLevel.this,MainActivity.class);
        intent.putExtra("levelChoosn", levelChoosen);
        startActivity(intent);
        finish();
    }

    public void Hard(View view) {
        levelChoosen = "Hard";
        Intent intent = new Intent(ChooseLevel.this,MainActivity.class);
        intent.putExtra("levelChoosn", levelChoosen);
        startActivity(intent);
        finish();
    }

}