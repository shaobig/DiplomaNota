package com.shaobig.diplomanota.activities;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shaobig.diplomanota.R;
import com.shaobig.diplomanota.entities.player.MusicPlayer;
import com.shaobig.diplomanota.entities.player.MusicSettings;

public class MusicActivity extends AppCompatActivity {

    private static final int START_DELAY = 3000;

    private MusicPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "Идёт загрузка аудиокомпонентов... Подождите пожалуйста.", Toast.LENGTH_SHORT)
                .show();

        if (getIntent().getExtras() != null) {
            MusicSettings settings = (MusicSettings) getIntent().getExtras().getSerializable("settings");

            if (settings != null) {
                this.player = new MusicPlayer(this, settings);
            }
            else {
                throw new NullPointerException("The settings of the music player haven't been initialized!");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(() -> {
            do {
                if (player.isActive()) {
                    player.play();
                }
                try {
                    Thread.sleep(START_DELAY);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (!player.isActive());
        }, START_DELAY);
    }
}