package com.example.testupdownrecyclerview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<StudentData> studentDataList = new ArrayList<>();
    private Context context;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        final FloatingActionButton moveTop = findViewById(R.id.fab_top);
        final FloatingActionButton moveDown = findViewById(R.id.fab_down);
        recyclerView = findViewById(R.id.recycler_view);
        studentAdapter = new StudentAdapter(studentDataList, this);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(manager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(studentAdapter);

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        if (android.os.Build.VERSION.SDK_INT >= 24){
            // Do something for Nougat and above versions
            moveTop.setVisibility(View.GONE);
            moveDown.setVisibility(View.GONE);

        } else{
            // do something for phones running an SDK before Nougat
            moveTop.setVisibility(View.VISIBLE);
            moveDown.setVisibility(View.VISIBLE);
        }

        studentDataPrepare();

        moveTop.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                recyclerView.smoothScrollToPosition(0);
                moveTop.setVisibility(View.GONE);
                moveDown.setVisibility(View.VISIBLE);
            }
        });
        moveDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                recyclerView.smoothScrollToPosition(studentDataList.size());
                moveTop.setVisibility(View.VISIBLE);
                moveDown.setVisibility(View.GONE);
            }
        });
    }

    private void studentDataPrepare() {
        StudentData data = new StudentData("sai", 25);
        studentDataList.add(data);
        data = new StudentData("sai raj", 25);
        studentDataList.add(data);
        data = new StudentData("raghu", 20);
        studentDataList.add(data);
        data = new StudentData("raj", 28);
        studentDataList.add(data);
        data = new StudentData("amar", 15);
        studentDataList.add(data);
        data = new StudentData("bapu", 19);
        studentDataList.add(data);
        data = new StudentData("chandra", 52);
        studentDataList.add(data);
        data = new StudentData("deraj", 30);
        studentDataList.add(data);
        data = new StudentData("eshanth", 28);
        studentDataList.add(data);
        data = new StudentData("sai raj", 25);
        studentDataList.add(data);
        data = new StudentData("raghu", 20);
        studentDataList.add(data);
        data = new StudentData("raj", 28);
        studentDataList.add(data);
        data = new StudentData("amar", 15);
        studentDataList.add(data);
        data = new StudentData("bapu", 19);
        studentDataList.add(data);
        data = new StudentData("chandra", 52);
        studentDataList.add(data);
        data = new StudentData("deraj", 30);
        studentDataList.add(data);
        data = new StudentData("eshanth", 28);
        studentDataList.add(data);

//        Collections.sort(studentDataList, new Comparator() {
//
//            @Override
//            public int compare(StudentData o1, StudentData o2) {
//                return o1.name.compareTo(o2.name);
//            }
//        });
    }
}
