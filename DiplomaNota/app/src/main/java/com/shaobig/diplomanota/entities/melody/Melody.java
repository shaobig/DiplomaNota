package com.shaobig.diplomanota.entities.melody;

import com.shaobig.diplomanota.entities.pattern.MusicPattern;

import java.util.ArrayList;
import java.util.List;

public class Melody implements MelodyController {

    private List<MusicPattern> patterns;

    public Melody() {
        this.patterns = new ArrayList<>();
    }

    public Melody(List<MusicPattern> patterns) {
        this.patterns = patterns;
    }

    @Override
    public void addPattern(MusicPattern pattern) {
        if (pattern != null) {
            getPatterns().add(pattern);
        }
        else {
            String message = "The pattern has no reference to an object";
            throw new IllegalArgumentException(message);
        }
    }

    public List<MusicPattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<MusicPattern> patterns) {
        if (patterns != null) {
            this.patterns = patterns;
        }
        else {
            String message = "The patterns list has no reference to an object";
            throw new IllegalArgumentException(message);
        }
    }
}
