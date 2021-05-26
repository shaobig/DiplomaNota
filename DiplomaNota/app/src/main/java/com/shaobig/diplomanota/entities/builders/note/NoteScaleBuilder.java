package com.shaobig.diplomanota.entities.builders.chord.scale.note;

import com.shaobig.diplomanota.entities.enums.NoteLetter;
import com.shaobig.diplomanota.entities.note.NoteQualifier;

import java.util.List;

public interface NoteScaleBuilder {
    List<NoteQualifier> getNoteScale(NoteLetter letter, int octave);
}
