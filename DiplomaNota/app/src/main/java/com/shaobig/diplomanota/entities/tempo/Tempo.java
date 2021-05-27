package com.shaobig.diplomanota.entities.tempo;

import java.io.Serializable;

public class Tempo implements Serializable {

    private Integer value;

    public Tempo(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
