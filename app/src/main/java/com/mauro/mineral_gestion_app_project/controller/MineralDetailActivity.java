package com.mauro.mineral_gestion_app_project.controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mauro.mineral_gestion_app_project.R;
import com.mauro.mineral_gestion_app_project.model.Mineral;
import com.mauro.mineral_gestion_app_project.model.Mineral_DAO;

public class MineralDetailActivity extends AppCompatActivity {

    Mineral mineral;
    Mineral_DAO mMineral_dao;

    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mineral_detail);
        setTitle("Mineral details");


        TextView nameView = (TextView) findViewById(R.id.textViewName);
        TextView systCristView = (TextView) findViewById(R.id.textViewSystCrist);
        TextView colorView = (TextView) findViewById(R.id.textViewColor);
        TextView glowView = (TextView) findViewById(R.id.textViewGlow);
        TextView aspectView = (TextView) findViewById(R.id.textViewAspect);
        TextView clivageView = (TextView) findViewById(R.id.textViewClivage);
        TextView hardnessView = (TextView) findViewById(R.id.textViewHardness);
        TextView densityView = (TextView) findViewById(R.id.textViewDensity);
        TextView priceView = (TextView) findViewById(R.id.textViewPrice);

        Bundle bundle= getIntent().getExtras();
        if(bundle != null){
            id = (int) bundle.get("ID");
        }
        else{
            id = 0;
        }

        final Context context = getApplicationContext();
        mMineral_dao = new Mineral_DAO(context);
        mMineral_dao.openForRead();
        mineral = mMineral_dao.getId(id);
        mMineral_dao.close();


        String setName = " Name : " + mineral.getMineral_name();
        /*String setSystCrist = "Syst Crist :" + mineral.getMineral_systCrist();
        String setColor = "Color :" + mineral.getMineral_color();
        String setGlow = "Glow :" + mineral.getMineral_glow();
        String setAspect = "Aspect : " + mineral.getMineral_aspect();
        String setClivage = "Clivage : " + mineral.getMineral_clivage();
        String setHardness = "Hardness :" + mineral.getMineral_hardness();
        String setDensity = "Density :" + mineral.getMineral_density();
        String setPrice = "Price :" + mineral.getMineral_price();*/

        nameView.setText(setName);
        /*systCristView.setText(setSystCrist);
        colorView.setText(setColor);
        glowView.setText(setGlow);
        aspectView.setText(setAspect);
        clivageView.setText(setClivage);
        hardnessView.setText(setHardness);
        densityView.setText(setDensity);
        priceView.setText(setPrice);*/


    }
}
