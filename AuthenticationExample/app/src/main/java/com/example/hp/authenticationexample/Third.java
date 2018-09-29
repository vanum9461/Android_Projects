package com.example.hp.authenticationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Third extends AppCompatActivity {

    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView1=(TextView)findViewById(R.id.tv1);
        textView2=(TextView)findViewById(R.id.tv2);

        //Storing information of the current user
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String email = user.getEmail();
        textView2.setText(email);

    }
}
