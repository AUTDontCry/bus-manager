package at.wifi.swdev.saschabrodschneider.helpers;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import at.wifi.swdev.saschabrodschneider.persistence.Dienst.Dienst;

public class FirebaseHelper {

    private String dienst;
    private DatabaseReference databaseReference;


    public FirebaseHelper(String dienst) {
        this.dienst = dienst;


        // DB Verbindung aufbauen

        databaseReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child("dienste")
                .child(dienst);

        databaseReference.onDisconnect().removeValue();

    }

    public void updateDienst(Dienst dienst) {
        databaseReference.setValue(dienst);
    }

    public void deleteDienst() {
        databaseReference.removeValue();
    }

}
