package com.example.gowiththeflow.database;

import android.util.Log;

import com.example.gowiththeflow.Location;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnect {

    private List <Location> locations;


    public static void getLocationID(String id, final OnSuccessListener<List<Location>> handler) {

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firestore.collection("Locations");

     //   DocumentReference documentReference = collectionReference.document(id);
        //CollectionReference sessionsCollectionReference = documentReference.collection("sessions");
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
                List<Location> locations = new ArrayList<Location>();
                for (DocumentSnapshot document : documents) {
                    String tempID = document.getId();
                    Location loc = new Location(tempID);
//                    String tempDesc = document.get("Description").toString();
//                    GeoPoint tempGPS = (GeoPoint)document.get("location");
//                    loc.setlocation(tempGPS);
//                    loc.setDesc(tempDesc);
                    Log.d("JOSIAH", "Document " + tempID);
                    locations.add(loc);
                }
                handler.onSuccess(locations);
            }
            public void onFailure(){
                Log.d("JOSIAH", "Failure!!! ");
            }
        });
    }



}
