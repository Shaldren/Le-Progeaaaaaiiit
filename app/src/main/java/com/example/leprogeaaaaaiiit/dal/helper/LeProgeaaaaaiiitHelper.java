package com.example.leprogeaaaaaiiit.dal.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.leprogeaaaaaiiit.dal.contracts.ClientContract;

public class LeProgeaaaaaiiitHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "ParkingBdd.db";
    private final static int DATABASE_VERSION = 1;

    public LeProgeaaaaaiiitHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //si plusieurs tables, on ajoute ici les autres créations
        db.execSQL(ClientContract.SQL_CREATE_TABLE);

        //Bouchon

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Attention faire les updates pour chaque changement de version de oldVersion à newVersion
        db.execSQL(ClientContract.SQL_DROP_TABLE);

        //on recrée la base de données
        onCreate(db);
    }
}
