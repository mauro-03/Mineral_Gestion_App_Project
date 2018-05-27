package com.mauro.mineral_gestion_app_project.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Chemical_DAO extends DAO<Chemical>  {

    private SQLiteDatabase db;
    private MineralGestion_DB_SQLite mineralGestion_db;

    private static final String table_chemical = "table_chemical";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_FORMULA = "FORMULA";
    private static final int NUM_COL_FORMULA = 1;
    private static final String COL_CLASS = "CLASS";
    private static final int NUM_COL_CLASS = 2;


    // Override methods that come from class DAO
    @Override
    public long insert(Chemical object) {
        ContentValues content = new ContentValues();
        content.put(COL_FORMULA, object.getChemical_formula());
        content.put(COL_CLASS, object.getChemical_class());

        return db.insert(table_chemical, null, content);
    }

    @Override
    public int update(int id, Chemical object) {
        ContentValues content = new ContentValues();
        content.put(COL_FORMULA, object.getChemical_formula());
        content.put(COL_CLASS, object.getChemical_class());

        return db.update(table_chemical, content, COL_ID + " = " + id, null );
    }

    @Override
    public int remove(int id) {
        return db.delete(table_chemical, COL_ID + " = " + id, null);
    }

    @Override
    public Chemical getObject(String formula) {
        Cursor c = db.query(table_chemical, new String[] {COL_ID, COL_FORMULA, COL_CLASS}, COL_FORMULA + " LIKE \"" +
                formula + " \"", null, null, null, COL_FORMULA );
        return cursorToObject(c);
    }

    @Override
    public Chemical cursorToObject(Cursor c) {
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        c.moveToFirst();
        Chemical chemical = new Chemical();
        chemical.setChemical_id(c.getInt(NUM_COL_ID));
        chemical.setChemical_formula(c.getString(NUM_COL_FORMULA));
        chemical.setChemical_class(c.getInt(NUM_COL_CLASS));
        c.close();

        return chemical;
    }

    @Override
    public ArrayList<Chemical> getAllObject() {
        Cursor c = db.query(table_chemical, new String[] {COL_ID, COL_FORMULA, COL_CLASS},
                null, null, null, null, COL_ID);

        if (c.getCount() == 0){
            c.close();
            return null;
        }
        ArrayList<Chemical> listChemical = new ArrayList<>();
        do{
            Chemical chemical = new Chemical();
            chemical.setChemical_id(c.getInt(NUM_COL_ID));
            chemical.setChemical_formula(c.getString(NUM_COL_FORMULA));
            chemical.setChemical_class(c.getInt(NUM_COL_CLASS));
        }while(c.moveToNext());
        c.close();
        return listChemical;
    }
}
