package com.syndicate.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SetupProfile extends AppCompatActivity {

    EditText name;
    Button setUpSubmit;
    String res_dept,res_year,res_profession;
    LinearLayout deptLayout,yearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_profile);

        name = findViewById(R.id.txt_name);
        setUpSubmit = findViewById(R.id.Btn_setupProfile);

        Spinner dept = findViewById(R.id.spinner_dept);
        Spinner year = findViewById(R.id.spinner_year);
        Spinner profession= findViewById(R.id.spinner_profession);

        deptLayout=findViewById(R.id.dept_container);
        yearLayout=findViewById(R.id.yr_container);

        final ArrayAdapter<CharSequence> adapterDept = ArrayAdapter.createFromResource(this,R.array.dept,R.layout.custom_spinner);
        ArrayAdapter<CharSequence> adapterYear = ArrayAdapter.createFromResource(this,R.array.year,R.layout.custom_spinner);
        ArrayAdapter<CharSequence> adapterProfession = ArrayAdapter.createFromResource(this,R.array.profession,R.layout.custom_spinner);

        adapterDept.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterProfession.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dept.setAdapter(adapterDept);
        year.setAdapter(adapterYear);
        profession.setAdapter(adapterProfession);

        profession.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                res_profession = parent.getItemAtPosition(position).toString();
                if(res_profession.equals("Student"))
                {
                    deptLayout.setVisibility(View.VISIBLE);
                    yearLayout.setVisibility(View.VISIBLE);
                }else{
                    deptLayout.setVisibility(View.GONE);
                    yearLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                res_dept = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                res_year = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        setUpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(name.getText().toString().equals(""))
                {
                    Toast.makeText(SetupProfile.this,"Type A Valid Name !",Toast.LENGTH_SHORT).show();
                } else if (res_profession.equals("----")) {
                    Toast.makeText(SetupProfile.this,"Please Select a Valid Profession!",Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        FileOutputStream fileOutputStream = openFileOutput("name.txt", MODE_PRIVATE);
                        fileOutputStream.write(name.getText().toString().getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(res_profession.equals("Student"))
                    {
                        if (res_dept.equals("----"))
                        {
                            Toast.makeText(SetupProfile.this,"Please Select a Valid Department!",Toast.LENGTH_SHORT).show();
                        }
                        else if(res_year.equals("----")){
                            Toast.makeText(SetupProfile.this,"Please Select a Year Year!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            try{
                                FileOutputStream fileOutputStream = openFileOutput("profession.txt",MODE_PRIVATE);
                                fileOutputStream.write(res_profession.getBytes());
                                fileOutputStream.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            try{
                                FileOutputStream fileOutputStream = openFileOutput("dept.txt",MODE_PRIVATE);
                                fileOutputStream.write(res_dept.getBytes());
                                fileOutputStream.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try{
                                FileOutputStream fileOutputStream = openFileOutput("year.txt",MODE_PRIVATE);
                                fileOutputStream.write(res_year.getBytes());
                                fileOutputStream.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            login();
                        }
                    }else{
                        try{
                            FileOutputStream fileOutputStream = openFileOutput("profession.txt",MODE_PRIVATE);
                            fileOutputStream.write(res_profession.getBytes());
                            fileOutputStream.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        login();
                    }



                }

            }
        });

    }
    void login(){
        try{
            String log = "1";
            FileOutputStream fileOutputStream = openFileOutput("logged.txt",MODE_PRIVATE);
            fileOutputStream.write(log.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(SetupProfile.this,"Informations Are Updated Successfully",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SetupProfile.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
