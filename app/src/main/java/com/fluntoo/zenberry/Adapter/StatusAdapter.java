package com.fluntoo.zenberry.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.playflix.R;

import com.fluntoo.zenberry.R;

import org.jetbrains.annotations.NotNull;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewholder> {
    String [] data;

    public StatusAdapter(String[] data) {
        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_item_status, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StatusAdapter.MyViewholder holder, int position) {
String abc=data[position];

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        ImageView img;

        public MyViewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.status_img);

        }
}

}
