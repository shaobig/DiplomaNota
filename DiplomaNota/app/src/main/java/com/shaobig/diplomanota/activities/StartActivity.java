package com.shaobig.diplomanota.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;

import com.shaobig.diplomanota.R;
import com.shaobig.diplomanota.entities.enums.BeatDuration;
import com.shaobig.diplomanota.entities.enums.Mode;
import com.shaobig.diplomanota.entities.enums.NoteLetter;
import com.shaobig.diplomanota.entities.player.MusicPlayer;
import com.shaobig.diplomanota.entities.player.MusicSettings;
import com.shaobig.diplomanota.entities.rhythm.Rhythm;
import com.shaobig.diplomanota.entities.rhythm.Rhythms;
import com.shaobig.diplomanota.entities.scale.Scale;
import com.shaobig.diplomanota.entities.scale.Scales;
import com.shaobig.diplomanota.entities.tempo.Tempo;

public class StartActivity extends AppCompatActivity {

    private Spinner tonicSpinner;
    private Spinner modeSpinner;
    private Spinner octaveSpinner;

    private Spinner beatCountSpinner;
    private Spinner beatDurationSpinner;

    private NumberPicker tempoPicker;

    private Button startMusicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        tonicSpinner = findViewById(R.id.tonic_spinner);
        modeSpinner = findViewById(R.id.mode_spinner);
        octaveSpinner = findViewById(R.id.octave_number_spinner);

        beatCountSpinner = findViewById(R.id.beat_count_spinner);
        beatDurationSpinner = findViewById(R.id.beat_duration_spinner);

        tempoPicker = findViewById(R.id.tempo_picker);

        startMusicButton = findViewById(R.id.start_music_button);
        startMusicButton.setOnClickListener(view -> {
            Scale scale = getScale();
            Rhythm rhythm = getRhythm();
            Tempo tempo = getTempo();

            MusicSettings settings = new MusicSettings(scale, rhythm, tempo);

            Intent goToMusicActivityIntent = new Intent(this, MusicActivity.class);
            goToMusicActivityIntent.putExtra("settings", settings);

            startActivity(goToMusicActivityIntent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        setSpinner(tonicSpinner, NoteLetter.values());
        setSpinner(modeSpinner, Mode.values());
        setSpinner(octaveSpinner, new Integer[] {1, 2, 3, 4, 5});
        setSpinner(beatCountSpinner, new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32});
        setSpinner(beatDurationSpinner, BeatDuration.values());

        setTempoPicker(tempoPicker);

        octaveSpinner.setSelection(2);
        beatCountSpinner.setSelection(3);
        beatDurationSpinner.setSelection(2);
    }

    private void setSpinner(Spinner spinner, Object[] info) {
        ArrayAdapter<Object> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, info);
        spinner.setAdapter(adapter);
    }

    private void setTempoPicker(NumberPicker picker) {
        picker.setMinValue(MusicPlayer.MIN_TEMPO);
        picker.setMaxValue(MusicPlayer.MAX_TEMPO);

        picker.setValue(MusicPlayer.DEFAULT_TEMPO);
    }

    private Scale getScale() {
        NoteLetter tonic = (NoteLetter) tonicSpinner.getSelectedItem();
        Mode mode = (Mode) modeSpinner.getSelectedItem();
        int octave = (Integer) octaveSpinner.getSelectedItem();

        return Scales.getScale(tonic, mode, octave);
    }

    private Rhythm getRhythm() {
        int count = (Integer) beatCountSpinner.getSelectedItem();
        BeatDuration duration = (BeatDuration) beatDurationSpinner.getSelectedItem();

        return Rhythms.getRhythm(count, duration);
    }

    private Tempo getTempo() {
        int value = tempoPicker.getValue();
        return new Tempo(value);
    }
}