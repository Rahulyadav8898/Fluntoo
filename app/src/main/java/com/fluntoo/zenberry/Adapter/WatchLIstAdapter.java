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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.WatchLAterINterface;
import com.fluntoo.zenberry.Model.Playwatchlater;
import com.fluntoo.zenberry.Player;
import com.fluntoo.zenberry.R;
import com.fluntoo.zenberry.WatchListActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WatchLIstAdapter extends RecyclerView.Adapter<WatchLIstAdapter.Myviewholder> {
    List<Playwatchlater> items = new ArrayList<>();
    Context context;
    String vid;


    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public WatchLIstAdapter(List<Playwatchlater> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_watchlist, parent, false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

        Playwatchlater item = items.get(position);
        holder.txttitle.setText(item.getVideoTitle());
        holder.txtchannelname.setText(item.getVideoChannelName());
        Glide.with(context)
                .load(item.getVideoPosterpath())
                .into(holder.img);

        vid = item.getVideoId().toString();

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
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    //
    private void deletewatchlist() {

        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(context, user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/video/" + user + "/deletewatchlater/" + vid;
        Log.d("url", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WatchLAterINterface watchLAterINterface = retrofit.create(WatchLAterINterface.class);
        Call<Playwatchlater> call = watchLAterINterface.deletewatchlist(Url);
        call.enqueue(new Callback<Playwatchlater>() {
            @Override
            public void onResponse(Call<Playwatchlater> call, Response<Playwatchlater> response) {
                Toast.makeText(context.getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Playwatchlater> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, WatchListActivity.class));
                ((AppCompatActivity)context).finish();


            }
        });

    }


    public class Myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
        ImageView img;
        TextView txtchannelname, txttitle;
        ImageView menuimg;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.watchlist_img);
            txtchannelname = itemView.findViewById(R.id.watchlistchannel_name);
            txttitle = itemView.findViewById(R.id.watchlist_title);
//            menuimg = itemView.findViewById(R.id.watchlistmenu);
//            menuimg.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    showpop(v);
                    return false;
                }
            });
        }

        @Override
        public void onClick(View v) {
            showpop(v);
        }

        private void showpop(View v) {
            PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
            popupMenu.inflate(R.menu.deletemenu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.deletemenu:
                    deletewatchlist();
                    return true;

                default:
                    return false;
            }


//
//


        }
    }
}

//
