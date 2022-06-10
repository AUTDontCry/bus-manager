package at.wifi.swdev.saschabrodschneider.persistence.HaltestellenZeit;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;

@Dao
public interface HaltestellenZeitDao {

    @Insert
    void insert(HaltestellenZeit haltestellenZeit);

    @Update
    void update(HaltestellenZeit haltestellenZeit);

    @Delete
    void delete(HaltestellenZeit haltestellenZeit);



    // TODO: Abfragen für die DB


    @Query("SELECT * FROM HaltestellenZeit ORDER BY haltestellen_zeit ASC")
    LiveData<List<HaltestellenZeit>> getAllHaltestellenZeiten();

}
