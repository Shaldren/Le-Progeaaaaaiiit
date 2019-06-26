package com.example.leprogeaaaaaiiit.dal.impls;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.leprogeaaaaaiiit.bo.Client;
import com.example.leprogeaaaaaiiit.bo.Vehicule;
import com.example.leprogeaaaaaiiit.dal.ClientDAO;
import com.example.leprogeaaaaaiiit.dal.VehiculeDAO;
import com.example.leprogeaaaaaiiit.dal.contracts.LeProgeaaaaaiiitRoom;

@Database(entities = {Client.class, Vehicule.class},version = LeProgeaaaaaiiitRoom.DATABASE_VERSION,
        exportSchema = false)
public abstract class DatabaseRoom extends RoomDatabase {
    public abstract ClientDAO getClientDAO();
    public abstract VehiculeDAO getVehiculeDAO();
}
