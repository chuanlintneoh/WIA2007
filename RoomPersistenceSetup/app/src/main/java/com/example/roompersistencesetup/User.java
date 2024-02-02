package com.example.roompersistencesetup;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//@Entity(tableName = "users") // if table name and class name different
//@Entity(primaryKeys = {"firstName", "lastName"}) // if contains composite key
@Entity
public class User { // Table name = class name
//    @PrimaryKey(autoGenerate = true) // if want primary key to be auto-generated
    @PrimaryKey // MUST define one
    public int id;

    // Field names and data types
    @ColumnInfo(name = "first_name") // if column name and field name different
    public String firstName;
    @ColumnInfo(name = "last_name") // if column name and field name different
    public String lastName;
    public int age;
    public String region;
    @Embedded public Address address; // Address object decomposed to street, state, city, post code

//    @Ignore // if do not want field of the entity to persist
//    Bitmap picture;
}

//@Entity(ignoredColumns = "picture") // if do not want the field of the entity to persist (field is inherited from parent entity)
//public class RemoteUser extends User {
//    @PrimaryKey
//    public int id;
//
//    public boolean hasVpn;
//}
