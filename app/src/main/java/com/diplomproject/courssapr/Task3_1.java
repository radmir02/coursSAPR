package com.diplomproject.courssapr;


import android.content.Intent;
import android.icu.number.Precision;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Task3_1 extends AppCompatActivity {
    RadioGroup rg;

    LinearLayout ll1;
    LinearLayout ll2;
    LinearLayout ll3;
    LinearLayout ll4;
    LinearLayout ll5;

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    TextView q_god_1;
    TextView q_god_2;
    TextView q_ch_pik;

    TextView k_tz60;
    TextView k_tz22;
    TextView k_tz7;
    TextView v_tz60;
    TextView v_tz22;
    TextView v_tz7;
    EditText t_tz60;
    EditText t_tz22;
    EditText t_tz7;
    TextView q_tz60;
    TextView q_tz22;
    TextView q_tz7;
    TextView n_potr_tz60;
    TextView n_potr_tz22;
    TextView n_potr_tz7;
    TextView n_potr;

    TextView tv_lamdba;
    TextView tv_k0;
    TextView tv_ktg;
    TextView tv_tc;
    TextView n_za;

    EditText et_m;
    EditText et_q_tr;
    TextView tv_nu;
    TextView tv_t_vsp;
    TextView t_zan;
    TextView tv_q_tz;

    double q_ch;
    double q_tz;
    double t_vsp;
    double nu;
    int airport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3_1);

        rg = findViewById(R.id.idRGroup);

        ll1 = findViewById(R.id.idLL_1);
        ll2 = findViewById(R.id.idLL_2);
        ll3 = findViewById(R.id.idLL_3);
        ll4 = findViewById(R.id.idLL_4);
        ll5 = findViewById(R.id.idLL_5);

        tv1 = findViewById(R.id.idTextView_1);
        tv2 = findViewById(R.id.idTextView_2);
        tv3 = findViewById(R.id.idTextView_3);
        tv4 = findViewById(R.id.idTextView_4);

        q_god_1 = findViewById(R.id.idTextView_Qgod_1);
        q_god_2 = findViewById(R.id.idTextView_Qgod_2);
        q_ch_pik = findViewById(R.id.idTextView_Qch);

        k_tz60 = findViewById(R.id.idTextView_tz60_0);
        k_tz22 = findViewById(R.id.idTextView_tz22_0);
        k_tz7 = findViewById(R.id.idTextView_tz7_0);
        v_tz60 = findViewById(R.id.idTextView_tz60_1);
        v_tz22 = findViewById(R.id.idTextView_tz22_1);
        v_tz7 = findViewById(R.id.idTextView_tz7_1);
        t_tz60 = findViewById(R.id.idEditText_tz60_2);
        t_tz22 = findViewById(R.id.idEditText_tz22_2);
        t_tz7 = findViewById(R.id.idEditText_tz7_2);
        q_tz60 = findViewById(R.id.idTextView_tz60_3);
        q_tz22 = findViewById(R.id.idTextView_tz22_3);
        q_tz7 = findViewById(R.id.idTextView_tz7_3);
        n_potr_tz60 = findViewById(R.id.idTextView_tz60_4);
        n_potr_tz22 = findViewById(R.id.idTextView_tz22_4);
        n_potr_tz7 = findViewById(R.id.idTextView_tz7_4);
        n_potr = findViewById(R.id.idTextView_Npotr);

        tv_lamdba = findViewById(R.id.idTextView_lambda);
        tv_k0 = findViewById(R.id.idTextView_k0);
        tv_ktg = findViewById(R.id.idTextView_Ktg);
        tv_tc = findViewById(R.id.idTextView_Tc);
        n_za = findViewById(R.id.idTextView_Nza);

        et_m = findViewById(R.id.idEditText_m);
        et_q_tr = findViewById(R.id.idEditText_Qtr);
        tv_nu = findViewById(R.id.idTextView_nu);
        tv_t_vsp = findViewById(R.id.idTextView_Tvsp);
        tv_q_tz = findViewById(R.id.idTextView_Qtz);
        t_zan = findViewById(R.id.idTextView_Tzan);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int min = 0, max = 0, c = 0;

                switch (checkedId) {
                    case R.id.idPB1:
                        min = 1095;
                        max = 1460;
                        airport = 1;
                        break;
                    case R.id.idPB2:
                        min = 730;
                        max = 1095;
                        airport = 2;
                        break;
                    case R.id.idPB3:
                        min = 365;
                        max = 730;
                        airport = 3;
                        break;
                    case R.id.idPB4:
                        min = 182;
                        max = 365;
                        airport = 4;
                        break;
                    case R.id.idPB5:
                        min = 110;
                        max = 182;
                        airport = 5;
                        break;
                    case R.id.idPB6:
                        min = 18;
                        max = 110;
                        airport = 6;
                        break;
                }

                c = (int) (Math.random()*((max - min) + 1)) + min;
                q_ch = roundAvoid(((c * 1.1 * 1.2) / (365 * 24)), 4);

                tv1.setVisibility(View.VISIBLE);
                ll1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll3.setVisibility(View.GONE);

                q_god_1.setText("[" + min + ";" + max + "]              ");
                q_god_2.setText("" + c);
                q_ch_pik.setText("" + q_ch);
            }
        });
    }

    public void onClick1(View view) {
        ll3.setVisibility(View.VISIBLE);

        double k60, k22, k7, v60, v22, v7, t60, t22, t7, q60, q22, q7;
        double n60, n22, n7, n;

        try {
            k60 = Float.parseFloat(k_tz60.getText().toString().replace(',', '.'));
            k22 = Float.parseFloat(k_tz22.getText().toString().replace(',', '.'));
            k7 = Float.parseFloat(k_tz7.getText().toString().replace(',', '.'));
            v60 = Float.parseFloat(v_tz60.getText().toString().replace(',', '.'));
            v22 = Float.parseFloat(v_tz22.getText().toString().replace(',', '.'));
            v7 = Float.parseFloat(v_tz7.getText().toString().replace(',', '.'));
            t60 = Float.parseFloat(t_tz60.getText().toString().replace(',', '.'));
            t22 = Float.parseFloat(t_tz22.getText().toString().replace(',', '.'));
            t7 = Float.parseFloat(t_tz7.getText().toString().replace(',', '.'));

            q60 = roundAvoid((v60 / t60), 4);
            q22 = roundAvoid((v22 / t22), 4);
            q7 = roundAvoid((v7 / t7), 4);
            q_tz = q60 + q22 + q7;
            q_tz60.setText("" + q60);
            q_tz22.setText("" + q22);
            q_tz7.setText("" + q7);

            n60 = roundAvoid(((k60 * q_ch) / (q60 * 0.85)), 4);
            n22 = roundAvoid(((k22 * q_ch) / (q22 * 0.85)), 4);
            n7 = roundAvoid(((k7 * q_ch) / (q7 * 0.85)), 4);
            n_potr_tz60.setText("" + n60);
            n_potr_tz22.setText("" + n22);
            n_potr_tz7.setText("" + n7);

            n = (n60 + n22 + n7) * 0.8;
            n = roundAvoid(n, 4);
            n_potr.setText("" + n);

            show1();
            show2();
        }catch (Exception e){
            Toast.makeText(this, "Что-то пошло не так", Toast.LENGTH_LONG);
        }
    }

    public void onClick2(View view) {
        double m, q_tr, t;

        try {
            m = Float.parseFloat(et_m.getText().toString().replace(',', '.'));
            q_tr = Float.parseFloat(et_q_tr.getText().toString().replace(',', '.'));

            t = (q_tr / (m * q_tz * nu)) + t_vsp;
            t = roundAvoid(t, 4);
            t_zan.setText("" + t);
        }catch (Exception e){
            Toast.makeText(this, "Что-то пошло не так", Toast.LENGTH_LONG);
        }

    }

    public void show1(){
        ll4.setVisibility(View.VISIBLE);
        tv3.setVisibility(View.VISIBLE);

        int lambda = 0, tc = 0;
        double k0, ktg, n;

        ktg = Float.parseFloat(tv_ktg.getText().toString().replace(',', '.'));

        lambda = (int) (Math.random()*((14 - 6) + 1)) + 6;
        if(lambda <= 10) k0 = (Math.random()*((1.5 - 1) + 1)) + 1;
        else k0 =  (Math.random()*((2 - 1.5) + 1)) + 1.5;
        k0 = roundAvoid(k0, 2);

        if(airport == 1)  tc = (int) (Math.random()*((40 - 35) + 1)) + 35;
        if(airport == 2 || airport == 3)  tc = (int) (Math.random()*((35 - 25) + 1)) + 25;
        if(airport == 4)  tc = (int) (Math.random()*((25 - 20) + 1)) + 20;
        if(airport == 5 || airport == 6)  tc = (int) (Math.random()*((20 - 15) + 1)) + 15;

        n = ((lambda * tc) / (60 * ktg)) * k0;
        n = roundAvoid(n, 4);

        tv_tc.setText(tc + "      ");
        tv_lamdba.setText("" + lambda);
        tv_k0.setText(k0 + "      ");
        n_za.setText("" + n);
    }

    public void show2(){
        ll5.setVisibility(View.VISIBLE);
        tv4.setVisibility(View.VISIBLE);

        nu = (Math.random()*((0.9 - 0.7) + 1)) + 0.7;
        nu = roundAvoid(nu, 2);
        t_vsp = (Math.random()*((3 - 1) + 1)) + 1;
        t_vsp = roundAvoid(t_vsp, 2);

        tv_nu.setText(nu + "   ");
        tv_t_vsp.setText(t_vsp + "   ");
        tv_q_tz.setText("" + q_tz);
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
