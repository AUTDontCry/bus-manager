package at.wifi.swdev.saschabrodschneider.persistence.ZielSchildNummer;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "zielschildnummer")
public class Zielschildnummer implements Serializable {

    @PrimaryKey
    public int id;

    @NonNull
    public int zielschildnummer;

    @NonNull
    public String name;

    public String beschreibung;

    public int liniennummmer;


    public Zielschildnummer(int id, @NonNull String name, int zielschildnummer, String beschreibung, int liniennummmer) {
        this.id = id;
        this.name = name;
        this.zielschildnummer = zielschildnummer;
        this.beschreibung = beschreibung;
        this.liniennummmer = liniennummmer;
    }
}
