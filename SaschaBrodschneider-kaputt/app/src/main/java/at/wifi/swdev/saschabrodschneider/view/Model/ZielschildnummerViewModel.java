package at.wifi.swdev.saschabrodschneider.view.Model;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.ZielSchildNummer.Zielschildnummer;
import at.wifi.swdev.saschabrodschneider.persistence.ZielSchildNummer.ZielschildnummerRepository;

public class ZielschildnummerViewModel extends AndroidViewModel {

    public ZielschildnummerRepository repository;
    private LiveData<List<Zielschildnummer>> zielschildnummern;


    public ZielschildnummerViewModel(@NonNull Application application) {
        super(application);

        repository = new ZielschildnummerRepository(application);
        zielschildnummern = repository.getAllZielschieldnummern();
    }

    public void insert(Zielschildnummer zielschildnummer){
        repository.insert(zielschildnummer);
    }

    public void update(Zielschildnummer zielschildnummer){
        repository.update(zielschildnummer);
    }

    public void delete(Zielschildnummer zielschildnummer){
        repository.delete(zielschildnummer);
    }

    public LiveData<List<Zielschildnummer>> getZielschildnummern(){
        return zielschildnummern;
    }

}
