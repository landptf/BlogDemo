package com.landptf.blog.splash;

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
        new SplashAD(activity, container, tvSkip, Constants.APPID, Constants.SplashPosID, adListener, 3000);
    }

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
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            activity.dismissSplash();
        }

        /**
         * 广告成功展示时调用
         */
        @Override
        public void onADPresent() {
            ivSplashHolder.setVisibility(View.INVISIBLE);
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
