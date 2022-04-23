package com.fluntoo.zenberry.Adapter;

import static com.facebook.FacebookSdk.getApplicationContext;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Channel_Name_Activity;
import com.fluntoo.zenberry.Model.Latest;
import com.fluntoo.zenberry.Player;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.MyViewholder> {
    private Context context;
    public static List<Latest> items = new ArrayList<>();
    ProgressBar progressBar;
    String channeldyanmicid;
    String chdid;


    public LatestAdapter(Context context, List<Latest> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_latest, parent, false);

        return new MyViewholder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LatestAdapter.MyViewholder holder, int position) {
        Latest item = items.get(position);
        Glide.with(context)
                .load(item.getVideoPosterpath())
                .into(holder.imgposter);
        Glide.with(context)
                .load(item.getVideoChannelImage())
                .into(holder.imgchannelposter);
        holder.title.setText(item.getVideoTitle());
        holder.views.setText(item.getViews().toString() + "views");
        holder.channelname.setText(item.getVideoChannelName());

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
                intent.putExtra("channelid", item.getVideoChannelId());
                intent.putExtra("channeldyanmicid", item.getChanneldynamicid());
                chdid = intent.getStringExtra("channeldyanmicid");
                channeldyanmicid = chdid;

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
        ImageView imgposter, imgchannelposter;
        TextView channelname, title, views;


        public MyViewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgchannelposter = itemView.findViewById(R.id.latest_channel_img);
            imgposter = itemView.findViewById(R.id.latest_poster_img);
            channelname = itemView.findViewById(R.id.latest_channelname_tv);
            title = itemView.findViewById(R.id.latest_title_tv);
            views = itemView.findViewById(R.id.views_latest_tv);

        }
    }
}
