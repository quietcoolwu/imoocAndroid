package com.example.mySpinner927;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity implements AdapterView.OnItemSelectedListener {
    /**
     * Called when the activity is first created.
     */
    private TextView textView;
    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);
        textView.setText("Hello User!");

        //1.设置数据源
        list = new ArrayList<String>();
        list.add("Beijing");
        list.add("Shanghai");
        list.add("Guangzhou");
        list.add("Shenzhen");


        //2.新建ArrayList(数组适配器)
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        //3.adapter设置下拉列表样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //4.给Spinenr加载适配器
        spinner.setAdapter(adapter);

        //5.借助监听器spinner
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String cityName = adapter.getItem(position);
        textView.setText("您选择的城市是:" + cityName);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
