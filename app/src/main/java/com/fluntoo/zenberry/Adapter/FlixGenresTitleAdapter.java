package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.FlixGenresActivity;
import com.fluntoo.zenberry.Model.FlixGenres;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FlixGenresTitleAdapter extends RecyclerView.Adapter<FlixGenresTitleAdapter.Myholder> {
    List<FlixGenres> items = new ArrayList<>();
     Context mcontext;

    public FlixGenresTitleAdapter(List<FlixGenres> items, Context mcontext) {
        this.items = items;
        this.mcontext = mcontext;
    }

    @NonNull
    @NotNull
    @Override
    public Myholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.single_item_flix_genres, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FlixGenresTitleAdapter.Myholder holder, int position) {
        FlixGenres item=items.get(position);
        holder.tv.setText(item.getGenresName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, FlixGenresActivity.class);
                intent.putExtra("genresname",item.getGenresName());
                mcontext.startActivity(intent);
            }
        });

        Glide.with(mcontext)
        .load(item.getGenresThumbnail())
        .into(holder.imgflix);

//


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
//      ImageView imgflix;
      CircleImageView imgflix;
      TextView tv;


        public Myholder(@NonNull @NotNull View itemView) {
            super(itemView);
          imgflix=itemView.findViewById(R.id.genres_img);
          tv=itemView.findViewById(R.id.flix_tv);
        }
    }


}
