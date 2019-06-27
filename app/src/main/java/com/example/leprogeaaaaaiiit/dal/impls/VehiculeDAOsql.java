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
    @Override
    public List<Vehicule> getAll() {
        return null;
    }

    @Override
    public List<Vehicule> loadAllByIds(int[] id) {
        return null;
    }

    @Override
    public Vehicule findByName(String first, String last) {
        return null;
    }

    @Override
    public void insertAll(Vehicule... vehicules) {

    }

    @Override
    public void update(Vehicule vehicule) {

    }

    @Override
    public void delete(Vehicule vehicule) {

    }
}
