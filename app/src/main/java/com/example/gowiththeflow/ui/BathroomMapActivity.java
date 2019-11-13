package com.example.gowiththeflow.ui;

import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.gowiththeflow.R;
import com.example.gowiththeflow.data.Bathroom;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;

public class BathroomMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FirebaseFirestore firestoreDatabase;



    private static final String TAG = "BathroomMap";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
      //  mapFragment.getView().setClickable(true);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
      //  LatLng delhi = new LatLng(28, 77);  //28.644800, 77.216721.
      LatLng delhi = new LatLng(28.644800, 77.216721);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(delhi,11));


        //Read from the database and place markers on the map

        firestoreDatabase = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firestoreDatabase.collection("Bathrooms");

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot document : documents) {
                        Bathroom bath = document.toObject(Bathroom.class);
                        LatLng tempLoc = new LatLng(bath.getLocation().getLatitude(), bath.getLocation().getLongitude());
                        String name = bath.getName();
                        mMap.addMarker(new MarkerOptions().position(tempLoc).title(name));
                        Log.w(TAG, "JOSIAH Bathroom " + bath);
                    }
                    //adapter.notifyDataSetChanged();
                }
            }
        });




    }

}









/*
@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
      //  LatLng delhi = new LatLng(28, 77);  //28.644800, 77.216721.
      LatLng delhi = new LatLng(28.644800, 77.216721);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));


        //Read from the database and place markers on the map

        firestoreDatabase = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firestoreDatabase.collection("Bathrooms");

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot document : documents) {
                        Bathroom bath = document.toObject(Bathroom.class);
                        LatLng tempLoc = new LatLng(bath.getLocation().getLatitude(), bath.getLocation().getLongitude());
                        String name = bath.getName();
                        mMap.addMarker(new MarkerOptions().position(tempLoc).title(name));
                        Log.w(TAG, "JOSIAH Bathroom " + bath);
                    }
                    //adapter.notifyDataSetChanged();
                }
            }
        });




    }
 */
