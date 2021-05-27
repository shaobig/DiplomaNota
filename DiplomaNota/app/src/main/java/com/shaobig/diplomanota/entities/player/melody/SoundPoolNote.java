package com.shaobig.diplomanota.entities.player.melody;

import com.shaobig.diplomanota.entities.enums.Degree;

public class SoundPoolNote {

    private Integer soundId;
    private Degree degree;

    public SoundPoolNote(Integer soundId, Degree degree) {
        this.soundId = soundId;
        this.degree = degree;
    }

    public Integer getSoundId() {
        return soundId;
    }

    public void setSoundId(Integer soundId) {
        this.soundId = soundId;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
