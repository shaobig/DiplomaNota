package com.shaobig.diplomanota.entities.builders.chord.scale.chord;

import com.shaobig.diplomanota.entities.chord.Chord;
import com.shaobig.diplomanota.entities.chord.Chords;
import com.shaobig.diplomanota.entities.enums.Interval;
import com.shaobig.diplomanota.entities.enums.ModePattern;
import com.shaobig.diplomanota.entities.note.NoteQualifier;

import java.util.ArrayList;
import java.util.List;

public class AeolianChordScaleBuilder implements ChordScaleBuilder {

    @Override
    public List<Chord> getChordScale(NoteQualifier tonic) {
        Chord first = getChord(tonic, Interval.PRIMA);
        Chord second = getChord(tonic, Interval.MAJOR_SECOND);
        Chord third = getChord(tonic, Interval.MINOR_THIRD);
        Chord fourth = getChord(tonic, Interval.FOURTH);
        Chord fifth = getChord(tonic, Interval.FIFTH);
        Chord sixth = getChord(tonic, Interval.MINOR_SEXTH);
        Chord seventh = getChord(tonic, Interval.MINOR_SEVENTH);

        List<Chord> chords = new ArrayList<>();
        chords.add(first);
        chords.add(second);
        chords.add(third);
        chords.add(fourth);
        chords.add(fifth);
        chords.add(sixth);
        chords.add(seventh);

        return chords;
    }

    @Override
    public Chord getChord(NoteQualifier tonic, Interval interval) {
        NoteQualifier note = getNote(tonic, interval);
        ModePattern type = getMusicPatternType(interval);

        return Chords.getChord(note, type);
    }

    @Override
    public ModePattern getMusicPatternType(Interval interval) {
        switch (interval) {
            case MINOR_THIRD:
            case MINOR_SEXTH:
            case MINOR_SEVENTH:
                return ModePattern.MAJOR;
            case MAJOR_SECOND:
                return ModePattern.DIMINISHED;
            default: return ModePattern.MINOR;
        }
    }
}
