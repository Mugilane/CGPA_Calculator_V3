package com.syndicate.cgpacalculator.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.syndicate.cgpacalculator.adapters.ImageAdapter;
import com.syndicate.cgpacalculator.R;
import com.syndicate.cgpacalculator.ai.AiSemList;
import com.syndicate.cgpacalculator.ai23.Ai23SemList;
import com.syndicate.cgpacalculator.biomed.BioMedSemList;
import com.syndicate.cgpacalculator.chemical.ChemicalSemList;
import com.syndicate.cgpacalculator.civil.CivilSemList;
import com.syndicate.cgpacalculator.cse.CseSemList;
import com.syndicate.cgpacalculator.ece.EceSemList;
import com.syndicate.cgpacalculator.eee.EeeSemList;
import com.syndicate.cgpacalculator.eie.EieSemList;
import com.syndicate.cgpacalculator.foodtech.FoodTechSemList;
import com.syndicate.cgpacalculator.it.ItSemList;
import com.syndicate.cgpacalculator.mech.MechSemList;

import com.syndicate.cgpacalculator.mca.McaSem1list;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeptListFragment extends Fragment {
    AppCompatImageView BtnArts,BtnEngg,Btnback;
    LinearLayout StudyDiv,deptDiv;
    GridView gridView;

    public DeptListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dept_list, container, false);

        StudyDiv = view.findViewById(R.id.StudyDiv);
        deptDiv = view.findViewById(R.id.deptDiv);
        BtnArts  = view.findViewById(R.id.arts);
        BtnEngg  = view.findViewById(R.id.engg);
        Btnback = view.findViewById(R.id.backBtn);
        gridView = view.findViewById(R.id.gridview);
        gridView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        BtnEngg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudyDiv.setVisibility(View.GONE);
                deptDiv.setVisibility(View.VISIBLE);

            }
        });
        Btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deptDiv.setVisibility(View.GONE);
                StudyDiv.setVisibility(View.VISIBLE);


            }
        });


        BtnArts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Under Developement", Toast.LENGTH_SHORT).show();
            }
        });

        ImageAdapter imageAdapter = new ImageAdapter(view.getContext());
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getActivity(), CseSemList.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(getActivity(), EceSemList.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(getActivity(), EeeSemList.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(getActivity(), MechSemList.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(getActivity(), CivilSemList.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(getActivity(), ItSemList.class);
                    startActivity(intent);
                } else if (i == 6) {
                    Intent intent = new Intent(getActivity(), McaSem1list.class);
                    startActivity(intent);
                }else if (i == 7) {
                    Intent intent = new Intent(getActivity(), AiSemList.class);
                    startActivity(intent);
                } else if (i == 8) {
                    Intent intent = new Intent(getActivity(), Ai23SemList.class);
                    startActivity(intent);
                } else if (i == 9) {
                    Intent intent = new Intent(getActivity(), BioMedSemList.class);
                    startActivity(intent);
                } else if (i == 10) {
                    Intent intent = new Intent(getActivity(), ChemicalSemList.class);
                    startActivity(intent);
                } else if (i == 11) {
                    Intent intent = new Intent(getActivity(), EieSemList.class);
                    startActivity(intent);
                } else if (i == 12) {
                    Intent intent = new Intent(getActivity(), FoodTechSemList.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

}


//        btnCSE = view.findViewById(R.id.btnCse);
//        btnIT = view.findViewById(R.id.btnIt);
//        btnECE = view.findViewById(R.id.btnECE);
//        btnEEE = view.findViewById(R.id.btnEEE);
//        btnMech = view.findViewById(R.id.btnMech);
//        btnCivil = view.findViewById(R.id.btnCivil);
//
//        btnCSE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),CseSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnIT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),ItSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnECE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),EceSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnEEE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),EeeSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnMech.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),MechSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnCivil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),CivilSemList.class);
//                startActivity(intent);
//            }
//        });

