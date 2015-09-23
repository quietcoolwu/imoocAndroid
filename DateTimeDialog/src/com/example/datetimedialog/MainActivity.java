package com.example.datetimedialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.os.Build;

public class MainActivity extends Activity implements android.view.View.OnClickListener{

	private Button date_button;
	private Button time_button;
	private Calendar calendar;
	private TextView tv_date;
	private TextView tv_time;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        date_button=(Button) findViewById(R.id.date_button);
        time_button=(Button) findViewById(R.id.time_button);
        tv_date=(TextView) findViewById(R.id.tv_date);
        tv_time=(TextView) findViewById(R.id.tv_time);
        date_button.setOnClickListener(this);
        time_button.setOnClickListener(this);
        //获取当前的年月日时分信息
        calendar=Calendar.getInstance();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void showDateDialog()
	{
		DatePickerDialog date_dialog=new DatePickerDialog(MainActivity.this, new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				tv_date.setText("现在日期："+year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
			}
		}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		
		date_dialog.show();
	}
	
	private void showTimeDialog()
	{
		TimePickerDialog time_dialog=new TimePickerDialog(MainActivity.this, new OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				tv_time.setText("现在时间："+hourOfDay+":"+minute);
			}
		}, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
		time_dialog.show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		  case R.id.date_button:
			  showDateDialog();
			  break;
		  case R.id.time_button:
			  showTimeDialog();
			  break;
		}
	}









}
