package com.example.roompersistencesetup;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Relation;
import androidx.room.Transaction;

import java.util.List;

public class One_One_Relationship {
    // Entities
    @Entity
    public class User {
        @PrimaryKey public long userId;
        public String name;
        public int age;
    }
    @Entity
    public class Library {
        @PrimaryKey public long libraryId;
        public long userOwnerId;
    }

    // Data class that has two entities (Relationship model)
    public class UserAndLibrary {
        @Embedded public User user;
        @Relation(
                parentColumn = "userId",
                entityColumn = "userOwnerId"
        )// Use relation annotation to instance of child entity and set parent column as primary key of parent entity and entity column as foreign key of child entity
        public Library library;
    }

    // Query method in DAO class
//    @Transaction
//    @Query("SELECT * FROM User")
//    public List<UserAndLibrary> getUsersAndLibraries();
}
