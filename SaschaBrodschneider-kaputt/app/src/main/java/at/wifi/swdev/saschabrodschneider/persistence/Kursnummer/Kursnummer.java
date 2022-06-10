package at.wifi.swdev.saschabrodschneider.persistence.Kursnummer;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "kursnummern")
public class   Kursnummer  implements Serializable {



    @PrimaryKey(autoGenerate = true)
    public int kurs_id;


    public int zielschild_id;

    public int dienst_id;

    public  String kurs_nr;

    public String startZeit;

    public String endeZeit;

    public String teil;


    public Kursnummer(int kurs_id, int zielschild_id, int dienst_id, String kurs_nr, String teil, String startZeit, String endeZeit) {
        this.kurs_id = kurs_id;
        this.zielschild_id = zielschild_id;
        this.dienst_id = dienst_id;
        this.kurs_nr = kurs_nr;
        this.teil = teil;
        this.startZeit = startZeit;
        this.endeZeit = endeZeit;
    }
}
