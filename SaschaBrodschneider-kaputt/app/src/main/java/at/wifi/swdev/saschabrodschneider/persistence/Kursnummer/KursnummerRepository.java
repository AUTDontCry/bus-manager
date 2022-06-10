package at.wifi.swdev.saschabrodschneider.persistence.Kursnummer;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.BusDatebase;

public class KursnummerRepository {

    private BusDatebase busDatebase;
    private KursnummerDao kursnummerDao;
    private LiveData<List<Kursnummer>> allKursnummern;
    private LiveData<List<Kursnummer>> kursnummernByDienstId;


    public KursnummerRepository(Application application) {

        busDatebase = BusDatebase.getInstance(application);
        kursnummerDao = busDatebase.kursnummerDao();
        allKursnummern = kursnummerDao.getAllKursnummern();




    }

    public void insert(Kursnummer kursnummer) {

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                kursnummerDao.insert(kursnummer);
            }
        });


    }

    public void update(Kursnummer kursnummer) {

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                kursnummerDao.update(kursnummer);
            }
        });


    }


    public void delete(Kursnummer kursnummer) {

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                kursnummerDao.delete(kursnummer);
            }
        });


    }


    public LiveData<List<Kursnummer>> getAllKursnummern() {
        return allKursnummern;
    }


    public LiveData<List<Kursnummer>> getKursnummernByDienstId (int id){
        return kursnummerDao.getKursnummernByDienstId(id);
    }
}
