package com.shaobig.diplomanota.entities.rhythm;

import com.shaobig.diplomanota.entities.enums.BeatDuration;

public class Rhythms {

    public static Rhythm getRhythm(int count, BeatDuration duration) {
        return new Rhythm(count, duration);
    }
}
