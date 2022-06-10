package at.wifi.swdev.saschabrodschneider.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import at.wifi.swdev.saschabrodschneider.R;
import at.wifi.swdev.saschabrodschneider.persistence.Kursnummer.Kursnummer;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;


public class KursnummerListAdapter extends RecyclerView.Adapter<KursnummerListAdapter.KursnummerViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<Kursnummer> kursnummern;
    private PublishSubject<Kursnummer> onClickSubject = PublishSubject.create();




    public KursnummerListAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setKursnummern(List<Kursnummer> kursnummern){
        this.kursnummern = kursnummern;
        notifyDataSetChanged();
    }


    public Context getContext(){
        return  context;
    }


    public Kursnummer getKursnummerAt(int position){
        if (kursnummern != null)
            return kursnummern.get(position);
        return null;
    }


    public Observable<Kursnummer> getClickedKursnummer(){
        return onClickSubject;
    }

    // Erstellen der View


    @NonNull
    @Override
    public KursnummerViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.kursnummer_list_item, parent, false);
        return new KursnummerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  KursnummerListAdapter.KursnummerViewHolder holder, int position) {
        if(kursnummern != null){
            Kursnummer kursnummer = kursnummern.get(position);
            holder.kursnummerTv.setText(kursnummer.kurs_nr);
            holder.startZeitTv.setText(kursnummer.startZeit);
            holder.endZeitTv.setText(kursnummer.endeZeit);
            holder.teilTv.setText(kursnummer.teil);


            //Click Handler aufbinden
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 onClickSubject.onNext(kursnummer);
             }
         });

        }
    }

    @Override
    public int getItemCount() {
        if(kursnummern != null){
            return kursnummern.size();
        }
        return 0;
    }

    public class KursnummerViewHolder extends RecyclerView.ViewHolder{

        private final TextView kursnummerTv;
        private final TextView startZeitTv;
        private final TextView endZeitTv;
        private final TextView teilTv;



        public KursnummerViewHolder(@NonNull View itemView){
            super(itemView);

            kursnummerTv = itemView.findViewById(R.id.kursnummerTv);
            startZeitTv = itemView.findViewById(R.id.startZeitTv);
            endZeitTv = itemView.findViewById(R.id.endZeitTv);
            teilTv = itemView.findViewById(R.id.teilTv);




        }


    }


}


