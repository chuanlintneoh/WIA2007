package com.example.practical9;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class MoodNoteRepository {
    private MoodNoteDao moodNoteDao;
    private LiveData<List<MoodNote>> mAllNotes;
    MoodNoteRepository(Application application) {
        MoodNoteRoomDatabase db = MoodNoteRoomDatabase.getDatabase(application);
        moodNoteDao = db.noteDao();
        mAllNotes = moodNoteDao.getAscendingNote();
    }
    LiveData<List<MoodNote>> getAllNotes() {
        return mAllNotes;
    }
    void insert(MoodNote note) {
        MoodNoteRoomDatabase.databaseWriteExecutor.execute(() -> {
            moodNoteDao.insert(note);
        });
    }
}
