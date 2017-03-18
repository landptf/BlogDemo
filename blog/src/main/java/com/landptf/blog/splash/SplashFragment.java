package com.landptf.blog.splash;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.landptf.blog.Constants;
import com.landptf.blog.MainActivity;
import com.landptf.blog.R;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * Created by landptf on 2017/03/18.
 * 启动页，集成了腾讯广告联盟的开屏广告
 */
public class SplashFragment extends Fragment {
    private static final String TAG = SplashFragment.class.getSimpleName();

    private MainActivity activity;

    private ViewGroup container;
    private TextView tvSkip;
    private ImageView ivSplashHolder;
    private static final String SKIP_TEXT = "点击跳过 %d";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (MainActivity) getActivity();
        initView();
    }

    private void initView() {
        container = (ViewGroup) activity.findViewById(R.id.fl_splash_container);
        tvSkip = (TextView) activity.findViewById(R.id.tv_skip);
        ivSplashHolder = (ImageView) activity.findViewById(R.id.iv_splash_holder);
        //申请动态权限
        ApplyPermissions();
    }

    /**
     * 动态申请集成腾讯广告联盟的开屏广告所需要的三个权限
     * 使用了RxPermissions开源框架
     */
    private void ApplyPermissions() {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions
                .request(Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        //获取开屏广告
                        new SplashAD(activity, container, tvSkip, Constants.APPID, Constants.SplashPosID, adListener, 5000);
                    } else {
                        //直接进入主页面
                        activity.dismissSplash();
                    }
                });

    }

    /**
     * 开屏广告状态的监听
     */
    private SplashADListener adListener = new SplashADListener() {

        /**
         * 广告关闭时调用，可能是用户关闭或者展示时间到。此时一般需要跳过开屏的Activity，进入应用内容页面
         */
        @Override
        public void onADDismissed() {
            activity.dismissSplash();
        }

        /**
         * 广告加载失败，errCode用于描述失败原因。
         * @param i
         */
        @Override
        public void onNoAD(int i) {
            Log.e(TAG, "error code = " + i);
            activity.dismissSplash();
        }

        /**
         * 广告成功展示时调用
         */
        @Override
        public void onADPresent() {
            ivSplashHolder.setVisibility(View.GONE);
        }

        /**
         * 广告被点击时调用
         */
        @Override
        public void onADClicked() {
            Log.i(TAG, "SplashADClicked");
        }

        /**
         * 倒计时回调，返回广告还将被展示的剩余时间，单位是ms
         * @param l
         */
        @Override
        public void onADTick(long l) {
            tvSkip.setText(String.format(SKIP_TEXT, Math.round(l / 1000f)));
        }
    };
}
