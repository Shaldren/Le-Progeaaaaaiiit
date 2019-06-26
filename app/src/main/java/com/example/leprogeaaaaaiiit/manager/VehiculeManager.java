package com.example.leprogeaaaaaiiit.manager;

import android.arch.persistence.db.SimpleSQLiteQuery;
import android.content.SharedPreferences;

import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.bo.Vehicule;
import com.example.leprogeaaaaaiiit.dal.DAOFactory;
import com.example.leprogeaaaaaiiit.dal.VehiculeDAO;

import java.util.List;

public abstract class VehiculeManager {

    public static Vehicule getFirst(){
        VehiculeDAO dao = DAOFactory.getVehiculeDAO();
        return dao.getFirst();
    }

    public List<Vehicule> findAll(){
        String query = "SELECT * FROM VEHICULE";

        SharedPreferences pref = LeProgeaaaaaiiitApplication.getAppContext()
                .getSharedPreferences(
                        LeProgeaaaaaiiitApplication.CONFIGURATION_PREF,
                        LeProgeaaaaaiiitApplication.getAppContext().MODE_PRIVATE
                );

        VehiculeDAO dao = DAOFactory.getVehiculeDAO();
        return dao.findAll(new SimpleSQLiteQuery(query));
    }

    public static boolean insert(Vehicule vehicule){
        VehiculeDAO dao = DAOFactory.getVehiculeDAO();
        return dao.insert(vehicule) > 0;
    }

    public static boolean update(Vehicule vehicule){
        VehiculeDAO dao = DAOFactory.getVehiculeDAO();
        return dao.update(vehicule) > 0;
    }

    public static boolean delete(Vehicule vehicule){
        VehiculeDAO dao = DAOFactory.getVehiculeDAO();
        return dao.delete(vehicule) > 0;
    }

}
