package com.example.shayari2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    ImageView backbtn;
    Button change_detail , change_image;
    TextView name , email ,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        backbtn = findViewById(R.id.backbtn);
        change_detail = findViewById(R.id.chg_det);
        change_image = findViewById(R.id.chg_img);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);

        String acc = getIntent().getStringExtra("codeguest");

        if(acc.equals("guest")){
            name.setText("Hello,\nGuest User");
            email.setText("-");
            phone.setText("-");
            change_detail.setEnabled(false);
            change_image.setEnabled(false);
        }

        backbtn.setOnClickListener( v -> {
            finish();
        });
    }
}