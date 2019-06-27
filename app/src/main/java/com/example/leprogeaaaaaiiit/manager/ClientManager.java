package com.example.leprogeaaaaaiiit.manager;

import android.arch.persistence.room.Room;

import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.bo.Client;
import com.example.leprogeaaaaaiiit.bo.Vehicule;
import com.example.leprogeaaaaaiiit.dal.impls.DatabaseRoom;

import java.util.List;

public abstract class ClientManager {

    DatabaseRoom db = Room.databaseBuilder(LeProgeaaaaaiiitApplication.getAppContext(),
            DatabaseRoom.class, "Progeait").build();

    public List<Client> findAll(){
        return db.getClientDAO().getAll();
    }

    public void insert(Client client){
        db.getClientDAO().insertAll(client);
    }

    public void delete(Client client){
        db.getClientDAO().delete(client);
    }
}
