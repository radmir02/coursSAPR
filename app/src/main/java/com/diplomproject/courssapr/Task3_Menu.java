package com.diplomproject.courssapr;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Task3_Menu extends AppCompatActivity {
    String selectedLA;String selectedFS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3__menu);
        Intent intent = getIntent();
        selectedLA = intent.getStringExtra("la");
        selectedFS = intent.getStringExtra("fs");
    }

//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            setContentView(R.layout.activity_task3__menu);
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    public void onClick1(View view) {
        Intent intent = new Intent(this, Task3_1.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
            Intent intent = new Intent(this, ObledActivity.class);
            intent.putExtra("la", selectedLA);
            intent.putExtra("fs", selectedFS);
            startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent = new Intent(this, Buksirovka.class);
        intent.putExtra("la", selectedLA);
        intent.putExtra("fs", selectedFS);
        startActivity(intent);

    }
}
