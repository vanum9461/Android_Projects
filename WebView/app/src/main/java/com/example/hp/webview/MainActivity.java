package com.example.hp.webview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.floatingActionButton);
        b2=findViewById(R.id.floatingActionButton2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView wb1=(WebView)findViewById(R.id.web1);
                wb1.loadUrl("http://www.facebook.com");
                wb1.setWebViewClient(new WebViewClient());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView wb1=(WebView)findViewById(R.id.web1);
                wb1.loadUrl("http://developer.android.com");
                wb1.setWebViewClient(new WebViewClient());
            }
        });

    }
}
