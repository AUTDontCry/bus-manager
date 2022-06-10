package at.wifi.swdev.saschabrodschneider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.Adapter.DienstListAdapter;
import at.wifi.swdev.saschabrodschneider.databinding.ActivityDienstauswahlBinding;
import at.wifi.swdev.saschabrodschneider.persistence.BusDatebase;
import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;
import at.wifi.swdev.saschabrodschneider.persistence.Dienst.DienstDao;
import at.wifi.swdev.saschabrodschneider.view.Model.DienstViewModel;
import at.wifi.swdev.saschabrodschneider.view.Model.ViewModelFactory;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;

public class DienstauswahlActivity extends AppCompatActivity {

    private DienstDao dienstDao;
    private BusDatebase busDatebase;
    private ActivityDienstauswahlBinding binding;
    private RecyclerView recyclerView;
    private DienstViewModel viewModel;


    private static final int GET_DIENSTE_REQUEST = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dienstauswahl);

        binding = ActivityDienstauswahlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = binding.recyclerView;


        //ViewModel "andocken"
        viewModel = new ViewModelProvider(this, new ViewModelFactory(getApplication())).get(DienstViewModel.class);


        //Daten -> Adapter

        DienstListAdapter adapter = new DienstListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel.getAllDienste().observe(this, new Observer<List<Dienst>>() {
            @Override
            public void onChanged(List<Dienst> dienste) {
                adapter.setDienste(dienste);
            }
        });


        // Adapter -> Liste

        recyclerView.setAdapter(adapter);


        //Auf geklickten Notiz reagieren
        adapter.getClickedDienst().subscribe(new io.reactivex.rxjava3.core.Observer<Dienst>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                //egal
            }

            @Override
            public void onNext(@NonNull Dienst dienst) {
                Intent intent = new Intent(DienstauswahlActivity.this, AnzeigeKursnummernDesDienstesActivity.class);
                intent.putExtra(AnzeigeKursnummernDesDienstesActivity.SHOW_KURSNUMMERN_EXTRA, dienst);
                startActivity(intent);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                // Egal
            }

            @Override
            public void onComplete() {
                    //Egal
            }
        });






                    // Manuelles erstellen des Dienstes über den Database Inspector
            // Erstellen eines Test Dienstes mit dem Namen SA10
//        BusDatebase.databaseWriteExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                Dienst testDienst = new Dienst( "SA 10", "6:12", "17:00", "Das ist eine Test Beschreibung");
//                dienstDao.insert(testDienst);
//                    viewModel.insert(testDienst);
//
//            }
//        });


    }
}