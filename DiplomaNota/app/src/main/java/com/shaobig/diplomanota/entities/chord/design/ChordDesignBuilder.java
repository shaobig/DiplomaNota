package com.shaobig.diplomanota.entities.builders.chord.design;

import com.shaobig.diplomanota.entities.chord.ChordQualifier;
import com.shaobig.diplomanota.entities.note.NoteQualifier;
import com.shaobig.diplomanota.entities.enums.Interval;
import com.shaobig.diplomanota.entities.note.Notes;

import java.util.List;

public interface ChordDesignBuilder {
    List<NoteQualifier> buildChord(ChordQualifier chord);

    default NoteQualifier getNote(NoteQualifier tonic, Interval interval) {
        return Notes.getNoteQualifier(tonic, interval);
    }
}
