package com.syndicate.cgpacalculator.cse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.syndicate.cgpacalculator.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CseSem1List extends AppCompatActivity {

  //  private static final String FILE_NAME = "sem1.txt";

    Button submit,clear,copy,s,a,b,c,d,e,f;
    TextView result,resultText;
    ImageView cpyIcon,back,export;
    EditText t1,t2,t3,t4,t5,t6,t7,t8,t9;

    int pageHeight = 1120;
    int pagewidth = 792;
    String temp,nameStr,deptStr,profStr;
    Bitmap tclogo, tcscaledbmp,logo,logoscaledbmp;
    int lenSub=11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_sem1_list);

        //findview
        t1 = findViewById(R.id.txt1);
        t2 = findViewById(R.id.txt2);
        t3 = findViewById(R.id.txt3);
        t4 = findViewById(R.id.txt4);
        t5 = findViewById(R.id.txt5);
        t6 = findViewById(R.id.txt6);
        t7 = findViewById(R.id.txt7);
        t8 = findViewById(R.id.txt8);
        t9 = findViewById(R.id.txt9);

        back = findViewById(R.id.back);

        result = findViewById(R.id.ResultId);
        resultText = findViewById(R.id.ResultTextId);
        submit = findViewById(R.id.Btn_Submit);
        clear = findViewById(R.id.Btn_Clear);
        copy = findViewById(R.id.Btn_Copy);
        cpyIcon = findViewById(R.id.copy);
        export = findViewById(R.id.export);

        s = findViewById(R.id.S);
        a = findViewById(R.id.A);
        b = findViewById(R.id.B);
        c = findViewById(R.id.C);
        d = findViewById(R.id.D);
        e = findViewById(R.id.E);
        f = findViewById(R.id.F);

        t1.setShowSoftInputOnFocus(false);
        t2.setShowSoftInputOnFocus(false);
        t3.setShowSoftInputOnFocus(false);
        t4.setShowSoftInputOnFocus(false);
        t5.setShowSoftInputOnFocus(false);
        t6.setShowSoftInputOnFocus(false);
        t7.setShowSoftInputOnFocus(false);
        t8.setShowSoftInputOnFocus(false);
        t9.setShowSoftInputOnFocus(false);

        tclogo = BitmapFactory.decodeResource(getResources(), R.drawable.techcos);
        tcscaledbmp = Bitmap.createScaledBitmap(tclogo, 140, 140, false);
        logo = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
        logoscaledbmp = Bitmap.createScaledBitmap(logo, 140, 140, false);


        final int[] cursor = {0};
        final String[] txt = {"t1","t2","t3","t4","t5","t6","t7","t8","t9"};


        //grades click listener
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cursor[0]<9){
                    switch(txt[cursor[0]]){
                        case "t1":
                            t1.setText("S");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("S");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("S");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("S");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("S");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("S");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("S");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("S");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("S");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0]=0;
                }
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cursor[0]<9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("A");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("A");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("A");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("A");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("A");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("A");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("A");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("A");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("A");
                            cursor[0]++;
                            break;
                    }
                }else{
                        cursor[0]=0;
                    }
                }

        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("B");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("B");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("B");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("B");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("B");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("B");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("B");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("B");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("B");
                            cursor[0]++;
                            break;
                    }
                } else {
                    cursor[0] = 0;
                }
            }

        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("C");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("C");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("C");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("C");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("C");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("C");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("C");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("C");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("C");
                            cursor[0]++;
                            break;
                    }
                    }else{
                        cursor[0] = 0;
                    }
                }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("D");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("D");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("D");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("D");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("D");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("D");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("D");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("D");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("D");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0] = 0;
                }
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("E");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("E");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("E");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("E");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("E");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("E");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("E");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("E");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("E");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0] = 0;
                }
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("F");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("F");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("F");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("F");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("F");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("F");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("F");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("F");
                            cursor[0]++;
                            break;
                            
                        case "t9":
                            t9.setText("F");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0] = 0;
                }
            }
        });



//        setupSemInputs();

        export = findViewById(R.id.export);
        export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(CseSem1List.this,"Under Developement",Toast.LENGTH_SHORT).show();
                readSubWithGrades();
                readprofileInfo();
                generatePDF();
