package com.mauro.mineral_gestion_app_project.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mauro.mineral_gestion_app_project.R;
import com.mauro.mineral_gestion_app_project.model.User;
import com.mauro.mineral_gestion_app_project.model.User_DAO;

public class InscriptionActivity extends AppCompatActivity {

    EditText name_editText;
    EditText surname_editText;
    EditText email_editText;
    EditText phone_editText;
    TextView test;

    User user;
    User_DAO mUser_dao;

    Intent connexionActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        setTitle("Inscription");

        //Components
        Button signUp_button = (Button)findViewById(R.id.button_register);
        name_editText= (EditText)findViewById(R.id.editText_name);
        surname_editText = (EditText)findViewById(R.id.editText_surname);
        email_editText = (EditText)findViewById(R.id.editText_email);
        phone_editText = (EditText)findViewById(R.id.editText_phone);
        test = (TextView)findViewById(R.id.textView3);

        mUser_dao = new User_DAO(this);



        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = name_editText.getText().toString();
                String surname = surname_editText.getText().toString();
                String email = email_editText.getText().toString();
                String phone = phone_editText.getText().toString();


                user.setUser_name(name);
                user.setUser_surname(surname);
                user.setUser_email(email);
                user.setUser_phone(phone);

                mUser_dao.openForWrite();
                mUser_dao.update(user.getUser_id(), user);
                mUser_dao.close();

                //connexionActivity = new Intent(InscriptionActivity.this, ConnexionActivity.class);
                //startActivity(connexionActivity);

            }
        });
    }
}
