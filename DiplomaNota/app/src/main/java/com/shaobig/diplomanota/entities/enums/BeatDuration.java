package com.shaobig.diplomanota.entities.enums;

public enum BeatDuration {
    WHOLE(1), //W
    HALF(2), //H
    QUARTER(4), //Q
    EIGHTH(8), //E
    SIXTEENTH(16), //S
    THIRTY_SECOND(32); //TS

    private Integer duration;

    BeatDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }
}
