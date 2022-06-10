package at.wifi.swdev.saschabrodschneider.persistence.DienstTag;


import androidx.room.Entity;

import java.io.Serializable;


// Zwei primary Keys auf eine Tabelle aufbinden!!!
@Entity(primaryKeys = {"dienst_id", "wochentag"} ,tableName = "diensttag")
public class DienstTag implements Serializable {



    public int dienst_id;

    public int wochentag;


    public DienstTag(int dienst_id, int wochentag) {
        this.dienst_id = dienst_id;
        this.wochentag = wochentag;
    }
}
