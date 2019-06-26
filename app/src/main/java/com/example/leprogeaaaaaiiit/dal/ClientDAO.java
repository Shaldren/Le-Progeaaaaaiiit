package com.example.leprogeaaaaaiiit.dal;

import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RawQuery;
import android.arch.persistence.room.Update;

import com.example.leprogeaaaaaiiit.bo.Client;
import java.util.List;

public interface ClientDAO {

    @Query("SELECT * FROM CLIENT LIMIT 1")
    public Client getFirst();

    @Query("SELECT * FROM CLIENT")
    public List<Client> findAll();
    @RawQuery
    public List<Client> findAll(SupportSQLiteQuery query);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public boolean insert(Client client);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public boolean update(Client client);

    @Delete
    public boolean delete(Client client);
}
