package com.example.leprogeaaaaaiiit.dal.impls;

import com.example.leprogeaaaaaiiit.dal.ClientDAO;


import java.util.ArrayList;
import com.example.leprogeaaaaaiiit.bo.Client;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    private List<Client> clients;

    public ClientDAOImpl() {
        this.clients = new ArrayList<>();
    }

    @Override
    public Client getFirst() {
        return clients.get(0);
    }

    @Override
    public List<Client> findAll() {
        return this.clients;
    }

    @Override
    public boolean insert(Client client) {
        return false;
    }

    @Override
    public boolean update(Client client) {
        return false;
    }

    @Override
    public boolean delete(Client client) {
        return false;
    }

}
