package com.liupengfei.plugin.testmotionlayout;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.TypedValue;


import com.liupengfei.plugin.testmotionlayout.utils.RvAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MyBehaviorActivity extends AppCompatActivity {

    private static RecyclerView recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_behavior_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerview=(RecyclerView)findViewById(R.id.behavior_demo_recycler);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new RvAdapter(this));

    }

    private void initView(){

    }

}
