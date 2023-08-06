package com.example.shayari2023;

import static android.content.Context.CLIPBOARD_SERVICE;
import static com.example.shayari2023.Categories.CatColArr;
import static com.example.shayari2023.Categories.showToasting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomCatAdapter2 extends ArrayAdapter {

    String[] shayri ;
        Context context;
    public CustomCatAdapter2(CatItems catItems, int catshayari, String[] shayaries) {
        super(catItems,catshayari,shayaries);
        this.context = catItems;
        this.shayri = shayaries;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.catshayari,parent,false);

        ImageView imagg = view.findViewById(R.id.imgg);

        ImageView copybtnA = view.findViewById(R.id.copybtnA);
        ImageView sharebtnA = view.findViewById(R.id.sharebtnA);
        TextView textt = view.findViewById(R.id.textView);

        imagg.setBackgroundResource(CatColArr[position]);
        textt.setText(shayri[position]);


        copybtnA.setOnClickListener(v -> {

            ClipboardManager clipboard = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("label", shayri[position]);
            clipboard.setPrimaryClip(clip);
            showToasting(context,"Copied");
        });

        sharebtnA.setOnClickListener(v -> {
            /*Create an ACTION_SEND Intent*/
            Intent intent = new Intent(Intent.ACTION_SEND);
            /*This will be the actual content you wish you share.*/
            String shareBody = shayri[position];
            /*The type of the content is text, obviously.*/
            intent.setType("text/plain");
            /*Applying information Subject and Body.*/
            intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
            intent.putExtra(Intent.EXTRA_TEXT, shareBody);
            /*Fire!*/
            context.startActivity(Intent.createChooser(intent, "Share"));
        });

        return view;
    }
}
