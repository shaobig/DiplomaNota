package com.shaobig.diplomanota.entities.rhythm;

import com.shaobig.diplomanota.entities.enums.BeatDuration;

import java.io.Serializable;

public class Rhythm implements Serializable {

    private Integer beatCount;
    private BeatDuration beatDuration;

    public Rhythm(Integer beatCount, BeatDuration beatDuration) {
        this.beatCount = beatCount;
        this.beatDuration = beatDuration;
    }

    public Integer getBeatCount() {
        return beatCount;
    }

    public void setBeatCount(Integer beatCount) {
        if (beatCount != null) {
            this.beatCount = beatCount;
        }
        else {
            String message = "The valid beat count attribute's not been provided!";
            throw new NullPointerException(message);
        }
    }

    public BeatDuration getBeatDuration() {
        return beatDuration;
    }

    public void setBeatDuration(BeatDuration beatDuration) {
        if (beatDuration != null) {
            this.beatDuration = beatDuration;
        }
        else {
            String message = "The valid beat duration attribute's not been provided!";
            throw new NullPointerException(message);
        }
    }
}