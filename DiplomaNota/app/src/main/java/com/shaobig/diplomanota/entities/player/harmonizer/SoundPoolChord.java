package com.shaobig.diplomanota.entities.player.harmonizer;

import com.shaobig.diplomanota.entities.enums.Degree;

import java.util.ArrayList;
import java.util.List;

public class SoundPoolChord {

    private List<Integer> sounds;
    private Degree degree;

    public SoundPoolChord() {
        this.sounds = new ArrayList<>();
        this.degree = Degree.FIRST;
    }

    public SoundPoolChord(List<Integer> sounds, Degree degree) {
        this.sounds = sounds;
        this.degree = degree;
    }

    public List<Integer> getSounds() {
        return sounds;
    }

    public void setSounds(List<Integer> sounds) {
        this.sounds = sounds;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void addSound(int soundId) {
        getSounds().add(soundId);
    }
}
