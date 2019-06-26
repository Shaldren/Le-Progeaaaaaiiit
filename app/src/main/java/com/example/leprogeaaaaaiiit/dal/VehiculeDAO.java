package com.example.leprogeaaaaaiiit.dal;

import com.example.leprogeaaaaaiiit.bo.Vehicule;

import java.util.List;

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
