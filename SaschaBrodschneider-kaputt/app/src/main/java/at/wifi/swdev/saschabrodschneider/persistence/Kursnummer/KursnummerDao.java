package at.wifi.swdev.saschabrodschneider.persistence.Kursnummer;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;


@Dao
public interface KursnummerDao {


    @Insert
    void insert (Kursnummer kursnummer);

    @Update
    void update (Kursnummer kursnummer);

    @Delete
    void delete (Kursnummer kursnummer);


    @Query("SELECT * FROM kursnummern ORDER BY kurs_nr ASC")
    LiveData<List<Kursnummer>> getAllKursnummern();

    @Query("SELECT * FROM kursnummern WHERE dienst_id = :id")
    LiveData<List<Kursnummer>> getKursnummernByDienstId(int id);


}
