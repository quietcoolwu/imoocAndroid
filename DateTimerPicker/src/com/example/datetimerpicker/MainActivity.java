package com.example.datetimerpicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.text.method.DateTimeKeyListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {

	private DatePicker date_picker;
	private TimePicker time_picker;
	private TextView tv_date;
	private TextView tv_time;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //初始化
        date_picker=(DatePicker) findViewById(R.id.date);
        time_picker=(TimePicker) findViewById(R.id.time);
        tv_date=(TextView) findViewById(R.id.tv_date);
        tv_time=(TextView) findViewById(R.id.tv_time);
        //获取当前的年月日时分信息
        Calendar c=Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        int hour=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);
        tv_date.setText("现在日期："+year+"-"+(month+1)+"-"+day);
        tv_time.setText("现在时间："+hour+":"+minute);
        //初始化日期
        date_picker.init(year, month, day, new OnDateChangedListener() {
			
			//监听日期的改变
        	@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				//Toast.makeText(MainActivity.this, "现在时间："+year+"-"+(monthOfYear+1)+"-"+dayOfMonth, 0).show();
			    tv_date.setText("现在日期："+year+"-"+(monthOfYear+1)+"-"+dayOfMonth);   
			}
		});
        
        //设置时间为24小时制
        time_picker.setIs24HourView(true);
        time_picker.setOnTimeChangedListener(new OnTimeChangedListener() {	
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				tv_time.setText("现在时间："+hourOfDay+":"+minute);
			}
		});
       
        
        
   
        
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
