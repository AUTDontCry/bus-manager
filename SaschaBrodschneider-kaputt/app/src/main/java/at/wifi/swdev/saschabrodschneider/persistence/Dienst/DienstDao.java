package at.wifi.swdev.saschabrodschneider.persistence.Dienst;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface DienstDao {

    @Insert
    void insert(Dienst dienst);

    @Update
    void update(Dienst dienst);

    @Delete
    void delete(Dienst dienst);



    // TODO: Abfragen für die DB


    @Query("SELECT * FROM dienste ORDER BY name ASC")
    LiveData<List<Dienst>> getAllDienste();

}
