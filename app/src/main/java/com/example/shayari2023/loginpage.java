package com.example.shayari2023;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;
import java.util.Set;


public class loginpage extends AppCompatActivity {

    Button loginbtn;
    ImageView exit;
    TextView newreg, guestlogin;
//    public static SharedPreferences sp = new SharedPreferences()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        loginbtn =findViewById(R.id.login_btn);
        exit =findViewById(R.id.exit);
        newreg =findViewById(R.id.newuser);
        guestlogin =findViewById(R.id.guestlogin);

        Intent ils = new Intent(getApplicationContext(),Categories.class);
        Intent ig = new Intent(getApplicationContext(),Categories.class);
        Intent inr = new Intent(getApplicationContext(),newregister.class);


        loginbtn.setOnClickListener(v -> {
            startActivity(ils);
            finish();
        });

        exit.setOnClickListener( v -> {
            finish();
        });

        newreg.setOnClickListener( v -> {
            startActivity(inr); finish();
        });

        guestlogin.setOnClickListener( v -> {
            ig.putExtra("codeguest","guest");
            startActivity(ig);
            finish();
        });





    }


}




