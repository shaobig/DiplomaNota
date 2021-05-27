package com.shaobig.diplomanota.entities.chord;

import com.shaobig.diplomanota.entities.chord.design.ChordDesignBuilder;
import com.shaobig.diplomanota.entities.enums.ModePattern;
import com.shaobig.diplomanota.entities.enums.NoteLetter;
import com.shaobig.diplomanota.entities.factories.ChordDesignBuilderFactory;
import com.shaobig.diplomanota.entities.note.NoteQualifier;

import java.util.List;

public class Chords {

    public static ChordQualifier getChordQualifier(NoteQualifier note, ModePattern type) {
        return new ChordQualifier(note, type);
    }

    public static ChordQualifier getChordQualifier(NoteLetter letter, ModePattern type, int octave) {
        NoteQualifier note = new NoteQualifier(letter, octave);
        return getChordQualifier(note, type);
    }

    public static Chord getChord(ChordQualifier qualifier) {
        return new Chord(qualifier);
    }

    public static Chord getChord(NoteLetter letter, ModePattern type, int octave) {
        ChordQualifier qualifier = getChordQualifier(letter, type, octave);
        return getChord(qualifier);
    }

    public static Chord getChord(NoteQualifier note, ModePattern type) {
        ChordQualifier qualifier = getChordQualifier(note, type);
        return getChord(qualifier);
    }

    public static List<NoteQualifier> getChordNotes(ChordQualifier chord) {
        ChordDesignBuilder designBuilder = ChordDesignBuilderFactory.getDesignBuilder(chord.getChordType());
        return designBuilder.buildChord(chord);
    }
}
