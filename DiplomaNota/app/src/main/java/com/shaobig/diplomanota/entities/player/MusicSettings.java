package com.shaobig.diplomanota.entities.player;

import com.shaobig.diplomanota.entities.rhythm.Rhythm;
import com.shaobig.diplomanota.entities.scale.Scale;
import com.shaobig.diplomanota.entities.tempo.Tempo;

import java.io.Serializable;

public class MusicSettings implements Serializable {

    private Scale scale;
    private Rhythm rhythm;
    private Tempo tempo;

    public MusicSettings(Scale scale, Rhythm rhythm, Tempo tempo) {
        this.scale = scale;
        this.rhythm = rhythm;
        this.tempo = tempo;
    }

    public MusicSettings(MusicSettings copy) {
        this.scale = copy.getScale();
        this.rhythm = copy.getRhythm();
        this.tempo = copy.getTempo();
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public Rhythm getRhythm() {
        return rhythm;
    }

    public void setRhythm(Rhythm rhythm) {
        this.rhythm = rhythm;
    }

    public Tempo getTempo() {
        return tempo;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }
}
