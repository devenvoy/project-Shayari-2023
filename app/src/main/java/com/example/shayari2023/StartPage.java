package com.example.shayari2023;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);


        new Handler().postDelayed(() -> {
            SessionManager sessionManager = new SessionManager(this);
            boolean status = sessionManager.checkSession();

            if (status) {
                Intent i1 = new Intent(StartPage.this, Categories.class);
                startActivity(i1);
                finish();
            } else {
                Intent i2 = new Intent(StartPage.this, loginpage.class);
                startActivity(i2);
                finish();
            }

        }, 1500);

    }
}