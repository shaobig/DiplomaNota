package com.shaobig.diplomanota.entities.builders.chord.scale.note;

import com.shaobig.diplomanota.entities.enums.Interval;
import com.shaobig.diplomanota.entities.enums.NoteLetter;
import com.shaobig.diplomanota.entities.note.NoteQualifier;
import com.shaobig.diplomanota.entities.note.Notes;

import java.util.ArrayList;
import java.util.List;

public class IonianNoteScaleBuilder implements NoteScaleBuilder {

    @Override
    public List<NoteQualifier> getNoteScale(NoteLetter letter, int octave) {
        NoteQualifier tonic = Notes.getNoteQualifier(letter, octave);
        NoteQualifier second = Notes.getNoteQualifier(tonic, Interval.MINOR_SECOND);
        NoteQualifier third = Notes.getNoteQualifier(tonic, Interval.MAJOR_THIRD);
        NoteQualifier fourth = Notes.getNoteQualifier(tonic, Interval.FOURTH);
        NoteQualifier fifth = Notes.getNoteQualifier(tonic, Interval.FIFTH);
        NoteQualifier sixth = Notes.getNoteQualifier(tonic, Interval.MAJOR_SEXTH);
        NoteQualifier seventh = Notes.getNoteQualifier(tonic, Interval.MAJOR_SEVENTH);

        List<NoteQualifier> noteQualifiers = new ArrayList<>();
        noteQualifiers.add(tonic);
        noteQualifiers.add(second);
        noteQualifiers.add(third);
        noteQualifiers.add(fourth);
        noteQualifiers.add(fifth);
        noteQualifiers.add(sixth);
        noteQualifiers.add(seventh);

        return noteQualifiers;
    }
}
