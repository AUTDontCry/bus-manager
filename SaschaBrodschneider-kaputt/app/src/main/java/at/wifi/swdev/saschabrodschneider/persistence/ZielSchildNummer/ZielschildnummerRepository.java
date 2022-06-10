package at.wifi.swdev.saschabrodschneider.persistence.ZielSchildNummer;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.BusDatebase;

public class ZielschildnummerRepository {

    private BusDatebase busDatebase;
    private ZielschildnummerDao zielschildnummerDao;
    private LiveData<List<Zielschildnummer>> allZielschieldnummern;



    public ZielschildnummerRepository (Application application){

        busDatebase = BusDatebase.getInstance(application);
        zielschildnummerDao = busDatebase.zielschildnummerDao();
        allZielschieldnummern = zielschildnummerDao.getAllZielschildnummern();
    }

    public void insert(Zielschildnummer zielschildnummer){

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                zielschildnummerDao.instert(zielschildnummer);
            }
        });

    }

    public void update(Zielschildnummer zielschildnummer){

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                zielschildnummerDao.update(zielschildnummer);
            }
        });

    }



    public void delete(Zielschildnummer zielschildnummer){

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                zielschildnummerDao.delete(zielschildnummer);
            }
        });

    }



    public LiveData<List<Zielschildnummer>> getAllZielschieldnummern () {
        return allZielschieldnummern;
    }
}
