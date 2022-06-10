package at.wifi.swdev.saschabrodschneider.view.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.persistence.DienstTag.DienstTag;
import at.wifi.swdev.saschabrodschneider.persistence.DienstTag.DienstTagRepository;

public class DienstTagViewModel extends AndroidViewModel {

    private DienstTagRepository repository;
    private LiveData<List<DienstTag>> dienstTage;

    public DienstTagViewModel(@NonNull Application application) {
        super(application);

        repository = new DienstTagRepository(application);
        dienstTage = repository.getAllDienstTage();

    }


    public void insert(DienstTag dienstTag) {
        repository.insert(dienstTag);
    }

    public void update(DienstTag dienstTag) {
        repository.update(dienstTag);
    }

    public void delete(DienstTag dienstTag) {
        repository.delete(dienstTag);
    }

    public LiveData<List<DienstTag>> getAllDienstTage() {
        return dienstTage;
    }
}





