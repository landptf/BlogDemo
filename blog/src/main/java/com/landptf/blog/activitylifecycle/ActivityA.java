package com.landptf.blog.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.landptf.blog.BaseActivity;
import com.landptf.blog.R;
import com.landptf.view.ButtonM;

public class ActivityA extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        initView();
    }

    private void initView() {
        ButtonM btmStartActivity = (ButtonM) findViewById(R.id.btm_start_activity);
        if (btmStartActivity != null) {
            btmStartActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ActivityA.this, ActivityB.class));
                }
            });
        }
    }
}
