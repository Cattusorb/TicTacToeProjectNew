package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);


    }

    public void buttonEasyClick(View view) {
        Intent intent = new Intent(this, com.example.tictactoe.GameActivity.class);
        startActivity(intent);
    }

    public void buttonMediumClick(View view) {
        Intent intent = new Intent(this, com.example.tictactoe.GameActivity.class);
        startActivity(intent);
    }

    public void buttonHardClick(View view) {
        Intent intent = new Intent(this, com.example.tictactoe.GameActivity.class);
        startActivity(intent);
    }

}
