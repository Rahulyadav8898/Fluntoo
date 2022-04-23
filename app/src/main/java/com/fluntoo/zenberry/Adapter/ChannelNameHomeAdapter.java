package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Model.ChannelNameVideoList;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

public class ChannelNameHomeAdapter extends RecyclerView.Adapter<ChannelNameHomeAdapter.myview> {
    List<ChannelNameVideoList> items = new ArrayList<>();
    Context context;

    public ChannelNameHomeAdapter(List<ChannelNameVideoList> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_channelname_videolist, parent, false);

        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        ChannelNameVideoList item = items.get(position);
        Glide.with(context)
                .load(item.getVideoPosterpath())
                .into(holder.img);
        holder.title.setText(item.getVideoTitle());
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
            img = itemView.findViewById(R.id.channelname_img_home);
            title = itemView.findViewById(R.id.channelname_title_home);
            view = itemView.findViewById(R.id.channelname_views_home);
        }
    }
}