//                Intent intent = new Intent(CseSem1List.this,Sample.class);
//                startActivity(intent);
            }
        });

        //t1-t9 listener
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
                cursor[0]=0;
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText("");
                cursor[0]=1;
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t3.setText("");
                cursor[0]=2;
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t4.setText("");
                cursor[0]=3;
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t5.setText("");
                cursor[0]=4;
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t6.setText("");
                cursor[0]=5;
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t7.setText("");
                cursor[0]=6;
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t8.setText("");
                cursor[0]=7;
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t9.setText("");
                cursor[0]=8;
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseSem1List.this,CseSemList.class);
                startActivity(intent);
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            float res = calculate();
            result.setText(""+res);
            result.setVisibility(View.VISIBLE);
            cpyIcon.setVisibility(View.VISIBLE);
            copy.setVisibility(View.VISIBLE);
            resultText.setVisibility(View.VISIBLE);
//            writeGpa();
//            export.setVisibility(View.VISIBLE);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                result.setVisibility(View.GONE);
                cpyIcon.setVisibility(View.GONE);
                copy.setVisibility(View.GONE);
                resultText.setVisibility(View.GONE);
                t1.requestFocus();
                cursor[0]=0;
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//                ClipData clipData = ClipData.newPlainText("text",result.getText().toString());
//                clipboardManager.setPrimaryClip(clipData);
//                Toast.makeText(CseSem1List.this,"GPA Copied",Toast.LENGTH_SHORT).show();
                //sem1Gpa=Float.valueOf(result.getText().toString());
                write();
            }
        });

        cpyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text",result.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(CseSem1List.this,"GPA Copied",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public float calculate()
    {
        int val1,val2,val3,val4,val5,val6,val7,val8,val9;
        if (t1.getText().toString().equals("S")||t1.getText().toString().equals("s"))
        {
            val1=10;
        }else if(t1.getText().toString().equals("A")||t1.getText().toString().equals("a")){
            val1=9;
        }else if(t1.getText().toString().equals("B")||t1.getText().toString().equals("b")){
            val1=8;
        }else if(t1.getText().toString().equals("C")||t1.getText().toString().equals("c")){
            val1=7;
        }else if(t1.getText().toString().equals("D")||t1.getText().toString().equals("d")){
            val1=6;
        }else if(t1.getText().toString().equals("E")||t1.getText().toString().equals("e")){
            val1=5;
        }else{
            val1=0;
        }

        if (t2.getText().toString().equals("S")||t2.getText().toString().equals("s"))
        {
            val2=10;
        }else if(t2.getText().toString().equals("A")||t2.getText().toString().equals("a")){
            val2=9;
        }else if(t2.getText().toString().equals("B")||t2.getText().toString().equals("b")){
            val2=8;
        }else if(t2.getText().toString().equals("C")||t2.getText().toString().equals("c")){
            val2=7;
        }else if(t2.getText().toString().equals("D")||t2.getText().toString().equals("d")){
            val2=6;
        }else if(t2.getText().toString().equals("E")||t2.getText().toString().equals("e")){
            val2=5;
        }else{
            val2=0;
        }

        if (t3.getText().toString().equals("S")||t3.getText().toString().equals("s"))
        {
            val3=10;
        }else if(t3.getText().toString().equals("A")||t3.getText().toString().equals("a")){
            val3=9;
        }else if(t3.getText().toString().equals("B")||t3.getText().toString().equals("b")){
            val3=8;
        }else if(t3.getText().toString().equals("C")||t3.getText().toString().equals("c")){
            val3=7;
        }else if(t3.getText().toString().equals("D")||t3.getText().toString().equals("d")){
            val3=6;
        }else if(t3.getText().toString().equals("E")||t3.getText().toString().equals("e")){
            val3=5;
        }else{
            val3=0;
        }

        if (t4.getText().toString().equals("S")||t1.getText().toString().equals("s"))
        {
            val4=10;
        }else if(t4.getText().toString().equals("A")||t4.getText().toString().equals("a")){
            val4=9;
        }else if(t4.getText().toString().equals("B")||t4.getText().toString().equals("b")){
            val4=8;
        }else if(t4.getText().toString().equals("C")||t4.getText().toString().equals("c")){
            val4=7;
        }else if(t4.getText().toString().equals("D")||t4.getText().toString().equals("d")){
            val4=6;
        }else if(t4.getText().toString().equals("E")||t4.getText().toString().equals("e")){
            val4=5;
        }else{
            val4=0;
        }

        if (t5.getText().toString().equals("S")||t5.getText().toString().equals("s"))
        {
            val5=10;
        }else if(t5.getText().toString().equals("A")||t5.getText().toString().equals("a")){
            val5=9;
        }else if(t5.getText().toString().equals("B")||t5.getText().toString().equals("b")){
            val5=8;
        }else if(t5.getText().toString().equals("C")||t5.getText().toString().equals("c")){
            val5=7;
        }else if(t5.getText().toString().equals("D")||t5.getText().toString().equals("d")){
            val5=6;
        }else if(t5.getText().toString().equals("E")||t5.getText().toString().equals("e")){
            val5=5;
        }else{
            val5=0;
        }

        if (t6.getText().toString().equals("S")||t6.getText().toString().equals("s"))
        {
            val6=10;
        }else if(t6.getText().toString().equals("A")||t6.getText().toString().equals("a")){
            val6=9;
        }else if(t6.getText().toString().equals("B")||t6.getText().toString().equals("b")){
            val6=8;
        }else if(t6.getText().toString().equals("C")||t6.getText().toString().equals("c")){
            val6=7;
        }else if(t6.getText().toString().equals("D")||t6.getText().toString().equals("d")){
            val6=6;
        }else if(t6.getText().toString().equals("E")||t6.getText().toString().equals("e")){
            val6=5;
        }else{
            val6=0;
        }

        if (t7.getText().toString().equals("S")||t7.getText().toString().equals("s"))
        {
            val7=10;
        }else if(t7.getText().toString().equals("A")||t7.getText().toString().equals("a")){
            val7=9;
        }else if(t7.getText().toString().equals("B")||t7.getText().toString().equals("b")){
            val7=8;
        }else if(t7.getText().toString().equals("C")||t7.getText().toString().equals("c")){
            val7=7;
        }else if(t7.getText().toString().equals("D")||t7.getText().toString().equals("d")){
            val7=6;
        }else if(t7.getText().toString().equals("E")||t7.getText().toString().equals("e")){
            val7=5;
        }else{
            val7=0;
        }

        if (t8.getText().toString().equals("S")||t8.getText().toString().equals("s"))
        {
            val8=10;
        }else if(t8.getText().toString().equals("A")||t8.getText().toString().equals("a")){
            val8=9;
        }else if(t8.getText().toString().equals("B")||t8.getText().toString().equals("b")){
            val8=8;
        }else if(t8.getText().toString().equals("C")||t8.getText().toString().equals("c")){
            val8=7;
        }else if(t8.getText().toString().equals("D")||t8.getText().toString().equals("d")){
            val8=6;
        }else if(t8.getText().toString().equals("E")||t8.getText().toString().equals("e")){
            val8=5;
        }else{
            val8=0;
        }

        if (t9.getText().toString().equals("S")||t9.getText().toString().equals("s"))
        {
            val9=10;
        }else if(t9.getText().toString().equals("A")||t9.getText().toString().equals("a")){
            val9=9;
        }else if(t9.getText().toString().equals("B")||t9.getText().toString().equals("b")){
            val9=8;
        }else if(t9.getText().toString().equals("C")||t9.getText().toString().equals("c")){
            val9=7;
        }else if(t9.getText().toString().equals("D")||t9.getText().toString().equals("d")){
            val9=6;
        }else if(t9.getText().toString().equals("E")||t9.getText().toString().equals("e")){
            val9=5;
        }else{
            val9=0;
        }

        float res = ((float)val1*4+(float)val2*4+(float)val3*4+(float)val4*4+(float)val5*4+(float)val6*4+(float)val7*2+(float)val8*2+(float)val9*2)/30;

        return res;
    }

    private void setupSemInputs() {
        final View view = this.getCurrentFocus();
        t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if(view!=null){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(),0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(view!=null){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(),0);
                }
                if (!s.toString().trim().isEmpty()) {


                    t2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t7.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t8.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t9.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                //    t1.requestFocus();
                    InputMethodManager imm  =  (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void write(){
        String textToSave = result.getText().toString();

        try{
            FileOutputStream fileOutputStream = openFileOutput("sem1.txt",MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();
            Toast.makeText(CseSem1List.this,"Added To CGPA ",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeGpa(){
        String textToSave = t1.getText().toString().toUpperCase()+" "+ t2.getText().toString().toUpperCase()+" "+t3.getText().toString().toUpperCase()+" "+t4.getText().toString().toUpperCase()+" "+t5.getText().toString().toUpperCase()+" "+t6.getText().toString().toUpperCase()+" "+t7.getText().toString().toUpperCase()+" "+t8.getText().toString().toUpperCase()+" "+t9.getText().toString().toUpperCase()+" "+result.getText().toString() ;

        try{
            FileOutputStream fileOutputStream = openFileOutput("sem1Gpa.txt",MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();
            Toast.makeText(CseSem1List.this,"Export ",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readSubWithGrades() {
        String[] sub = {"M I","Physics","Chemistry","BEEE","TD","CP","CP  Lab","EG","BEE  Lab","GPA"};
        try {
            FileInputStream fileInputStream = openFileInput("sem1Gpa.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines= bufferedReader.readLine();
            String a  = lines.trim().replaceAll(" ","");
            temp  ="";
            int j = 0;
            char[] ch=a.toCharArray();
            for(int  i=0;i<10;i++)
            {
                if(i==9){
                    String gp="";
                    for(int x=i;x<ch.length;x++){
                        gp +=ch[x];
                    }
                    temp = temp + "\n"+sub[j]+" : "+gp;
                }else{
                    temp = temp + "\n"+sub[j]+" : "+ch[i];
                }
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void generatePDF() {
        // creating an object variable for our PDF document.
        String[] sub = {"M I","Physics","Chemistry","BEEE","TD","CP","CP  Lab","EG","BEE  Lab","GPA"};
        PdfDocument pdfDocument = new PdfDocument();

        // two variables for paint "paint" is used for drawing shapes and we will use "title" for adding text in our PDF file.
        Paint paint = new Paint();
        Paint title = new Paint();
        Paint heading = new Paint();

        // we are adding page info to our PDF file in which we will be passing our pageWidth, pageHeight and number of pages and after that we are calling it to create our PDF.
        PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();

        // below line is used for setting start page for our PDF file.
        PdfDocument.Page myPage = pdfDocument.startPage(mypageInfo);

        // creating a variable for canvas from our page of PDF.
        Canvas canvas = myPage.getCanvas();

        // below line is used to draw our image on our PDF file.the first parameter of our drawbitmap method is our bitmap second parameter is position from left third parameter is position from top and last one is our variable for paint.
        canvas.drawBitmap(logoscaledbmp, 56, 40, paint);
        canvas.drawBitmap(tcscaledbmp, 620, 40, paint);

        // below line is used for adding typeface for our text which we will be adding in our PDF file.
        title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        heading.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));

        // below line is used for setting text size which we will be displaying in our PDF file.
        title.setTextSize(15);
        heading.setTextSize(25);

        // below line is sued for setting color of our text inside our PDF file.
        title.setColor(ContextCompat.getColor(this, R.color.black));

        // below line is used to draw text in our PDF file. the first parameter is our text, second parameter is position from start, third parameter is position from top and then we are passing our variable of paint which is title.
//        canvas.drawText("CGPA CALCULATOR", 209, 80, title);
//        canvas.drawText("CGPA DOCUMENT.", 209, 100, title);

        canvas.drawText("Name          : "+nameStr, 209, 100, heading);
        canvas.drawText("Department    : "+deptStr, 209, 125, heading);



        // similarly we are creating another text and in this we are aligning this text to center of our PDF file.
        title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        title.setColor(ContextCompat.getColor(this, R.color.black));
        title.setTextSize(15);

        // below line is used for setting our text to center of PDF.
        title.setTextAlign(Paint.Align.CENTER);
        int heightInterval =205;
//        canvas.drawText(temp, 396, 205, title);
//        canvas.drawText(temp, 396, 230, title);
//        canvas.drawText(temp, 396, 560, title);
        try {
            FileInputStream fileInputStream = openFileInput("sem1Gpa.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines= bufferedReader.readLine();
            String a  = lines.trim().replaceAll(" ","");
            temp  ="";
            int j = 0;
            char[] ch=a.toCharArray();
            for(int  i=0;i<10;i++)
            {
                if(i==9){
                    String gp="";
                    for(int x=i;x<ch.length;x++){
                        gp +=ch[x];
                    }
                    canvas.drawText(String.format(sub[j]+" : "+gp), 396, heightInterval+10, title);
                }else{
                    canvas.drawText(String.format(sub[j]+" : "+ch[i]), 396, heightInterval, title);
                    heightInterval+=25;
//                    temp = temp + "\n"+sub[j]+" : "+ch[i];
                }
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // after adding all attributes to our PDF file we will be finishing our page.
        pdfDocument.finishPage(myPage);

        // below line is used to set the name of our PDF file and its path.
        File file = new File(Environment.getExternalStorageDirectory(), "sem1.pdf");



        try {
            // after creating a file name we will write our PDF file to that location.
            pdfDocument.writeTo(new FileOutputStream(file));

            // below line is to print toast message on completion of PDF generation.
            Toast.makeText(CseSem1List.this, "PDF file generated successfully.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // after storing our pdf to that location we are closing our PDF file.
        pdfDocument.close();
    }
    public void readprofileInfo() {
        try {
            FileInputStream fileInputStream = openFileInput("name.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            nameStr=stringBuffer.toString();
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
            profStr=stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(profStr.replaceAll("\n","").equals("Student")){
            try {
                FileInputStream fileInputStream = openFileInput("dept.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();

                String lines;
                while ((lines = bufferedReader.readLine()) != null) {
                    stringBuffer.append(lines + "\n");
                }
                deptStr=stringBuffer.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


