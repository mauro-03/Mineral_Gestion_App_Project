package com.mauro.mineral_gestion_app_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InscriptionActivity extends AppCompatActivity {

    EditText name_editText;
    EditText surname_editText;
    EditText email_editText;
    EditText phone_editText;
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        //Components
        Button signUp_button = (Button)findViewById(R.id.button_register);
        name_editText= (EditText)findViewById(R.id.editText_name);
        surname_editText = (EditText)findViewById(R.id.editText_surname);
        email_editText = (EditText)findViewById(R.id.editText_email);
        phone_editText = (EditText)findViewById(R.id.editText_phone);
        test = (TextView)findViewById(R.id.textView3);

        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name_editText.getText().toString();
                String surname = surname_editText.getText().toString();
                String email = email_editText.getText().toString();
                String phone = phone_editText.getText().toString();

            }
        });
    }
}
