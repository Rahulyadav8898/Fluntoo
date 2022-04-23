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
import com.fluntoo.zenberry.Model.Music;
import com.fluntoo.zenberry.MusicPlayerActivity;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

public class Music_Fav_Adapter extends RecyclerView.Adapter<Music_Fav_Adapter.myview> {
    private List<Music> items = new ArrayList<>();
    private Context context;

    public Music_Fav_Adapter(List<Music> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_music, parent, false);

        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        Music item = items.get(position);

        Glide.with(context)
                .load(item.getMusicposter())
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, MusicPlayerActivity.class);
                intent.putExtra("musicurl",item.getMusicurl());
                intent.putExtra("musicname",item.getMusictitle());
                intent.putExtra("musicpic",item.getMusicposter());
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
            img = itemView.findViewById(R.id.single_item_music_img);
        }
    }
}
