package at.wifi.swdev.saschabrodschneider.persistence.Dienst;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.BusDatebase;

public class DienstRepository {


    private BusDatebase busDatebase;
    private DienstDao dienstDao;
    private LiveData<List<Dienst>> allDienste;



    public DienstRepository(Application application){

        // Wir holen die Datenbank
        busDatebase = BusDatebase.getInstance(application);
        dienstDao = busDatebase.dienstDao();
        allDienste = dienstDao.getAllDienste();
    }

    public void insert(Dienst dienst){

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dienstDao.insert(dienst);
            }
        });

    }

    public  void update(Dienst dienst){
        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dienstDao.update(dienst);
            }
        });
    }


    public  void delete(Dienst dienst){
        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dienstDao.delete(dienst);
            }
        });
    }


    public  LiveData<List<Dienst>> getAllDienste() {
        return allDienste;
    }
}
