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
import com.fluntoo.zenberry.Model.WebRecommended;
//import com.example.playflix.R;
import com.fluntoo.zenberry.R;
import com.fluntoo.zenberry.WebseriesActivity;

import java.util.ArrayList;
import java.util.List;

public class WebRecommendedAdapter extends RecyclerView.Adapter<WebRecommendedAdapter.myview> {
    Context context;
    List<WebRecommended> items=new ArrayList<>();

    public WebRecommendedAdapter(Context context, List<WebRecommended> items) {
        this.context = context;
        this.items = items;
    }





    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_item_web_recommended,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        WebRecommended item=items.get(position);

        Glide.with(context)
                .load(item.getWebSeriesImage())
                .into(holder.img);

        String title=item.getWebSeriesTitle();
        String genres=item.getWebseriesGenres().toString();
        String image=item.getWebSeriesImage();
//        String restriction=item.getWebSeriesRestrication();
//        String relesedate= item.getWebseriesReleaseDate().toString();
        String desc=item.getWebSeriesDescription();
        String cast=item.getWebSeriesCast().toString();
        String webseriesid=item.getWebSeriesId();



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent intent=new Intent(context, WebseriesActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("genres",genres);
                intent.putExtra("image",image);
//                intent.putExtra("res",restriction);
                intent.putExtra("desc",desc);
                intent.putExtra("cast",cast);
                intent.putExtra("id",webseriesid);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("date",relesedate);
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
            img=itemView.findViewById(R.id.img_rec);
        }
    }
}
