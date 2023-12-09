package com.syndicate.cgpacalculator.ai23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.syndicate.cgpacalculator.R;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import com.syndicate.cgpacalculator.MainActivity;
import com.syndicate.cgpacalculator.adapters.SemImageAdapter;

public class Ai23SemList extends AppCompatActivity {


    Button sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;
    ImageView back;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai23_sem_list);




        gridView = findViewById(R.id.gridview);
        gridView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        SemImageAdapter imageAdapter = new SemImageAdapter(this);
        gridView.setAdapter(imageAdapter);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ai23SemList.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Intent intent = new Intent(Ai23SemList.this, Ai23Sem1List.class);
                    startActivity(intent);
                }else if(i==1) {
                    Intent intent = new Intent(Ai23SemList.this, Ai23Sem2List.class);
                    startActivity(intent);
                }else if(i==2) {
                    Intent intent = new Intent(Ai23SemList.this, Ai23Sem3List.class);
                    startActivity(intent);
                }else if(i==3) {
                    Intent intent = new Intent(Ai23SemList.this, Ai23Sem4List.class);
                    startActivity(intent);
                }else if(i==4) {
                    Intent intent = new Intent(Ai23SemList.this, Ai23Sem5List.class);
                    startActivity(intent);
                }else if(i==5) {
                    Intent intent = new Intent(Ai23SemList.this, Ai23Sem6List.class);
                    startActivity(intent);
                }else if(i==6) {
                    Intent intent = new Intent(Ai23SemList.this, Ai23Sem7List.class);
                    startActivity(intent);
                }else if(i==7) {
                    Intent intent = new Intent(Ai23SemList.this, Ai23Sem8List.class);
                    startActivity(intent);
                }
            }
        });
    }
}