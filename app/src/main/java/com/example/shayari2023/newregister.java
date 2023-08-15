package com.example.shayari2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class newregister extends AppCompatActivity {

    ImageView exit;
    TextView logintxt;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newregister);

        exit =findViewById(R.id.backbtn);
        logintxt =findViewById(R.id.logintxt);
        signup =findViewById(R.id.signup);


        Intent ihl = new Intent(getApplicationContext(),loginpage.class);


        exit.setOnClickListener( v -> {
            finish();
        });

        logintxt.setOnClickListener( v -> {
            startActivity(ihl); finish();
        });

        signup.setOnClickListener( v -> {
            startActivity(ihl); finish();
        });


    }
}