package com.example.gjq.myapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gjq.myapp.news.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * Created by guojiqing on 2017/4/8.
 *
 */
@ContentView(value= R.layout.home_page)
public class HomePageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("crc",this.getClass() + "---->2: onCreateView");
        return x.view().inject(this,inflater,null);
    }
}
