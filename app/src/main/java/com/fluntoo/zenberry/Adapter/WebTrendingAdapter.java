package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.FlixPlayerActivity;
import com.fluntoo.zenberry.LoginActivityNew;
import com.fluntoo.zenberry.Login_Page;
import com.fluntoo.zenberry.Model.WebTrending;
//import com.example.playflix.R;
import com.fluntoo.zenberry.R;
import com.fluntoo.zenberry.WebseriesActivity;

import java.util.ArrayList;
import java.util.List;

public class WebTrendingAdapter extends RecyclerView.Adapter<WebTrendingAdapter.myview> {
    List<WebTrending> items = new ArrayList<>();
    Context context;

    Boolean isLogin=false;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public WebTrendingAdapter(List<WebTrending> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.single_item_web_trending,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        WebTrending item=items.get(position);
        Glide.with(context)
                .load(item.getWebSeriesImage())
                .into(holder.img);
        String title=item.getWebSeriesTitle();
        String genres=item.getWebseriesGenres().toString();
        String image=item.getWebSeriesImage();
//        String restriction=item.getWebSeriesRestrication();
//        String relesedate= (String) item.getWebseriesReleaseDate();
        String desc=item.getWebSeriesDescription();
        String cast=item.getWebSeriesCast().toString();
        String webseriesid=item.getWebSeriesId();



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {

                    Intent intent=new Intent(context, WebseriesActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("genres",genres);
                intent.putExtra("image",image);
//                intent.putExtra("res",restriction);
                intent.putExtra("desc",desc);
                intent.putExtra("cast",cast);
                intent.putExtra("id",webseriesid);
//                intent.putExtra("date",relesedate);
                context.startActivity(intent);

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


//                Intent intent=new Intent(context, WebseriesActivity.class);
////                intent.putExtra("title",title);
////                intent.putExtra("genres",genres);
////                intent.putExtra("image",image);
////                intent.putExtra("res",restriction);
////                intent.putExtra("desc",desc);
////                intent.putExtra("cast",cast);
////                intent.putExtra("id",webseriesid);
////                intent.putExtra("date",relesedate);
////                context.startActivity(intent);
                }
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
            img = itemView.findViewById(R.id.web_trending_img);
        }
    }
}
