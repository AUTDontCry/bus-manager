package at.wifi.swdev.saschabrodschneider.view.Model;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.HaltestellenZeit.HaltestellenZeit;
import at.wifi.swdev.saschabrodschneider.persistence.HaltestellenZeit.HaltestellenZeitRepository;

public class HaltestellenZeitViewModel extends AndroidViewModel {

    public HaltestellenZeitRepository repository;
    private LiveData<List<HaltestellenZeit>> haltestellenZeiten;


    public HaltestellenZeitViewModel(@NonNull Application application) {
        super(application);

        repository = new HaltestellenZeitRepository(application);
        haltestellenZeiten = repository.getAllHaltestellenZeiten();
    }

    public void insert(HaltestellenZeit haltestellenZeit){
        repository.insert(haltestellenZeit);
    }

    public void update(HaltestellenZeit haltestellenZeit){
        repository.update(haltestellenZeit);
    }

    public void delete(HaltestellenZeit haltestellenZeit){
        repository.delete(haltestellenZeit);
    }

    public LiveData<List<HaltestellenZeit>> getHaltestellenZeiten(){
        return haltestellenZeiten;
    }


}
