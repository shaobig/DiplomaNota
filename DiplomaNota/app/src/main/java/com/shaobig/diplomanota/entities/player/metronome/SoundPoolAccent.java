package com.shaobig.diplomanota.entities.player.metronome;

import com.shaobig.diplomanota.entities.enums.BeatAccent;

public class SoundPoolAccent {

    private Integer soundId;
    private BeatAccent beatAccent;

    public SoundPoolAccent(Integer soundId, BeatAccent beatAccent) {
        this.soundId = soundId;
        this.beatAccent = beatAccent;
    }

    public Integer getSoundId() {
        return soundId;
    }

    public void setSoundId(Integer soundId) {
        this.soundId = soundId;
    }

    public BeatAccent getBeatAccent() {
        return beatAccent;
    }

    public void setBeatAccent(BeatAccent beatAccent) {
        this.beatAccent = beatAccent;
    }
}
