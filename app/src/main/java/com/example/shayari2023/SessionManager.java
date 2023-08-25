package com.example.shayari2023;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager {
    Context context;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    //providing file name
    private final String pref_file_name = "Login_Activity";

    // Constructor for this class
    public SessionManager(Context context) {

        this.context = context;
        // Crating file
        sp = context.getSharedPreferences(pref_file_name, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public boolean checkSession() {
        // if user created account it will be true else false
        if (sp.contains("login_status")) {
            return true;
        }
        return false;
    }

    public void createSession(String name, String email, String phono, String pass) {
        editor.putString("name_key", name);
        editor.putString("email_key", email);
        editor.putString("phone_key", phono);
        editor.putString("pass_key", pass);
        // if it storing means user has active logins
        setStatus(false);
        // without commit data will be not stored in file
        editor.commit();
    }

    public void setStatus(Boolean ss){
        editor.putBoolean("login_status", ss);
    }
    public String getSession(String key) {
        String value = sp.getString(key, null);
        return value;
    }

    public void logoutSession() {

        // this will clear all data
//        editor.clear();

        // clear only selected data
        // this only remove data from key given
         editor.remove("pass_key");

        editor.commit();

        Intent newl = new Intent(context, loginpage.class);
        context.startActivity(newl);
    }
}
