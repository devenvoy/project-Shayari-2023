package com.example.shayari2023;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class StartPage extends AppCompatActivity {


    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);


        ConstraintLayout startpage = findViewById(R.id.startpage);

        AnimationDrawable animationDrawable = (AnimationDrawable) startpage.getBackground();
        animationDrawable.setEnterFadeDuration(500);
        animationDrawable.setExitFadeDuration(3500);
        animationDrawable.start();

        btnStart = findViewById(R.id.btnStart);

        Intent i1 = new Intent(this, loginpage.class);

        btnStart.setOnClickListener(v -> {
            startActivity(i1);
            finish();
        });

    }
}