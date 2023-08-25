package com.example.shayari2023;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class newregister extends AppCompatActivity {

    SessionManager sessionManager;
    ImageView exit;
    TextView logintxt;
    Button signup;

    EditText reg_fname, reg_lname, reg_email, reg_phone, reg_password, reg_cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newregister);

        exit = findViewById(R.id.backbtn);
        logintxt = findViewById(R.id.logintxt);
        signup = findViewById(R.id.signup);
        reg_fname = findViewById(R.id.reg_fname);
        reg_lname = findViewById(R.id.reg_lname);
        reg_email = findViewById(R.id.reg_email);
        reg_phone = findViewById(R.id.reg_phone);
        reg_password = findViewById(R.id.reg_password);
        reg_cpassword = findViewById(R.id.reg_cpassword);


        Intent ihl = new Intent(getApplicationContext(), loginpage.class);


        exit.setOnClickListener(v -> {
            finish();
        });

        logintxt.setOnClickListener(v -> {
            startActivity(ihl);
            finish();
        });

        signup.setOnClickListener(v -> {
            String fname = reg_fname.getText().toString();
            String lname = reg_lname.getText().toString();
            String fullname = fname + " " + lname;
            String email = reg_email.getText().toString();
            String phono = reg_phone.getText().toString();
            String pass = reg_password.getText().toString();
            String cpass = reg_cpassword.getText().toString();

            if (pass.equals(cpass)) {
                sessionManager.createSession(fullname, email, phono, pass);
                startActivity(ihl);
                finish();
            } else {
                reg_cpassword.setText("");
                reg_cpassword.setError("Password did not match");
            }
        });


    }
}