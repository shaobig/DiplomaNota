package com.shaobig.diplomanota.entities.player.melody;

import android.content.Context;
import android.media.SoundPool;

import com.shaobig.diplomanota.entities.enums.BeatDuration;
import com.shaobig.diplomanota.entities.enums.Degree;
import com.shaobig.diplomanota.entities.melody.Melodies;
import com.shaobig.diplomanota.entities.melody.Melody;
import com.shaobig.diplomanota.entities.note.NoteQualifier;
import com.shaobig.diplomanota.entities.note.Notes;
import com.shaobig.diplomanota.entities.pattern.MusicPattern;
import com.shaobig.diplomanota.entities.player.MusicReproducer;
import com.shaobig.diplomanota.entities.player.MusicSettings;
import com.shaobig.diplomanota.entities.player.SoundPoolResourceDownloader;
import com.shaobig.diplomanota.entities.analyzer.ChordDegreeAnalyzer;
import com.shaobig.diplomanota.entities.analyzer.DegreeAnalyzer;
import com.shaobig.diplomanota.entities.player.metronome.Metronome;
import com.shaobig.diplomanota.entities.rhythm.Rhythm;
import com.shaobig.diplomanota.entities.scale.Scale;

import java.util.List;

public class MelodyDeployer implements SoundPoolResourceDownloader, MusicReproducer {

    private static final float DEFAULT_VOLUME = 0.75f;
    private static final int DEFAULT_PRIORITY = 1;
    private static final int DEFAULT_LOOP = 0;
    private static final int DEFAULT_RATE = 1;

    private static final int MELODY_OCTAVE_COEFFICIENT = 1;

    private SoundPool soundPool;

    private MusicSettings settings;

    private List<SoundPoolNote> notes;

    public MelodyDeployer(Context context, SoundPool soundPool, MusicSettings settings) {
        this.soundPool = soundPool;

        this.settings = new MusicSettings(settings);
        getSettings().getScale().getTonic().setOctave(getSettings().getScale().getTonic().getOctave() + MELODY_OCTAVE_COEFFICIENT);

        downloadSounds(context, soundPool);
    }

    @Override
    public void downloadSounds(Context context, SoundPool soundPool) {
        if (context != null && soundPool != null) {
            Scale scale = getSettings().getScale();

            List<NoteQualifier> noteQualifiers = Notes.getNoteQualifiers(scale.getTonic(), scale.getMode());
            MelodyDeployerSoundPoolPackager packager = new MelodyDeployerSoundPoolPackager(context, soundPool, noteQualifiers);

            setNotes(packager.loadSounds());
        }
        else {
            String message = "Either context or the soundpool object haven't been initialized";
            throw new NullPointerException(message);
        }
    }

    @Override
    public void play() {
        Rhythm rhythm = getSettings().getRhythm();
        Melody melody = Melodies.getMelody(rhythm, Melodies.DEFAULT_MELODY_PATTERN_COUNT);

        int frequency = Metronome.ONE_MINUTE_IN_MILLISECONDS / getSettings().getTempo().getValue();
        double duration;
        long speed;

        SoundPoolNote note = getNote(Degree.FIRST);
        DegreeAnalyzer analyzer = new ChordDegreeAnalyzer();

        try {
            Integer soundId;
            Degree degree = note.getDegree();

            while (true) {
                for (MusicPattern pattern : melody.getPatterns()) {
                    for (int j = 0; j < pattern.getPattern().size(); j++) {
                        soundId = note.getSoundId();
                        getSoundPool().play(soundId, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, DEFAULT_LOOP, DEFAULT_RATE);

                        degree = analyzer.getNext(degree);
                        note = getNote(degree);

                        duration = (double) BeatDuration.QUARTER.getDuration() / pattern.getPattern().get(j).getDuration();
                        speed = Math.round(frequency * duration);

                        Thread.sleep(speed);
                    }
                }
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

    public SoundPoolNote getNote(Degree degree) {
        return getNotes().stream()
                .filter(f -> f.getDegree().equals(degree))
                .findFirst()
                .get();
    }

    public List<SoundPoolNote> getNotes() {
        return notes;
    }

    public void setNotes(List<SoundPoolNote> notes) {
        if (notes != null && !notes.isEmpty()) {
            this.notes = notes;
        }
        else {
            String message = "The input argument doesn't satisfy the necessary conditions: list either empty or has no a reference";
            throw new IllegalArgumentException(message);
        }
    }
}