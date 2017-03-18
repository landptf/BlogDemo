package com.landptf.blog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.landptf.blog.splash.SplashFragment;

/**
 * Created by landptf on 2017/03/18.
 * 主页面，包含了SplashFragment和MainFragment
 */
public class MainActivity extends AppCompatActivity {

    private FragmentManager frManager;
    private SplashFragment fmSplash;
    private MainFragment fmMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        frManager = getSupportFragmentManager();
        fmSplash = (SplashFragment) frManager.findFragmentById(R.id.fm_splash);
        fmMain = (MainFragment) frManager.findFragmentById(R.id.fm_main);
        showSplash();
    }

    private void showSplash(){
        frManager.beginTransaction().hide(fmMain).show(fmSplash).commit();
    }

    public void dismissSplash(){
        frManager.beginTransaction().hide(fmSplash).show(fmMain).commitAllowingStateLoss();
    }
}
