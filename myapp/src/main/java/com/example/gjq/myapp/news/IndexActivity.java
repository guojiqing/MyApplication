package com.example.gjq.myapp.news;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.gjq.myapp.utils.SharedPreUtils;

import java.util.Timer;
import java.util.TimerTask;

public class IndexActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        // 两秒后跳转到引导页面
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                if (SharedPreUtils.getBoolean(IndexActivity.this, "welcome_show", false)) {
                    Intent intent = new Intent(IndexActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    // 启动主页面
                    startActivity(intent);
                } else
                    startActivity(new Intent(IndexActivity.this, WelcomeActivity.class));
            }
        }, 2000);

//        SharedPreferences ref = this.getSharedPreferences("config", MODE_PRIVATE);
        // 向config.xml中写入key与value
//        SharedPreferences.Editor editor = ref.edit();
//        editor.putString("name", "admin");
//        editor.commit();
//        Log.i("crc", ref.getString("name", "abc") + ref.getString("password", "admin****"));

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
