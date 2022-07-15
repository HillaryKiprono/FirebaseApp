package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "";
    TextView textView;
    RecyclerView recyclerView;
    private DatabaseReference myRef;
    private ArrayList<Messages> messagesArrayList;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        myRef=FirebaseDatabase.getInstance().getReference();
        //arraylist
        messagesArrayList=new ArrayList<>();
        //clear arraylist
        clearAll();
        //Get data method
        GetDataFromFirebase();
    }
    private void GetDataFromFirebase() {

        Query query=myRef.child("Category");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               clearAll();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Messages messages=new Messages();
                   messages.setImageUrl(dataSnapshot.child("imageUrl").getValue().toString());
                   messages.setFoodName(dataSnapshot.child("foodName").getValue().toString());
                   messages.setFoodPrice(dataSnapshot.child("foodPrice").getValue().toString());

                    messagesArrayList.add(messages);
                }
                recyclerViewAdapter=new RecyclerViewAdapter(getApplicationContext(),messagesArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    private  void clearAll()
    {
        if(messagesArrayList !=null)
        {
            messagesArrayList.clear();
            if(recyclerViewAdapter !=null)
            {
                recyclerViewAdapter.notifyDataSetChanged();
            }
        }
        else
        {
            messagesArrayList=new ArrayList<>();
        }
    }
}