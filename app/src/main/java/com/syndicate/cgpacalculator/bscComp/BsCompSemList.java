package com.syndicate.cgpacalculator.bscComp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.syndicate.cgpacalculator.MainActivity;
import com.syndicate.cgpacalculator.R;
import com.syndicate.cgpacalculator.adapters.SemImageAdapter;

public class BsCompSemList extends AppCompatActivity {
    ImageView back;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs_comp_sem_list);

        gridView = findViewById(R.id.gridview);
        gridView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        SemImageAdapter imageAdapter = new SemImageAdapter(this);
        gridView.setAdapter(imageAdapter);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.syndicate.cgpacalculator.bscComp.BsCompSemList.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Intent intent = new Intent(com.syndicate.cgpacalculator.bscComp.BsCompSemList.this, BsCompSem1.class);
                    startActivity(intent);
                }else if(i==1) {
                    Intent intent = new Intent(com.syndicate.cgpacalculator.bscComp.BsCompSemList.this, BsCompSem2.class);
                    startActivity(intent);
                }else if(i==2) {
                    Intent intent = new Intent(com.syndicate.cgpacalculator.bscComp.BsCompSemList.this, BsCompSem3.class);
                    startActivity(intent);
                }else if(i==3) {
                    Intent intent = new Intent(com.syndicate.cgpacalculator.bscComp.BsCompSemList.this, BsCompSem4.class);
                    startActivity(intent);
                }else if(i==4) {
                    Intent intent = new Intent(com.syndicate.cgpacalculator.bscComp.BsCompSemList.this, BsCompSem5.class);
                    startActivity(intent);
                }else if(i==5) {
                    Intent intent = new Intent(com.syndicate.cgpacalculator.bscComp.BsCompSemList.this, BsCompSem6.class);
                    startActivity(intent);
                }
            }
        });
    }
}