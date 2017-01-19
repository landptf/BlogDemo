package com.landptf.blog.activitylifecycle;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.landptf.blog.BaseActivity;
import com.landptf.blog.R;
import com.landptf.view.ButtonM;

public class ActivityB extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
//        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        initView();
    }

    private void initView() {
        ButtonM btmStartActivity = (ButtonM) findViewById(R.id.btm_start_activity);
        if (btmStartActivity != null) {
            btmStartActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ActivityB.this, ActivityA.class));
                }
            });
        }
    }
}
