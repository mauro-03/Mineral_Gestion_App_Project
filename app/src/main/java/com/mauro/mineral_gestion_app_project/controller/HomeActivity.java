package com.mauro.mineral_gestion_app_project.controller;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mauro.mineral_gestion_app_project.R;
import com.mauro.mineral_gestion_app_project.model.User;
import com.mauro.mineral_gestion_app_project.model.User_DAO;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        test = (TextView)findViewById(R.id.textView4);

        User user;
        Context context = getApplicationContext();
        User_DAO user_dao = new User_DAO(context);
        Cursor c = (Cursor) user_dao.getObject("mau");
        user = user_dao.cursorToObject(c);
        String textetest = user.getUser_surname();
        test.setText(textetest);
    }
}
