package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Model.TrendingMusic;
import com.fluntoo.zenberry.MusicPlayerActivity;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

public class TrendingMusicAdapter extends RecyclerView.Adapter<TrendingMusicAdapter.myview>{

    private Context context;
    private List<TrendingMusic> items=new ArrayList<>();

    public TrendingMusicAdapter(Context context, List<TrendingMusic> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_trending_music, parent, false);

        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        TrendingMusic item=items.get(position);
        Glide.with(context)
                .load(item.getPoster())
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, MusicPlayerActivity.class);
                intent.putExtra("musicurl",item.getSongFile());
                intent.putExtra("musicname",item.getSongTitle());
                intent.putExtra("musicpic",item.getPoster());
                intent.putExtra("musiclike",item.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myview extends RecyclerView.ViewHolder {
        ImageView img;
        public myview(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.single_item_trending_music_img);
        }
    }
}
