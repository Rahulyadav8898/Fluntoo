package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.FlixwatchlaterInterface;
import com.fluntoo.zenberry.FlixPlayerActivity;
import com.fluntoo.zenberry.Model.FlixTrending;
import com.fluntoo.zenberry.Model.FlixWatchlater;
import com.fluntoo.zenberry.R;
import com.fluntoo.zenberry.WatchListActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlixWatchlistAdapter extends RecyclerView.Adapter<FlixWatchlistAdapter.myview> {
    List<FlixTrending> items = new ArrayList<>();
    Context context;
    String vid;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public FlixWatchlistAdapter(List<FlixTrending> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_flixwatchlist, parent, false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        FlixTrending item = items.get(position);
        holder.txttitle.setText(item.getMovieTitle().toString());
        Glide.with(context)
                .load(item.getMovieImage().toString())
                .into(holder.img);
        holder.txtchannelname.setText(item.getMovieGenres().toString());
        vid = item.getMovieId().toString();
        String title = item.getMovieTitle();
        String genres = item.getMovieGenres().toString();
        String image = item.getMovieImage();
//        String restriction = item.getMovieRestrication();
//        String relesedate = item.getMovieReleaseDate().toString();
        String desc = item.getMovieDescription();
        String cast = "Cast : " + item.getMovieCast().toString();
        String id = item.getMovieId();
        String videoview = (String) item.getMovieUpload();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FlixPlayerActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("genres", genres);
                intent.putExtra("image", image);
//                intent.putExtra("res", restriction);
                intent.putExtra("desc", desc);
                intent.putExtra("cast", cast);
                intent.putExtra("id", id);
                intent.putExtra("videov", videoview);
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

    public class myview extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

        ImageView img;
        TextView txtchannelname, txttitle;
        ImageView menuimg;

        public myview(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.flixwatchlist_img);
            txtchannelname = itemView.findViewById(R.id.flixwatchlistchannel_name);
            txttitle = itemView.findViewById(R.id.flixwatchlist_title);
//            menuimg = itemView.findViewById(R.id.flixwatchlistmenu);
//            menuimg.setOnClickListener(this);
            itemView.setOnClickListener(this);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
//                    Toast.makeText(context.getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
                    showpop(v);
                    return false;
                }
            });


        }

        @Override
        public void onClick(View v) {
            showpop(v);
        }

        private void showpop(View v) {
            PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
            popupMenu.inflate(R.menu.deletemenu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }


        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.deletemenu:
                    deletewatchlist();
                    return true;

                default:
                    return false;
            }
        }

    }

    private void deletewatchlist() {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(context, user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/movie/" + user + "/deletemoviewatchlater/" + vid;
        Log.d("url", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FlixwatchlaterInterface flixwatchlaterInterface = retrofit.create(FlixwatchlaterInterface.class);
        Call<FlixWatchlater> call = flixwatchlaterInterface.deletewatchlist(Url);
        call.enqueue(new Callback<FlixWatchlater>() {
            @Override
            public void onResponse(Call<FlixWatchlater> call, Response<FlixWatchlater> response) {
                Toast.makeText(context.getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<FlixWatchlater> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();

                context.startActivity(new Intent(context, WatchListActivity.class));
                ((AppCompatActivity)context).finish();
            }
        });


    }
}
