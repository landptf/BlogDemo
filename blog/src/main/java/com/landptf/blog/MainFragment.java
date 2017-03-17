package com.landptf.blog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.landptf.blog.activitylifecycle.ActivityA;
import com.landptf.blog.audiofocus.MediaActivity;
import com.landptf.blog.picasso.PicassoActivity;
import com.landptf.view.ButtonM;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getActivity());
    }

    private void initView(final FragmentActivity activity) {
        Toolbar tbMain = (Toolbar) activity.findViewById(R.id.tb_main);
        ((AppCompatActivity)activity).setSupportActionBar(tbMain);
        tbMain.setTitleTextColor(getResources().getColor(android.R.color.white));

        ButtonM btmActivityLifeCycle = (ButtonM) activity.findViewById(R.id.btm_activity_life_cycle);
        if (btmActivityLifeCycle != null) {
            btmActivityLifeCycle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(activity, ActivityA.class));
                }
            });
        }

        ButtonM btmAudioFocus = (ButtonM) activity.findViewById(R.id.btm_audio_focus);
        if(btmAudioFocus != null){
            btmAudioFocus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(activity, MediaActivity.class));
                }
            });
        }

        ButtonM btmPicasso = (ButtonM) activity.findViewById(R.id.btm_picasso);
        if(btmPicasso != null){
            btmPicasso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(activity, PicassoActivity.class));
                }
            });
        }
    }
}
