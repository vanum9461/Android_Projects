package com.example.hp.authenticationexample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText email,password;
    Button register;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();

        email=findViewById(R.id.edt1);
        password=findViewById(R.id.edt2);
        register=findViewById(R.id.button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail=email.getText().toString();
                String pwd=password.getText().toString();

                if (mail.isEmpty() || pwd.isEmpty()) {
                    Toast.makeText(Register.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mAuth.createUserWithEmailAndPassword(mail,pwd)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(Register.this, "You have been registered", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Register.this, Third.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        Toast.makeText(Register.this, task.getException().toString(), Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                }
            }
        });
    }
}
