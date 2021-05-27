package com.shaobig.diplomanota.entities.factories;

import com.shaobig.diplomanota.entities.builders.note.AeolianNoteScaleBuilder;
import com.shaobig.diplomanota.entities.builders.note.IonianNoteScaleBuilder;
import com.shaobig.diplomanota.entities.builders.note.NoteScaleBuilder;
import com.shaobig.diplomanota.entities.enums.Mode;

public class NoteScaleBuilderFactory {

    public static NoteScaleBuilder getBuilder(Mode name) {
        switch (name) {
            case IONIAN: case MAJOR: return new IonianNoteScaleBuilder();
            case AEOLIAN: case MINOR: return new AeolianNoteScaleBuilder();
            default: return new IonianNoteScaleBuilder();
        }
    }
}