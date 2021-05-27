package com.shaobig.diplomanota.entities.scale;

import com.shaobig.diplomanota.entities.builders.chord.ChordScaleBuilder;
import com.shaobig.diplomanota.entities.chord.Chord;
import com.shaobig.diplomanota.entities.enums.Mode;
import com.shaobig.diplomanota.entities.enums.NoteLetter;
import com.shaobig.diplomanota.entities.factories.ChordScaleBuilderFactory;
import com.shaobig.diplomanota.entities.note.NoteQualifier;
import com.shaobig.diplomanota.entities.note.Notes;

import java.util.List;

public class Scales {

    public static Scale getScale(NoteQualifier tonic, Mode name) {
        return new Scale(tonic, name);
    }

    public static Scale getScale(NoteLetter letter, Mode name, int octave) {
        NoteQualifier tonic = Notes.getNoteQualifier(letter, octave);
        return getScale(tonic, name);
    }

    public static Scale getScale(NoteLetter letter, Mode name) {
        NoteQualifier tonic = Notes.getNoteQualifier(letter, NoteQualifier.DEFAULT_OCTAVE);
        return getScale(tonic, name);
    }

    public static List<Chord> getChordScale(NoteQualifier tonic, Mode name) {
        ChordScaleBuilder builder = ChordScaleBuilderFactory.getBuilder(name);
        return builder.getChordScale(tonic);
    }

    public static List<Chord> getChordScale(Scale scale) {
        ChordScaleBuilder builder = ChordScaleBuilderFactory.getBuilder(scale.getMode());
        return builder.getChordScale(scale.getTonic());
    }
}
