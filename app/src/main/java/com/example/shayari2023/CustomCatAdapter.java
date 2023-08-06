package com.example.shayari2023;

import static com.example.shayari2023.Categories.CatImgArr;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomCatAdapter extends ArrayAdapter {

    private String[] categoryItem;
    private Context context;

    // Constructor to intialize adapter class
    public CustomCatAdapter(@NonNull Context context, int resource , String[] catgoryitem) {

        // to intialize extended adapter class
        super(context, resource , catgoryitem);

        // Intialize current class
        this.categoryItem = catgoryitem;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.catitems,parent,false);

        ImageView imagg = view.findViewById(R.id.catitemImage);
        TextView textt = view.findViewById(R.id.catitemText);

        imagg.setBackgroundResource(CatImgArr[position]);
        textt.setText(categoryItem[position]);


        return view;
    }
}
