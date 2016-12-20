package com.example.xinyu.testsome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by Administrator on 2016/11/1.
 */
public class NewsDetails extends AppCompatActivity {
    private  String path="\"http://news-at.zhihu.com/api/4/news/8939056\"";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetails);
        WebView webView = (WebView) findViewById(R.id.web);
        webView.loadUrl(path);
    }
}


