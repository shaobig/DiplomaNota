package com.shaobig.diplomanota.entities.builders.chord.scale.chord;

import com.shaobig.diplomanota.entities.chord.Chord;
import com.shaobig.diplomanota.entities.enums.Interval;
import com.shaobig.diplomanota.entities.enums.ModePattern;
import com.shaobig.diplomanota.entities.note.NoteQualifier;
import com.shaobig.diplomanota.entities.note.Notes;

import java.util.List;

public interface ChordScaleBuilder {

    List<Chord> getChordScale(NoteQualifier tonic);
    Chord getChord(NoteQualifier tonic, Interval interval);
    ModePattern getMusicPatternType(Interval interval);

    default NoteQualifier getNote(NoteQualifier tonic, Interval interval) {
        return Notes.getNoteQualifier(tonic, interval);
    }
}
