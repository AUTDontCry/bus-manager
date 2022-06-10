package at.wifi.swdev.saschabrodschneider.persistence.Haltestelle;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.BusDatebase;

public class HaltestelleRepository {

    private BusDatebase busDatebase;
    private HaltestelleDao haltestellenDao;
    private LiveData<List<Haltestelle>> allHaltestellen;


    public HaltestelleRepository(Application application){

        busDatebase = BusDatebase.getInstance(application);
        haltestellenDao = busDatebase.haltestellenDao();
        allHaltestellen = haltestellenDao.getAllHaltestellen();

    }

    public void insert(Haltestelle haltestelle){

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                haltestellenDao.insert(haltestelle);
            }
        });

    }

    public void update(Haltestelle haltestelle){

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                haltestellenDao.update(haltestelle);
            }
        });

    }

    public void delete(Haltestelle haltestelle){

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                haltestellenDao.delete(haltestelle);
            }
        });

    }




    public  LiveData<List<Haltestelle>> getAllHaltestellen(){
        return allHaltestellen;
    }


}
