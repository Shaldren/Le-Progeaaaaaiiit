package com.example.leprogeaaaaaiiit.dal.contracts;

public abstract class ClientContract {

    public static final String TABLE_NAME = "CLIENT";
    public static final String COL_ID = "ID";
    public static final String COL_NOM = "NOM";
    public static final String COL_PRENOM = "PRENOM";
    public static final String COL_ADRESSE = "ADRESSE";
    public static final String COL_VILLE = "VILLE";
    public static final String COL_CP = "CP";
    public static final String COL_IDCLIENT = "IDCLIENT";


    public static final String SQL_CREATE_TABLE =
            " CREATE TABLE IF NOT EXISTS "
                    + TABLE_NAME + " ( "
                    + COL_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + COL_NOM
                    + " TEXT , "
                    + COL_PRENOM
                    + " TEXT ,"
                    + COL_ADRESSE
                    + " TEXT , "
                    + COL_VILLE
                    + " TEXT ,"
                    + COL_CP
                    + " INTEGER , "
                    + COL_IDCLIENT
                    + " INTEGER "
                    + " )";

    public static final String SQL_DROP_TABLE =
            " DROP TABLE IF EXISTS "
                    + TABLE_NAME;

}
