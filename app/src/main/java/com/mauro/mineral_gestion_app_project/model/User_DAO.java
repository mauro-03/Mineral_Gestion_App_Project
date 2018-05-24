package com.mauro.mineral_gestion_app_project.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by mauro on 11-05-18.
 */

public class User_DAO extends DAO<User> {

    private SQLiteDatabase bdd;
    private MineralGestion_DB_SQLite mineral_gestion;

    private static final String  table_user = "table_user";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NAME= "NAME";
    private static final int NUM_COL_NAME = 1;
    private static final String COL_SURNAME = "SURNAME";
    private static final int NUM_COL_SURNAME = 2;
    private static final String COL_EMAIL = "EMAIL";
    private static final int NUM_COL_EMAIL = 3;
    private static final String COL_PHONE = "PHONE";
    private static final int NUM_COL_PHONE = 4;

    public User_DAO() {
        super();
    }

    // Override methods that come from class DAO
    @Override
    public long insert(User object) {
        ContentValues content = new ContentValues();
        content.put(COL_NAME, object.getUser_name());
        content.put(COL_SURNAME, object.getUser_surname());
        content.put(COL_EMAIL, object.getUser_email());
        content.put(COL_PHONE, object.getUser_phone());

        return bdd.insert(table_user, null, content);
    }

    @Override
    public int update(int id, User object) {
        ContentValues content = new ContentValues();
        content.put(COL_NAME, object.getUser_name());
        content.put(COL_SURNAME, object.getUser_surname());
        content.put(COL_EMAIL, object.getUser_email());
        content.put(COL_PHONE, object.getUser_phone());

        return bdd.update(table_user, content, COL_ID + " = " + id, null );
    }

    @Override
    public int remove(int id) {
        return bdd.delete(table_user, COL_ID + " = " + id, null);
    }

    @Override
    public User getObject(String surname) {
        Cursor c = bdd.query(table_user, new String[] {COL_ID, COL_NAME, COL_SURNAME, COL_EMAIL, COL_PHONE},
                COL_SURNAME + " LIKE \"" + surname + " \"", null, null, null, COL_NAME );
        return cursorToObject(c);
    }

    @Override
    public User cursorToObject(Cursor c) {
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        c.moveToFirst();
        User user = new User();
        user.setUser_id(c.getInt(NUM_COL_ID));
        user.setUser_name(c.getString(NUM_COL_NAME));
        user.setUser_surname(c.getString(NUM_COL_SURNAME));
        user.setUser_email(c.getString(NUM_COL_EMAIL));
        user.setUser_phone(c.getString(NUM_COL_PHONE));
        c.close();
        return user;
    }

    @Override
    public ArrayList<User> getAllObject() {
        Cursor c = bdd.query(table_user, new String[] { COL_ID, COL_NAME, COL_SURNAME, COL_EMAIL,
                COL_PHONE}, null, null, null, null, COL_ID );
        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<User> list_user = new ArrayList<>();
        c.moveToFirst();
        do{
            User user = new User();
            user.setUser_id(c.getInt(NUM_COL_ID));
            user.setUser_name(c.getString(NUM_COL_NAME));
            user.setUser_surname(c.getString(NUM_COL_SURNAME));
            user.setUser_email(c.getString(NUM_COL_EMAIL));
            user.setUser_phone(c.getString(NUM_COL_PHONE));
            list_user.add(user);
        }while(c.moveToNext());
        return list_user;
    }
}
