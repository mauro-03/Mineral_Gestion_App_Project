package com.mauro.mineral_gestion_app_project.controller;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

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

        final Context context = getApplicationContext();
        mUser_dao = new User_DAO(context);

        connect_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameEntry.getText().toString();
                String code = codeEntry.getText().toString();

                mUser_dao.openForRead();
                User findUser = mUser_dao.getObject(username);

                if(findUser != null){
                    if(findUser.getUser_username().equals(username)
                            && findUser.getUser_pinCode().equals(code)){
                        Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                        String idUser = Integer.toString(findUser.getUser_id());
                        homeIntent.putExtra("idUser", idUser);
                        startActivity(homeIntent);
                    }
                }else{
                    String txt = "username/pinCode incorrects";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, txt, duration);
                    toast.show();

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
