package com.example.gowiththeflow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "JOSIAH";
    private static final String REQUIRED = "Required";

    // [START declare_database_ref]
    private FirebaseFirestore mDatabase;
    // [END declare_database_ref]

    @Nullable
    private OnSuccessListener<Boolean> loadingHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String id = "IPOoKKIvjwy1G8ZCZQz1";

   //     String locationID = SessionManager.getInstance().getPatient().id;

//        DatabaseConnect.getLocationID(id, new OnSuccessListener<List<Location>>() {
//            @Override
//            public void onSuccess(List<Location> locations) {
//
//                loadingHandler.onSuccess(true);
//
//                for (Location location : locations) {
//                    String tempID = location.toString();
//                    Log.w(TAG, "Location ID " + tempID);
//                }
//            }
//        });
    }



}

/*
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