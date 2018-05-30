package com.mauro.mineral_gestion_app_project.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mauro.mineral_gestion_app_project.R;
import com.mauro.mineral_gestion_app_project.model.User;
import com.mauro.mineral_gestion_app_project.model.User_DAO;

import java.util.ArrayList;

// class permettant de se connecter à l'application

public class MainActivity extends AppCompatActivity {

    User_DAO mUser_dao;

    Button connect_button;
    Button register_button;
    EditText usernameEntry;
    EditText codeEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");

        connect_button = (Button) findViewById(R.id.connect_button);
        register_button = (Button) findViewById(R.id.register_button);
        usernameEntry = (EditText) findViewById(R.id.username);
        codeEntry = (EditText) findViewById(R.id.code);

        Context context = getApplicationContext();
        mUser_dao = new User_DAO(context);

        connect_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameEntry.getText().toString();
                String code = codeEntry.getText().toString();

                //User user = mUser_dao.getObject(username);

                if(code.equals("0000") && username.equals("mau")){
                    Intent homeActivity = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(homeActivity);
                }
            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerActivity);
            }
        });
    }
}
