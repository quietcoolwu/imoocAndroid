package com.example.ActivityDemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by William on 2015/9/12.
 */
public class FActivity extends Activity {
    //bt1初始化
    private Button bt1;
    private Button bt2;
    private Context mContext;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);

        mContext = this;
        tv = (TextView) findViewById(R.id.textView);
        /*
        通过bt1实现页面间跳转
        1.startActivity方式实现
         */
        bt1 = (Button) findViewById(R.id.button1_first);
        bt2 = (Button) findViewById(R.id.button2_second);
        //注册点击事件
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                1.初始化Intent
                第一个参数:上下文对象this
                第二个参数:目标文件
                 */
                Intent intent = new Intent(mContext, SActivity.class);
                startActivity(intent);
            }
        });

        /*
        通过startActivityforResult,又返回数据跳转,两种参数搭配
         */
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SActivity.class);
                /*
                返回结果的Intent跳转
                参数一:Intent对象
                参数二:请求标识
                 */
                startActivityForResult(intent, 1);
            }
        });
    }


    /*
    通过startActivotyForResult跳转,接收返回数据的方法
    requestCode:请求的标识,通过标志接收不同的返回数据
    resultcode:第二个页面返回的标志
    data:第二个页面回传的数据
    双向确立方向
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && requestCode == 2) {
            String content = data.getStringExtra("data");
            tv.setText(content);
        }


    }
}
