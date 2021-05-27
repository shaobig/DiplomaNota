package com.shaobig.diplomanota.entities.factories;

import com.shaobig.diplomanota.entities.builders.chord.AeolianChordScaleBuilder;
import com.shaobig.diplomanota.entities.enums.Mode;
import com.shaobig.diplomanota.entities.builders.chord.ChordScaleBuilder;
import com.shaobig.diplomanota.entities.builders.chord.IonianChordScaleBuilder;

public class ChordScaleBuilderFactory {

    public static ChordScaleBuilder getBuilder(Mode name) {
        switch (name) {
            case IONIAN: case MAJOR: return new IonianChordScaleBuilder();
            case AEOLIAN: case MINOR: return new AeolianChordScaleBuilder();
            default: return new IonianChordScaleBuilder();
        }
    }
}
