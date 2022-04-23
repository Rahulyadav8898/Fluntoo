package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Model.Category;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CategoryRecommendedAdapter extends RecyclerView.Adapter <CategoryRecommendedAdapter.myviewholder>{
    private Context context;
    private List<Category> items=new ArrayList<>();

    public static final String DATE_FORMAT_2 = "dd MMM, yyyy";


    public CategoryRecommendedAdapter(Context context, List<Category> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_cat_recommended, parent, false);
        return new myviewholder(view);
    }
    public static String getCurrentDate(Long videoDateadded) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryRecommendedAdapter.myviewholder holder, int position) {
        Category item=items.get(position);

        holder.channelname.setText(item.getVideo().get(position).getVideoChannelName());
        holder.title.setText(item.getVideo().get(position).getVideoTitle());
//        holder.view.setText(item.getViews());
        holder.views.setText(item.getVideo().get(position).getViews().toString());
//        holder.time.setText(getCurrentDate(item.getVideo().get(position).getVideoDateadded()));
        Glide.with(context)
                .load(item.getVideo().get(position).getVideoPosterpath())
                .into(holder.videoView);
        Glide.with(context)
                .load(item.getVideo().get(position).getVideoChannelImage())
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class myviewholder extends RecyclerView.ViewHolder {
        ImageView videoView;
        ImageView img;
        TextView views, title, channelname, time;

        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView01);
            videoView = itemView.findViewById(R.id.playVideoView01);
            views = itemView.findViewById(R.id.postViews);
            title = itemView.findViewById(R.id.textViewTitle);
            channelname = itemView.findViewById(R.id.channelName);
            time = itemView.findViewById(R.id.postTime);
            videoView = itemView.findViewById(R.id.playVideoView01);

        }
    }
}
