package at.wifi.swdev.saschabrodschneider.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Time;
import java.util.List;

import at.wifi.swdev.saschabrodschneider.R;
import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class DienstListAdapter extends RecyclerView.Adapter<DienstListAdapter.DienstViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<Dienst> dienste;
    private PublishSubject<Dienst> onClickSubject = PublishSubject.create();


    public DienstListAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    public void setDienste(List<Dienst> dienste){
        this.dienste = dienste;
        // Adapter mitteilen das sich die Daten geändert haben
        notifyDataSetChanged();
    }

    public Context getContext(){
        return context;
    }

    public Dienst getDienstAt(int position){
        if(dienste != null)
            return dienste.get(position);
        return null;
    }

    public Observable<Dienst> getClickedDienst(){
        return onClickSubject;
    }



    //Erstellen der View

    @NonNull
    @Override
    public DienstViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.dienst_list_item,parent,false);
        return new DienstViewHolder(view);
    }


    //Innere Klasse für den ViewHolder
    //Brücke von Adapter zu Layout Datei


    @Override
    public void onBindViewHolder(@NonNull  DienstListAdapter.DienstViewHolder holder, int position) {
        if(dienste !=null){
            Dienst dienst = dienste.get(position);
            holder.dienstNameTv.setText(dienst.name);
            holder.dienstBeschreibungTv.setText(dienst.dienstBeschreibung);
            holder.dienstBeginTv.setText(dienst.dienstbegin);
            holder.dienstEndeTv.setText(dienst.dienstEnde);


            //Click Handler aufbinden
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickSubject.onNext(dienst);
                }
            });

        }
    }

    @Override
    public int getItemCount() {

        if(dienste != null){
            return dienste.size();
        }
        return 0;
    }

    // Innere Klassen für den ViewHolder
    //Brücke von Adapter zu Layout-Datei
    public class  DienstViewHolder extends RecyclerView.ViewHolder{

        private final TextView dienstNameTv;
        private final TextView dienstBeginTv;
        private final TextView dienstEndeTv;
        private final TextView dienstBeschreibungTv;



        public DienstViewHolder(@NonNull View itemView){
            super(itemView);

            dienstNameTv = itemView.findViewById(R.id.dienstNameTv);
            dienstBeginTv = itemView.findViewById(R.id.dienstBeginTv);
            dienstEndeTv = itemView.findViewById(R.id.dienstEndeTv);
            dienstBeschreibungTv = itemView.findViewById(R.id.dienstBeschreibungTv);


        }



    }




}
