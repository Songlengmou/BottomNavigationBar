package com.example.administrator.bottomnavigationbar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.bottomnavigationbar.Manager.BaseFragment;
import com.example.administrator.bottomnavigationbar.activity.MainActivity;
import com.example.administrator.bottomnavigationbar.fragment.FourFragment;
import com.example.administrator.bottomnavigationbar.fragment.OneFragment;
import com.example.administrator.bottomnavigationbar.fragment.ThreeFragment;
import com.example.administrator.bottomnavigationbar.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeVpAdapter extends FragmentPagerAdapter {
    private MainActivity activity;
    private int count = 0;
    private List<BaseFragment> fragments = new ArrayList<>();

    public HomeVpAdapter(FragmentManager fm, MainActivity activity) {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        //TODO 根据position 展示fragment  如果fragment的名字换了要换这个地方
        if (position == 0) {
            return new OneFragment();
        } else if (position == 1) {
            return new TwoFragment();
        } else if (position == 2) {
            return new ThreeFragment();
        } else {
            return new FourFragment();
        }
//          return fragments.get(position);
    }

    @Override
    public int getCount() {
        //TODO 如果再次添加fragment的话 这里的size需要更改
        return 4;
    }
}
