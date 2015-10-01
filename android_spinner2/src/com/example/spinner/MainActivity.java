package com.example.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private TextView myTextView;
    private Spinner mySpinner;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
        dataList = new ArrayList<Map<String, Object>>();
        getData();
        myTextView = (TextView) findViewById(R.id.textView);
        mySpinner = (Spinner) findViewById(R.id.spinner);
        // 第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter = new SimpleAdapter(this, dataList, R.layout.item, new String[]{"image", "text"}, new int[]{R.id.image, R.id.text});

        // 第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter.setDropDownViewResource(R.layout.item);
        // 第四步：将适配器添加到下拉列表上
        mySpinner.setAdapter(adapter);
        // 第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中

        mySpinner
                .setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        // TODO Auto-generated method stub
                        /* 将所选mySpinner 的值带入myTextView 中 */
                        myTextView.setText("您选择的是：" + adapter.getItem(arg2));
                    }

                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub
                        myTextView.setText("NONE");
                    }
                });

    }

    private void getData() {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("image", R.drawable.ic_launcher);
        map.put("text", "北京");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("image", R.drawable.ic_launcher);
        map2.put("text", "上海");
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("image", R.drawable.ic_launcher);
        map3.put("text", "广州");
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("image", R.drawable.ic_launcher);
        map4.put("text", "深圳");
        dataList.add(map);
        dataList.add(map2);
        dataList.add(map3);
        dataList.add(map4);
    }

}
