package com.liupengfei.plugin.testmotionlayout;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class ConstraintSetActivity extends AppCompatActivity implements View.OnClickListener {

    boolean boogle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_start);

        findViewById(R.id.v1).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        ConstraintLayout root = findViewById(R.id.root);

        TransitionManager.beginDelayedTransition(root);

        ConstraintSet constraintSet = new ConstraintSet();

        //根据标识克隆布局
        if (boogle){
            constraintSet.clone(this,R.layout.activity_main3_start);

        }else {
            constraintSet.clone(this,R.layout.activity_main3_end);

        }
        constraintSet.applyTo(root);

        boogle = !boogle;
    }
}
