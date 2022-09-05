package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.quizapp.adapter.RangkingAdapter;
import com.example.quizapp.database.AppDatabase;
import com.example.quizapp.database.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class Activity_Rangking extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppDatabase db;
    private List<User> list = new ArrayList<>();
    private RangkingAdapter rangkingAdapter;
    private ImageButton backTOMenu, deleteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangking);

        //inisialization component
        recyclerView = findViewById(R.id.RecyleList);
        backTOMenu = findViewById(R.id.backToMenu);
        deleteList = findViewById(R.id.deleteListRank);

        //inisialization database
        db = AppDatabase.getInstance(getApplicationContext());

        //handle list
        list.clear();
        list.addAll(db.userDao().getAll());
        rangkingAdapter = new RangkingAdapter(getApplicationContext(), list);

        //create list
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rangkingAdapter);

        //back to Menu
        backTOMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Rangking.this , Activity_Main_Menu.class));
            }
        });

        //delete list
        deleteList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.userDao().delete();
                onStart();
            }
        });

    }

    //refresh list


    @Override
    protected void onStart() {
        super.onStart();
        list.clear();
        list.addAll(db.userDao().getAll());
        rangkingAdapter.notifyDataSetChanged();
    }
}