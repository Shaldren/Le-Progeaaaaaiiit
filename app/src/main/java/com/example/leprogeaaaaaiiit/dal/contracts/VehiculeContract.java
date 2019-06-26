package com.example.leprogeaaaaaiiit.dal.contracts;

public abstract class VehiculeContract {

    public static final String TABLE_NAME = "VEHICULE";
    public static final String COL_ID = "ID";
    public static final String COL_MARQUE = "MARQUE";
    public static final String COL_MODEL = "MODELE";
    public static final String COL_TYPE = "TYPE";
    public static final String COL_IMMAT = "IMMAT";
    public static final String COL_PRIX = "PRIX";
    public static final String COL_IMAGE = "IMAGE";


    public static final String SQL_CREATE_TABLE =
            " CREATE TABLE IF NOT EXISTS "
                    + TABLE_NAME + " ( "
                    + COL_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + COL_MARQUE
                    + " TEXT , "
                    + COL_MODEL
                    + " TEXT ,"
                    + COL_TYPE
                    + " TEXT , "
                    + COL_IMMAT
                    + " TEXT ,"
                    + COL_PRIX
                    + " INTEGER , "
                    + COL_IMAGE
                    + " TEXT "
                    + " )";

    public static final String SQL_DROP_TABLE =
            " DROP TABLE IF EXISTS "
                    + TABLE_NAME;


}
