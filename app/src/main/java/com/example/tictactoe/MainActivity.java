package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playPVPMode;
    private Button playPVCMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);


        playPVPMode = findViewById(R.id.pvp_mode);
        playPVCMode = findViewById(R.id.pvc_mode);


        playPVPMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playPVP();
            }
        });

        playPVCMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playPVC();
            }
        });
    }

    private void playPVP() {

        Intent intent = new Intent(this, com.example.tictactoe.GameActivity.class);
        startActivity(intent);
    }

    private void playPVC() {

        Intent intent = new Intent(this, com.example.tictactoe.ModeActivity.class);
        startActivity(intent);
    }



}
