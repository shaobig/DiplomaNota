package com.shaobig.diplomanota.entities.factories;

import android.media.AudioAttributes;
import android.media.SoundPool;

public class SoundPoolFactory {

    private static final int DEFAULT_CONTENT_TYPE = AudioAttributes.CONTENT_TYPE_MUSIC;
    private static final int DEFAULT_USAGE = AudioAttributes.USAGE_MEDIA;

    private static final int DEFAULT_MAX_STREAMS = 25;

    public static SoundPool getSoundPool() {
        return new SoundPool.Builder()
                .setAudioAttributes(getAudioAttributes())
                .setMaxStreams(DEFAULT_MAX_STREAMS)
                .build();
    }

    public static AudioAttributes getAudioAttributes() {
        return new AudioAttributes.Builder()
                .setContentType(DEFAULT_CONTENT_TYPE)
                .setUsage(DEFAULT_USAGE)
                .build();
    }
}
