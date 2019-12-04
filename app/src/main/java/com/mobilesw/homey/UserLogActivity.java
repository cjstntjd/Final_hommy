package com.mobilesw.homey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserLogActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance(); //Initalize Firestore object
    final CollectionReference dbLogs = db.collection("UserLogs"); //Call the collection UserLogs in firestore
    final FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ; //Get the current user logged in
    private Date date;
    private UserLog userlog;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private UserLogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query query = dbLogs.orderBy("date", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<UserLog> options = new FirestoreRecyclerOptions.Builder<UserLog>()
                .setQuery(query, UserLog.class)
                .build();

        adapter = new UserLogAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
