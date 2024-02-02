package com.example.roompersistencesetup;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao { // Data Access Object
    // Insert annotation
    // If single parameter received, returns a long value, rowid created
    // If parameter is an array/collection, returns long[] or List<Long>, rowids created
    // Example:
    @Insert
    void insertAll(User... users);
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(User... users);
    @Insert
    public void insertBothUsers(User user1, User user2);
    @Insert
    public void insertUsersAndFriends(User user, List<User> friends);

    // Update annotation
    // Uses primary key to match with the passed instances, if no match, no changes are made
    // Can optionally change return type to int, obtain number of rows updated
    // Example:
    @Update
    public void updateUsers(User... users); // To update one or more users

    // Delete annotation
    // Uses primary key to match with the passed instances, if no match, no deletions are made
    // Can optionally change return type to int, obtain number of rows deleted successfully
    // Example:
    @Delete
    void delete(User user);
    @Delete
    public void deleteUsers(User... users); // To delete one or more users

    // Query annotation
    // Allows us to write our own SQL queries to perform customized insertion, update and deletion in the table
    // Example:
    @Query("SELECT * FROM user")
    List<User> getAll();
    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);
    @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);
    @Query("SELECT * FROM user")
    public User[] loadAllUsers();
    @Query("SELECT first_name, last_name FROM user")
    public List<NameTuple> loadFullName();
    @Query("SELECT * FROM user WHERE age > :minAge")
    public User[] loadAllUsersOlderThan(int minAge);// passing parameter, : is a bind parameter
    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    public User[] loadAllUsersBetweenAges(int minAge, int maxAge);// multiple parameters
    @Query("SELECT * FROM user WHERE first_name LIKE :search OR last_name LIKE :search")
    public List<User> findUserWithName(String search);// same parameter used multiple times in query
    @Query("SELECT * FROM user WHERE region IN (:regions)")
    public List<User> loadUsersFromRegions(List<String> regions);// collection of parameter - unknown number

//    @Query("SELECT * FROM book " +
//            "INNER JOIN loan ON loan.book_id = book.id " +
//            "INNER JOIN user ON user.id = loan.user_id " +
//            "WHERE user.name LIKE :userName")
//    public List<Book> findBooksBorrowedByUser(String userName); // combine multiple tables

//    @Query("SELECT user.name AS userName, book.name AS bookName " +
//            "FROM user, book " +
//            "WHERE user.id = book.user_id")
//    public LiveData<List<UserBook>> loadUserAndBookNames(); // return different columns from different tables
//    static class UserBook {
//        public String userName;
//        public String bookName;
//    }
}
