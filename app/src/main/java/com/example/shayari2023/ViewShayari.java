package com.example.shayari2023;

import static com.example.shayari2023.Categories.shayaries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class ViewShayari extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view_shayari);

        int catposition = getIntent().getIntExtra("cposition",0);
        int itemposition = getIntent().getIntExtra("itemloc",0);

        viewPager = findViewById(R.id.viewpagershayari);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(shayaries[catposition], ViewShayari.this);

        viewPager.setAdapter(myPagerAdapter);

        viewPager.setCurrentItem(itemposition);
    }
}