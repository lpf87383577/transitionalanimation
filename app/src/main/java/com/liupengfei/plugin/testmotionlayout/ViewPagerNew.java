package com.liupengfei.plugin.testmotionlayout;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;

import com.liupengfei.plugin.testmotionlayout.fragment.BaseFragmentAdapter;
import com.liupengfei.plugin.testmotionlayout.fragment.ListFragment;


import java.util.ArrayList;
import java.util.List;

public class ViewPagerNew extends AppCompatActivity {

    ViewPager mViewPager;
    List<Fragment> mFragments;
    AppBarLayout mAppBarLayout;
    View mView;

    String[] mTitles = new String[]{
            "主页", "微博", "相册"
    };

    View ll_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_new);
        mView = findViewById(R.id.view);
        ll_content = findViewById(R.id.ll_content);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBar);

        setupViewPager();
    }


    private void setupViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            ListFragment listFragment = ListFragment.newInstance(mTitles[i]);
            mFragments.add(listFragment);
        }
        BaseFragmentAdapter adapter =
                new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, mTitles);


        viewPager.setAdapter(adapter);
    }
}
