package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.quizapp.database.AppDatabase;

public class Activity_Question_3 extends AppCompatActivity {

    private Button btnQ3A , btnQ3B, btnQ3C ;
    private int score;
    private AppDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        //inisilisasi component
        btnQ3A = findViewById(R.id.chooseQuestion3A);
        btnQ3B = findViewById(R.id.chooseQuestion3B);
        btnQ3C = findViewById(R.id.chooseQuestion3C);

        //inisialization database
        database = AppDatabase.getInstance(getApplicationContext());

        //get key value username
        SharedPreferences getUsername = getSharedPreferences("name",0);
        String getUsernameValue =  getUsername.getString("username", "Error");

        ///get data from question 2
        Intent data = getIntent();
        int getScore = data.getIntExtra("score", 0);
        if (data != null ) {
            if ( getScore != 0 ) {
                score = data.getIntExtra("score", 0);
            }else {
                score = 0;
            }

        }


        btnQ3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += score ;
                database.userDao().insertAll(getUsernameValue,score);
                startActivity(new Intent(Activity_Question_3.this, Activity_Rangking.class));
                finish();
            }
        });

        btnQ3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += 10 ;
                database.userDao().insertAll(getUsernameValue,score);
                startActivity(new Intent(Activity_Question_3.this, Activity_Rangking.class));
                finish();
            }
        });

        btnQ3C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += score ;
                database.userDao().insertAll(getUsernameValue,score);
                startActivity(new Intent(Activity_Question_3.this, Activity_Rangking.class));
                finish();
            }
        });




    }
}