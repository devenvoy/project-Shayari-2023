package com.example.shayari2023;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class newregister extends AppCompatActivity {

    SessionManager sessionManager;
    ImageView exit;
    TextView logintxt;
    Button signup;
    Boolean canLogin;
    TextInputLayout passlay, cpasslay;
    EditText reg_fname, reg_lname, reg_email, reg_phone, reg_password, reg_cpassword;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(newregister.this, loginpage.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newregister);

        sessionManager = new SessionManager(getApplicationContext());
        exit = findViewById(R.id.backbtn);
        logintxt = findViewById(R.id.logintxt);
        signup = findViewById(R.id.signup);
        reg_fname = findViewById(R.id.reg_fname);
        reg_lname = findViewById(R.id.reg_lname);
        reg_email = findViewById(R.id.reg_email);
        reg_phone = findViewById(R.id.reg_phone);
        reg_password = findViewById(R.id.reg_password);
        reg_cpassword = findViewById(R.id.reg_cpassword);
        passlay = findViewById(R.id.passlay);
        cpasslay = findViewById(R.id.cpasslay);


        Intent ihl = new Intent(getApplicationContext(), loginpage.class);


        exit.setOnClickListener(v -> {
            startActivity(new Intent(newregister.this, loginpage.class));
            finish();
        });

        logintxt.setOnClickListener(v -> {
            startActivity(ihl);
            finish();
        });

        reg_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                String errorMessage = errorMsg(input);

                if (errorMessage.equals("Field Empty")) {
                    passlay.setError("Enter Valid Password");
                } else {
                    passlay.setHelperText(errorMessage);
                }

                if (errorMessage.equals("Strong Password")) {
                    passlay.setError(null);
                    canLogin = true;
                }
            }
        });


        signup.setOnClickListener(v ->

        {
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

    public static String errorMsg(String input) {
        if (input == null || input.isEmpty()) {
            return "Field Empty";
        }

        boolean hasSpecialChar = input.matches(".*[@#$%_].*");
        boolean hasCapitalLetter = false;

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
                break;
            }
        }

        String errorMessage;

        if (!hasCapitalLetter) {
            errorMessage = "At least one capital letter is required.";
        } else if (input.length() < 8) {
            errorMessage = "Length Minimum 8 characters";
        } else if (input.length() > 16) {
            errorMessage = "Length Maximum 16 characters";
        } else if (!hasSpecialChar) {
            errorMessage = "Include one special character @, #, $, %, or _.";
        } else {
            errorMessage = "Strong Password";
        }

        return errorMessage;
    }

}