package com.syndicate.cgpacalculator.ece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.syndicate.cgpacalculator.MainActivity;
import com.syndicate.cgpacalculator.R;
import com.syndicate.cgpacalculator.adapters.SemImageAdapter;


public class EceSemList extends AppCompatActivity {
    Button sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;
    ImageView back;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_sem_list);

        gridView = findViewById(R.id.gridview);
        gridView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        SemImageAdapter imageAdapter = new SemImageAdapter(this);
        gridView.setAdapter(imageAdapter);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EceSemList.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Intent intent = new Intent(EceSemList.this, EceSem1List.class);
                    startActivity(intent);
                }else if(i==1) {
                    Intent intent = new Intent(EceSemList.this, EceSem2List.class);
                    startActivity(intent);
                }else if(i==2) {
                    Intent intent = new Intent(EceSemList.this, EceSem3List.class);
                    startActivity(intent);
                }else if(i==3) {
                    Intent intent = new Intent(EceSemList.this, EceSem4List.class);
                    startActivity(intent);
                }else if(i==4) {
                    Intent intent = new Intent(EceSemList.this, EceSem5List.class);
                    startActivity(intent);
                }else if(i==5) {
                    Intent intent = new Intent(EceSemList.this, EceSem6List.class);
                    startActivity(intent);
                }else if(i==6) {
                    Intent intent = new Intent(EceSemList.this, EceSem7List.class);
                    startActivity(intent);
                }else if(i==7) {
                    Intent intent = new Intent(EceSemList.this, EceSem8List.class);
                    startActivity(intent);
                }
            }
        });
//        sem1 = findViewById(R.id.sem1Id);
//        sem2 = findViewById(R.id.sem2Id);
//        sem3 = findViewById(R.id.sem3Id);
//        sem4 = findViewById(R.id.sem4Id);
//        sem5 = findViewById(R.id.sem5Id);
//        sem6 = findViewById(R.id.sem6Id);
//        sem7 = findViewById(R.id.sem7Id);
//        sem8 = findViewById(R.id.sem8Id);
//        back = findViewById(R.id.back);
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EceSemList.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        sem1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EceSemList.this,EceSem1List.class);
//                startActivity(intent);
//            }
//        });
//
//        sem2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EceSemList.this,EceSem2List.class);
//                startActivity(intent);
//            }
//        });
//
//        sem3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EceSemList.this,EceSem3List.class);
//                startActivity(intent);
//            }
//        });
//
//        sem4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EceSemList.this,EceSem4List.class);
//                startActivity(intent);
//            }
//        });
//
//        sem5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EceSemList.this,EceSem5List.class);
//                startActivity(intent);
//            }
//        });
//
//        sem6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EceSemList.this,EceSem6List.class);
//                startActivity(intent);
//            }
//        });
//        sem7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EceSemList.this,EceSem7List.class);
//                startActivity(intent);
//            }
//        });
//
//        sem8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EceSemList.this,EceSem8List.class);
//                startActivity(intent);
//            }
//        });


    }

}


