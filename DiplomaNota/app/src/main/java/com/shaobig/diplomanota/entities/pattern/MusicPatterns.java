package com.shaobig.diplomanota.entities.pattern;

import com.shaobig.diplomanota.entities.enums.BeatDuration;
import com.shaobig.diplomanota.entities.factories.pattern.FourFourMusicPatternFactory;
import com.shaobig.diplomanota.entities.factories.pattern.MusicPatternFactory;
import com.shaobig.diplomanota.entities.factories.pattern.ThreeFourMusicPatternFactory;
import com.shaobig.diplomanota.entities.rhythm.Rhythm;

public class MusicPatterns {

    public static MusicPattern getMusicPattern(Rhythm rhythm) {
        MusicPatternFactory factory = getPatternFactory(rhythm);
        return factory.getPattern();
    }

    public static MusicPatternFactory getPatternFactory(Rhythm rhythm) {
        if (rhythm.getBeatCount().equals(4) && rhythm.getBeatDuration().getDuration().equals(4)) {
            return new FourFourMusicPatternFactory();
        }
        else if (rhythm.getBeatCount().equals(3) && rhythm.getBeatDuration().getDuration().equals(4)) {
            return new ThreeFourMusicPatternFactory();
        }
        else {
            return new FourFourMusicPatternFactory();
        }
    }
}
