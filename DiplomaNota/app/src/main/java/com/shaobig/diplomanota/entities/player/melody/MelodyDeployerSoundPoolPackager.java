package com.shaobig.diplomanota.entities.player.melody;

import android.content.Context;
import android.media.SoundPool;

import com.shaobig.diplomanota.entities.enums.Degree;
import com.shaobig.diplomanota.entities.note.NoteQualifier;
import com.shaobig.diplomanota.entities.player.SoundPoolPackager;

import java.util.ArrayList;
import java.util.List;

public class MelodyDeployerSoundPoolPackager implements SoundPoolPackager<SoundPoolNote> {

    private static final int DEFAULT_SOUND_PRIORITY = 1;
    private static final String DEFAULT_RESOURCE_TYPE = "raw";

    private Context context;
    private SoundPool soundPool;

    private List<NoteQualifier> noteQualifiers;

    public MelodyDeployerSoundPoolPackager(Context context, SoundPool soundPool, List<NoteQualifier> noteQualifiers) {
        this.context = context;
        this.soundPool = soundPool;
        this.noteQualifiers = noteQualifiers;
    }

    @Override
    public List<SoundPoolNote> loadSounds() {
        String name;
        int resId;

        int soundId;
        Degree degree;

        NoteQualifier noteQualifier;
        List<SoundPoolNote> notes = new ArrayList<>();

        for (int i = 0; i < getNoteQualifiers().size(); i++) {
            noteQualifier = getNoteQualifiers().get(i);

            name = noteQualifier.getNoteLetter().toString().toLowerCase()
                    .concat(String.valueOf(noteQualifier.getOctave()));
            resId = getContext().getResources().getIdentifier(name, DEFAULT_RESOURCE_TYPE, getContext().getPackageName());

            try {
                soundId = getSoundPool().load(getContext(), resId, DEFAULT_SOUND_PRIORITY);
                degree = Degree.values()[i];
                notes.add(new SoundPoolNote(soundId, degree));
            }
            catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

        return notes;
    }

    public Context getContext() {
        return context;
    }

    public SoundPool getSoundPool() {
        return soundPool;
    }

    public List<NoteQualifier> getNoteQualifiers() {
        return noteQualifiers;
    }
}
