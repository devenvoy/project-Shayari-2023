package com.example.shayari2023;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class loginpage extends AppCompatActivity {

    SessionManager sessionManager;
    Button loginbtn;
    ImageView exit;
    TextView newreg, guestlogin;

    EditText log_email, log_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        sessionManager = new SessionManager(getApplicationContext());
        loginbtn = findViewById(R.id.login_btn);
        exit = findViewById(R.id.exit);
        newreg = findViewById(R.id.newuser);
        log_email = findViewById(R.id.log_email);
        log_pass = findViewById(R.id.log_pass);
        guestlogin = findViewById(R.id.guestlogin);

        Intent ils = new Intent(getApplicationContext(), Categories.class);
        Intent ig = new Intent(getApplicationContext(), Categories.class);
        Intent inr = new Intent(getApplicationContext(), newregister.class);

        String email = sessionManager.getSession("email_key");
        String pass = sessionManager.getSession("pass_key");

        loginbtn.setOnClickListener(v -> {

            if (log_email.getText().toString().isEmpty() || log_pass.getText().toString().isEmpty()) {
                log_email.setError("Enter details");
                log_pass.setError("Enter details");
            } else {
                if (email.equals(log_email.getText().toString())) {
                    if (pass.equals(log_pass.getText().toString())) {
                        sessionManager.editor.putBoolean("login_status", true);
                        sessionManager.editor.commit();
                        startActivity(ils);
                        finish();
                    } else {
                        log_pass.setText("");
                        log_pass.setError("Wrong Password");
                    }
                } else {
                    log_email.setError("Wrong Email credentials ");
                }
            }
        });

        exit.setOnClickListener(v -> {
            finish();
        });

        newreg.setOnClickListener(v -> {
            startActivity(inr);
            finish();
        });

        guestlogin.setOnClickListener(v -> {
            ig.putExtra("codeguest", "guest");
            startActivity(ig);
            finish();
        });

    }

}




