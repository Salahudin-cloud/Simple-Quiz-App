package com.example.quizapp.database.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int id;

    public String username;

    public int score;


}
