package com.example.leprogeaaaaaiiit.dal;

import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.dal.impls.ClientDAOsql;

public abstract class DAOFactory {

    public static ClientDAO getClientDAO(){
        return new ClientDAOsql(LeProgeaaaaaiiitApplication.getAppContext());
    }
}
