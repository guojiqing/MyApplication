package com.example.gjq.myapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gjq.myapp.fragment.homepage.HomePageLBFragment;
import com.example.gjq.myapp.fragment.homepage.HomePageVGFragment;
import com.example.gjq.myapp.fragment.homepage.HomePageYWFragment;
import com.example.gjq.myapp.fragment.homepage.HomePageZBFragment;
import com.example.gjq.myapp.news.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojiqing on 2017/4/8.
 */
@ContentView(value = R.layout.home_page)
public class HomePageFragment extends Fragment {

    @ViewInject(R.id.homePageTitle)
    private TabLayout homePageTitle;
    @ViewInject(R.id.homeViewPager)
    private ViewPager homeViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("crc", this.getClass() + "---->2: onCreateView");

        return x.view().inject(this, inflater, null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData(view);
    }

    private void initData(View view) {

        List<String> list_title = new ArrayList<>();
        list_title.add("要闻");
        list_title.add("直播");
        list_title.add("V观");
        list_title.add("联播");

        homePageTitle.setTabMode(TabLayout.MODE_FIXED);
        homePageTitle.addTab(homePageTitle.newTab().setText(list_title.get(0)));
        homePageTitle.addTab(homePageTitle.newTab().setText(list_title.get(1)));
        homePageTitle.addTab(homePageTitle.newTab().setText(list_title.get(2)));
        homePageTitle.addTab(homePageTitle.newTab().setText(list_title.get(3)));

        homeViewPager.setAdapter(new HomeFragmentPage(getActivity().getSupportFragmentManager(),list_title));

        homePageTitle.setupWithViewPager(homeViewPager);
    }

    private class HomeFragmentPage extends FragmentPagerAdapter {

        List<Fragment> iList = new ArrayList<Fragment>();
        private List<String> listTitle;

        public HomeFragmentPage(FragmentManager fm, List<String> listTitle) {
            super(fm);
            iList.add(new HomePageYWFragment());
            iList.add(new HomePageZBFragment());
            iList.add(new HomePageVGFragment());
            iList.add(new HomePageLBFragment());
            this.listTitle = listTitle;
        }

        @Override
        public Fragment getItem(int position) {
            return iList.get(position);
        }

        @Override
        public int getCount() {
            return iList.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return listTitle.get(position % listTitle.size());
        }
    }
}
