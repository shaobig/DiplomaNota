package com.shaobig.diplomanota.entities.note;

import com.shaobig.diplomanota.entities.enums.NoteLetter;

import java.io.Serializable;

public class NoteQualifier implements Serializable {

    public static final int DEFAULT_OCTAVE = 3;

    private NoteLetter noteLetter;
    private Integer octave;

    public NoteQualifier(NoteLetter noteLetter, Integer octave) {
        this.noteLetter = noteLetter;
        this.octave = octave;
    }

    public NoteQualifier(NoteLetter noteLetter) {
        this.noteLetter = noteLetter;
        this.octave = DEFAULT_OCTAVE;
    }

    public NoteLetter getNoteLetter() {
        return noteLetter;
    }

    public void setNoteLetter(NoteLetter symbol) {
        this.noteLetter = symbol;
    }

    public Integer getOctave() {
        return octave;
    }

    public void setOctave(Integer octave) {
        this.octave = octave;
    }

    @Override
    public String toString() {
        return noteLetter + "(" + octave + ")";
    }
}
