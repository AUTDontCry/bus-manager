package at.wifi.swdev.saschabrodschneider.persistence.Dienst;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.sql.Time;


@Entity(tableName = "dienste")
public class Dienst implements Serializable {



    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String name;

    public String dienstbegin;

    public String dienstEnde;

    public String dienstBeschreibung;


    public Dienst(@NonNull String name, String dienstbegin, String dienstEnde, String dienstBeschreibung) {
        this.name = name;
        this.dienstbegin = dienstbegin;
        this.dienstEnde = dienstEnde;
        this.dienstBeschreibung = dienstBeschreibung;
    }
}
