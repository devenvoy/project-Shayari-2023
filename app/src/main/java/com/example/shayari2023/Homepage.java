package com.example.shayari2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Homepage extends AppCompatActivity {

    ImageView backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        backbtn = findViewById(R.id.backbtn);

        backbtn.setOnClickListener( v -> {
            finish();
        });
    }
}