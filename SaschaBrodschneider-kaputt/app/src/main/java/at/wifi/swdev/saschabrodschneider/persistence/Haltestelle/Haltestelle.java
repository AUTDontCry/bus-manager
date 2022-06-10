package at.wifi.swdev.saschabrodschneider.persistence.Haltestelle;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "haltestelle")
public class Haltestelle implements Serializable {

    @PrimaryKey
    public int id;


    public String name;


    public Haltestelle(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
