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
import com.fluntoo.zenberry.FlixPlayerActivity;
import com.fluntoo.zenberry.Model.MovieRecommended;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import java.util.ArrayList;
import java.util.List;

public class FlixRecommendedAdapter extends RecyclerView.Adapter<FlixRecommendedAdapter.myview> {
    Context context;
    List<MovieRecommended> items = new ArrayList<>();

    public FlixRecommendedAdapter(Context context, List<MovieRecommended> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_item_flix_recommended, parent, false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        MovieRecommended item = items.get(position);
        Glide.with(context)
                .load(item.getMovieImage())
                .into(holder.img);
        String title = (String) item.getMovieTitle();
//        String genres = item.getMovieGenres().toString();
        String image = item.getMovieImage().toString();
//        String restriction = item.getMovieRestrication().toString();
//        String relesedate = item.getMovieReleaseDate().toString();
        String desc = item.getMovieDescription().toString();
//        String cast = "Cast:" + item.getMovieCast().toString();
        String webseriesid = item.getMovieId().toString();
        String videoview = item.getMovieDash().toString();
        String id = item.getMovieId().toString();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FlixPlayerActivity.class);
                intent.putExtra("title", title);
//                intent.putExtra("genres", genres);
                intent.putExtra("image", image);
//                intent.putExtra("res", restriction);
                intent.putExtra("desc", desc);
//                intent.putExtra("cast", cast);
                intent.putExtra("id", webseriesid);
                intent.putExtra("videov", videoview);
                intent.putExtra("id", id);
//                intent.putExtra("date", relesedate);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
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
            img = itemView.findViewById(R.id.img_rec);
        }
    }
}
