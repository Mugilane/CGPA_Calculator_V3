package com.syndicate.cgpacalculator.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.syndicate.cgpacalculator.R;

public class SemImageAdapter extends BaseAdapter {
    private Context mContext;

    public SemImageAdapter(Context c) {
        this.mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //  ImageView imageView;
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(600,600));
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageView.setPadding(8,8,8,8);
            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.gridview_sem,null);
            TextView textView = gridViewAndroid.findViewById(R.id.gridview_text);
            ImageView imageView = gridViewAndroid.findViewById(R.id.gridview_image);
            textView.setText(mString[i]);
            imageView.setImageResource(mThumbIds[i]);

        }else{
            gridViewAndroid = (View)  view;
        }
        //  imageView.setImageResource(mThumbIds[i]);
        return gridViewAndroid;
    }
    public Integer[] mThumbIds = {
            R.drawable.books,R.drawable.books,R.drawable.books,R.drawable.books,R.drawable.books,R.drawable.books,R.drawable.books,R.drawable.books
    };
    public String[] mString ={
            "SEM 1","SEM 2","SEM 3","SEM 4","SEM 5","SEM 6","SEM 7","SEM 8"
    };
}
