package com.example.shayari2023;

import static com.example.shayari2023.Categories.catarray;
import static com.example.shayari2023.Categories.shayaries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CatItems extends AppCompatActivity {

    TextView Catitemtxt;
    ImageView backbtns;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_items);

        Catitemtxt = findViewById(R.id.Catitemtxt);

        backbtns = findViewById(R.id.backbtns);

        listView = findViewById(R.id.catshayari);

        int cposition = getIntent().getIntExtra("pos",0);

        Catitemtxt.setText(catarray[cposition]);

        CustomCatAdapter2 adapter = new CustomCatAdapter2(this, R.layout.catshayari, shayaries[cposition]);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener((parent, view, position, id) -> {

        });

        backbtns.setOnClickListener(v -> finish());


    }
}