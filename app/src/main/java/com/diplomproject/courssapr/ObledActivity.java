package com.diplomproject.courssapr;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ObledActivity extends AppCompatActivity {
    String selectedLA;String selectedFS;float tol;
    int qp,temp,Qpl;
    int count,time;
    Boolean mainFlag=false;
    int T;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z32);
        Intent intent = getIntent();

        selectedLA = intent.getStringExtra("la");
        selectedFS = intent.getStringExtra("fs");
    }
    public void onClickR1(View view) {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        // Найдём переключатель по его id
        RadioButton myRadioButton = findViewById(checkedRadioButtonId);
        String type=myRadioButton.getText().toString();

        EditText editText1=findViewById(R.id.ed1);
        EditText editText2=findViewById(R.id.ed2);
        Boolean flag1=false,flag2=false;
        if (!editText1.getText().toString().equals(""))
        {
            editText1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            try{  tol=Float.valueOf(editText1.getText().toString());if(tol>=0.5&&tol<=5)flag1=true; else
            {editText1.setBackgroundColor(Color.parseColor("#FFA07A"));
            };}
            catch(NumberFormatException e){editText1.setBackgroundColor(Color.parseColor("#FFA07A"));}
        }
        else
        {editText1.setBackgroundColor(Color.parseColor("#FFA07A"));
        }
        if (!editText2.getText().toString().equals(""))
        {
            editText2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            try{   temp=Integer.parseInt(editText2.getText().toString());
                ;
                if(temp<=-2&&temp>=-10){flag2=true;
                }
                else
                {editText2.setBackgroundColor(Color.parseColor("#FFA07A"));
                }

            }
            catch(NumberFormatException e){editText2.setBackgroundColor(Color.parseColor("#FFA07A"));}
        }
        else
        {editText2.setBackgroundColor(Color.parseColor("#FFA07A"));
        }
        int S;

        if(flag1&&flag2) {switch (selectedLA) {
            case  ("Ил-96"):
                S=2100;
                break;
            case ("Ил-86"):
                S=1800;
                break;
            case ("Ил-62"):
                S=1250;
                break;
            case ("Ту-204"):
                S=950;
                break;
            case ("Як-42"):
                S=750;
                break;
            case ("Ту-154"):
                S=1000;
                break;
            case ("Ту-134"):
                S=620;
                break;
            case ("Ан-24"):
                S=950;
                break;

            default:
                S=400;
                break;
        }
            float vl=S*tol;
            if (type.equals("МП-85")) qp=1475;else qp=5000;
            T= (int) (vl*0.9*(0.54*temp+80)/((1-0.7)*qp));
            System.out.println(T);
            TextView tvl=findViewById(R.id.vl);
            tvl.setText("="+vl);
            TextView ttl=findViewById(R.id.tl);
            ttl.setText("="+temp);
            TextView tq=findViewById(R.id.q);
            tq.setText("="+qp);
            TextView tqp=findViewById(R.id.qp);
            Qpl= (int) (vl*0.9*(0.54*temp+80));
            tqp.setText("="+Qpl);
            TextView tTobr=findViewById((R.id.Tob));
            tTobr.setText("="+T);
            mainFlag=true;

        }

    }

    public void onClickR2(View view) {
        if(mainFlag){
            EditText editText3=findViewById(R.id.ed3);
            EditText editText4=findViewById(R.id.ed4);
            Boolean flag3=false,flag4=false;

            if (!editText3.getText().toString().equals(""))
            {
                editText3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                try{  count=Integer.parseInt(editText3.getText().toString());if(count>=6&&count<=12)flag3=true; else
                {editText3.setBackgroundColor(Color.parseColor("#FFA07A"));
                };}
                catch(NumberFormatException e){editText3.setBackgroundColor(Color.parseColor("#FFA07A"));}
            }
            else
            {editText3.setBackgroundColor(Color.parseColor("#FFA07A"));
            }
            if (!editText4.getText().toString().equals(""))
            {
                editText4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                try{   time=Integer.parseInt(editText4.getText().toString());
                    flag4=true;


                }
                catch(NumberFormatException e){editText4.setBackgroundColor(Color.parseColor("#FFA07A"));}
            }
            else
            {editText4.setBackgroundColor(Color.parseColor("#FFA07A"));
            }
            int Npod;
            Npod=(int) (count*Qpl*60/(0.3*qp*time));
            System.out.println(Npod);
            TextView Nla=findViewById(R.id.Nla);
            Nla.setText("="+count);
            TextView Ttr=findViewById(R.id.Ttr);
            Ttr.setText("="+time);
            TextView Npr=findViewById(R.id.Npr);
            Npr.setText("="+Npod);
            TextView Q2=findViewById(R.id.q2);
            Q2.setText("="+qp);
            TextView Qp2=findViewById(R.id.Qpl2);
            Qp2.setText("="+Qpl);}
        else {Toast.makeText(getApplicationContext(),"Выполните расчеты в пункте 1",Toast.LENGTH_SHORT).show();}

    }

}