package com.example.leprogeaaaaaiiit.dal.impls;

import android.arch.persistence.db.SupportSQLiteQuery;
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


    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public List<Client> loadAllByIds(int[] idClient) {
        return null;
    }

    @Override
    public Client findByName(String first, String last) {
        return null;
    }

    @Override
    public void insertAll(Client... clients) {

    }

    @Override
    public void delete(Client client) {

    }
}
