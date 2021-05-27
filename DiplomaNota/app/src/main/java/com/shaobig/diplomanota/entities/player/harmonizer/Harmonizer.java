package com.shaobig.diplomanota.entities.player.harmonizer;

import android.content.Context;
import android.media.SoundPool;

import com.shaobig.diplomanota.entities.chord.Chord;
import com.shaobig.diplomanota.entities.enums.BeatDuration;
import com.shaobig.diplomanota.entities.enums.Degree;
import com.shaobig.diplomanota.entities.player.MusicReproducer;
import com.shaobig.diplomanota.entities.player.MusicSettings;
import com.shaobig.diplomanota.entities.player.SoundPoolResourceDownloader;
import com.shaobig.diplomanota.entities.analyzer.DegreeAnalyzer;
import com.shaobig.diplomanota.entities.analyzer.ChordDegreeAnalyzer;
import com.shaobig.diplomanota.entities.player.metronome.Metronome;
import com.shaobig.diplomanota.entities.scale.Scale;
import com.shaobig.diplomanota.entities.scale.Scales;

import java.util.List;

public class Harmonizer implements SoundPoolResourceDownloader, MusicReproducer {

    private static final float DEFAULT_VOLUME = 0.5f;
    private static final int DEFAULT_PRIORITY = 1;
    private static final int DEFAULT_LOOP = 0;
    private static final int DEFAULT_RATE = 1;

    private SoundPool soundPool;

    private MusicSettings settings;

    private List<SoundPoolChord> soundPoolChords;

    public Harmonizer(Context context, SoundPool soundPool, MusicSettings settings) {
        this.soundPool = soundPool;
        this.settings = settings;

        downloadSounds(context, soundPool);
    }

    @Override
    public void downloadSounds(Context context, SoundPool soundPool) {
        Scale scale = getSettings().getScale();
        List<Chord> chords = Scales.getChordScale(scale);
        HarmonizerSoundPoolPackager packager = new HarmonizerSoundPoolPackager(context, soundPool, chords);

        setSoundPoolChords(packager.loadSounds());
    }

    @Override
    public void play() {
        int frequency = Metronome.ONE_MINUTE_IN_MILLISECONDS / getSettings().getTempo().getValue();
        double duration = (double) BeatDuration.QUARTER.getDuration() / getSettings().getRhythm().getBeatDuration().getDuration();
        long speed = Math.round(frequency * duration) * getSettings().getRhythm().getBeatCount();

        SoundPoolChord chord = getSoundPoolChord(Degree.FIRST);
        DegreeAnalyzer analyzer = new ChordDegreeAnalyzer();

        try {
            Integer soundId;
            Degree degree = chord.getDegree();

            while (true) {
                for (int i = 0; i < chord.getSounds().size(); i++) {
                    soundId = chord.getSounds().get(i);
                    getSoundPool().play(soundId, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, DEFAULT_LOOP, DEFAULT_RATE);
                }

                degree = analyzer.getNext(degree);
                chord = getSoundPoolChord(degree);

                Thread.sleep(speed);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public SoundPool getSoundPool() {
        return soundPool;
    }

    public MusicSettings getSettings() {
        return settings;
    }

    public SoundPoolChord getSoundPoolChord(Degree degree) {
        return getSoundPoolChords().stream()
                .filter(f -> f.getDegree().equals(degree))
                .findFirst()
                .get();
    }

    public List<SoundPoolChord> getSoundPoolChords() {
        return soundPoolChords;
    }

    public void setSoundPoolChords(List<SoundPoolChord> chords) {
        this.soundPoolChords = chords;
    }
}
