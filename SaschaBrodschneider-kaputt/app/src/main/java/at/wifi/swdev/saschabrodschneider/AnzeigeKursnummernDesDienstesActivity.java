package at.wifi.swdev.saschabrodschneider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.Adapter.KursnummerListAdapter;
import at.wifi.swdev.saschabrodschneider.databinding.ActivityAnzeigeKursnummernDesDienstesBinding;
import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;
import at.wifi.swdev.saschabrodschneider.persistence.Kursnummer.Kursnummer;
import at.wifi.swdev.saschabrodschneider.view.Model.KursnummerViewModel;
import at.wifi.swdev.saschabrodschneider.view.Model.ViewModelFactory;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;

public class AnzeigeKursnummernDesDienstesActivity extends AppCompatActivity {

    public static final String SHOW_KURSNUMMERN_EXTRA = "showKursnummern";
    private ActivityAnzeigeKursnummernDesDienstesBinding binding;
    private Dienst dienst;
    private RecyclerView recyclerView;
    private KursnummerViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anzeige_kursnummern_des_dienstes);

        binding = ActivityAnzeigeKursnummernDesDienstesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = binding.recyclerView;


        //Holen den DIenst aus dem Intent
        dienst = (Dienst) getIntent().getSerializableExtra(SHOW_KURSNUMMERN_EXTRA);


        //ViewModel andoken
        viewModel = new ViewModelProvider(this, new ViewModelFactory(getApplication())).get(KursnummerViewModel.class);



        // Daten -> Adapter

        //TODO die Id welche Kursnummern man möchte! bzw zu welcher ID

        KursnummerListAdapter adapter = new KursnummerListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel.getKursnummernByDienstId(dienst.id).observe(this, new Observer<List<Kursnummer>>() {
            @Override
            public void onChanged(List<Kursnummer> kursnummern) {
                adapter.setKursnummern(kursnummern);
            }
        });


        // Adapter -> Liste

        recyclerView.setAdapter(adapter);




        adapter.getClickedKursnummer().subscribe(new io.reactivex.rxjava3.core.Observer<Kursnummer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                //egal
            }

            @Override
            public void onNext(@NonNull Kursnummer kursnummer) {
                //TODO: intent Fertig machen für das get Clicked

                 Intent intent = new Intent(AnzeigeKursnummernDesDienstesActivity.this, ShowDriverActivity.class);
                 startActivity(intent);


            }

            @Override
            public void onError(@NonNull Throwable e) {
                //Egal
            }

            @Override
            public void onComplete() {
                // Egal
            }
        });


    }
}