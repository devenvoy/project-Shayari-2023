package com.example.shayari2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {

    SessionManager sessionManager;
    ImageView backbtn;
    TextView name, email, phone;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Homepage.this, Categories.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        sessionManager = new SessionManager(getApplicationContext());

        backbtn = findViewById(R.id.backbtn);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);


        name.setText(sessionManager.getSession("name_key"));
        email.setText(sessionManager.getSession("email_key"));
        phone.setText(sessionManager.getSession("phone_key"));


        backbtn.setOnClickListener(v -> {
            startActivity(new Intent(Homepage.this, Categories.class));
            finish();
        });
    }

    public void logout(View view) {
        sessionManager.logoutSession();
        startActivity(new Intent(Homepage.this, loginpage.class));
        finish();
    }
}