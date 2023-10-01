package com.example.shayari2023;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
public class StartPage extends AppCompatActivity {
    SessionManager sessionManager;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        handler = new Handler();
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(() -> {
            sessionManager = new SessionManager(this);
            boolean status = sessionManager.checkSession();
            if (status == true) {
                startActivity(new Intent(StartPage.this, Categories.class));
                finish();
            } else {
                startActivity(new Intent(StartPage.this, loginpage.class));
                finish();
            }
        }, 1500);
    }
}