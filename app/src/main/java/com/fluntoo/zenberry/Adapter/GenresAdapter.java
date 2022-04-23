package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.FlixGenresActivity;
import com.fluntoo.zenberry.Model.Genres;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import java.util.ArrayList;
import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.myview> {

    List<Genres> items=new ArrayList<>();
    Context context;

    public GenresAdapter(List<Genres> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_item_genres, parent, false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        Genres item=items.get(position);
        holder.txt.setText(item.getGenresName());
        Glide.with(context)
                .load(item.getGenresThumbnail())
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, FlixGenresActivity.class);
                intent.putExtra("genresname",item.getGenresName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                Toast.makeText(context.getApplicationContext(),item.getGenresName(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class myview extends RecyclerView.ViewHolder {
        CardView card;
        TextView txt;
        ImageView img;
        public myview(@NonNull View itemView) {
            super(itemView);
//            card=itemView.findViewById(R.id.cardgenres);
            img=itemView.findViewById(R.id.img_genres);
            txt=itemView.findViewById(R.id.title_genres);
        }
    }
}
