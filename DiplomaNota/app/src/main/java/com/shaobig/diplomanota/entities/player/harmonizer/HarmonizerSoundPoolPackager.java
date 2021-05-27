package com.shaobig.diplomanota.entities.player.harmonizer;

import android.content.Context;
import android.media.SoundPool;

import com.shaobig.diplomanota.entities.chord.Chord;
import com.shaobig.diplomanota.entities.enums.Degree;
import com.shaobig.diplomanota.entities.player.SoundPoolPackager;

import java.util.ArrayList;
import java.util.List;

public class HarmonizerSoundPoolPackager implements SoundPoolPackager<SoundPoolChord> {

    private static final int DEFAULT_SOUND_PRIORITY = 1;
    private static final String DEFAULT_RESOURCE_TYPE = "raw";

    private Context context;
    private SoundPool soundPool;

    private List<Chord> chords;

    public HarmonizerSoundPoolPackager(Context context, SoundPool soundPool, List<Chord> chords) {
        this.context = context;
        this.soundPool = soundPool;

        this.chords = chords;
    }

    @Override
    public List<SoundPoolChord> loadSounds() {
        List<SoundPoolChord> poolChords = new ArrayList<>();
        List<Integer> sounds;

        String name;
        int resId;
        int soundId;

        Chord chord;
        Degree degree;

        for (int i = 0; i < getChords().size(); i++) {
            chord = getChords().get(i);
            sounds = new ArrayList<>();

            for (int j = 0; j < chord.getNotes().size(); j++) {
                name = chord.getNotes().get(j).getNoteLetter().toString().toLowerCase()
                        .concat(String.valueOf(chord.getNotes().get(j).getOctave()));
                resId = getContext().getResources().getIdentifier(name, DEFAULT_RESOURCE_TYPE, getContext().getPackageName());

                try {
                    soundId = getSoundPool().load(getContext(), resId, DEFAULT_SOUND_PRIORITY);
                    sounds.add(soundId);
                }
                catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }

            degree = Degree.values()[i];
            poolChords.add(new SoundPoolChord(sounds, degree));
        }

        return poolChords;
    }

    public Context getContext() {
        return context;
    }

    public SoundPool getSoundPool() {
        return soundPool;
    }

    public List<Chord> getChords() {
        return chords;
    }

    public void setChords(List<Chord> chords) {
        this.chords = chords;
    }
}
