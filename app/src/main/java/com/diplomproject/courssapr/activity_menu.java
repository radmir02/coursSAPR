package com.diplomproject.courssapr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class activity_menu extends AppCompatActivity {
    String selectedLA;String selectedFS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
       Intent intent = getIntent();

      selectedLA = intent.getStringExtra("la");
        selectedFS = intent.getStringExtra("fs");
    }


    public void onClick1(View view) {
        Intent intent = new Intent(this, Task1.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, Task2.class);
        startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent = new Intent(this, Task3_Menu.class);
        intent.putExtra("la", selectedLA);
        intent.putExtra("fs", selectedFS);
        startActivity(intent);
    }

//    public void onClick4(View view) {
//        Intent intent = new Intent(this, ObledActivity.class);
//        intent.putExtra("la", selectedLA);
//        intent.putExtra("fs", selectedFS);
//        startActivity(intent);
//    }
}