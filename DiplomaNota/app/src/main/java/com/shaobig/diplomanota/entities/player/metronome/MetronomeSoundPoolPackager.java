package com.shaobig.diplomanota.entities.player.metronome;

import android.content.Context;
import android.media.SoundPool;

import com.shaobig.diplomanota.R;
import com.shaobig.diplomanota.entities.enums.BeatAccent;
import com.shaobig.diplomanota.entities.player.SoundPoolPackager;

import java.util.ArrayList;
import java.util.List;

public class MetronomeSoundPoolPackager implements SoundPoolPackager<SoundPoolAccent> {

    private static final int DEFAULT_SOUND_PRIORITY = 1;

    private Context context;
    private SoundPool soundPool;

    public MetronomeSoundPoolPackager(Context context, SoundPool soundPool) {
        this.context = context;
        this.soundPool = soundPool;
    }

    @Override
    public List<SoundPoolAccent> loadSounds() {
        List<SoundPoolAccent> sounds = new ArrayList<>();

        int id;
        BeatAccent accent;

        id = getSoundPool().load(getContext(), R.raw.beat_accent, DEFAULT_SOUND_PRIORITY);
        accent = BeatAccent.STRESSED;
        sounds.add(new SoundPoolAccent(id, accent));

        id = getSoundPool().load(getContext(), R.raw.beat_normal, DEFAULT_SOUND_PRIORITY);
        accent = BeatAccent.UNSTRESSED;
        sounds.add(new SoundPoolAccent(id, accent));

        return sounds;
    }

    public Context getContext() {
        return context;
    }

    public SoundPool getSoundPool() {
        return soundPool;
    }
}
