package com.example.leprogeaaaaaiiit.application;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leprogeaaaaaiiit.dal.impls.DatabaseRoom;
import com.example.leprogeaaaaaiiit.manager.VehiculeManager;

public class CustomApplication extends Application {
    public DatabaseRoom db;


    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(this,
                DatabaseRoom.class, "LeProgeaaaaaiiitBdd").build();

    }
}
