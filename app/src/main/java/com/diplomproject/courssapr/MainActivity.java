package com.diplomproject.courssapr;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner laSpin;
    Spinner fsSpin;
    String[] la = {"Ил-96", "Ил-86", "Ил-62", "Ту-154",  "Ту-134", "Як-42", "Як-40", "Ан-24",
            "Ми-10", "Ми-8", "Ми-6", "Ми-2", "Ми-26", "Ка-26", "Ка-32", "Другие"};
    String[] fs = {"Кондиционирования", "Управления РВ", "Управления РН", "Управления элеронами",
            "Гидравлическая (уборки-выпуска шасси)", "Гидравлическая (управления передней ногой)",
            "Гидравлическая (торможения)", "Топливная", "Масляная", "Другие"};
    String selectedLA;
    String selectedFS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        laSpin = findViewById(R.id.laSpin);
        fsSpin = findViewById(R.id.fsSpin);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Информация");
        builder.setMessage("Выберите тип летательного аппарата и функциональной системы");
        builder.setPositiveButton("OK", null);
        builder.show();


        laSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                selectedLA = la[selectedItemPosition];
                Log.d("myTag", "selectedLA = " + selectedLA);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        fsSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                selectedFS = fs[selectedItemPosition];
                Log.d("myTag", "selectedFS = " + selectedFS);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void onResume() {
        super.onResume();
        fillSpinner();
    }

    public void fillSpinner() {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, la);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        laSpin.setAdapter(spinnerArrayAdapter);

        spinnerArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, fs);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fsSpin.setAdapter(spinnerArrayAdapter);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, activity_menu.class);
        intent.putExtra("la", selectedLA);
        intent.putExtra("fs", selectedFS);
        startActivity(intent);
    }
}
