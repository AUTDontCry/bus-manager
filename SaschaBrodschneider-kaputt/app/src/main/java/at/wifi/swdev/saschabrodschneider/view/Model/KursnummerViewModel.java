package at.wifi.swdev.saschabrodschneider.view.Model;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.Kursnummer.Kursnummer;
import at.wifi.swdev.saschabrodschneider.persistence.Kursnummer.KursnummerRepository;

public class KursnummerViewModel extends AndroidViewModel {

    public KursnummerRepository repository;
    private LiveData<List<Kursnummer>> kursnummern;
    private LiveData<List<Kursnummer>> kursnummernByDienstId;





    public KursnummerViewModel(@NonNull Application application) {
        super(application);

        repository = new KursnummerRepository(application);
        kursnummern = repository.getAllKursnummern();



    }

    public void insert(Kursnummer kursnummer){
        repository.insert(kursnummer);
    }

    public void update(Kursnummer kursnummer){
        repository.update(kursnummer);
    }

    public void delete(Kursnummer kursnummer){
        repository.delete(kursnummer);
    }

    public LiveData<List<Kursnummer>> getAllKursnummern(){
        return kursnummern;
    }



    public LiveData<List<Kursnummer>> getKursnummernByDienstId(int id){
        return repository.getKursnummernByDienstId(id);
    }

}
