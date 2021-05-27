package com.shaobig.diplomanota.entities.note;

import com.shaobig.diplomanota.entities.builders.note.NoteScaleBuilder;
import com.shaobig.diplomanota.entities.enums.Interval;
import com.shaobig.diplomanota.entities.enums.Mode;
import com.shaobig.diplomanota.entities.enums.NoteLetter;
import com.shaobig.diplomanota.entities.factories.NoteScaleBuilderFactory;

import java.util.List;

public class Notes {

    public static NoteQualifier getNoteQualifier(NoteLetter letter, int octave) {
        return new NoteQualifier(letter, octave);
    }

    public static NoteQualifier getNoteQualifier(NoteQualifier tonic, Interval interval) {
        int length = NoteLetter.values().length;
        int index = tonic.getNoteLetter().ordinal() + interval.ordinal();

        NoteLetter letter = NoteLetter.values()[index % length];
        int octave = tonic.getOctave() + (index / length);

        return Notes.getNoteQualifier(letter, octave);
    }

    public static List<NoteQualifier> getNoteQualifiers(NoteQualifier tonic, Mode mode) {
        NoteScaleBuilder builder = NoteScaleBuilderFactory.getBuilder(mode);
        return builder.getNoteScale(tonic.getNoteLetter(), tonic.getOctave());
    }

    public static List<NoteQualifier> getNoteQualifiers(NoteLetter letter, int octave, Mode mode) {
        NoteQualifier tonic = Notes.getNoteQualifier(letter, octave);
        return getNoteQualifiers(tonic, mode);
    }
}
