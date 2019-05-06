package com.test.myapplication;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.test.myapplication.objects.User;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private FirebaseAuth mAuth;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        this.username = (EditText)this.findViewById(R.id.Username);
        this.password = (EditText)this.findViewById(R.id.Password);
    }
    public void SignUp(View view) {
        CheckAccount(view);
    }
    public void CheckAccount(View view)
    {
        String email = username.getText().toString();
        String pass = password.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this,"Sign Up Success !",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(SignUp.this,"Sign Up Fail ! Try Again !",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    public void SignIn(View view)
    {
        Intent intent = new Intent(this, Activity_use.class);
        startActivity(intent);
    }
}
