package com.example.gowiththeflow;

import android.app.Activity;
import android.app.Person;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.view.View;


import com.example.gowiththeflow.data.Bathroom;
import com.example.gowiththeflow.data.User;
import com.example.gowiththeflow.ui.BathroomMapActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private List <Location> locations;
    private List <Bathroom> bathrooms;
    private List <Person> people;

    private FirebaseFirestore firestoreDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    FirebaseApp.initializeApp(this);

     //   locations = getLocations();
     //   bathrooms = getBathrooms();

  //      String bathroomPath = "/Bathrooms/XBcVEo2OGTx44MnyDzHB";
  //      Bathroom bath = getBathroomByPath(bathroomPath);

//        ArrayList<Integer> tp = new ArrayList<Integer>() {{ add(5); add(5); }};
//        ArrayList<Integer> water = new ArrayList<Integer>() {{ add(10); add(5); }};
//        Bathroom testBath = new Bathroom("Khidmat", "very clean", tp,water,new GeoPoint(28.54222222,77.25472222) );
//        addBathroom(testBath);

    }


    private List<Location> getLocations(){
        final List<Location> locations = new ArrayList<Location>();

        firestoreDatabase = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firestoreDatabase.collection("Locations");

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot document : documents) {
                        Location loc = document.toObject(Location.class);
                        Log.w(TAG, "JOSIAH Location " + loc);
                        locations.add(loc);
                    }
                    //adapter.notifyDataSetChanged();
                }
            }
        });

        if( locations.isEmpty()){
            return null;
        }
        else{
            return locations;
        }
    }


    private List<Bathroom> getBathrooms(){
        final List<Bathroom> bathrooms = new ArrayList<Bathroom>();

        firestoreDatabase = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firestoreDatabase.collection("Bathrooms");

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot document : documents) {
                        Bathroom bath = document.toObject(Bathroom.class);
                        Log.w(TAG, "JOSIAH Bathroom " + bath);
                        bathrooms.add(bath);
                    }
                    //adapter.notifyDataSetChanged();
                }
            }
        });

        if( bathrooms.isEmpty()){
            return null;
        }
        else{
            return bathrooms;
        }
    }

    private void addBathroom(Bathroom bath){
        firestoreDatabase = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firestoreDatabase.collection("Bathrooms");

        collectionReference.add(bath).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.w(TAG, "Bathroom Added " + documentReference.getPath());
            }
        });
    }

//    private Bathroom getBathroomByPath(String path){
//        final Bathroom bathroom = new Bathroom();
//
//        firestoreDatabase = FirebaseFirestore.getInstance();
//        DocumentReference documentReference = firestoreDatabase.document(path);
//
//        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                if (!queryDocumentSnapshots.isEmpty()) {
//                    List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
//                    for (DocumentSnapshot document : documents) {
//                        Bathroom bath = document.toObject(Bathroom.class);
//                        Log.w(TAG, "JOSIAH Bathroom " + bath);
//                        bathrooms.add(bath);
//                    }
//                    //adapter.notifyDataSetChanged();
//                }
//            }
//        });
//            return bathroom;
//    }


    private List<User> getPerson(){
        final List<User> people = new ArrayList<User>();

        firestoreDatabase = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firestoreDatabase.collection("Bathrooms");

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot document : documents) {
                        User person = document.toObject(User.class);
                        Log.w(TAG, "JOSIAH Person " + person);
                        people.add(person);
                    }
                    //adapter.notifyDataSetChanged();
                }
            }
        });

        if( people.isEmpty()){
            return null;
        }
        else{
            return people;
        }
    }



    public void sendMessage(View view) {
        Intent intent = new Intent(this, BathroomMapActivity.class);
        startActivity(intent);
    }

}


/*

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JOSIAH";
    private static final String REQUIRED = "Required";

    // [START declare_database_ref]
    private FirebaseFirestore mDatabase;
    // [END declare_database_ref]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String id = "IPOoKKIvjwy1G8ZCZQz1";
        Log.d(TAG, "Location ID " + id);

        DatabaseConnect.getLocationID(id, new OnSuccessListener<List<Location>>() {
            @Override
            public void onSuccess(List<Location> locations) {

                for (Location location : locations) {
                    String tempID = location.toString();
                    Log.w(TAG, "Location ID " + tempID);
                }
            }
        });

    }






}

*/
/*
@Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_sessions, container, false);

        String userName = SessionManager.getInstance().getPatient().userName;
        FirebaseManager.getSessionsForUserName(userName, new OnSuccessListener<List<Session>>() {
            @Override
            public void onSuccess(List<Session> sessions) {
                loadingHandler.onSuccess(true);
                // Set the adapter
                if (view instanceof RecyclerView) {
                    Context context = view.getContext();
                    RecyclerView recyclerView = (RecyclerView) view;
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(
                            new BasicRecyclerViewAdapter(
                                    sessions,
                                    mListener
                            )
                    );
                }
            }
        });

        return view;
    }
 */

/*
    public class MainActivity extends AppCompatActivity {

    private static final String TAG = "NewPostActivity";
    private static final String REQUIRED = "Required";

    // [START declare_database_ref]
    private FirebaseFirestore mDatabase;
    // [END declare_database_ref]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    FirebaseApp.initializeApp(this);

        mDatabase = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = mDatabase.collection("Locations");

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
                List<Location> locations = new ArrayList<Location>();
                for (DocumentSnapshot document : documents) {
                    String tempID = document.getId();
                    Location loc = new Location(tempID);
                    String tempDesc = document.get("Description").toString();
                    GeoPoint tempCGPS = (GeoPoint)document.get("location");
                    // loc.setlocation(document)
                    Log.w(TAG, "JOSIAH Document " + tempID);
                    locations.add(loc);
                }
            }
            });
    }

}

*/



/*
addListererForSingleValueEvent

//onDataChange


//adapter.notifyDataSetChanged(); // need this when you change a field of the parent class is changed asyncrounsously

//An activity is a screen that is open
//Main activity is the deafult screen


 */