package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.NotificationInterface;
import com.fluntoo.zenberry.Model.Notification;
import com.fluntoo.zenberry.Model.NotificationModel;
import com.fluntoo.zenberry.Player;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.mynotifyview> {
    private Context context;
    private List<Notification> items = new ArrayList<>();


    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public NotificationAdapter(Context context, List<Notification> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public mynotifyview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_notification, parent, false);
        return new mynotifyview(view);

    }

    @Override
    public void onBindViewHolder(@NonNull mynotifyview holder, int position) {
        Notification item = items.get(position);
        holder.channeltitlen.setText(item.getTitle());
        holder.videotitle.setText(item.getText());
        Glide.with(context)
                .load(item.getImage1())
                .into(holder.channelimg);
        Glide.with(context)
                .load(item.getImage2())
                .into(holder.videoomg);
        String video = item.getVideo();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);

                String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
                String user = prefs.getString("userId", "no vale");
//        Toast.makeText(context, user, Toast.LENGTH_SHORT).show();

                String Urlno = "https://www.api.playflixx.com/" + user + "/videoplay/" + video;
                Log.d("url", Urlno);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                NotificationInterface notificationInterface = retrofit.create(NotificationInterface.class);
                Call<NotificationModel> call = notificationInterface.getnoti(Urlno);
                call.enqueue(new Callback<NotificationModel>() {
                    @Override
                    public void onResponse(Call<NotificationModel> call, Response<NotificationModel> response) {
                        String videodesc = response.body().getVideoDescription();
                        String videotitle = response.body().getVideoTitle();
                        String vv = response.body().getVideoFilepath();
                        int likes = response.body().getLikes();
                        int dislikes = response.body().getDislikes();
                        String sub = response.body().getSubscribed();
                        String views = response.body().getViews().toString();
                        String videocat = response.body().getVideoCategory();
                        String cimg = response.body().getVideoChannelImage();
                        String vcn = response.body().getVideoChannelName();
                        String vt = response.body().getVideoTags();
                        String vcid = response.body().getVideoChannelId().toString();
                        String vid = response.body().getVideoId();

                        Intent intent = new Intent(v.getContext(), Player.class);
                        intent.putExtra("videodesc", videodesc);
                        intent.putExtra("videotitle", videotitle);
                        intent.putExtra("videoview", vv);
                        intent.putExtra("likes", likes);
                        intent.putExtra("dislikes", dislikes);
                        intent.putExtra("subscribed", sub);
                        intent.putExtra("views", views);
                        intent.putExtra("videoCategory", videocat);
                        intent.putExtra("img_channel", cimg);
                        intent.putExtra("channel_title", vcn);
                        intent.putExtra("videoTags", vt);
                        intent.putExtra("channelid", vcid);
                        intent.putExtra("videoId", vid);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        v.getContext().startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<NotificationModel> call, Throwable t) {

                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class mynotifyview extends RecyclerView.ViewHolder {
        ImageView videoomg, channelimg;
        TextView videotitle, channeltitlen;

        public mynotifyview(@NonNull View itemView) {
            super(itemView);

            videoomg = itemView.findViewById(R.id.video_notimg);
            channelimg = itemView.findViewById(R.id.channel_notimg);
            videotitle = itemView.findViewById(R.id.videonamenot_tv);
            channeltitlen = itemView.findViewById(R.id.channel_namenot_tv);
        }
    }
}
