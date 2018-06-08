package com.example.administrator.bottomnavigationbar.othersManger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();

        setContentView(getLayoutResource());
        mContext = this;
        ButterKnife.bind(this);
        initViews(savedInstanceState);
        loadData();
    }

    /**
     * 初始化变量，包括Intent带的数据和activity内的变量
     */
    protected void initVariables() {

    }

    /**
     * 加载layout布局文件
     */
    protected abstract int getLayoutResource();

    /**
     * 初始化控件，设置控件事件
     *
     * @param savedInstanceState
     */
    protected abstract void initViews(Bundle savedInstanceState);

    /**
     * 调用api获取数据
     */
    protected abstract void loadData();


    protected String getName() {
        return BaseActivity.class.getName();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    //------------------------------------------------------------------

    /**
     * 回退事件
     *
     * @param v
     */
    public void onBack(View v) {
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


    /**
     * Toast提示信息的方法
     */
    public static void toastShow(final Activity activity, final String message) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
