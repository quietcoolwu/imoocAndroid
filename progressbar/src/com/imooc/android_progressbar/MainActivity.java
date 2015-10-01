package com.imooc.android_progressbar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    private ProgressBar progress;
    private Button add;
    private Button reduce;
    private Button reset;
    private TextView text;
    private ProgressDialog prodialog;
    private Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 启用窗口特征，启用带进度和不带进度的进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.main);
        // 显示两种进度条
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(false);
        // Max=10000
        setProgress(9999);
        init();

    }

    private void init() {
        // TODO Auto-generated method stub
        progress = (ProgressBar) findViewById(R.id.horiz);
        add = (Button) findViewById(R.id.add);
        reduce = (Button) findViewById(R.id.reduce);
        reset = (Button) findViewById(R.id.reset);
        text = (TextView) findViewById(R.id.text);
        show = (Button) findViewById(R.id.show);
        show.setOnClickListener(this);
        // 获取第一进度条的进度
        int first = progress.getProgress();
        // 获取第二进度条的进度
        int second = progress.getSecondaryProgress();
        // 获取进度条的最大进度
        int max = progress.getMax();
        text.setText("第一进度百分比：" + (int) (first / (float) max * 100)
                + "% 第二进度百分比：" + (int) (second / (float) max * 100) + "%");
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.add: {
                // 增加第一进度和第二进度10个刻度
                progress.incrementProgressBy(10);
                progress.incrementSecondaryProgressBy(10);

                break;
            }

            case R.id.reduce: {
                // 减少第一进度和第二进度10个刻度
                progress.incrementProgressBy(-10);
                progress.incrementSecondaryProgressBy(-10);

                break;
            }
            case R.id.reset: {
                progress.setProgress(50);
                progress.setSecondaryProgress(80);
                break;
            }

            case R.id.show: {

                /**
                 * 页面显示风格
                 */
                //新建ProgressDialog对象
                prodialog = new ProgressDialog(MainActivity.this);
                //设置显示风格
                prodialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //设置标题
                prodialog.setTitle("幕课网");
                //设置对话框里的文字信息
                prodialog.setMessage("欢迎大家支持幕课网");
                //设置图标
                prodialog.setIcon(R.drawable.ic_launcher);

                /**
                 * 设定关于ProgressBar的一些属性
                 */
                //设定最大进度
                prodialog.setMax(100);
                //设定初始化已经增长到的进度
                prodialog.incrementProgressBy(50);
                //进度条是明确显示进度的
                prodialog.setIndeterminate(false);

                /**
                 * 设定一个确定按钮
                 */

                prodialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Toast.makeText(MainActivity.this, "欢迎大家支持幕课网", Toast.LENGTH_SHORT).show();
                    }
                });

                //是否可以通过返回按钮退出对话框
                prodialog.setCancelable(true);
                //显示ProgressDialog
                prodialog.show();

                break;
            }

        }
        text.setText("第一进度百分比：" + (int) (progress.getProgress() / (float) progress.getMax() * 100) + "% 第二进度百分比：" + (int) (progress.getSecondaryProgress() / (float) progress.getMax() * 100) + "%");

    }

}
