package com.fluntoo.zenberry.Adapter;

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
import com.fluntoo.zenberry.Login_Page;
import com.fluntoo.zenberry.Model.FlixGenresData;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FlixGenresAdapter extends RecyclerView.Adapter<FlixGenresAdapter.Myview> {
    private Context context;
    List<FlixGenresData> items=new ArrayList<>();

    Boolean isLogin=false;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public FlixGenresAdapter(Context context, List<FlixGenresData> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public Myview onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_image_flix, parent, false);
        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FlixGenresAdapter.Myview holder, int position) {
        FlixGenresData item=items.get(position);
//        Log.d("TAG", "onBindViewHolder: "+item.getMovieId());
        Glide.with(context)
                .load(item.getMovieImage())
                .into(holder.imageView);

        holder.tv.setText(item.getMovieTitle());
        String title=item.getMovieTitle();
        String genres=item.getMovieGenres().toString();
        String image=item.getMovieImage();
//        String restriction=item.getMovieRestrication();
//        String relesedate= item.getWebseriesReleaseDate().toString();
        String desc=item.getMovieDescription();
        String cast=item.getMovieCast().toString();
        String id=item.getMovieId();
        String videoview=item.getMovieDash();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {
                    Intent intent=new Intent(v.getContext(), FlixPlayerActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("genres",genres);
                intent.putExtra("image",image);
//                intent.putExtra("res",restriction);
                intent.putExtra("desc",desc);
                intent.putExtra("cast",cast);
                intent.putExtra("id",id);
                intent.putExtra("videov",videoview);

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
                                    context.startActivity(new Intent(context, Login_Page.class));

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

//                Intent intent=new Intent(v.getContext(), FlixPlayerActivity.class);
//                intent.putExtra("title",title);
//                intent.putExtra("genres",genres);
//                intent.putExtra("image",image);
//                intent.putExtra("res",restriction);
//                intent.putExtra("desc",desc);
//                intent.putExtra("cast",cast);
//                intent.putExtra("id",id);
//                intent.putExtra("videov",videoview);
//
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

    public class Myview extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv;

        public Myview(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.flix_genres_img);
            tv=itemView.findViewById(R.id.movie_title);
        }
    }
}
