package com.diplomproject.courssapr;


import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Task1 extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    ImageView iv1;
    ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        tv1 = findViewById(R.id.idTextView_1);
        tv2 = findViewById(R.id.idTextView_2);
        tv3 = findViewById(R.id.idTextView_3);
        tv4 = findViewById(R.id.idTextView_4);
        tv5 = findViewById(R.id.idTextView_5);
        tv6 = findViewById(R.id.idTextView_6);
        iv1 = findViewById(R.id.idImageView_1);
        iv2 = findViewById(R.id.idImageView_2);

        iv1.setImageResource(R.drawable.diagram);
        iv2.setImageResource(R.drawable.algorithm);

        tv1.setText("Поиск и устранение неисправностей ");
        tv2.setText("\t\t\t Решение на поиск и устранение неисправности и обуславливающих их появление дефектов" +
                " принимается после разработки технического решения (ТР) и технического задания (ТЗ). " +
                "На основании ТР, разрабатывается ТЗ, определяющее технологию выполнения работ, " +
                "предусмотренных в ТР. Кроме того, в ТЗ формулируется предложения " +
                "по дальнейшим продолжении работ на объекте после выявления причин неисправности и их устранения.");
        tv3.setText("Выявление наиболее часто встречающихся видов неисправностей");
        tv4.setText("\t\t\t Необходимо прежде всего изучить конструкцию, " +
                "принцип работы, технические характеристики заданной системы и ее элементов " +
                "и необходимую техническую документацию. " +
                "Основными источниками являются технические описания летательного аппарата, " +
                "инструкции по эксплуатации и техническому обслуживанию и т.д. " +
                "Анализ данных заключается в установлении распределения отказов " +
                "и неисправностей по системам, узлам, агрегатам, " +
                "видам (трещины, износ, негерметичность) и классификационным группам.");
        tv5.setText("Исследование причин возникновения неисправности (отказа)");
        tv6.setText("\t\t\t Предварительное ознакомление с объектом исследования заключается в " +
                "установлении времени, места, обстоятельств, при которых произошла неисправность, " +
                "условий эксплуатации и наработки детали в часах (полетах, посадках). " +
                "На основании изучения полученных сведений делается предположение " +
                "о возможных причинах появления дефекта и составляется план проведения исследования." +
                "\n\n" +
                "\t\t\t Анализ внешнего состояния производится с целью установления " +
                "внешних признаков, которые могли послужить причинами появления неисправности. " +
                "Для этого необходимо иметь дефектную деталь или ее фотографию " +
                "с подробным описанием места расположения и характера неисправности." +
                "\n\n" +
                "\t\t\t Анализ условий работы детали включает в себя изучение эксплуатационных, " +
                "производственно-технологических и конструктивных факторов с точки " +
                "зрения оценки их влияния на условия нагружения детали и возможности появления перегрузки." +
                "\n\n" +
                "\t\t\t Анализ данных статистической обработки патока неисправностей производится в случаях, " +
                "когда неисправность имеет массовый характер. " +
                "Он заключается в установлении закона распределения потока неисправности, " +
                "знание которого, позволяют высказать предположительно причину возникновения неисправности.");
    }
}