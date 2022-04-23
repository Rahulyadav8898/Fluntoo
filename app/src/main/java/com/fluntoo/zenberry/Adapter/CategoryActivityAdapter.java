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
import com.fluntoo.zenberry.Model.Video;
import com.fluntoo.zenberry.Player;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;
//import com.example.playflix.R;
//import com.fluntoo.zenberry.R;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CategoryActivityAdapter extends RecyclerView.Adapter<CategoryActivityAdapter.MyView> {

    public static final String DATE_FORMAT_2 = " MMM dd, yyyy";
    List<Video> items;
    private Context context;

    public CategoryActivityAdapter(Context context, List<Video> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public MyView onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_item_player_recomendation1, parent, false);
        return new MyView(view);

    }


    public static String getCurrentDate(Long videoDateadded) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryActivityAdapter.MyView holder, int position) {
        Video item = items.get(position);
        holder.channelname.setText(item.getVideoChannelName());
        holder.title.setText(item.getVideoTitle());
//        holder.view.setText(item.getViews());
        holder.view.setText(item.getViews().toString() + " views");
        holder.time.setText(getCurrentDate(item.getVideoDateadded()));
        Glide.with(context)
                .load(item.getVideoPosterpath())
                .into(holder.videoView);
        Glide.with(context)
                .load(item.getVideoChannelImage())
                .into(holder.img);

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

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class MyView extends RecyclerView.ViewHolder {
        ImageView videoView;
        ImageView img;
        TextView view, title, channelname, time;


        public MyView(@NonNull @NotNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView01);
            videoView = itemView.findViewById(R.id.playVideoView01);
            view = itemView.findViewById(R.id.postViews);
            title = itemView.findViewById(R.id.textViewTitle);
            channelname = itemView.findViewById(R.id.channelName);
            time = itemView.findViewById(R.id.postTime);
            videoView = itemView.findViewById(R.id.playVideoView01);

//            img = itemView.findViewById(R.id.imageView01s);
//            videoView = itemView.findViewById(R.id.playVideoView01s);
//            view = itemView.findViewById(R.id.postViews1);
//            title = itemView.findViewById(R.id.textViewTitles);
//            channelname = itemView.findViewById(R.id.channelNames);
//            time = itemView.findViewById(R.id.postTimes);
//            videoView = itemView.findViewById(R.id.playVideoView01s);
        }
    }

}
