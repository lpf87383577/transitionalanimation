package com.liupengfei.plugin.testmotionlayout;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TransitionManagerGoActivity extends AppCompatActivity {

    int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindData();

    }

    private void bindData() {

        findViewById(R.id.iv1).setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                ViewGroup vg = findViewById(R.id.root);

                Scene sceneStart = Scene.getSceneForLayout(vg,R.layout.go_start,TransitionManagerGoActivity.this);

                Scene sceneEnd = Scene.getSceneForLayout(vg,R.layout.go_end,TransitionManagerGoActivity.this);

                if (type==1){

                    TransitionManager.go(sceneEnd,new ChangeBounds());


                    type=2;

                }else {

                    TransitionManager.go(sceneStart,new ChangeBounds());

                    type=1;
                }
                bindData();
            }
        });

        ((TextView)findViewById(R.id.tv)).setText("你好");

    }
}
