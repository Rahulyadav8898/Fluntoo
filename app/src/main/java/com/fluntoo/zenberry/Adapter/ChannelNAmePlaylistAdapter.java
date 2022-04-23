package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Model.ChannelPlaylist;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

public class ChannelNAmePlaylistAdapter extends RecyclerView.Adapter<ChannelNAmePlaylistAdapter.myview> {
    List<ChannelPlaylist> items = new ArrayList<>();
    Context context;

    public ChannelNAmePlaylistAdapter(List<ChannelPlaylist> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_channelname_playlist, parent, false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {

        ChannelPlaylist item = items.get(position);
        holder.title.setText(item.getPlaylistTitle());
        holder.channelname.setText(item.getPlayListChannelName());
        Glide.with(context)
                .load(item.getPlayListPosterAdress())
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myview extends RecyclerView.ViewHolder {

        TextView title, channelname;
        ImageView img;

        public myview(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.playlist_titlechannel);
            img = itemView.findViewById(R.id.playlist_imgchannel);
            channelname = itemView.findViewById(R.id.channel_namechannel);


        }
    }
}
