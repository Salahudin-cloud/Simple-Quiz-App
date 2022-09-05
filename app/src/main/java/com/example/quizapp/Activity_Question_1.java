package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity_Question_1 extends AppCompatActivity {

    private Button btnQ1A , btnQ1B, btnQ1C ;
    private int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        //inisialisastion
        btnQ1A = findViewById(R.id.chooseQuestion1A);
        btnQ1B = findViewById(R.id.chooseQuestion1B);
        btnQ1C = findViewById(R.id.chooseQuestion1C);

        //handle question
        btnQ1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 10 ;
                Intent intent = new Intent(Activity_Question_1.this , Activity_Question_2.class);
                intent.putExtra("score", score);
                Log.d(String.valueOf(score), String.valueOf(score));
                startActivity(intent);
                finish();
            }
        });

        btnQ1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0 ;
                Intent intent = new Intent(Activity_Question_1.this , Activity_Question_2.class);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();
            }
        });

        btnQ1C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0 ;
                Intent intent = new Intent(Activity_Question_1.this , Activity_Question_2.class);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();
            }
        });
    }
}