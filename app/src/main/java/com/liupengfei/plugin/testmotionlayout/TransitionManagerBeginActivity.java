package com.liupengfei.plugin.testmotionlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class TransitionManagerBeginActivity extends AppCompatActivity implements View.OnClickListener {

    View v1;
    View v2;
    View v3;

    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);

        v1.setOnClickListener(this);
        v2.setOnClickListener(this);
        v3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        TransitionManager.beginDelayedTransition((ViewGroup) view.getParent());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
        layoutParams.height *= 2;
        layoutParams.width *= 2;
        view.setLayoutParams(layoutParams);

        if (v !=null){

            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)v.getLayoutParams();
            layoutParams2.height  = layoutParams2.height / 2;
            layoutParams2.width = layoutParams2.width / 2;
            v.setLayoutParams(layoutParams2);
        }

        v = view;
    }
}
