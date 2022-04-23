package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Model.FlixSlider;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import java.util.ArrayList;
import java.util.List;

public class FlixSliderAdapter extends RecyclerView.Adapter<FlixSliderAdapter.myview> {
    Context context;
    List<FlixSlider> items=new ArrayList<>();

    public FlixSliderAdapter(Context context, List<FlixSlider> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_item_flix_slider,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        FlixSlider item=items.get(position);
        Glide.with(context)
                .load(item.getSliderImage())
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myview extends RecyclerView.ViewHolder {
        ImageView img;
        public myview(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.flix_slider_img);
        }
    }
}
