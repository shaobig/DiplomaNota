package com.shaobig.diplomanota.entities.scale;

import com.shaobig.diplomanota.entities.enums.Mode;
import com.shaobig.diplomanota.entities.note.NoteQualifier;

import java.io.Serializable;

public class Scale implements Serializable {

    private NoteQualifier tonic;
    private Mode mode;

    public Scale(NoteQualifier tonic, Mode mode) {
        this.tonic = tonic;
        this.mode = mode;
    }

    public NoteQualifier getTonic() {
        return tonic;
    }

    public void setTonic(NoteQualifier tonic) {
        if (tonic != null) {
            this.tonic = tonic;
        }
        else {
            String message = "The valid tonic attribute's not been provided!";
            throw new NullPointerException(message);
        }
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        if (mode != null) {
            this.mode = mode;
        }
        else {
            String message = "The valid mode attribute's not been provided!";
            throw new NullPointerException(message);
        }
    }
}
