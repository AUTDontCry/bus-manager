package at.wifi.swdev.saschabrodschneider.view.Model;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.Haltestelle.Haltestelle;
import at.wifi.swdev.saschabrodschneider.persistence.Haltestelle.HaltestelleRepository;

public class HaltestelleViewModel extends AndroidViewModel {

    public HaltestelleRepository repository;
    private LiveData<List<Haltestelle>> haltestellen;


    public HaltestelleViewModel(@NonNull Application application) {
        super(application);

        repository = new HaltestelleRepository(application);
        haltestellen = repository.getAllHaltestellen();
    }

    public void insert(Haltestelle haltestelle){
        repository.insert(haltestelle);
    }

    public void update(Haltestelle haltestelle){
        repository.update(haltestelle);
    }

    public void delete(Haltestelle haltestelle){
        repository.delete(haltestelle);
    }

    public LiveData<List<Haltestelle>> getHaltestellen(){
        return haltestellen;
    }

}
