package com.shaobig.diplomanota.entities.chord;

import com.shaobig.diplomanota.entities.note.NoteQualifier;

import java.util.List;

public class Chord {

    private ChordQualifier chord;
    private List<NoteQualifier> notes;

    public Chord(ChordQualifier chord) {
        setChord(chord);
    }

    public ChordQualifier getChord() {
        return chord;
    }

    public void setChord(ChordQualifier chord) {
        this.chord = chord;
        this.notes = Chords.getChordNotes(chord);
    }

    public List<NoteQualifier> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return chord.toString()
                .concat(" ")
                .concat(notes.toString());
    }
}
