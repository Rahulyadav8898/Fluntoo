package com.fluntoo.zenberry.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

public class ChannelPopularAdapter extends RecyclerView.Adapter<ChannelPopularAdapter.myview> {
    List<ChannelPopular> items = new ArrayList<>();
    Context context;

    public ChannelPopularAdapter(List<ChannelPopular> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_channel_popular, parent, false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        ChannelPopular item = items.get(position);
        Glide.with(context)
                .load(item.getVideoPosterpath().toString())
                .into(holder.img);
        holder.title.setText(item.getVideoTitle().toString());
        holder.view.setText(item.getViews().toString()+" views");

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myview extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title, view;

        public myview(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.channelname_img_pop);
            title = itemView.findViewById(R.id.channelname_title_pop);
            view = itemView.findViewById(R.id.channelname_views_pop);
        }
    }
}
