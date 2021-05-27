package com.shaobig.diplomanota.entities.factories.pattern;

import com.shaobig.diplomanota.entities.pattern.MusicPattern;
import com.shaobig.diplomanota.entities.pattern.four_four.*;

import java.util.Random;

public class FourFourMusicPatternFactory implements MusicPatternFactory {

    private static final int PATTERN_COUNT = 9;

    @Override
    public MusicPattern getPattern() {
        int index = new Random().nextInt(getPatternCount());

        switch (index) {
            case 0: return new PatternEEQQQ();
            case 1: return new PatternQEEQQ();
            case 2: return new PatternQQEEQ();
            case 3: return new PatternQQQEE();
            case 4: return new PatternEEHQ();
            case 5: return new PatternQEEH();
            case 6: return new PatternHQEE();
            case 7: return new PatternHEEQ();
            case 8: return new PatternEHEQ();

            default: return new PatternEEQQQ();
        }
    }

    @Override
    public Integer getPatternCount() {
        return PATTERN_COUNT;
    }
}
