package com.example.practical11;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class PlaybackInfoListener {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({State.INVALID, State.PLAYING, State.PAUSED, State.RESET, State.COMPLETED})
    @interface State {
        int INVALID = -1;
        int PLAYING = 0;
        int PAUSED = 1;
        int RESET = 2;
        int COMPLETED = 3;
    }

    public static String convertStatetoString(@State int state) {
        String stateString;
        switch (state) {
            case State.INVALID:
                stateString = "INVALID";
                break;
            case State.PLAYING:
                stateString = "PLAYING";
                break;
            case State.PAUSED:
                stateString = "PAUSED";
                break;
            case State.RESET:
                stateString = "RESET";
                break;
            case State.COMPLETED:
                stateString = "COMPLETED";
                break;
            default:
                stateString = "UNKNOWN STATE";
        }
        return stateString;
    }

    void onLogUpdated(String formattedMessage) {}
    void onDurationChanged(int duration) {}
    void onPositionChanged(int position) {}
    void onStateChanged(@State int state) {}
    void onPlaybackCompleted() {}
}
