package com.example.myDatetimePicker926;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private TimePicker timePicker;
    private DatePicker datePicker;
    private Calendar calendar;
    //what?
    private int year, month, day, hour, minute;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //获取日历对象
        calendar = Calendar.getInstance();
        //获取年月日及时间
        year = calendar.get(Calendar.YEAR);
        //month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        setTitle(year + "-" + calendar.get(Calendar.MONTH) + "-" + day + "-" + hour + ":" + minute);

        datePicker = (DatePicker) findViewById(R.id.datePicker);

        timePicker = (TimePicker) findViewById(R.id.timePicker);

        //datePicker初始化
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                setTitle(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth + "-" + hour + ":" + minute);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                setTitle(hourOfDay + ":" + minute);
            }
        });


//        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                setTitle(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
//
//            }
//        }, year, calendar.get(Calendar.MONTH), day).show();

        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                setTitle(hourOfDay + ":" + minute);
            }
        }, hour, calendar.get(Calendar.MINUTE), true).show();


    }
}
