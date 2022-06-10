package at.wifi.swdev.saschabrodschneider.persistence.DienstTag;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.BusDatebase;

public class DienstTagRepository {

    private BusDatebase busDatebase;
    private DienstTagDao dienstTagDao;
    private LiveData<List<DienstTag>> allDienstTage;


    public DienstTagRepository(Application application) {

        // Wir holen die Datenbank
        busDatebase = BusDatebase.getInstance(application);
        dienstTagDao = busDatebase.dienstTagDao();
        allDienstTage = dienstTagDao.getAllDienstTage();
    }

    public void insert(DienstTag dienstTag) {
        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dienstTagDao.insert(dienstTag);
            }
        });

    }


    public void update(DienstTag dienstTag) {
        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dienstTagDao.update(dienstTag);
            }
        });

    }

    public void delete(DienstTag dienstTag) {
        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dienstTagDao.delete(dienstTag);
            }
        });

    }

    public LiveData<List<DienstTag>> getAllDienstTage(){
        return allDienstTage;
    }

}
