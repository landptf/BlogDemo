package com.landptf.blog;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(this.getClass().getSimpleName(), "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(this.getClass().getSimpleName(), "onStart()");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(this.getClass().getSimpleName(), "onNewIntent()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(this.getClass().getSimpleName(), "onRestoreInstanceState()");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(this.getClass().getSimpleName(), "onConfigurationChanged()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(this.getClass().getSimpleName(), "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(this.getClass().getSimpleName(), "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(this.getClass().getSimpleName(), "onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(this.getClass().getSimpleName(), "onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(this.getClass().getSimpleName(), "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(this.getClass().getSimpleName(), "onDestroy()");
    }
}
