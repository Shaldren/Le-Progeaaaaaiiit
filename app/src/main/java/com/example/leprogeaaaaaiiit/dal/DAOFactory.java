package com.example.leprogeaaaaaiiit.dal;

import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.dal.impls.ClientDAOsql;
import com.example.leprogeaaaaaiiit.dal.impls.VehiculeDAOsql;

public abstract class DAOFactory {

    public static ClientDAO getClientDAO(){
        return new ClientDAOsql(LeProgeaaaaaiiitApplication.getAppContext());
    }

    public static VehiculeDAO getVehiculeDAO(){
        return new VehiculeDAOsql(LeProgeaaaaaiiitApplication.getAppContext());
    }
}
