package com.example.leprogeaaaaaiiit.dal;

import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RawQuery;
import android.arch.persistence.room.Update;

import com.example.leprogeaaaaaiiit.bo.Vehicule;

import java.util.List;

@Dao
public interface VehiculeDAO {

    @Query("SELECT * FROM vehicule")
    List<Vehicule> getAll();

    @Query("SELECT * FROM vehicule WHERE id IN (:id)")
    List<Vehicule> loadAllByIds(int[] id);

    @Query("SELECT * FROM vehicule WHERE marque LIKE :first AND " +
            "modele LIKE :last LIMIT 1")
    Vehicule findByName(String first, String last);

    @Insert
    void insertAll(Vehicule... vehicules);

    @Update
    void update(Vehicule vehicule);

    @Delete
    void delete(Vehicule vehicule);

}
