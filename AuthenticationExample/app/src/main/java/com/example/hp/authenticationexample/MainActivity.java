package com.example.hp.authenticationexample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button login,register;
    CheckBox c1;
    TextView t1;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.edt1);
        password=findViewById(R.id.edt2);
        c1=findViewById(R.id.cb);
        login=findViewById(R.id.button1);
        register=findViewById(R.id.button2);
        t1=findViewById(R.id.tv);

        mAuth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail=email.getText().toString();
                String pwd=password.getText().toString();
                if (mail.isEmpty() || pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mAuth.signInWithEmailAndPassword(mail,pwd)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(MainActivity.this, "Logging into your account...", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(MainActivity.this, Third.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {

                                        Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    password.setTransformationMethod(null);
                    password.setSelection(password.length());
                    //Setting the cursor at the end after changing visibility
                }
                else
                {
                    password.setTransformationMethod(new PasswordTransformationMethod());
                    password.setSelection(password.length());
                    //Setting the cursor at the end after changing visibility
                }

            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ForgetPassword.class);
                startActivity(intent);
            }
        });

    }


}
