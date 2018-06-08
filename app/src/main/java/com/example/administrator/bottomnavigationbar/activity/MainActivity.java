package com.example.administrator.bottomnavigationbar.activity;

import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.bottomnavigationbar.R;
import com.example.administrator.bottomnavigationbar.adapter.HomeVpAdapter;
import com.example.administrator.bottomnavigationbar.othersManger.RxActivity;

import butterknife.Bind;

public class MainActivity extends RxActivity {
    @Bind(R.id.vp)
    ViewPager mViewpager;
    @Bind(R.id.rg)
    RadioGroup mRadioGroup;
    @Bind(R.id.rb1)
    RadioButton rb1;
    @Bind(R.id.rb2)
    RadioButton rb2;
    @Bind(R.id.rb3)
    RadioButton rb3;
    @Bind(R.id.rb4)
    RadioButton rb4;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        final HomeVpAdapter vpAdapter = new HomeVpAdapter(getSupportFragmentManager(), this);
        mViewpager.setAdapter(vpAdapter);

        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //viewPager切换中 设置rg的显示
                ((RadioButton) mRadioGroup.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //设置RadioGroup的监听  点击的时候 可以切换fragment
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                // 根据点击的id  设置vp当前显示
                int pos;
                if (i == R.id.rb1) {
                    pos = 0;
                } else if (i == R.id.rb2) {
                    pos = 1;
                } else if (i == R.id.rb3) {
                    pos = 2;
                } else {
                    pos = 3;
                }
                mViewpager.setCurrentItem(pos);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
