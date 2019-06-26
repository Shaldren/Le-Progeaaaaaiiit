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

    @Query("SELECT * FROM VEHICULE LIMIT 1")
    public Vehicule getFirst();

    @Query("SELECT * FROM VEHICULE")
    public List<Vehicule> findAll();

    @RawQuery
    public List<Vehicule> findAll(SupportSQLiteQuery query);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insert(Vehicule vehicule);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public int update(Vehicule vehicule);

    @Delete
    public int delete(Vehicule vehicule);

}
