package com.example.hp.video;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
VideoView v1;
Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1=findViewById(R.id.videoView);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaController mc=new MediaController(MainActivity.this);
                mc.setAnchorView(v1);//link mediacontroller to videoview
                String uri= "android.resource://com.example.hp.video/"+R.raw.abhi;
                Uri video=Uri.parse(uri);
                v1.setMediaController(mc);//link videoview to mediscontroller
                v1.setVideoURI(video);
                v1.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaController mc=new MediaController(MainActivity.this);
                mc.setAnchorView(v1);
                String uri= "android.resource://com.example.hp.video/"+R.raw.diltutda;
                Uri video=Uri.parse(uri);
                v1.setMediaController(mc);
                v1.setVideoURI(video);
                v1.start();
            }
        });

    }
}
