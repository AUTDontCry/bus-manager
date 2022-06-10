package at.wifi.swdev.saschabrodschneider.persistence.Haltestelle;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;


@Dao
public interface HaltestelleDao {

    @Insert
    void insert(Haltestelle haltestelle);

    @Update
    void update(Haltestelle haltestelle);

    @Delete
    void delete(Haltestelle haltestelle);


    @Query("SELECT * FROM haltestelle ORDER BY name ASC")
    LiveData<List<Haltestelle>> getAllHaltestellen();



}
