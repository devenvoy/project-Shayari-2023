package com.example.shayari2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    SessionManager sessionManager;
    ImageView backbtn;
    Button change_detail , change_image;
    TextView name , email ,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        sessionManager = new SessionManager(getApplicationContext());

        backbtn = findViewById(R.id.backbtn);
        change_detail = findViewById(R.id.chg_det);
        change_image = findViewById(R.id.chg_img);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);


        name.setText("hello \n"+sessionManager.getSession("name_key"));
        email.setText(sessionManager.getSession("email_key"));
        phone.setText(sessionManager.getSession("phone_key"));

        backbtn.setOnClickListener( v -> {
            startActivity(new Intent(Homepage.this , Categories.class));
            finish();
        });
    }

    public void logout(View view) {
        sessionManager.logoutSession();
        finish();
    }
}