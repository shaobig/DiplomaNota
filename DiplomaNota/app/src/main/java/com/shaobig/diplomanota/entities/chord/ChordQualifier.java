package com.shaobig.diplomanota.entities.chord;

import com.shaobig.diplomanota.entities.enums.ModePattern;
import com.shaobig.diplomanota.entities.note.NoteQualifier;

public class ChordQualifier {
    private NoteQualifier tonic;
    private ModePattern chordType;

    public ChordQualifier(NoteQualifier tonic, ModePattern chordType) {
        this.tonic = tonic;
        this.chordType = chordType;
    }

    public NoteQualifier getTonic() {
        return tonic;
    }

    public void setTonic(NoteQualifier tonic) {
        this.tonic = tonic;
    }

    public ModePattern getChordType() {
        return chordType;
    }

    public void setChordType(ModePattern chordType) {
        this.chordType = chordType;
    }

    @Override
    public String toString() {
        return tonic + "(" + chordType.toString() + ")";
    }
}
