package com.example.practical9;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MoodNote.class}, version = 1, exportSchema = false)
public abstract class MoodNoteRoomDatabase extends RoomDatabase {
    public abstract MoodNoteDao noteDao();
    private static volatile MoodNoteRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static MoodNoteRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MoodNoteRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MoodNoteRoomDatabase.class, "note_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                MoodNoteDao dao = INSTANCE.noteDao();
                dao.deleteAll();
                MoodNote note = new MoodNote("12.12.2022", 1, false, "It's a happy day!");
                dao.insert(note);
            });
        }
    };
}
