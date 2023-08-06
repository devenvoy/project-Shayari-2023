package com.example.shayari2023;

import static com.example.shayari2023.Categories.CatColArr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyPagerAdapter extends PagerAdapter {

    String[] catlist;
    Context pagerContext;

    LayoutInflater layoutInflater;

    public MyPagerAdapter(String[] catlist, Context pagerContext) {
        this.catlist = catlist;
        this.pagerContext = pagerContext;
        layoutInflater = LayoutInflater.from(pagerContext);
    }

    @Override
    public int getCount() {
        return catlist.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView bgimg;
        ImageView shayariimg;
        TextView shayri;

        View view =  layoutInflater.inflate(R.layout.viewpageritem,container,false);
        bgimg = view.findViewById(R.id.background);
        shayariimg = view.findViewById(R.id.viewshayaribg);
        shayri = view.findViewById(R.id.viewshayaritext);

        bgimg.setBackgroundResource(CatColArr[position]);
        shayariimg.setBackgroundResource(CatColArr[position]);
        shayri.setText(catlist[position]);

        // Its main thing that set our current item
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }
}
