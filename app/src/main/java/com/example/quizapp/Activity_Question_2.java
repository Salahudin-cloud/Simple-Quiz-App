package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity_Question_2 extends AppCompatActivity {

    private Button btnQ2A , btnQ2B, btnQ2C ;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        //inisilisasi component
        btnQ2A = findViewById(R.id.chooseQuestion2A);
        btnQ2B = findViewById(R.id.chooseQuestion2B);
        btnQ2C = findViewById(R.id.chooseQuestion2C);



        //get data from question 1
        Intent data = getIntent();
        int getScore = data.getIntExtra("score", 0);
        Log.d("GET_SCORE : ", String.valueOf(getScore));
        if (getScore == 0  ) {
            score = 0;
            Log.d("SCORE 1  ", String.valueOf(score));
        }else {
            score = data.getIntExtra("score", 0);
            Log.d("SCORE 2  ", String.valueOf(score));
        }


        btnQ2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += score ;
                Intent intent = new Intent(Activity_Question_2.this , Activity_Question_3.class);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();
            }
        });

        btnQ2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += 10 ;
                Intent intent = new Intent(Activity_Question_2.this , Activity_Question_3.class);
                intent.putExtra("score", score);
                Log.d("SCOORE NOW : ", String.valueOf(score));
                startActivity(intent);
                finish();
            }
        });

        btnQ2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += score ;
                Intent intent = new Intent(Activity_Question_2.this , Activity_Question_3.class);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();
            }
        });



    }
}