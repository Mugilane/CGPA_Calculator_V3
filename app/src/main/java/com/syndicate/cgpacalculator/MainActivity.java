package com.syndicate.cgpacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.tabs.TabLayout;
import com.syndicate.cgpacalculator.adapters.TabsAccessAdapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager pager;

    TabLayout tabLayout;
    //   Button btnCSE,btnIT,btnECE,btnEEE,btnMech,btnCivil,btnCgpa;
    TabsAccessAdapter tabsAccessAdapter;


    @Override
    protected void onStart() {
        super.onStart();
        isLogged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnCSE = findViewById(R.id.btnCse);
//        btnIT = findViewById(R.id.btnIt);
//        btnECE = findViewById(R.id.btnECE);
//        btnEEE = findViewById(R.id.btnEEE);
//        btnMech = findViewById(R.id.btnMech);
//        btnCivil = findViewById(R.id.btnCivil);
//        btnCgpa = findViewById(R.id.btnCgpa);


        toolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<small>CGPA Calculator</small>"));

        pager = findViewById(R.id.main_tabs_pager);
        tabsAccessAdapter = new TabsAccessAdapter(getSupportFragmentManager());
        pager.setAdapter(tabsAccessAdapter);
        tabLayout = findViewById(R.id.main_tabs);
        pager.setCurrentItem(1);
        tabLayout.setupWithViewPager(pager);


//        btnCSE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,CseSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnIT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,ItSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnECE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,EceSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnEEE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,EeeSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnMech.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,MechSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnCivil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,CivilSemList.class);
//                startActivity(intent);
//            }
//        });
//
//
//        btnCgpa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,Cgpa.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options_menu, menu);
        for(int i=0;i<menu.size();i++){
            MenuItem item = menu.getItem(i);
            SpannableString spannableString = new SpannableString(menu.getItem(i).getTitle().toString());
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK),0,spannableString.length(),0);
            item.setTitle(spannableString);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.main_help_option) {
            Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.main_about_option) {
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.main_rateus_option) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
        }
        if (item.getItemId() == R.id.main_profile_option) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.main_more_apps_option) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=5381883898197393897")));
        }
        return true;
    }

    public void isLogged() {
        try {
            FileInputStream fileInputStream = openFileInput("logged.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines);
            }
            int a = Integer.parseInt(stringBuffer.toString());
            Boolean b = (a == 1);
            if (!b) {
                Intent intent = new Intent(MainActivity.this, SetupProfile.class);
                startActivity(intent);
                finish();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Intent intent = new Intent(MainActivity.this, SetupProfile.class);
            startActivity(intent);
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
