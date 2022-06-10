package at.wifi.swdev.saschabrodschneider.view.Model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;
import at.wifi.swdev.saschabrodschneider.persistence.Dienst.DienstRepository;

public class DienstViewModel extends AndroidViewModel {

    public DienstRepository repository;
    private LiveData<List<Dienst>> dienste;


    public DienstViewModel(@NonNull Application application) {
        super(application);

        repository = new DienstRepository(application);
        dienste = repository.getAllDienste();
    }

    public void insert(Dienst dienst) {
        repository.insert(dienst);
    }

    public void update(Dienst dienst) {
        repository.update(dienst);
    }

    public void delete(Dienst dienst) {
        repository.delete(dienst);
    }

    public LiveData<List<Dienst>> getAllDienste() {
        return dienste;
    }
}
