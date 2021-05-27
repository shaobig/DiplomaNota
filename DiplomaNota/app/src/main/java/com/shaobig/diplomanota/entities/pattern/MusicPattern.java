package com.shaobig.diplomanota.entities.pattern;

import com.shaobig.diplomanota.entities.enums.BeatDuration;

import java.util.List;

public interface MusicPattern {
    List<BeatDuration> getPattern();
}