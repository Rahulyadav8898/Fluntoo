package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Channel_Name_Activity;
import com.fluntoo.zenberry.Model.Trending;
import com.fluntoo.zenberry.Player;
import com.fluntoo.zenberry.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.MyViewholder> {
    private Context context;
    public static List<Trending> items = new ArrayList<>();
    ProgressBar progressBar;

    String channeldyanmicid;
    String chdid;

    public TrendingAdapter(Context context, List<Trending> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_trending, parent, false);

        return new MyViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TrendingAdapter.MyViewholder holder, int position) {
        Trending item = items.get(position);
        Glide.with(context)
                .load(item.getVideoPosterpath())
                .into(holder.imgposter);
        Glide.with(context)
                .load(item.getVideoChannelImage())
                .into(holder.imgchannel);
        holder.title.setText(item.getVideoTitle());
        holder.channelname.setText(item.getVideoChannelName());
        holder.views.setText(item.getViews().toString() + " views");



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Player.class);
                intent.putExtra("videodesc", item.getVideoDescription());
                intent.putExtra("videotitle", item.getVideoTitle());
                intent.putExtra("videoview", item.getVideoFilepath());
                intent.putExtra("likes", item.getLikes());
                intent.putExtra("dislikes", item.getDislikes());
                intent.putExtra("subscribed", (Bundle) item.getSubscribed());
                intent.putExtra("views", item.getViews().toString());
                intent.putExtra("img_channel", item.getVideoChannelImage().toString());
                intent.putExtra("channel_title", item.getVideoChannelName());
                intent.putExtra("videoTags", item.getVideoTags());
                intent.putExtra("videoCategory", item.getVideoCategory());
                intent.putExtra("videoId", item.getVideoId());
                intent.putExtra("channelid",item.getVideoChannelId());
                intent.putExtra("channeldyanmicid",item.getChanneldynamicid());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);

            }
        });
        holder.channelname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Player.class);
                intent.putExtra("videodesc", item.getVideoDescription());
                intent.putExtra("videotitle", item.getVideoTitle());
                intent.putExtra("videoview", item.getVideoFilepath());
                intent.putExtra("likes", item.getLikes());
                intent.putExtra("dislikes", item.getDislikes());
                intent.putExtra("subscribed", (Bundle) item.getSubscribed());
                intent.putExtra("views", item.getViews().toString());
                intent.putExtra("img_channel", item.getVideoChannelImage().toString());
                intent.putExtra("channel_title", item.getVideoChannelName());
                intent.putExtra("videoTags", item.getVideoTags());
                intent.putExtra("videoCategory", item.getVideoCategory());
                intent.putExtra("videoId", item.getVideoId());
                intent.putExtra("channelid", item.getVideoChannelId());
                intent.putExtra("channeldyanmicid", item.getChanneldynamicid());
                chdid = intent.getStringExtra("channeldyanmicid");
                channeldyanmicid = chdid;

                Intent intent1 = new Intent(context, Channel_Name_Activity.class);
                intent1.putExtra("channeldyanmicid", channeldyanmicid);
//                intent1.getIntExtra("rah", sid);
                context.startActivity(intent1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        ImageView imgposter, imgchannel;
        TextView title, channelname, views;

        public MyViewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgposter = itemView.findViewById(R.id.trend_poster_img);
            imgchannel = itemView.findViewById(R.id.trend_channel_img);
            title = itemView.findViewById(R.id.trend_title_tv);
            channelname = itemView.findViewById(R.id.trend_channelname_tv);
            views = itemView.findViewById(R.id.views_trend_tv);

        }
    }
}
