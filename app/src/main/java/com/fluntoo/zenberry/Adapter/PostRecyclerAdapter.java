package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Channel_Name_Activity;
import com.fluntoo.zenberry.Model.PostItem;
import com.fluntoo.zenberry.Player;
import com.fluntoo.zenberry.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

//import com.example.playflix.R;


public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.ViewHolder> {

    private Context context;
    public static List<PostItem> items = new ArrayList<>();
    String channelid;
    String channeldyanmicid;
    String chdid;

    private PostAdapterInterface mAdapterCallback;

    private boolean isLoadingAdded = false;




    public static final String DATE_FORMAT_2 = "dd MMM, yyyy";




//    public PostRecyclerAdapter(PostAdapterInterface mAdapterCallback) {
//        this.mAdapterCallback = mAdapterCallback;
//    }

    public PostRecyclerAdapter(Context context, List<PostItem> items,PostAdapterInterface mAdapterCallback) {
        this.context = context;
        this.items = items;
        this.mAdapterCallback=mAdapterCallback;

    }



    public static String getCurrentDate(Long videoDateadded) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_player_recomendation1, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PostItem item = items.get(position);

        holder.views.setText(item.getViews().toString() + "views");
//        holder.time.setText(item.getVideoDateadded().toString());


//        holder.time.setText(getCurrentDate(item.getVideoDateadded()));
        holder.title.setText(item.getVideoTitle());
        holder.channelname.setText(item.getVideoChannelName());
        Glide.with(context)
                .load(item.getVideoPosterpath())
                .into(holder.videoView);
        Glide.with(context)
                .load(item.getVideoChannelImage())
                .into(holder.img);
        String channel = item.getVideoChannelId().toString();

//        holder.dislikes.setText(item.getDislikes());
//        holder.likes.setText(item.getLikes());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Player.class);
                intent.putExtra("videodesc", item.getVideoDescription());
                intent.putExtra("videotitle", item.getVideoTitle());
                intent.putExtra("videoview", item.getVideoFilepath());
                intent.putExtra("likes", item.getLikes().intValue());
                intent.putExtra("dislikes", item.getDislikes().intValue());
                intent.putExtra("subscribed", (Bundle) item.getSubscribed());
                intent.putExtra("views", item.getViews().toString());
                intent.putExtra("videoCategory", item.getVideoCategory());
                intent.putExtra("img_channel", item.getVideoChannelImage().toString());
                intent.putExtra("channel_title", item.getVideoChannelName());
                intent.putExtra("videoTags", item.getVideoTags());
                intent.putExtra("channelid", item.getVideoChannelId());
                intent.putExtra("videoId", item.getVideoId());
                intent.putExtra("channeldyanmicid", item.getChanneldynamicid());
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

        if (items.size()-2== position) {
            Log.d("TAG", "onBindViewHolder: "+position+items.size());
            mAdapterCallback.onMethodCallback();

        }

    }

public void adddata(List<PostItem> items1){
        int pos= items.size();
        items.addAll(items1);
        notifyItemInserted(pos);

}

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView videoView;
        ImageView img;
        TextView views, title, channelname, time, likes, dislikes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView01);
            videoView = itemView.findViewById(R.id.playVideoView01);
            views = itemView.findViewById(R.id.postViews);
            title = itemView.findViewById(R.id.textViewTitle);
            channelname = itemView.findViewById(R.id.channelName);
            time = itemView.findViewById(R.id.postTime);
            videoView = itemView.findViewById(R.id.playVideoView01);
            likes = itemView.findViewById(R.id.likes_tv);
            dislikes = itemView.findViewById(R.id.dilikes_tv);


        }


    }
}

