package com.example.leprogeaaaaaiiit.dal;

import com.example.leprogeaaaaaiiit.bo.Client;
import java.util.List;

public interface ClientDAO {

    public Client getFirst();
    public List<Client> findAll();
    public boolean insert(Client client);
    public boolean update(Client client);
    public boolean delete(Client client);
}
