package com.talo.datechangedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView time;
    private Button btnDateDig, btnTimeDig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.txtTime);

        btnDateDig = findViewById(R.id.btnDateChange);  //日期
        btnDateDig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance(); //取得目前時間
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        datePickerDigOnDateSet,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.setTitle("選擇日期 ");
                datePickerDialog.setMessage("請選擇");
                datePickerDialog.setIcon(android.R.drawable.ic_dialog_info);
                datePickerDialog.setCancelable(false);
                datePickerDialog.show();
            }
        });

        btnTimeDig = findViewById(R.id.btnTimeChange);  //時間
        btnTimeDig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance(); //取得目前時間
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        timePickDigOnTimeSet,
                        calendar.get(Calendar.HOUR),
                        calendar.get(Calendar.MINUTE),
                        true);
                timePickerDialog.setTitle("選擇時間 ");
                timePickerDialog.setMessage("請選擇");
                timePickerDialog.setIcon(android.R.drawable.ic_dialog_info);
                timePickerDialog.setCancelable(false);
                timePickerDialog.show();
            }
        });
    }
    private DatePickerDialog.OnDateSetListener datePickerDigOnDateSet = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            time.setText("選擇日期 : " + String.valueOf(year) + " 年 " +
                    String.valueOf(month + 1) + " 月 " +
                    String.valueOf(dayOfMonth) + " 日 ");
        }
    };
    private TimePickerDialog.OnTimeSetListener timePickDigOnTimeSet = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            time.setText("選擇時間 : " + String.valueOf(hourOfDay) + " 時 " +
                    String.valueOf(minute) + " 分 ");
        }
    };
}