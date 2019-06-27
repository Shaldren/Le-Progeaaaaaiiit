package com.example.leprogeaaaaaiiit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leprogeaaaaaiiit.R;
import com.example.leprogeaaaaaiiit.bo.Vehicule;

import org.w3c.dom.Text;

import java.util.List;

public class VehiculeAdapter extends RecyclerView.Adapter<VehiculeAdapter.MyViewHolder> {

    private List<Vehicule> data;
    private CustomItemClickListener listener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_vehicule,viewGroup,false);

        final MyViewHolder viewHolder = new MyViewHolder(mView);

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    Log.i("ITEM_VEHICULE","Position : " + viewHolder.getAdapterPosition());
                    listener.onItemClick(v, VehiculeAdapter.this.data.get(viewHolder.getAdapterPosition()));
                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Vehicule vehicule = data.get(i);
        myViewHolder.marque.setText(vehicule.getMarque());
        myViewHolder.model.setText(vehicule.getModele());
        myViewHolder.type.setText(vehicule.getTypeEnvironnement());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public VehiculeAdapter(List<Vehicule> data, CustomItemClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView marque;
        public TextView model;
        public TextView type;

        public MyViewHolder(View v) {
            super(v);
            marque = v.findViewById(R.id.txtMarqueVehicule);
            model = v.findViewById(R.id.txtModeleVehicule);
            type = v.findViewById(R.id.txtTypeVehicule);
        }
    }

    public interface CustomItemClickListener{
        public void onItemClick(View v, Vehicule vehicule);
    }
}
