package com.example.gjq.myapp.news;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.gjq.myapp.utils.DensityUtils;
import com.example.gjq.myapp.utils.SharedPreUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_welcome)
public class WelcomeActivity extends Activity {
    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;
    @ViewInject(R.id.ll)
    private LinearLayout ll;
    private int pointMoveWidth = 0;
    private Button btnStart = null;
    private List<View> iList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
//        setContentView(R.layout.activity_welcome);
        // 绑定组件
//        initView();
        // 初始化数据
        initData();
        Log.i("crc", this.getResources().getDisplayMetrics().density + "");  // 3.0

    }

    public void startMainActivity(View view) {
        //设置欢迎页面已显示
        SharedPreUtils.setBoolean(this, "welcome_show", true);
        Intent intent = new Intent(this, MainActivity.class);

        // 标准模式在同一个APP中所有Activity都在同一个栈
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        // 启动主页面
        startActivity(intent);
    }

//    private void initView() {
//        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        ll = (LinearLayout) findViewById(R.id.ll);
//    }

    private void initData() {
        viewPager.setAdapter(new WelcomePage());
        for (int i = 0; i < iList.size(); i++) {
            View view = new View(this);
            view.setBackgroundResource(R.drawable.welcome_point_gray);
            int px = DensityUtils.dpi2px(this, 10);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(px, px);
            if (i > 0) {
                param.leftMargin = DensityUtils.dpi2px(this, 5); // 20px
            }
            view.setLayoutParams(param);
            ll.addView(view);
        }

        ll.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.i("crc", "onGlobalLayout........");
                Log.i("jxy", "0point:" + ll.getChildAt(0).getLeft() + ",1point:" + ll.getChildAt(1).getLeft());
                pointMoveWidth = ll.getChildAt(1).getLeft() - ll.getChildAt(0).getLeft();
                ll.getViewTreeObserver().removeOnGlobalLayoutListener(this);

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *
             * @param position
             * @param positionOffset
             * @param positionOffsetPixels
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("crc", "当前页面的索引:" + position + ",移动距离百分比:" + positionOffset + ",移动的像素:" + positionOffsetPixels);
                // 获取red_poinrt的组件,并且设置参数
                View redPoint = findViewById(R.id.red_point);
                RelativeLayout.LayoutParams param = (RelativeLayout.LayoutParams) redPoint.getLayoutParams();
                param.leftMargin = (int) (pointMoveWidth * positionOffset) + position * pointMoveWidth;
                redPoint.setLayoutParams(param);

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("crc", "当前被选择的页面:" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("crc", "state:" + state);
            }
        });
    }

    private class WelcomePage extends PagerAdapter {
        private int[] ids = null;

        public WelcomePage() {
            ids = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
            iList = new ArrayList<View>();
            // 创建一个ListView<ImageView>来存储图片,
            for (int i = 0; i < ids.length; i++) {
                ImageView imageView = new ImageView(WelcomeActivity.this);
                // 给当前ImageView设置背景图
                imageView.setBackgroundResource(ids[i]);
                iList.add(imageView);
            }
            iList.add(View.inflate(WelcomeActivity.this,R.layout.btn_start,null));
        }

        @Override
        public int getCount() {
            return iList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = (View) iList.get(position);
            Log.i("crc", "当前的ViewPager对象:" + container + ",position:" + position + ",ImageView:" + view);
            // 返回之前必须把当前View对象添加到容器中
            container.addView(view); // lv.addView(view); 只能使用适配器
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.i("crc", "当前销毁的对象:" + object);
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
