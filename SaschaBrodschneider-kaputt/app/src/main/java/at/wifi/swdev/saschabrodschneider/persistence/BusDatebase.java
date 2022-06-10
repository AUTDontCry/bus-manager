package at.wifi.swdev.saschabrodschneider.persistence;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;
import at.wifi.swdev.saschabrodschneider.persistence.Dienst.DienstDao;
import at.wifi.swdev.saschabrodschneider.persistence.DienstTag.DienstTag;
import at.wifi.swdev.saschabrodschneider.persistence.DienstTag.DienstTagDao;
import at.wifi.swdev.saschabrodschneider.persistence.Haltestelle.Haltestelle;
import at.wifi.swdev.saschabrodschneider.persistence.Haltestelle.HaltestelleDao;
import at.wifi.swdev.saschabrodschneider.persistence.HaltestellenZeit.HaltestellenZeit;
import at.wifi.swdev.saschabrodschneider.persistence.HaltestellenZeit.HaltestellenZeitDao;
import at.wifi.swdev.saschabrodschneider.persistence.Kursnummer.Kursnummer;
import at.wifi.swdev.saschabrodschneider.persistence.Kursnummer.KursnummerDao;
import at.wifi.swdev.saschabrodschneider.persistence.ZielSchildNummer.Zielschildnummer;
import at.wifi.swdev.saschabrodschneider.persistence.ZielSchildNummer.ZielschildnummerDao;


@Database(version = 1, entities = {Dienst.class, DienstTag.class, Haltestelle.class, HaltestellenZeit.class, Kursnummer.class, Zielschildnummer.class}, exportSchema = false)
@TypeConverters(Converter.class)
public abstract class BusDatebase extends RoomDatabase {

    // Singelton - Sorgt dafür das es nur eine Instanz davon gibt!
    private static BusDatebase INSTANCE;

    // Sorgt dafür das meine DB Abfragen in einen Eigenen Thread laufen
    private  static  final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static BusDatebase getInstance(Context context){

        // Gibt es schon eine Instanz?
        if(INSTANCE == null){
            // Nein wir erzeugen die einzige Instanz
            //Erzeug das diesen Bereich nur von einen Thread betret werden kann
            synchronized (BusDatebase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, BusDatebase.class, "busdatabase").build();
                }
            }
        }
        return INSTANCE;
    }

    // TODO: Getter für DAOs!!!!

    public abstract DienstDao dienstDao();

    public abstract DienstTagDao dienstTagDao();

    public abstract KursnummerDao kursnummerDao();

    public abstract ZielschildnummerDao zielschildnummerDao();

    public abstract HaltestelleDao haltestellenDao();

    public abstract HaltestellenZeitDao haltestellenZeitDao();
}
