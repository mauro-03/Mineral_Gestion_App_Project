package com.mauro.mineral_gestion_app_project.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mauro.mineral_gestion_app_project.R;
import com.mauro.mineral_gestion_app_project.model.User;
import com.mauro.mineral_gestion_app_project.model.User_DAO;

import java.nio.file.attribute.UserDefinedFileAttributeView;


public class HomeActivity extends AppCompatActivity {

    TextView test = (TextView)findViewById(R.id.textView4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        User user = new User();
        Context context = getApplicationContext();
        User_DAO user_dao = new User_DAO(context);
        user = user_dao.getObject("mau");
        String textetest = user.getUser_surname();
        test.setText(textetest);
    }
}
