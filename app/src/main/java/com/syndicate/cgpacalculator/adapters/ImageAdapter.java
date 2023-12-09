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

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    View gridViewAndroid;
    LayoutInflater inflater;
    TextView textView;
    ImageView imageView;


    public ImageAdapter(Context c) {
        this.mContext = c;
    }

    @Override
    public int getCount() {
        return mString.length;
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
        if (inflater==null){
            inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view==null){
            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.gridview_layout,null);

        }else{
            gridViewAndroid = (View)  view;
        }
        textView = gridViewAndroid.findViewById(R.id.gridview_text);
        imageView = gridViewAndroid.findViewById(R.id.gridview_image);

        //  imageView.setImageResource(mThumbIds[i]);
        textView.setText(mString[i]);
        imageView.setImageResource(mThumbIds[i]);
        return gridViewAndroid;
    }
    public Integer[] mThumbIds = {
      R.drawable.cse_logo,R.drawable.ece_logo,R.drawable.eee_logo,R.drawable.mech_logo,
            R.drawable.civil_logo,R.drawable.cse_logo,R.drawable.cse_logo,R.drawable.cse_logo,
            R.drawable.cse_logo,R.drawable.cse_logo,R.drawable.ece_logo,R.drawable.civil_logo,R.drawable.mech_logo
    };
    public String[] mString ={
      "CSE","ECE","EEE","MECH","CIVIL","IT","MCA","AI","AI 2022-23","BIO MED","CHEMICAL","EIE","FOOD TECH"
    };
}
