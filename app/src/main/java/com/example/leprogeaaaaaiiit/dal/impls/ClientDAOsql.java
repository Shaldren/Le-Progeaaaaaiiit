package com.example.leprogeaaaaaiiit.dal.impls;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.bo.Client;
import com.example.leprogeaaaaaiiit.dal.ClientDAO;
import com.example.leprogeaaaaaiiit.dal.contracts.ClientContract;
import com.example.leprogeaaaaaiiit.dal.helper.LeProgeaaaaaiiitHelper;

import java.util.ArrayList;
import java.util.List;


public class ClientDAOsql implements ClientDAO {

    private LeProgeaaaaaiiitHelper helper;
    private Context context;

    public ClientDAOsql(Context context)
    {
        this.helper = new LeProgeaaaaaiiitHelper(context);

        this.context = context;
    }

    @Override
    public Client getFirst() {
        return null;
    }

    @Override
    public List<Client> findAll() {

        List<Client> lst = new ArrayList<>();
        SharedPreferences pref = context.getSharedPreferences(LeProgeaaaaaiiitApplication.CONFIGURATION_PREF, Context.MODE_PRIVATE);

        String where = null;

        String order = null;

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query(
                ClientContract.TABLE_NAME,
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

    private Client getClient(Cursor c) {

        Client client = new Client(
            c.getInt(c.getColumnIndex(ClientContract.COL_ID)),
            c.getString(c.getColumnIndex(ClientContract.COL_NOM)),
            c.getString(c.getColumnIndex(ClientContract.COL_PRENOM)),
            c.getString(c.getColumnIndex(ClientContract.COL_ADRESSE)),
            c.getString(c.getColumnIndex(ClientContract.COL_VILLE)),
            c.getInt(c.getColumnIndex(ClientContract.COL_CP)),
            c.getInt(c.getColumnIndex(ClientContract.COL_IDCLIENT))

        );

        return  client;

    }

    @Override
    public boolean insert(Client client) {

        ContentValues values = this.getContents(client);

        Log.i("LEPROGEAAAAAIIIT", values.toString());
        SQLiteDatabase db = helper.getWritableDatabase();

        long id = db.insert(ClientContract.TABLE_NAME,null,values);

        client.setId((int) id);

        db.close();

        return id > 0;
    }

    @Override
    public boolean update(Client client) {
        ContentValues values = this.getContents(client);
        String selection = ClientContract.COL_ID + " = ?";
        String[] selectionArgs = { String.valueOf(client.getId()) };
        SQLiteDatabase db = helper.getWritableDatabase();
        int count = db.update(ClientContract.TABLE_NAME, values, selection, selectionArgs);
        db.close();
        return count > 0;
    }

    @Override
    public boolean delete(Client client) {
        String selection = ClientContract.COL_ID + " = ?";

        String[] selectionArgs = { String.valueOf(client.getId()) };
        SQLiteDatabase db = helper.getWritableDatabase();
        int deletedRows = db.delete(ClientContract.TABLE_NAME, selection, selectionArgs);
        db.close();
        return deletedRows > 0;
    }

    /**
     *
     * @param client
     * @return
     */
    private ContentValues getContents(Client client){
        ContentValues values = new ContentValues();

        values.put(ClientContract.COL_NOM, client.getNom());
        values.put(ClientContract.COL_PRENOM, client.getPrenom());
        values.put(ClientContract.COL_ADRESSE, client.getAdresse());
        values.put(ClientContract.COL_VILLE, client.getVille());
        values.put(ClientContract.COL_CP, client.getCodePostal());
        values.put(ClientContract.COL_IDCLIENT, client.getIdClient());


        return values;
    }
}
