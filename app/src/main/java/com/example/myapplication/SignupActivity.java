package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    TextView textView;
    EditText inputEmail,inputPassword,inputconfrompassword;
    Button btnregister;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textView=findViewById(R.id.a1);
        inputEmail=findViewById(R.id.e1);
        inputPassword=findViewById(R.id.e2);
        inputconfrompassword=findViewById(R.id.e3);

        btnregister=findViewById(R.id.btnregister);

        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignupActivity.this,login.class));
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PerforAuth();
            }

        });
    }

    private void PerforAuth() {

        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String password2=inputconfrompassword.getText().toString();
        if(!email.matches(emailPattern)){

            inputEmail.setError("Enter correct email");
        } else if (password.isEmpty() || password.length()<6) {
            inputPassword.setError("enter proper password");
        } else if (!password .equals(password2)) {
            inputconfrompassword.setError("password not matched both field");

        }else {
            progressDialog.setMessage("please wait for registration");
            progressDialog.setTitle("registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(SignupActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }

                    else {

                        progressDialog.dismiss();
                        Toast.makeText(SignupActivity.this, "" +task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void sendUserToNextActivity() {

        Intent intent=new Intent(SignupActivity.this,MainActivity3.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
  }