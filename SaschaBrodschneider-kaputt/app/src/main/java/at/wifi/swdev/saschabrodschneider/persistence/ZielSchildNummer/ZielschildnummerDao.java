package at.wifi.swdev.saschabrodschneider.persistence.ZielSchildNummer;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;

@Dao
public interface ZielschildnummerDao {

    @Insert
    void instert (Zielschildnummer zielschildnummer);

    @Update
    void  update (Zielschildnummer zielschildnummer);

    @Delete
    void delete (Zielschildnummer zielschildnummer);


    // TODO: Abfragen für die DB


    @Query("SELECT * FROM zielschildnummer ORDER BY zielschildnummer ASC")
    LiveData<List<Zielschildnummer>> getAllZielschildnummern();



}
