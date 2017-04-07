package com.example.gjq.myapp.news;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<News> newsList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsList = new ArrayList<News>();
        for (int i = 0; i < 20; i++) {
            newsList.add(new News("新闻" + i, "新闻副标题" + i + "-" + i));
        }
        ListView lv = (ListView) findViewById(R.id.lv);
        myAdapter = new MyAdapter();
        lv.setAdapter(myAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);  // 退出app 0 代表正常退出
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return newsList.size();
        }

        @Override
        public Object getItem(int i) {
            return newsList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View item = null;
            if (view != null) {
                item = view;
            } else {
                item = View.inflate(MainActivity.this, R.layout.list_item, null);
            }
            TextView title = (TextView) item.findViewById(R.id.newsTitle);
            TextView subTitle = (TextView) item.findViewById(R.id.subTitle);
            News news = (News) getItem(i);
            title.setText(news.getTitle());
            subTitle.setText(news.getSubTitle());
            return item;
        }
    }

    public void btnHome(View view) {
        Log.i("crc", "Click Btn Home.");
    }

    public void btnInfo(View view) {
        Log.i("crc", "Click Btn Info.");
    }

    public void btnStart(View view) {
        Log.i("crc", "Click Btn Start.");
    }
}
