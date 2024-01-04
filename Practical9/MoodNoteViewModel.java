package com.example.practical9;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MoodNoteViewModel extends AndroidViewModel {
    private MoodNoteRepository mRepository;
    private final LiveData<List<MoodNote>> mAllNotes;
    public MoodNoteViewModel (Application application) {
        super(application);
        mRepository = new MoodNoteRepository(application);
        mAllNotes = mRepository.getAllNotes();
    }
    LiveData<List<MoodNote>> getAllNotes() { return mAllNotes; }
    public void insert(MoodNote note) { mRepository.insert(note); }
}
