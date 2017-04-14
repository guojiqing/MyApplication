package com.example.gjq.myapp.news;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends Activity {

//    private List<News> newsList;
//    private MyAdapter myAdapter;
    @ViewInject(R.id.rbGroup)
    private RadioGroup radioGroup;
    @ViewInject(R.id.viewpager)
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
//        setContentView(R.layout.activity_main);
//        loadData();
        radioGroup.check(R.id.rbHome);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);  // 退出app 0 代表正常退出
    }

    private void initData() {

        viewpager.setAdapter(new MainPage());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbHome:
                        viewpager.setCurrentItem(0, true);
                        break;
                    case R.id.rbTime:
                        viewpager.setCurrentItem(1, true);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private class MainPage extends PagerAdapter {

        List<View> iList = new ArrayList<View>();

        public MainPage() {
            iList.add(View.inflate(MainActivity.this, R.layout.home_page, null));
            iList.add(View.inflate(MainActivity.this, R.layout.time_page, null));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = (View) iList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return iList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

//    private void loadData() {
//
//        newsList = new ArrayList<News>();
//        for (int i = 0; i < 20; i++) {
//            newsList.add(new News("新闻" + i, "新闻副标题" + i + "-" + i));
//        }
//        ListView lv = (ListView) findViewById(R.id.lv);
//        myAdapter = new MyAdapter();
//        lv.setAdapter(myAdapter);
//    }

//    private class MyAdapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {
//            return newsList.size();
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return newsList.get(i);
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            View item = null;
//            if (view != null) {
//                item = view;
//            } else {
//                item = View.inflate(MainActivity.this, R.layout.list_item, null);
//            }
//            TextView title = (TextView) item.findViewById(R.id.newsTitle);
//            TextView subTitle = (TextView) item.findViewById(R.id.subTitle);
//            News news = (News) getItem(i);
//            title.setText(news.getTitle());
//            subTitle.setText(news.getSubTitle());
//            return item;
//        }
//    }


}
