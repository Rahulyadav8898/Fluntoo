package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.DeleteVideolistInterface;
import com.fluntoo.zenberry.Model.Videolist;
import com.fluntoo.zenberry.Player;
import com.fluntoo.zenberry.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.playflix.R;

public class VideolistAdapter extends RecyclerView.Adapter<VideolistAdapter.MYview> implements PopupMenu.OnMenuItemClickListener {
    List<Videolist> items=new ArrayList<>();
    Context context;

    public static final String DATE_FORMAT_2 = "dd MMM, yyyy";
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    String videoid;
    public VideolistAdapter(List<Videolist> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MYview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_videolist, parent, false);
        return new MYview(view);
    }
    public static String getCurrentDate(Long videoDateadded) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }


    @Override
    public void onBindViewHolder(@NonNull MYview holder, int position) {
        Videolist item=items.get(position);

        holder.views.setText(item.getViews().toString());
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
        videoid=item.getVideoId().toString();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), Player.class);
                intent.putExtra("videodesc",item.getVideoDescription());
                intent.putExtra("videotitle",item.getVideoTitle());
                intent.putExtra("videoview",item.getVideoFilepath());
                intent.putExtra("likes",item.getLikes());
                intent.putExtra("dislikes",item.getDislikes());
                intent.putExtra("subscribed", (Bundle) item.getSubscribed());
                intent.putExtra("views",item.getViews().toString());
                intent.putExtra("img_channel",item.getVideoChannelImage().toString());
                intent.putExtra("channel_title",item.getVideoChannelName());
                intent.putExtra("videoTags",item.getVideoTags());
                intent.putExtra("videoCategory",item.getVideoCategory());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deletemenu:
                deletevideolist();
                return true;

            default:
                return false;
        }
    }

    private void deletevideolist() {

        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
        Toast.makeText(context, user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/video/"+user+"/deletevideo/"+videoid;
        Log.d("url",Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DeleteVideolistInterface deleteVideolistInterface=retrofit.create(DeleteVideolistInterface.class);
        Call<Videolist> call=deleteVideolistInterface.deletevideolist(Url,"Bearer "+name);
        call.enqueue(new Callback<Videolist>() {
            @Override
            public void onResponse(Call<Videolist> call, Response<Videolist> response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Videolist> call, Throwable t) {
                Toast.makeText(context,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }

    public class MYview extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView videoView,videomenu;
        ImageView img;
        TextView views, title, channelname, time;

        public MYview(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView01);
            videoView = itemView.findViewById(R.id.playVideoView01);
            views = itemView.findViewById(R.id.postViews);
            title = itemView.findViewById(R.id.textViewTitle);
            channelname = itemView.findViewById(R.id.channelName);
            time = itemView.findViewById(R.id.postTime);
            videoView = itemView.findViewById(R.id.playVideoView01);
            videomenu=itemView.findViewById(R.id.videolistmenu);
            videomenu.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            showpop(v);

        }
    }

    private void showpop(View v) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.inflate(R.menu.deletemenu);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }
}
