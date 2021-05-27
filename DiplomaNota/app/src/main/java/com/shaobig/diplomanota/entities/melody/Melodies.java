package com.shaobig.diplomanota.entities.melody;

import com.shaobig.diplomanota.entities.factories.pattern.MusicPatternFactory;
import com.shaobig.diplomanota.entities.pattern.MusicPatterns;
import com.shaobig.diplomanota.entities.rhythm.Rhythm;

public class Melodies {

    public static final Integer DEFAULT_MELODY_PATTERN_COUNT = 64;

    public static Melody getMelody(Rhythm rhythm, Integer patternCount) {
        MusicPatternFactory patternFactory = MusicPatterns.getPatternFactory(rhythm);
        Melody melody = new Melody();

        for (int i = 0; i < patternCount; i++) {
            melody.addPattern(patternFactory.getPattern());
        }

        return melody;
    }
}
