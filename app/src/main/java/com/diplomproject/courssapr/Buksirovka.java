package com.diplomproject.courssapr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;



public class Buksirovka extends AppCompatActivity {
    String selectedLA;
    double Gla;
    double Ptyag, Pdv_potr,Pb_str,k,f,Dtr, Pc1, Pt1;
    double Gb=120.0,alfa;
    int Gt1;
    TextView diapK,diapF,text_k,text_f, znachGla, znachPtyag, znachP, znachDtr, znachPtyag2, Gt, Pc,Pt,vyvod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buksirovka);

        RadioButton betonRadioButton = findViewById(R.id.radio_beton);
        betonRadioButton.setOnClickListener(radioButtonClickListener);
        RadioButton gruntRadioButton = findViewById(R.id.radio_grunt);
        gruntRadioButton.setOnClickListener(radioButtonClickListener);
        diapF=findViewById(R.id.diapF);
        diapK=findViewById(R.id.diapK);
        text_k=findViewById(R.id.k);
        text_f=findViewById(R.id.f);
        znachGla=findViewById(R.id.znachGla);
        znachPtyag=findViewById(R.id.znachPtyag);
        znachPtyag2=findViewById(R.id.znachPtyag2);
        znachP=findViewById(R.id.znachP);
        znachDtr=findViewById(R.id.znachDtr);
        Gla=0;
        Ptyag=0;
        Gt=findViewById(R.id.Gt);
        Pc=findViewById(R.id.Pc);
        Pt=findViewById(R.id.Pt);
        vyvod=findViewById(R.id.vyvod);
        selectedLA= (String) getIntent().getSerializableExtra("la");
        Log.i("myTag", selectedLA );
        switch (selectedLA){
            case("Як-40"):
                Gla=16.8;
                Ptyag=14.4;
                break;
            case("Як-42"):
                Gla=48;
                Ptyag=42;
                break;
            case("Ан-24"):
                Gla=21;
                Ptyag=18.5;
                break;
            case("Ан-12"):
                Gla=61;
                Ptyag=53;
                break;
            case("Ту-134"):
                Gla=47;
                Ptyag=40;
                break;
            case("Ту-154"):
                Gla=90;
                Ptyag=78;
                break;
            case("Ил-62"):
                Gla=165;
                Ptyag=143;
                break;
            case("Ил-86"):
                Gla=193;
                Ptyag=168;
                break;
            default:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Информации по выбранному ЛА недостаточно для буксировки", Toast.LENGTH_SHORT);
                toast.show();
                //LinearLayout glavnaya=findViewById(R.id.glavnaya);
                //glavnaya.setVisibility(View.INVISIBLE);
                this.finish();
                break;
        }

        znachGla.setText(new Double(Gla).toString());
        znachPtyag.setText(new Double(Ptyag).toString());
        CheckBox checkBox=findViewById(R.id.checkBox);
        LinearLayout linearHard=findViewById(R.id.linearHard);
        linearHard.setVisibility(View.INVISIBLE);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked()) {
                    Log.i("myTag", "checked" );
                    linearHard.setVisibility(View.VISIBLE);;
                }
                else {
                    Log.i("myTag", "unchecked" );
                    linearHard.setVisibility(View.INVISIBLE);;
                }
            }
        });
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;

            switch (rb.getId()) {
                case R.id.radio_beton:
                    Log.i("myTag", "beton" );
                    diapK.setText("1,1..1,2");
                    diapF.setText("0,04..0,06");
                    k=(Math.random() * ( 1.2 -1.1 )) + 1.1;
                    f=(Math.random() * ( 0.06 -0.04 )) + 0.04;
                    break;
                case R.id.radio_grunt:
                    Log.i("myTag", "grunt" );
                    diapK.setText("1,5..1,7");
                    diapF.setText("0,08..0,11");
                    k= (Math.random() * ( 1.7 - 1.5)) + 1.5;
                    f=(Math.random() * ( 0.11 -0.08 )) + 0.08;
                    break;
                default:
                    break;
            }

            text_k.setText(String.format("%.3f",k));
            text_f.setText(String.format("%.3f",f));
            Pdv_potr=k*f*Gla;
            Pb_str=Pdv_potr;
            znachP.setText(String.format("%.2f",Pdv_potr));
            alfa=3;
            Log.i("myTag", String.valueOf(Math.cos(Math.toRadians(alfa))));
            Dtr=Math.pow((6*Pb_str*4)/(2*Math.cos(Math.toRadians(alfa))*0.85*Math.PI*Gb),0.5)*10;
            znachDtr.setText(String.format("%.3f мм",Dtr));
        }
    };

    public void rasschet(View view) {
        try {
            double ugol = Double.parseDouble(((EditText) findViewById(R.id.editTextNumberDecimal3)).getText().toString());
            double koef = Double.parseDouble(((EditText) findViewById(R.id.editTextNumberDecimal)).getText().toString());
            Log.i("myTag", ugol+" "+koef);
            Ptyag=Gla*(9.81*(koef*Math.cos(Math.toRadians(ugol))+Math.sin(Math.toRadians(ugol)))+0.104);
            znachPtyag2.setText(String.format("%.3f кН",Ptyag));
        }catch(Exception e){
            Log.i("myTag", "uuups");
        }

    }
    public void rasschet_Pt(View view) {
        Gt1= (int) ((Math.random() * ( 200 - 15)) + 15);//в кг
        Log.i("myTag", " "+Gt1);
        Pc1=Gt1*9.81*0.025*Math.cos((Math.toRadians(3)))+Gt1*9.81*Math.sin((Math.toRadians(3)));
        Pt1=71.650-Pc1;

        Log.i("myTag", "pt "+Pt1);
        Log.i("myTag", "pc "+Pc1);
        Gt.setText(""+Gt1+" т");
        Pc.setText(""+String.format("%.2f кН",Pc1));
        Pt.setText(String.format("%.2f кН",Pt1));
        if(Pt1>Ptyag){
            vyvod.setText("Буксировка возможна");
        }
        else vyvod.setText("Буксировка не возможна, т.к. Рт<Ртяг");
    }

}