package com.mauro.mineral_gestion_app_project.controller;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mauro.mineral_gestion_app_project.R;
import com.mauro.mineral_gestion_app_project.model.User;
import com.mauro.mineral_gestion_app_project.model.User_DAO;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {
    // TEST, A SUPP !!
    TextView test;

    //Components
    Button btnSeeAllMinerals;
    Button btnAddMineral;
    Button btnSignOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        final String idUser = intent.getStringExtra("idUser");

        btnSeeAllMinerals = (Button)findViewById(R.id.button_allMinerals);
        btnAddMineral = (Button)findViewById(R.id.button_addMineral);
        btnSignOut = (Button)findViewById(R.id.button_signOut);

        btnSeeAllMinerals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seeAllMineralIntent = new Intent(HomeActivity.this, ListMineralsActivity.class);
                seeAllMineralIntent.putExtra("idUser", idUser);
                startActivity(seeAllMineralIntent);
            }
        });

        btnAddMineral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMineralIntent = new Intent(HomeActivity.this, NewMineralActivity.class);
                newMineralIntent.putExtra("idUser", idUser);
                startActivity(newMineralIntent);

            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });



        // TEST, A SUPP !!!

        test = (TextView)findViewById(R.id.textView4);

        Context context = getApplicationContext();
        User_DAO user_dao = new User_DAO(context);
        user_dao.openForRead();
        ArrayList<User> listUser = user_dao.getAllObject();
        User user = listUser.get(0);
        String textetest = user.getUser_surname();
        test.setText(textetest);
    }
}
