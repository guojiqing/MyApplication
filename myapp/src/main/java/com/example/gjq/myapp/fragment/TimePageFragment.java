package com.example.gjq.myapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.NestedScrollingChild;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gjq.myapp.models.News;
import com.example.gjq.myapp.news.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.image.SmartImageView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by guojiqing on 2017/4/8.
 */
@ContentView(value = R.layout.time_page)
public class TimePageFragment extends Fragment {

    @ViewInject(R.id.lv)
    private ListView listView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("crc", this.getClass() + "---->1: onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("crc", this.getClass() + "---->2: onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("crc", this.getClass() + "---->3: onCreateView");
        return x.view().inject(this, inflater, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("crc", this.getClass() + "---->4: onViewCreated");
        getRequestData(view);

    }

    private void getRequestData(View view) {
        RequestParams params = new RequestParams("http://hiwbs101083.jsp.jspee.com.cn/NewServlet");
        params.addQueryStringParameter("wd", "xUtils");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(x.app(), result, Toast.LENGTH_LONG).show();
                final List<News> newsList = new Gson().fromJson(result,new TypeToken<List<News>>(){}.getType());
                Log.i("crc","num: " + newsList.size());
                listView.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return newsList.size();
                    }

                    @Override
                    public Object getItem(int position) {
                        return newsList.get(position);
                    }

                    @Override
                    public long getItemId(int position) {
                        return 0;
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        News news = (News) getItem(position);
                        View view = null;
                        if (convertView != null) {
                            view = convertView;
                        } else {
                            view = View.inflate(TimePageFragment.this.getActivity(), R.layout.time_list_item, null);
                        }

                        TextView txt_itemTime = (TextView) view.findViewById(R.id.timeItemTime);
                        TextView txt_itemTitle = (TextView) view.findViewById(R.id.timeItemTitle);
                        SmartImageView smartImg = (SmartImageView) view.findViewById(R.id.timeItemImg);

                        txt_itemTime.setText(news.getTime());
                        txt_itemTitle.setText(news.getTitle());
                        smartImg.setImageUrl(news.getImgUrl());

                        return view;
                    }
                });
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("crc","---onError" );
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();
                Log.i("crc","---onCancelled" );

            }

            @Override
            public void onFinished() {
                Log.i("crc","---onCancelled" );
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("crc", this.getClass() + "---->5: onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("crc", this.getClass() + "---->6: onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("crc", this.getClass() + "---->7: onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("crc", this.getClass() + "---->8: onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("crc", this.getClass() + "---->9: onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("crc", this.getClass() + "---->10: onDestroy");
    }
}
