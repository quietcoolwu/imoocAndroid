package com.example.test921;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import android.widget.AbsListView.OnScrollListener;

public class MyActivity extends Activity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    /**
     * Called when the activity is first created.
     */

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView = (ListView) findViewById(R.id.listView);

        //1.新建适配器
        //ArrayAdapter三个参数(上下文, 当前listview加载的每一个列表项所对应的布局文件, 加载数据源)
        //2.适配器加载数据源
        String[] arrayData = {"imooc1", "imooc2", "imooc3", "imooc4"};
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayData);

        /*
        simpleadapter五个参数(上下文; data数据源(泛型集合); )
        context:上下文
        data类型:(List<? extends Map<String, ?>> data)一个Map所组成的List集合
        每一个Map都会去对应ListView列表中的一行
        每个Map(键值对)中的键必须包含所有在from中所指定的键

        resource:列表项的布局文件

        from:Map中的名

        to:绑定数据视图中的ID,与from 成对应关系
         */

        dataList = new ArrayList<Map<String, Object>>();
        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic", "textView"}, new int[]{R.id.pic, R.id.textView});

        //3.使用视图加载适配器
        //listView.setAdapter(arrayAdapter);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }


    private List<Map<String, Object>> getData() {

        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", R.drawable.ic_launcher);
            map.put("textView", "imooc num" + i);
            dataList.add(map);
        }
        return dataList;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String text = listView.getItemAtPosition(position) + "";
        Toast.makeText(this, "position= " + position + "text= " + text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        switch (scrollState) {
            case SCROLL_STATE_FLING:
                Log.i("Main", "用户在手指离开屏幕之前,视图依靠惯性滑动");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("pic", R.drawable.ic_launcher);
                map.put("text", "增加项");
                dataList.add(map);
                simpleAdapter.notifyDataSetChanged();
                break;
            case SCROLL_STATE_IDLE:
                Log.i("Main", "视图停止滑动");
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                Log.i("Main", "手指没有离开屏幕,视图正在滑动");
                break;
        }


    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
