package com.example.leprogeaaaaaiiit.dal;

import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RawQuery;
import android.arch.persistence.room.Update;

import com.example.leprogeaaaaaiiit.bo.Client;
import java.util.List;

@Dao
public interface ClientDAO {

    @Query("SELECT * FROM client")
    List<Client> getAll();

    @Query("SELECT * FROM client WHERE idClient IN (:idClient)")
    List<Client> loadAllByIds(int[] idClient);

    @Query("SELECT * FROM client WHERE nom LIKE :first AND " +
            "prenom LIKE :last LIMIT 1")
    Client findByName(String first, String last);

    @Insert
    void insertAll(Client... clients);

    @Delete
    void delete(Client client);
}
