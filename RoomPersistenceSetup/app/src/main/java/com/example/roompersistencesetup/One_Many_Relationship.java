package com.example.roompersistencesetup;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Relation;

import java.util.List;

public class One_Many_Relationship {
    // Entities
    @Entity
    public class User {
        @PrimaryKey public long userId;
        public String name;
        public int age;
    }
    @Entity
    public class Playlist {
        @PrimaryKey public long playlistId;
        public long userCreatorId;
        public String playlistName;
    }

    // Data class that has two entities (Relationship model)
    public class UserWithPlaylists {
        @Embedded public User user;
        @Relation(
                parentColumn = "userId",
                entityColumn = "userCreatorId"
        )// Use relation annotation to instance of child entity and set parent column as primary key of parent entity and entity column as foreign key of child entity
        public List<Playlist> playlists;
    }

    // Query method in DAO class
//    @Transaction
//    @Query("SELECT * FROM User")
//    public List<UserWithPlaylists> getUsersWithPlaylists();
}
