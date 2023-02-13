package com.syndicate.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {
    TextView name,year,dept,cgpa,cgpaPer,profession;
    ImageView back,write,logOut;
    LinearLayout deptContainer,yrContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.pro_name);
        dept = findViewById(R.id.pro_dept);
        year = findViewById(R.id.pro_year);
        cgpa = findViewById(R.id.pro_cgpa);
        profession = findViewById(R.id.pro_profession);
        cgpaPer = findViewById(R.id.pro_cgpaPer);
        write = findViewById(R.id.writeProfile);
        logOut = findViewById(R.id.logOutProfile);
        back = findViewById(R.id.back);

        deptContainer=findViewById(R.id.dept_container);
        yrContainer=findViewById(R.id.year_container);

        read();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,SetupProfile.class);
                startActivity(intent);
                finish();
            }
        });
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(File f : ProfileActivity.this.getFilesDir().listFiles()){
                    if (f.exists())
                    {
                        ProfileActivity.this.deleteFile(f.getName());
                    }
                }
                Intent intent = new Intent(ProfileActivity.this,SetupProfile.class);
                finish();
                startActivity(intent);
            }
        });
        cgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", cgpa.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(ProfileActivity.this, "CGPA Copied", Toast.LENGTH_SHORT).show();
            }
        });
        cgpaPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", cgpaPer.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(ProfileActivity.this, "CGPA % Copied", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void read() {
        try {
            FileInputStream fileInputStream = openFileInput("name.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            name.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = openFileInput("profession.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            profession.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(profession.getText().toString().replaceAll("\n","").equals("Student")){
            try {
                FileInputStream fileInputStream = openFileInput("dept.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();

                String lines;
                while ((lines = bufferedReader.readLine()) != null) {
                    stringBuffer.append(lines + "\n");
                }
                dept.setText(stringBuffer.toString());
                dept.setVisibility(View.VISIBLE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                FileInputStream fileInputStream = openFileInput("year.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();

                String lines;
                while ((lines = bufferedReader.readLine()) != null) {
                    stringBuffer.append(lines + "\n");
                }
                year.setText(stringBuffer.toString());
                year.setVisibility(View.VISIBLE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            deptContainer.setVisibility(View.GONE);
            yrContainer.setVisibility(View.GONE);
        }




        try {
            FileInputStream fileInputStream = openFileInput("cgpaProfile.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            cgpa.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = openFileInput("percentProfile.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            cgpaPer.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
