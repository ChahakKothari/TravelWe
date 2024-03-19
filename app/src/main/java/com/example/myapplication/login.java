package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextView textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        textView=findViewById(R.id.create);
       btn=findViewById(R.id.b1);

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent =new Intent(login.this,MainActivity3.class);
               Toast.makeText(login.this, "login successfully", Toast.LENGTH_SHORT).show();
               startActivity(intent);
           }
       });


       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(login.this,SignupActivity.class);
               startActivity(intent);
           }
       });
    }
}