package com.example.roompersistencesetup;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Relation;
import androidx.room.Transaction;

import java.util.List;

public class Many_Many_Relationship {
    // Entities
    @Entity
    public class Playlist {
        @PrimaryKey public long playlistId;
        public String playlistName;
    }
    @Entity
    public class Song {
        @PrimaryKey public long songId;
        public String songName;
        public String artist;
    }
    // Associative entity (cross-reference table)
    @Entity(primaryKeys = {"playlistId", "songId"})
    public class PlaylistSongCrossRef {
        public long playlistId;
        public long songId;
    }

    // Data class that has two entities (Relationship model)
    public class PlaylistWithSongs {
        @Embedded public Playlist playlist;
        @Relation(
                parentColumn = "playlistId",
                entityColumn = "songId",
                associateBy = @Junction(PlaylistSongCrossRef.class)
        )// Use relation annotation to instance of child entity and set parent column as primary key of parent entity and entity column as foreign key of child entity
        public List<Song> songs;
    }
    public class SongWithPlaylists {
        @Embedded public Song song;
        @Relation(
                parentColumn = "songId",
                entityColumn = "playlistId",
                associateBy = @Junction(PlaylistSongCrossRef.class)
        )// Use relation annotation to instance of child entity and set parent column as primary key of parent entity and entity column as foreign key of child entity
        public List<Playlist> playlists;
    }

    // Query method in DAO class
//    @Transaction
//    @Query("SELECT * FROM Playlist")
//    public List<PlaylistWithSongs> getPlaylistsWithSongs();
//    @Transaction
//    @Query("SELECT * FROM Song")
//    public List<SongWithPlaylists> getSongsWithPlaylists();
}
