package com.example.leprogeaaaaaiiit.manager;

import android.app.Application;
import android.arch.persistence.db.SimpleSQLiteQuery;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.bo.Vehicule;
import com.example.leprogeaaaaaiiit.dal.VehiculeDAO;
import com.example.leprogeaaaaaiiit.dal.contracts.LeProgeaaaaaiiitRoom;
import com.example.leprogeaaaaaiiit.dal.impls.DatabaseRoom;

import java.util.List;

public class VehiculeManager {

    DatabaseRoom db;

    public VehiculeManager(Context ctx) {
        db = Room.databaseBuilder(ctx,
                DatabaseRoom.class, "LeProgeaaaaaiiitBdd").build();
    }

    public List<Vehicule> findAll(){
        return db.getVehiculeDAO().getAll();
    }

    public void update(Vehicule vehicule){
        db.getVehiculeDAO().update(vehicule);
    }

    public void insert(Vehicule vehicule){
        db.getVehiculeDAO().insertAll(vehicule);
    }

    public void delete(Vehicule vehicule){
        db.getVehiculeDAO().delete(vehicule);
    }
}
