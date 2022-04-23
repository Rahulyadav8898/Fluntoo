package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Model.PlayerRecommendation;
import com.fluntoo.zenberry.Player;
import com.fluntoo.zenberry.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

//import com.example.playflix.R;

public class PlayerRecomendationAdapter extends RecyclerView.Adapter<PlayerRecomendationAdapter.Myviewholder> {
    List<PlayerRecommendation> items = new ArrayList<>();
    Context context;
    public static final String DATE_FORMAT_2 = "dd MMM, yyyy";

    public PlayerRecomendationAdapter(List<PlayerRecommendation> items, Context context) {
        this.items = items;
        this.context = context;
    }


    public static String getCurrentDate(Long videoDateadded) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_player_recomendation1, parent, false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        PlayerRecommendation item = items.get(position);
        holder.views.setText(item.getViews().toString());
//        holder.time.setText(item.getVideoDateadded().toString());
//        holder.time.setText(getCurrentDate(item.getVideoDateadded()));
        holder.title.setText(item.getVideoTitle());
        holder.views.setText(item.getViews().toString() + " views");
        holder.channelname.setText(item.getVideoChannelName());
        Glide.with(context)
                .load(item.getVideoPosterpath())
                .into(holder.videoView);
        Glide.with(context)
                .load(item.getVideoChannelImage())
                .into(holder.img);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context.getApplicationContext(), "click" + item.getVideoChannelName(), Toast.LENGTH_SHORT).show();
////
//                Intent intent = new Intent(context, Player.class);
//                intent.putExtra("videodesc", item.getVideoDescription());
//                intent.putExtra("videotitle", item.getVideoTitle());
//                intent.putExtra("videoview", item.getVideoFilepath());
//                intent.putExtra("likes", item.getLikes());
//                intent.putExtra("dislikes", item.getDislikes());
//                intent.putExtra("subscribed", (Bundle) item.getSubscribed());
//                intent.putExtra("views", item.getViews().toString());
//                intent.putExtra("img_channel", item.getVideoChannelImage().toString());
//                intent.putExtra("channel_title", item.getVideoChannelName());
//                intent.putExtra("videoTags", item.getVideoTags());
//                intent.putExtra("videoCategory", item.getVideoCategory());
//                intent.putExtra("videoId", item.getVideoId());
//                intent.putExtra("channeldyanmicid", item.getChanneldynamicid());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
////                v.getContext().startActivity(intent);
//                context.startActivity(intent);
////                ((AppCompatActivity)context).finish();
////

//
                Intent intent = new Intent(context, Player.class);
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
                intent.putExtra("channeldyanmicid", item.getChanneldynamicid());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

//                v.getContext().startActivity(intent);
                context.startActivity(intent);

//                ((AppCompatActivity)context).finish();

            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        ImageView videoView;
        ImageView img;
        TextView views, title, channelname, time;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView01);
            videoView = itemView.findViewById(R.id.playVideoView01);
            views = itemView.findViewById(R.id.postViews);
            title = itemView.findViewById(R.id.textViewTitle);
            channelname = itemView.findViewById(R.id.channelName);
            time = itemView.findViewById(R.id.postTime);
            videoView = itemView.findViewById(R.id.playVideoView01);


        }
    }
}
