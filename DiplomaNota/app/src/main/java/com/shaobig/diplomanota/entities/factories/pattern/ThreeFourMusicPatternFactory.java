package com.shaobig.diplomanota.entities.factories.pattern;

import com.shaobig.diplomanota.entities.pattern.MusicPattern;
import com.shaobig.diplomanota.entities.pattern.four_four.PatternEEHQ;
import com.shaobig.diplomanota.entities.pattern.four_four.PatternEEQQQ;
import com.shaobig.diplomanota.entities.pattern.four_four.PatternEHEQ;
import com.shaobig.diplomanota.entities.pattern.four_four.PatternHEEQ;
import com.shaobig.diplomanota.entities.pattern.four_four.PatternHQEE;
import com.shaobig.diplomanota.entities.pattern.four_four.PatternQEEH;
import com.shaobig.diplomanota.entities.pattern.four_four.PatternQEEQQ;
import com.shaobig.diplomanota.entities.pattern.four_four.PatternQQEEQ;
import com.shaobig.diplomanota.entities.pattern.four_four.PatternQQQEE;
import com.shaobig.diplomanota.entities.pattern.three_four.PatternEEQQ;
import com.shaobig.diplomanota.entities.pattern.three_four.PatternQEEQ;
import com.shaobig.diplomanota.entities.pattern.three_four.PatternQQEE;

import java.util.Random;

public class ThreeFourMusicPatternFactory implements MusicPatternFactory {

    private static final int PATTERN_COUNT = 3;

    @Override
    public MusicPattern getPattern() {
        int index = new Random().nextInt(getPatternCount());

        switch (index) {
            case 0: return new PatternEEQQ();
            case 1: return new PatternQEEQ();
            case 2: return new PatternQQEE();

            default: return new PatternEEQQQ();
        }
    }

    @Override
    public Integer getPatternCount() {
        return PATTERN_COUNT;
    }
}
