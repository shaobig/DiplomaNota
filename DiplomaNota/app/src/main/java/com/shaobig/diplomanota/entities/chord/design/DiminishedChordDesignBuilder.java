package com.shaobig.diplomanota.entities.builders.chord.design;

import com.shaobig.diplomanota.entities.chord.ChordQualifier;
import com.shaobig.diplomanota.entities.enums.Interval;
import com.shaobig.diplomanota.entities.note.NoteQualifier;

import java.util.ArrayList;
import java.util.List;

public class DiminishedChordDesignBuilder implements ChordDesignBuilder {

    @Override
    public List<NoteQualifier> buildChord(ChordQualifier chord) {
        List<NoteQualifier> notes = new ArrayList<>();

        NoteQualifier tonic = chord.getTonic();
        notes.add(tonic);

        NoteQualifier third = getNote(tonic, Interval.MINOR_THIRD);
        notes.add(third);

        NoteQualifier fifth = getNote(tonic, Interval.TRITONE);
        notes.add(fifth);

        NoteQualifier octave = getNote(tonic, Interval.OCTAVE);
        notes.add(octave);

        return notes;
    }
}
