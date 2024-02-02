package com.example.roompersistencesetup;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

// To obtain table subset
// This class is not an entity, but it is used to query a subset of columns from a table
// This class is an object used to hold these 2 values from the query result
public class NameTuple {
    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    @NonNull
    public String lastName;
}
