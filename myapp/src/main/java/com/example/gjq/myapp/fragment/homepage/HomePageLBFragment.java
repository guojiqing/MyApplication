package com.example.gjq.myapp.fragment.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gjq.myapp.news.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 *  Fragmet需要添加xml布局文件
 */

@ContentView(value = R.layout.home_page_lb)
public class HomePageLBFragment extends Fragment {

    @ViewInject(R.id.homePageLBText)
    private TextView textView;

    @Nullable
    @Override  // 每个Fragment都有自己的XML配置文件
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return x.view().inject(this,inflater,null);
//        return View.inflate(this.getActivity(), R.layout.home_page,null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView.setText("这是首页的联播");
    }
}
