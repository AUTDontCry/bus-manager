package at.wifi.swdev.saschabrodschneider.persistence.HaltestellenZeit;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.BusDatebase;

public class HaltestellenZeitRepository {

    private BusDatebase busDatebase;
    private HaltestellenZeitDao haltestellenZeitDao;
    private LiveData<List<HaltestellenZeit>> allHaltestellenZeiten;


    public HaltestellenZeitRepository(Application application){

        busDatebase = BusDatebase.getInstance(application);
        haltestellenZeitDao = busDatebase.haltestellenZeitDao();
        allHaltestellenZeiten = haltestellenZeitDao.getAllHaltestellenZeiten();
    }

    public void insert(HaltestellenZeit haltestellenZeit){

        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                haltestellenZeitDao.insert(haltestellenZeit);
            }
        });
    }

    public  void update(HaltestellenZeit haltestellenZeit){
        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                haltestellenZeitDao.update(haltestellenZeit);
            }
        });
    }


    public  void delete(HaltestellenZeit haltestellenZeit){
        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                haltestellenZeitDao.delete(haltestellenZeit);
            }
        });
    }


    public  LiveData<List<HaltestellenZeit>> getAllHaltestellenZeiten() {
        return allHaltestellenZeiten;
    }
}
