package com.shaobig.diplomanota.entities.factories;

import com.shaobig.diplomanota.entities.chord.design.AugmentedChordDesignBuilder;
import com.shaobig.diplomanota.entities.chord.design.ChordDesignBuilder;
import com.shaobig.diplomanota.entities.chord.design.DiminishedChordDesignBuilder;
import com.shaobig.diplomanota.entities.chord.design.MajorChordDesignBuilder;
import com.shaobig.diplomanota.entities.chord.design.MinorChordDesignBuilder;
import com.shaobig.diplomanota.entities.enums.ModePattern;

public class ChordDesignBuilderFactory {
    public static ChordDesignBuilder getDesignBuilder(ModePattern type) {
        switch (type) {
            case MAJOR: return new MajorChordDesignBuilder();
            case MINOR: return new MinorChordDesignBuilder();
            case DIMINISHED: return new DiminishedChordDesignBuilder();
            case AUGMENTED: return new AugmentedChordDesignBuilder();
            default: return new MajorChordDesignBuilder();
        }
    }
}
