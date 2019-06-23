package com.test.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.test.myapplication.objects.User;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    private static final int PICK_IMAGE=100;
    private static String imagename;
    ArrayList<User> users;
    String displayname;
    EditText displayName;
    ImageView img;
    boolean check=false;
    Uri imageUri;
    String Linkimage=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        this.username = this.findViewById(R.id.Username);
        this.password = this.findViewById(R.id.Password);
        this.displayName = this.findViewById(R.id.displayName);
        this.img = this.findViewById(R.id.avatar);
        final String userid = firebaseUser.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");


    }
    public void selectImage(View view){
        opengallery();
    }
    private void opengallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            img.setImageURI(imageUri);
        //    avatar.setVisibility(View.VISIBLE);
            Cursor cursor = SignUp.this.getContentResolver().query(imageUri, null, null, null, null);
            int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            cursor.moveToFirst();
            imagename = cursor.getString(nameIndex);
            imagename = imagename.substring(0, imagename.length() - 4);
            //Toast.makeText(ge.tContext(),imagename.toString(),Toast.LENGTH_LONG).show();
            check=true;
        }
    }
    public void SignUp(View view) {
        CheckAccount(view);
    }
    public void CheckAccount(View view)
    {
        String email = username.getText().toString();
        String pass = password.getText().toString();
        String name = displayName.getText().toString();
        String linkImage = imagename;
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                                            Toast.makeText(SignUp.this,"Sign Up Success !",Toast.LENGTH_LONG).show();
                                            Intent intent1 = new Intent(getApplication(), Activity_use.class);
                                            startActivity(intent1);
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
