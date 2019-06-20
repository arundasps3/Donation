package com.example.donation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Donation> myList;

    public MyAdapter(ArrayList<Donation> arrayList) {
            myList = arrayList;
        }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.donationId.setText(myList.get(i).getMethod());
        myViewHolder.donationAmount.setText(Integer.toString(myList.get(i).getAmount()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView donationId;

        public TextView donationAmount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            donationId = itemView.findViewById(R.id.donationIdRow);
            donationAmount = itemView.findViewById(R.id.donationAmountRow);

        }
    }
}
