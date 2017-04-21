package com.example.gjq.myapp.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.gjq.myapp.fragment.HomePageFragment;
import com.example.gjq.myapp.fragment.TimePageFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(value = R.layout.activity_main)
public class  MainActivity extends FragmentActivity {

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

        viewpager.setAdapter(new MainFragmentPage(getSupportFragmentManager()));

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

    private class MainFragmentPage extends FragmentPagerAdapter{

        List<Fragment> iList = new ArrayList<Fragment>();
        public MainFragmentPage(FragmentManager fm) {
            super(fm);
            iList.add(new HomePageFragment());
            iList.add(new TimePageFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return iList.get(position);
        }

        @Override
        public int getCount() {
            return iList.size();
        }
    }



}
