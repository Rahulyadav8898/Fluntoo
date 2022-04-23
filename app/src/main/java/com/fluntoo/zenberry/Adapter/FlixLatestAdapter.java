package com.fluntoo.zenberry.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.FlixPlayerActivity;
import com.fluntoo.zenberry.LoginActivityNew;
import com.fluntoo.zenberry.Model.FlixLatest;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

//import com.example.playflix.R;

public class FlixLatestAdapter extends RecyclerView.Adapter<FlixLatestAdapter.MYView> {
    List<FlixLatest> items = new ArrayList<>();
    Context context;

    ProgressDialog progressBar;
    Boolean isLogin=false;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public FlixLatestAdapter(List<FlixLatest> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MYView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_flix_latest, parent, false);


        return new MYView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYView holder, int position) {

        FlixLatest item = items.get(position);
//        holder.txtlat.setText(item.getMovieTitle());
        Glide.with(context)
                .load(item.getMovieImage())
                .into(holder.imglat);

        String title = item.getMovieTitle();
        String genres = item.getMovieGenres().toString();
        String image = item.getMovieImage();
        String restriction = item.getMovieRestrication();
//        String relesedate = item.getMovieReleaseDate();
        String desc = item.getMovieDescription();
        String cast = "Cast:" + item.getMovieCast().toString();
        String webseriesid = item.getMovieId();
        String videoview = item.getMovieDash();
        String id = item.getMovieId();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {
                    Intent intent = new Intent(v.getContext(), FlixPlayerActivity.class);
                    intent.putExtra("title", title);
                    intent.putExtra("genres", genres);
                    intent.putExtra("image", image);
                    intent.putExtra("res", restriction);
                    intent.putExtra("desc", desc);
                    intent.putExtra("cast", cast);
                    intent.putExtra("id", webseriesid);
                    intent.putExtra("videov", videoview);
                    intent.putExtra("id", id);
//                    intent.putExtra("date", relesedate);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    v.getContext().startActivity(intent);


                } else {
//                    Toast.makeText(getApplicationContext(), "You are not logged in !!", Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(context)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    context.startActivity(new Intent(context, LoginActivityNew.class));

                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();


//                Intent intent = new Intent(v.getContext(), FlixPlayerActivity.class);
//                intent.putExtra("title", title);
//                intent.putExtra("genres", genres);
//                intent.putExtra("image", image);
//                intent.putExtra("res", restriction);
//                intent.putExtra("desc", desc);
//                intent.putExtra("cast", cast);
//                intent.putExtra("id", webseriesid);
//                intent.putExtra("videov", videoview);
//                intent.putExtra("id", id);
//                intent.putExtra("date", relesedate);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                v.getContext().startActivity(intent);
                }
            }

    });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MYView extends RecyclerView.ViewHolder {
        ImageView imglat;
        TextView txtlat;

        public MYView(@NonNull View itemView) {
            super(itemView);
            imglat = itemView.findViewById(R.id.flix_latest_img);
//            txtlat = itemView.findViewById(R.id.flix_latest_tv);
        }
    }
}
