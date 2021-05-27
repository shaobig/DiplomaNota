package com.shaobig.diplomanota.entities.builders.chord.design;

import com.shaobig.diplomanota.entities.chord.ChordQualifier;
import com.shaobig.diplomanota.entities.note.NoteQualifier;
import com.shaobig.diplomanota.entities.enums.Interval;

import java.util.ArrayList;
import java.util.List;

public class MajorChordDesignBuilder implements ChordDesignBuilder {

    @Override
    public List<NoteQualifier> buildChord(ChordQualifier chord) {
        List<NoteQualifier> notes = new ArrayList<>();

        NoteQualifier tonic = chord.getTonic();
        notes.add(tonic);

        NoteQualifier third = getNote(tonic, Interval.MAJOR_THIRD);
        notes.add(third);

        NoteQualifier fifth = getNote(tonic, Interval.FIFTH);
        notes.add(fifth);

        NoteQualifier octave = getNote(tonic, Interval.OCTAVE);
        notes.add(octave);

        return notes;
    }
}
