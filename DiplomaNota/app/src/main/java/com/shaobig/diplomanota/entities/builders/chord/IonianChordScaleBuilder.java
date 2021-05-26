package com.shaobig.diplomanota.entities.builders.chord.scale.chord;

import com.shaobig.diplomanota.entities.chord.Chord;
import com.shaobig.diplomanota.entities.chord.Chords;
import com.shaobig.diplomanota.entities.enums.Interval;
import com.shaobig.diplomanota.entities.enums.ModePattern;
import com.shaobig.diplomanota.entities.note.NoteQualifier;

import java.util.ArrayList;
import java.util.List;

public class IonianChordScaleBuilder implements ChordScaleBuilder {

    @Override
    public List<Chord> getChordScale(NoteQualifier tonic) {
        Chord first = getChord(tonic, Interval.PRIMA);
        Chord second = getChord(tonic, Interval.MAJOR_SECOND);
        Chord third = getChord(tonic, Interval.MAJOR_THIRD);
        Chord fourth = getChord(tonic, Interval.FOURTH);
        Chord fifth = getChord(tonic, Interval.FIFTH);
        Chord sixth = getChord(tonic, Interval.MAJOR_SEXTH);
        Chord seventh = getChord(tonic, Interval.MAJOR_SEVENTH);

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
            case PRIMA:
            case FOURTH:
            case FIFTH:
                return ModePattern.MAJOR;
            case MAJOR_SEVENTH:
                return ModePattern.DIMINISHED;
            default: return ModePattern.MINOR;
        }
    }
}
