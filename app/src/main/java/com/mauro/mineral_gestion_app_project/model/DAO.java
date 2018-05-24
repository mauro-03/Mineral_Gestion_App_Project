package com.mauro.mineral_gestion_app_project.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by mauro on 11-05-18.
 */

public abstract class DAO<T> {
    public static final String name = "Mineral_Gestion_DB";
    public static final int version = 1;

    private SQLiteDatabase bdd;
    private MineralGestion_DB_SQLite mineral_gestion;

    public DAO(){}

    public DAO(Context context){
        mineral_gestion = new MineralGestion_DB_SQLite(context, name, null, version);
    }

    public void openForWrite() {
        bdd = mineral_gestion.getWritableDatabase();
    }

    public void openForRead() {
        bdd = mineral_gestion.getReadableDatabase();
    }

    public void close(){ bdd.close(); }

    public SQLiteDatabase getBdd() {
        return bdd;
    }

    //Abstracts methods, defined in the T_DAO classes that extends this one
    public abstract long insert( T object);
    public abstract int update(int id, T object);
    public abstract int remove(int id);
    public abstract T getObject(String name);
    public abstract T cursorToObject(Cursor c);
    public abstract ArrayList<T> getAllObject();



}
