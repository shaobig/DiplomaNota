package com.shaobig.diplomanota.entities.player.metronome;

import android.content.Context;
import android.media.SoundPool;

import com.shaobig.diplomanota.entities.enums.BeatAccent;
import com.shaobig.diplomanota.entities.enums.BeatDuration;
import com.shaobig.diplomanota.entities.player.MusicReproducer;
import com.shaobig.diplomanota.entities.player.MusicSettings;
import com.shaobig.diplomanota.entities.player.SoundPoolResourceDownloader;
import com.shaobig.diplomanota.entities.rhythm.Rhythm;
import com.shaobig.diplomanota.entities.tempo.Tempo;

import java.util.List;

public class Metronome implements SoundPoolResourceDownloader, MusicReproducer {

    public static final int ONE_MINUTE_IN_MILLISECONDS = 60000;

    private static final float DEFAULT_VOLUME = 0.1f;
    private static final int DEFAULT_PRIORITY = 1;
    private static final int DEFAULT_LOOP = 0;
    private static final int DEFAULT_RATE = 1;

    private SoundPool soundPool;

    private Rhythm rhythm;
    private Tempo tempo;

    private List<SoundPoolAccent> soundPoolAccents;

    public Metronome(Context context, SoundPool soundPool, MusicSettings settings) {
        this.soundPool = soundPool;

        this.rhythm = settings.getRhythm();
        this.tempo = settings.getTempo();

        downloadSounds(context, soundPool);
    }

    @Override
    public void downloadSounds(Context context, SoundPool soundPool) {
        if (context != null && soundPool != null) {
            MetronomeSoundPoolPackager packager = new MetronomeSoundPoolPackager(context, soundPool);
            List<SoundPoolAccent> soundPoolAccents = packager.loadSounds();

            setSoundPoolAccents(soundPoolAccents);
        }
        else {
            String message = "Either context or the SoundPool object haven't been initialized";
            throw new NullPointerException(message);
        }
    }

    @Override
    public void play() {
        int frequency = Metronome.ONE_MINUTE_IN_MILLISECONDS / getTempo().getValue();
        double duration = (double) BeatDuration.QUARTER.getDuration() / getRhythm().getBeatDuration().getDuration();
        long speed = Math.round(frequency * duration);

        List<SoundPoolAccent> sounds = getSoundPoolAccents();

        SoundPoolAccent stressedSound = sounds.stream()
                .filter(f -> f.getBeatAccent().equals(BeatAccent.STRESSED))
                .findFirst()
                .get();
        SoundPoolAccent unstressedSound = sounds.stream()
                .filter(f -> f.getBeatAccent().equals(BeatAccent.UNSTRESSED))
                .findFirst()
                .get();

        while (true) {
            try {
                getSoundPool().play(stressedSound.getSoundId(), DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, DEFAULT_LOOP, DEFAULT_RATE);
                Thread.sleep(speed);
                for (int i = 0; i < getRhythm().getBeatCount() - 1; i++) {
                    getSoundPool().play(unstressedSound.getSoundId(), DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, DEFAULT_LOOP, DEFAULT_RATE);
                    Thread.sleep(speed);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public SoundPool getSoundPool() {
        return soundPool;
    }

    public Rhythm getRhythm() {
        return rhythm;
    }

    public Tempo getTempo() {
        return tempo;
    }

    public List<SoundPoolAccent> getSoundPoolAccents() {
        return soundPoolAccents;
    }

    public void setSoundPoolAccents(List<SoundPoolAccent> soundPoolAccents) {
        if (soundPoolAccents != null && !soundPoolAccents.isEmpty()) {
            this.soundPoolAccents = soundPoolAccents;
        }
        else {
            String message = "The input argument doesn't satisfy the necessary conditions: list either empty or has no a reference";
            throw new IllegalArgumentException(message);
        }
    }
}
