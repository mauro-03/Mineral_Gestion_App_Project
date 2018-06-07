package com.mauro.mineral_gestion_app_project.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mauro.mineral_gestion_app_project.R;
import com.mauro.mineral_gestion_app_project.model.Mineral;
import com.mauro.mineral_gestion_app_project.model.Mineral_DAO;

import java.util.ArrayList;

public class ListMineralsActivity extends AppCompatActivity {

    ListView listMinerals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_minerals);

        Intent homeIntent = getIntent();
        final String fk_user = homeIntent.getStringExtra("idUser");
        int fk_userInt = Integer.parseInt(fk_user);

        listMinerals = (ListView)findViewById(R.id.mineralsList);

        Context context = getApplicationContext();
        Mineral_DAO mineral_dao = new Mineral_DAO(context);
        mineral_dao.openForRead();
        final ArrayList<Mineral> minerals = mineral_dao.getAllObject(fk_userInt);
        mineral_dao.close();

        //Creating an array with id an name to display in the listView
        ArrayList<String> basicsMinerals = new ArrayList<>();
        for (int i = 0; i<minerals.size(); i++){
            String text = " ID : " + minerals.get(i).getMineral_id() + "    Name : " + minerals.get(i).getMineral_name()
                    + "    Color : " + minerals.get(i).getMineral_color();
            basicsMinerals.add(text);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, basicsMinerals);
        listMinerals.setAdapter(adapter);

        listMinerals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mineral mineralToDetail = minerals.get(position);
                int id_mineral = mineralToDetail.getMineral_id();
                String id_mineralString = Integer.toString(id_mineral);

                Intent mineralDetailIntent = new Intent(ListMineralsActivity.this, MineralDetailActivity.class);
                mineralDetailIntent.putExtra("idMineral", id_mineralString);
                mineralDetailIntent.putExtra("idUser", fk_user);
                startActivity(mineralDetailIntent);

                // j'ai une erreur sur l'id que tu envoies
            }
        });

    }
}
