package at.wifi.swdev.saschabrodschneider.persistence.HaltestellenZeit;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(tableName = "HaltestellenZeit")
public class HaltestellenZeit implements Serializable {

    @PrimaryKey
    public int id;

    public int haltestellen_id;

    public int kurs_id;

    public LocalDateTime haltestellen_zeit;



    public HaltestellenZeit(int id, int haltestellen_id, int kurs_id, LocalDateTime haltestellen_zeit) {
        this.id = id;
        this.haltestellen_id = haltestellen_id;
        this.kurs_id = kurs_id;
        this.haltestellen_zeit = haltestellen_zeit;

    }
}
