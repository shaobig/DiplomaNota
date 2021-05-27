package com.shaobig.diplomanota.entities.player;

import android.content.Context;
import android.media.SoundPool;

import com.shaobig.diplomanota.entities.factories.SoundPoolFactory;
import com.shaobig.diplomanota.entities.player.harmonizer.Harmonizer;
import com.shaobig.diplomanota.entities.player.melody.MelodyDeployer;
import com.shaobig.diplomanota.entities.player.metronome.Metronome;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MusicPlayer implements MusicReproducer {

    public static final int MIN_TEMPO = 30;
    public static final int DEFAULT_TEMPO = 120;
    public static final int MAX_TEMPO = 360;

    private static final int MUSIC_COMPONENT_COUNT = 3;

    private SoundPool soundPool;

    private Metronome metronome;
    private Harmonizer harmonizer;
    private MelodyDeployer melodyDeployer;

    private boolean isActive;

    public MusicPlayer(Context context, MusicSettings settings) {
        this.soundPool = initSoundPool();

        this.metronome = new Metronome(context, getSoundPool(), settings);
        this.harmonizer = new Harmonizer(context, getSoundPool(), settings);
        this.melodyDeployer = new MelodyDeployer(context, getSoundPool(), settings);

        this.isActive = false;
    }

    private SoundPool initSoundPool() {
        SoundPool soundPool = SoundPoolFactory.getSoundPool();
        soundPool.setOnLoadCompleteListener((soundPool1, i, i1) -> setActive());

        return soundPool;
    }

    @Override
    public void play() {
        ExecutorService executor = Executors.newFixedThreadPool(MUSIC_COMPONENT_COUNT);

        executor.execute(() -> getMetronome().play());
        executor.execute(() -> getHarmonizer().play());
        executor.execute(() -> getMelodyDeployer().play());
    }

    public SoundPool getSoundPool() {
        return soundPool;
    }

    public Metronome getMetronome() {
        return metronome;
    }

    public Harmonizer getHarmonizer() {
        return harmonizer;
    }

    public MelodyDeployer getMelodyDeployer() { return melodyDeployer; }

    public boolean isActive() {
        return isActive;
    }

    private void setActive() {
        this.isActive = true;
    }
}
