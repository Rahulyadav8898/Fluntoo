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
import com.fluntoo.zenberry.Model.LatestMusic;
import com.fluntoo.zenberry.MusicPlayerActivity;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

public class LatestMusicAdapter extends RecyclerView.Adapter<LatestMusicAdapter.myview1> {
    private List<LatestMusic> items = new ArrayList<>();
    private Context context;

    public LatestMusicAdapter(List<LatestMusic> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_latest_music, parent, false);

        return new myview1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview1 holder, int position) {
        LatestMusic item = items.get(position);
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
                intent.putExtra("musiclike",item.getMusicid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myview1 extends RecyclerView.ViewHolder {
        ImageView img;

        public myview1(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_latest);
        }
    }
}
