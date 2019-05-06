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
import com.google.firebase.auth.FirebaseUser;
import com.test.myapplication.objects.User;

import java.util.ArrayList;

public class Activity_use extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private FirebaseAuth mAuth;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        this.username = (EditText)this.findViewById(R.id.Username);
        this.password = (EditText)this.findViewById(R.id.Password);
    }
    public void Login(View view) {
//        users = new ArrayList<>();
//        users.add(new User(1,"16110348","123",16110348,"Hoang Hung"));
//        users.add(new User(2,"16110429","123",16110429,"Hoang Quan"));
        CheckLogin(view);
//       if(username.getText().toString().equals("1")) {
//           intent(view);
//        }
    }
    public void CheckLogin(final View view)
    {
        final String email = username.getText().toString();
        String pass = password.getText().toString();
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Toast.makeText(Activity_use.this,"Login Success !",Toast.LENGTH_LONG).show();
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                            Intent intent = new Intent(Activity_use.this, MainActivity.class);
                            intent.putExtra("email",email);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Activity_use.this,"Login Fail ! Try again !",Toast.LENGTH_LONG).show();
//                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
    public void SignUp(View view)
    {
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
}
