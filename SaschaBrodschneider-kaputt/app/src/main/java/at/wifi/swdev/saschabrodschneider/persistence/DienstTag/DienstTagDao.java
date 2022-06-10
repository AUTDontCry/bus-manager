package at.wifi.swdev.saschabrodschneider.persistence.DienstTag;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface DienstTagDao {


    @Insert
    void insert(DienstTag dienstTag);

    @Update
    void update(DienstTag dienstTag);

    @Delete
    void delete(DienstTag dienstTagienst);


    // TODO: Abfragen für die DB


    @Query("SELECT * FROM diensttag  ORDER BY wochentag ASC")
    LiveData<List<DienstTag>> getAllDienstTage();


}
