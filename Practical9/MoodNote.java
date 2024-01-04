package com.example.practical9;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MoodNote {
    @PrimaryKey(autoGenerate = true)
    public int mNoteID;
    public String mNote;
    @NonNull
    public String mDate;
    @NonNull
    public int mMood;
    @NonNull
    public boolean mDayNight;
    public MoodNote(@NonNull String date, @NonNull int mood, @NonNull boolean dayNight, String note) {
        this.mDate = date;
        this.mMood = mood;
        this.mDayNight = dayNight;
        this.mNote = note;
    }
    public String getmDate(){return this.mDate;}
    public int getmMood(){return this.mMood;}
    public boolean getmDayNight(){return this.mDayNight;}
    public String getmNote(){return this.mNote;}
}
