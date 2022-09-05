package com.example.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Activity_NewUser extends AppCompatActivity {
    private Button backBtn , nextBtn;
    private TextInputEditText fieldUser;
    private String getName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        //initilization component
        backBtn = findViewById(R.id.backButton);
        nextBtn = findViewById(R.id.nextButton);
        fieldUser = findViewById(R.id.inputUser);





        //handle back button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_NewUser.this, Activity_Main_Menu.class));
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialization Shared Preference
                SharedPreferences dataName = getSharedPreferences("name", 0);
                SharedPreferences.Editor editorName = dataName.edit();

                if (fieldUser.getText().length() == 0 ) {
                    getName = "User";
                    editorName.putString("username", getName);
                }else {
                    editorName.putString("username", fieldUser.getText().toString());
                }
                editorName.apply();
                startActivity(new Intent(Activity_NewUser.this , Activity_Question_1.class));
                finish();
            }
        });

    }
}