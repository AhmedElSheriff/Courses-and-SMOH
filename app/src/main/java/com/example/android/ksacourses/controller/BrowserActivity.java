package com.example.android.ksacourses.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.android.ksacourses.R;

public class BrowserActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){

            setContentView(R.layout.activity_browser);
        }

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar)
        ;
        Intent i = getIntent();
        String link = getIntent().getStringExtra("Link");
        initWebView(link);

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView(String link){
        webView = findViewById(R.id.internal_browser);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(link);
    }
}
