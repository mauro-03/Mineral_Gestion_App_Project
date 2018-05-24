package com.mauro.mineral_gestion_app_project.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mauro.mineral_gestion_app_project.R;
import com.mauro.mineral_gestion_app_project.model.User_DAO;

public class MainActivity extends AppCompatActivity {

    User_DAO mUser_dao;
    Intent inscriptionActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");

        Button connect_button = (Button) findViewById(R.id.connect_button);
        EditText username_Entry = (EditText) findViewById(R.id.username);

        //mUser_dao = new User_DAO(this);

        connect_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
    }
}
