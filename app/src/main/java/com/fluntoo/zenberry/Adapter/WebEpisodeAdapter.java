package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Model.WebEpisodes;
import com.fluntoo.zenberry.R;
import com.fluntoo.zenberry.WebseriesPlayerActivity;

import java.util.ArrayList;
import java.util.List;

//import com.example.playflix.R;


public class WebEpisodeAdapter extends RecyclerView.Adapter<WebEpisodeAdapter.myview> {
    Context context;
    List<WebEpisodes> items = new ArrayList<>();
    String web;

    public WebEpisodeAdapter(Context context, List<WebEpisodes> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_item_web_epds, parent, false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        WebEpisodes item = items.get(position);
        Glide.with(context)
                .load(item.getEpisodeImage())
                .into(holder.img);
        holder.txt.setText("EPD " + item.getWebSeriesEpisodeNumber());

//
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent();
                web = intent2.getStringExtra("id");

                Intent intent = new Intent(context, WebseriesPlayerActivity.class);
//                intent.putExtra("epdno", item.getWebSeriesEpisodeNumber());
//                intent.putExtra("videopath",item.getWebSeriesUploadVideo());
//                intent.putExtra("image",item.getWebSeriesLogo());
//                intent.putExtra("title",item.getWebSeriesTitle());
////                intent.putExtra("desc",item.getWebSeriesDescription().toString());
//                intent.putExtra("id",item.getId());
//                intent.putExtra("res",item.getWebSeriesRestrication());
                intent.putExtra("videopath", item.getWebSeriesUploadVideo());
                intent.putExtra("epdid", item.getEpisodeId());
                intent.putExtra("web", web);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
        TextView txt;

        public myview(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.web_epd_img);
            txt = itemView.findViewById(R.id.epdno_tv);

        }
    }
}
