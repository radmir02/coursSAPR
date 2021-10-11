package com.diplomproject.courssapr;


import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Collections;

public class Task2 extends AppCompatActivity {
    EditText etL;
    EditText etS;
    GraphView graph;

    LineGraphSeries<DataPoint> series;
    float eps = (float) (3.6 * Math.pow(10, 5));
    float aTP = (float) (12 * Math.pow(10, -6));
    float aF = (float) (23 * Math.pow(10, -6));
    int t1 = 60;

    ArrayList<Float> P0;
    ArrayList<Float> B0;
    Float L;
    Float S;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        etL = findViewById(R.id.idEditText_1);
        etS = findViewById(R.id.idEditText_2);
        graph = findViewById(R.id.idGraphView);

        P0 = new ArrayList();
        B0 = new ArrayList();
    }

    public void onClick1(View view) {
        try {
            series = new LineGraphSeries<DataPoint>();
            graph.removeSeries(series);

            S = Float.parseFloat(etS.getText().toString());

            for (int t2 = -40; t2 <= 40; t2++) {
                Float currentP0 = S * eps * (aF - aTP) * (t2 - t1);
                P0.add(currentP0);
            }

            for (int j = 0; j < P0.size(); j++)
                series.appendData(new DataPoint(j, (Float) P0.get(j)), true, P0.size());

            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getViewport().setMaxY(Collections.max(P0) + 1);
            graph.getViewport().setMinY(Collections.min(P0) - 1);
            graph.getViewport().setMaxX(80);
            graph.getViewport().setMinX(0);
            graph.getGridLabelRenderer().setHorizontalLabelsVisible(true);
            graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
            series.setColor(Color.rgb(255, 0, 0));
            series.setThickness(6);
            graph.getViewport().setScrollable(true);
            graph.getViewport().setScrollableY(true);

            graph.addSeries(series);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Что-то пошло не так", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick2 (View view){
        try {
            graph.removeSeries(series);
            series = new LineGraphSeries<DataPoint>();

            L = Float.parseFloat(etL.getText().toString());

            int i = 0;
            for (int t2 = -40; t2 <= 40; t2++) {
                Float currentB0 = (L * P0.get(i)) / (S * eps);
                B0.add(currentB0);
                i++;
            }

            for (int j = 0; j < B0.size(); j++)
                series.appendData(new DataPoint(j, (Float) B0.get(j)), true, B0.size());

            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getViewport().setMaxY(Collections.max(B0) + 1);
            graph.getViewport().setMinY(Collections.min(B0) - 1);
            graph.getViewport().setMaxX(80);
            graph.getViewport().setMinX(0);
            graph.getGridLabelRenderer().setHorizontalLabelsVisible(true);
            graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
            series.setColor(Color.rgb(255, 0, 0));
            series.setThickness(6);
            graph.getViewport().setScrollable(true);
            graph.getViewport().setScrollableY(true);

            graph.addSeries(series);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Что-то пошло не так", Toast.LENGTH_SHORT).show();
        }
    }
}
