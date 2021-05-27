package com.shaobig.diplomanota.entities.pattern.four_four;

import com.shaobig.diplomanota.entities.enums.BeatDuration;
import com.shaobig.diplomanota.entities.pattern.MusicPattern;

import java.util.Arrays;
import java.util.List;

public class PatternEHEQ implements MusicPattern {

    @Override
    public List<BeatDuration> getPattern() {
        return Arrays.asList(
                BeatDuration.EIGHTH,
                BeatDuration.HALF,
                BeatDuration.EIGHTH,
                BeatDuration.QUARTER
        );
    }
}
