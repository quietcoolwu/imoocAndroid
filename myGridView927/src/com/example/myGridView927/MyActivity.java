package com.example.myGridView927;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyActivity extends Activity implements AdapterView.OnItemClickListener {
    String[] iconName = {"联系人", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置",
            "语音", "天气", "浏览器", "Youtube"};
    /**
     * Called when the activity is first created.
     */

    private GridView gridView;
    private List<Map<String, Object>> datalist;
    private int[] icon = {R.drawable.address_book, R.drawable.calendar,
            R.drawable.camera, R.drawable.clock, R.drawable.games_control,
            R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
            R.drawable.speech_balloon, R.drawable.weather,
            R.drawable.world, R.drawable.youtube};
    private SimpleAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView) findViewById(R.id.gridView);

        /*
        1.准备数据源
        2.新建适配器
        3.GridView加载适配器
        4.GridView配置时间监听器(OnItemClickListener)
         */
        datalist = new ArrayList<Map<String, Object>>();

        //getData(); 此处不注释会显示两次,为什么?
        adapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"imageView", "textView"}, new int[]{R.id.imageView, R.id.textView});

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);

    }

    private List<Map<String, Object>> getData() {

        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("imageView", icon[i]);
            map.put("textView", iconName[i]);
            datalist.add(map);
        }


        return datalist;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "我是" + iconName[position], Toast.LENGTH_SHORT).show();
    }
}
