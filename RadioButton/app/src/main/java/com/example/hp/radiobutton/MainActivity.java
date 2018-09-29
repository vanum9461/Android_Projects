package com.example.hp.radiobutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgrp;
    RelativeLayout rlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgrp=findViewById(R.id.radiogrp);
        rlayout=findViewById(R.id.relativeLayout);
        rgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.r1:
                        rlayout.setBackgroundColor(Color.RED);
                        break;
                    case R.id.r2:
                        rlayout.setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.r3:
                        rlayout.setBackgroundColor(Color.YELLOW);
                        break;

                }
            }
        });

    }
}
