package com.mauro.mineral_gestion_app_project.controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        final EditText phone_num = (EditText) findViewById(R.id.editTextPhoneNumber);
        Button sendButton = (Button) findViewById(R.id.sendButton);


        Bundle bundle= getIntent().getExtras();
        if(bundle != null){
            id = (int) bundle.get("ID");
        }
        else{
            id = 0;
        }


        //try{

            final Context context = getApplicationContext();
            mMineral_dao = new Mineral_DAO(context);
            mMineral_dao.openForRead();
            mineral = mMineral_dao.getId(id);
            mMineral_dao.close();


            final String setName = " Name : " + mineral.getMineral_name();
            final String setSystCrist = "Syst Crist :" + mineral.getMineral_systCrist();
            final String setColor = "Color :" + mineral.getMineral_color();
            final String setGlow = "Glow :" + mineral.getMineral_glow();
            final String setAspect = "Aspect : " + mineral.getMineral_aspect();
            final String setClivage = "Clivage : " + mineral.getMineral_clivage();
            final String setHardness = "Hardness :" + mineral.getMineral_hardness();
            final String setDensity = "Density :" + mineral.getMineral_density();
            final String setPrice = "Price :" + mineral.getMineral_price();

            nameView.setText(setName);
            systCristView.setText(setSystCrist);
            colorView.setText(setColor);
            glowView.setText(setGlow);
            aspectView.setText(setAspect);
            clivageView.setText(setClivage);
            hardnessView.setText(setHardness);
            densityView.setText(setDensity);
            priceView.setText(setPrice);
        //}
        //catch(Exception e){
            //Toast.makeText(MineralDetailActivity.this, e.toString(),Toast.LENGTH_LONG).show();
        //}

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    String message = "Informations" + setName + setSystCrist + setColor + setGlow + setAspect + setClivage + setHardness + setDensity + setPrice;
                    sms(message);
                }
                catch(Exception e){
                    Toast.makeText(MineralDetailActivity.this, e.toString(),Toast.LENGTH_LONG).show();
                }
            }

            private void sms(String message) {
                if(phone_num.length()>= 4){
                    SmsManager.getDefault().sendTextMessage(String.valueOf(phone_num), null, message, null, null );
                }
            }
        });


    }
}
