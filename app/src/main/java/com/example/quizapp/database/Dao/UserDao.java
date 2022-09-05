package com.example.quizapp.database.Dao;


import androidx.room.Dao;
import androidx.room.Query;

import com.example.quizapp.database.Entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User ORDER BY score DESC")
    List<User> getAll();

    //insert username,score  to database
    @Query("INSERT INTO user(username,score) VALUES(:user,:score)")
    void insertAll(String user, int score);

    @Query("DELETE FROM user")
    void delete();

}
