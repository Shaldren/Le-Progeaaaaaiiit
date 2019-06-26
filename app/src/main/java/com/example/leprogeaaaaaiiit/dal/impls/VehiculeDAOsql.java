package com.example.leprogeaaaaaiiit.dal.impls;

import android.arch.persistence.db.SupportSQLiteQuery;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.bo.Vehicule;
import com.example.leprogeaaaaaiiit.dal.VehiculeDAO;
import com.example.leprogeaaaaaiiit.dal.contracts.VehiculeContract;
import com.example.leprogeaaaaaiiit.dal.helper.LeProgeaaaaaiiitHelper;

import java.util.ArrayList;
import java.util.List;

public class VehiculeDAOsql implements VehiculeDAO {

    private LeProgeaaaaaiiitHelper helper;
    private Context context;

    public VehiculeDAOsql(Context context)
    {
        this.helper = new LeProgeaaaaaiiitHelper(context);

        this.context = context;
    }

    @Override
    public Vehicule getFirst() {
        return null;
    }

    @Override
    public List<Vehicule> findAll() {

        List<Vehicule> lst = new ArrayList<>();
        SharedPreferences pref = context.getSharedPreferences(LeProgeaaaaaiiitApplication.CONFIGURATION_PREF, Context.MODE_PRIVATE);

        String where = null;

        String order = null;

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query(
                VehiculeContract.TABLE_NAME,
                null,
                where,
                null,
                null,
                null,
                order,
                null
        );

        while(c.moveToNext()){
            lst.add(this.getClient(c));
        }

        c.close();

        db.close();

        return lst;
    }

    @Override
    public List<Vehicule> findAll(SupportSQLiteQuery query) {
        return null;
    }

    private Vehicule getClient(Cursor c) {

        Vehicule vehicule = new Vehicule(
                c.getInt(c.getColumnIndex(VehiculeContract.COL_ID)),
                c.getString(c.getColumnIndex(VehiculeContract.COL_MARQUE)),
                c.getString(c.getColumnIndex(VehiculeContract.COL_MODEL)),
                c.getString(c.getColumnIndex(VehiculeContract.COL_TYPE)),
                c.getDouble(c.getColumnIndex(VehiculeContract.COL_PRIX)),
                c.getString(c.getColumnIndex(VehiculeContract.COL_IMMAT)),
                c.getString(c.getColumnIndex(VehiculeContract.COL_IMMAT))

        );

        return  vehicule;

    }

    @Override
    public long insert(Vehicule vehicule) {

        ContentValues values = this.getContents(vehicule);

        Log.i("LEPROGEAAAAAIIIT", values.toString());
        SQLiteDatabase db = helper.getWritableDatabase();

        long id = db.insert(VehiculeContract.TABLE_NAME,null,values);

        vehicule.setId(id);

        db.close();

        return id;
    }

    @Override
    public int update(Vehicule vehicule) {
        ContentValues values = this.getContents(vehicule);
        String selection = VehiculeContract.COL_ID + " = ?";
        String[] selectionArgs = { String.valueOf(vehicule.getId()) };
        SQLiteDatabase db = helper.getWritableDatabase();
        int count = db.update(VehiculeContract.TABLE_NAME, values, selection, selectionArgs);
        db.close();
        return count;
    }

    @Override
    public int delete(Vehicule vehicule) {
        String selection = VehiculeContract.COL_ID + " = ?";

        String[] selectionArgs = { String.valueOf(vehicule.getId()) };
        SQLiteDatabase db = helper.getWritableDatabase();
        int deletedRows = db.delete(VehiculeContract.TABLE_NAME, selection, selectionArgs);
        db.close();
        return deletedRows;
    }

    /**
     *
     * @param vehicule
     * @return
     */
    private ContentValues getContents(Vehicule vehicule){
        ContentValues values = new ContentValues();

        values.put(VehiculeContract.COL_MARQUE, vehicule.getMarque());
        values.put(VehiculeContract.COL_MODEL, vehicule.getModele());
        values.put(VehiculeContract.COL_TYPE, vehicule.getTypeEnvironnement());
        values.put(VehiculeContract.COL_IMMAT, vehicule.getImmatriculation());
        values.put(VehiculeContract.COL_PRIX, vehicule.getPrixParJour());
        values.put(VehiculeContract.COL_IMAGE, vehicule.getImage());


        return values;
    }


}
