package com.landptf.blog.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.landptf.blog.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;

public class PicassoActivity extends AppCompatActivity {
    private static final String imageUrl = "http://upload-images.jianshu.io/upload_images/589909-e339eb2763fa172c.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        initView();
    }

    private void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        //设置图片来源指示图标
        //Picasso.with(this).setIndicatorsEnabled(true);
        //从网络加载
        //Picasso.with(this).load(imageUrl).into(imageView);

        //从res中加载
        //Picasso.with(this).load(R.mipmap.default_image).into(imageView);

        //加载过程中显示默认图片
        //Picasso.with(this).load(imageUrl).placeholder(R.mipmap.default_image).into(imageView);

        //加载失败后显示错误的图片
        //Picasso.with(this).load(imageUrl+"landptf").error(R.mipmap.default_image).into(imageView);

        //fit
        //Picasso.with(this).load(imageUrl).fit().into(imageView);
        //centerCrop
        //Picasso.with(this).load(imageUrl).resize(320, 640).centerCrop().into(imageView);
        //centerInside
        //Picasso.with(this).load(imageUrl).resize(320, 640).centerInside().into(imageView);
        //onlyScaleDown
        //Picasso.with(this).load(imageUrl).resize(3000, 1563).onlyScaleDown().into(imageView);

        //取消图片显示的过度效果
        //Picasso.with(this).load(imageUrl).noFade().into(imageView);

        //顺时针旋转
        //Picasso.with(this).load(imageUrl).rotate(45).into(imageView);

        //跳过从内存加载图片，并且图片下载之后也不在内存中进行缓存
//        Picasso.with(this)
//                .load(imageUrl)
//                .skipMemoryCache()
//                .into(imageView);
//
//        Picasso.with(this)
//                .load(imageUrl)
//                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
//                .into(imageView);

        //跳过从磁盘加载图片，并且图片下载之后也不在磁盘中进行缓存
//        Picasso.with(this)
//                .load(imageUrl)
//                .networkPolicy(NetworkPolicy.OFFLINE)
//                .into(imageView);
        //优先级
        //Picasso.with(this).load(imageUrl).priority(Picasso.Priority.HIGH).into(imageView);

        //tag管理
        //Picasso.with(this).load(imageUrl).tag("landptf").into(imageView);
        //Picasso.with(this).pauseTag("landptf");
        //Picasso.with(this).resumeTag("landptf");
        //Picasso.with(this).cancelTag("landptf");

        //手动指定key值
        //Picasso.with(this).load(imageUrl).stableKey("landptf").into(imageView);

    }
}
