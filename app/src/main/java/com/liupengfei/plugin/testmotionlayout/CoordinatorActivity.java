package com.liupengfei.plugin.testmotionlayout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liupengfei.plugin.testmotionlayout.utils.RvAdapter;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("唐嫣");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv = findViewById(R.id.recyclerView);

        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(new RvAdapter(this));



    }


    @Override
    protected void onResume() {
        super.onResume();
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }


}
