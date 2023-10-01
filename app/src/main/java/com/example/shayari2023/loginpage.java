package com.example.shayari2023;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;
public class loginpage extends AppCompatActivity {
    SessionManager sessionManager;
    Button loginbtn;
    ImageView exit, guestlogin;
    TextView newreg;
    TextInputLayout log_emailay, log_passlay;
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
        log_emailay = findViewById(R.id.log_emaillay);
        log_passlay = findViewById(R.id.log_passlay);
        guestlogin = findViewById(R.id.guestlogin);
        Intent ils = new Intent(getApplicationContext(), Categories.class);
        Intent ig = new Intent(getApplicationContext(), Categories.class);
        Intent inr = new Intent(getApplicationContext(), newregister.class);
        String email = sessionManager.getSession("email_key");
        String pass = sessionManager.getSession("pass_key");
        log_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String EMAIL_REGEX = "^[a-z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-z.-]+$";
                Pattern pattern = Pattern.compile(EMAIL_REGEX);
                String email = log_email.getText().toString();
                if (!pattern.matcher(email).matches()) {
                    log_emailay.setHelperText("Invalid email");
                } else {
                    log_emailay.setHelperText("");
                }
            }
        });
        loginbtn.setOnClickListener(v -> {
            if (log_email.getText().toString().isEmpty() || log_pass.getText().toString().isEmpty()) {
                log_emailay.setHelperText("Enter details");
                log_passlay.setHelperText("Enter details");
            } else {
                if (email.equals(log_email.getText().toString())) {
                    if (pass.equals(log_pass.getText().toString())) {
                        sessionManager.editor.putBoolean("login_status", true);
                        sessionManager.editor.commit();
                        startActivity(ils);
                        finish();
                    } else {
                        log_passlay.setError("Wrong Password");
                    }
                } else {
                    log_email.setText("");
                    log_pass.setText("");
                    log_emailay.setError("Invalid Login credentials ");
                    Toast.makeText(loginpage.this, "Enter correct Email And Password", Toast.LENGTH_SHORT).show();
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
            sessionManager.createSession("User", "", "", "");
            ig.putExtra("guestcode","guest");
            startActivity(ig);
            finish();
        });
    }
}
