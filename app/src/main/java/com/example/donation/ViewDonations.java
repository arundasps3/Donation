package com.example.donation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewDonations extends AppCompatActivity {

    ArrayList<Donation>ArrayList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager LayoutManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_donations);


recyclerView =findViewById(R.id.recyclerview);
Bundle b = this.getIntent().getExtras();
        ArrayList = b.getParcelableArrayList("Key");


        // use layoutManager
        LayoutManager = new LinearLayoutManager(this);


        //specify adapter
        myAdapter = new MyAdapter(ArrayList);

        //set layout manager adn adapter
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(myAdapter);
    }
}
