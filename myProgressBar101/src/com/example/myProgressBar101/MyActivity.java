package com.example.myProgressBar101;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */

    private ProgressBar progressBar;
    private Button add;
    private Button reduce;
    private Button reset;
    private TextView textView;
    private ProgressDialog progressDialog;
    private Button show;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //启用窗口特征,启用带进度和不带进度的
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        setContentView(R.layout.main);

        //显示两种进度条
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(false);
        //进度条满值10000
        setProgress(9999);

        init();
    }

    private void init() {

        progressBar = (ProgressBar) findViewById(R.id.progressBar4);
        add = (Button) findViewById(R.id.add);
        reduce = (Button) findViewById(R.id.reduce);
        reset = (Button) findViewById(R.id.reset);
        textView = (TextView) findViewById(R.id.textView);
        show = (Button) findViewById(R.id.show);
        show.setOnClickListener(this);


        //getProgress方法第一进度第二进度最大进度
        int first = progressBar.getProgress();
        int second = progressBar.getSecondaryProgress();
        int max = progressBar.getMax();
        //整形相除可能为0先浮点强转,x100后化整
        textView.setText("第一进度百分比: " + (int) (first / (float) max * 100) + "% 第二进度百分比: " + (int) (second / (float) max * 100) + "%");

        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add: {
                //增加第一进度和第二进度10个刻度
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(10);
                break;
            }

            case R.id.reduce: {
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-10);
                break;
            }

            case R.id.reset: {
                progressBar.setProgress(50);
                progressBar.setSecondaryProgress(80);

                break;
            }

            case R.id.show: {
                /*
                progressdialog的基础页面显示风格
                what?
                 */
                //新建progressdialog对象
                progressDialog = new ProgressDialog(MyActivity.this);
                //设置显示风格
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //设置标题
                progressDialog.setTitle("imooc");
                //设置对话框文字信息
                progressDialog.setMessage("Welcome to imooc!");
                //设置图标
                progressDialog.setIcon(R.drawable.ic_launcher);

                /**
                 * 设定关于进度条的属性
                 */

                progressDialog.setMax(100);
                //设定初始化已经有的进度
                progressDialog.incrementProgressBy(progressBar.getProgress());
                //指定进度条明确显示进度
                progressDialog.setIndeterminate(false);


                /**
                 * 设定确定按钮
                 * 1.whichbutton
                 * 2.确定按钮的文字显示内容
                 * 3.确认点击事件的监听器
                 */

                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MyActivity.this, "欢迎大家支持慕课网", Toast.LENGTH_SHORT).show();
                    }
                });

                //是否可以通过返回按钮推出对话框
                progressDialog.setCancelable(true);

                //显示progressdialog
                progressDialog.show();

                break;
            }

        }

        textView.setText("第一进度百分比: " + (int) (progressBar.getProgress() / (float) progressBar.getMax() * 100) + "% 第二进度百分比: " + (int) (progressBar.getSecondaryProgress() / (float) progressBar.getMax() * 100) + "%");
    }
}
