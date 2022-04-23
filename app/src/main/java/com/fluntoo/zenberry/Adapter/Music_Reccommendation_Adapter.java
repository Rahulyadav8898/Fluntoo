package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Model.Music;
import com.fluntoo.zenberry.MusicPlayerActivity;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

public class Music_Reccommendation_Adapter extends RecyclerView.Adapter<Music_Reccommendation_Adapter.myview> implements PopupMenu.OnMenuItemClickListener {

    private List<Music> items = new ArrayList<>();
    private Context context;

    public Music_Reccommendation_Adapter(List<Music> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_music_reccommendation, parent, false);

        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {

        Music item = items.get(position);
        holder.tv.setText(item.getMusictitle());

        Glide.with(context)
                .load(item.getMusicposter())
                .into(holder.img);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MusicPlayerActivity.class);
                intent.putExtra("musicurl", item.getMusicurl());
                intent.putExtra("musicname", item.getMusictitle());
                intent.putExtra("musicpic", item.getMusicposter());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


    public class myview extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;
        ImageView img, menu;

        public myview(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.title_music_recc);
            img = itemView.findViewById(R.id.rec_img);
            menu = itemView.findViewById(R.id.musicmenu);
            menu.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Log.d("check", "onclick " + getAdapterPosition());
            showpop(v);
        }
    }

    private void showpop(View v) {
        android.widget.PopupMenu popupMenu = new android.widget.PopupMenu(v.getContext(), v);
        popupMenu.inflate(R.menu.musicmenu);

        popupMenu.show();
    }


}


