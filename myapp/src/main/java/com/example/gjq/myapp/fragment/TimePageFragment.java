package com.example.gjq.myapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gjq.myapp.news.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by guojiqing on 2017/4/8.
 *
 */
@ContentView(value= R.layout.time_page)
public class TimePageFragment extends Fragment {

    @ViewInject(R.id.lv)
    private ListView listView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("crc",this.getClass() + "---->1: onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("crc",this.getClass() + "---->2: onCreate");
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("crc",this.getClass() + "---->3: onCreateView");
        return x.view().inject(this,inflater,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("crc",this.getClass() + "---->4: onViewCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("crc",this.getClass() + "---->5: onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("crc",this.getClass() + "---->6: onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("crc",this.getClass() + "---->7: onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("crc",this.getClass() + "---->8: onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("crc",this.getClass() + "---->9: onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("crc",this.getClass() + "---->10: onDestroy");
    }
}
