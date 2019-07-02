package com.liupengfei.plugin.testmotionlayout.utils;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/6/20 17:39
 */
public class FollowBehavior extends CoordinatorLayout.Behavior<TextView> {

    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX() + 150);
        child.setY(dependency.getY() + 150);
        return true;
    }
}
