package com.landptf.blog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.landptf.blog.activitylifecycle.ActivityA;
import com.landptf.view.ButtonM;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ButtonM btmActivityLifeCycle = (ButtonM) findViewById(R.id.btm_activity_life_cycle);
        if (btmActivityLifeCycle != null) {
            btmActivityLifeCycle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, ActivityA.class));
                }
            });
        }
    }
}
