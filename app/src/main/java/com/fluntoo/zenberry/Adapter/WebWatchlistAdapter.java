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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.WebWatchlaterInterface;
import com.fluntoo.zenberry.Model.WebTrending;
import com.fluntoo.zenberry.R;
import com.fluntoo.zenberry.WatchListActivity;
import com.fluntoo.zenberry.WebseriesActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebWatchlistAdapter extends RecyclerView.Adapter<WebWatchlistAdapter.myview> {
    List<WebTrending> items = new ArrayList<>();
    Context context;
    String webid;

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    ConstraintLayout layout;

    public WebWatchlistAdapter(List<WebTrending> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_web_watchlist, parent, false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        WebTrending item = items.get(position);
        holder.txttitle.setText(item.getWebSeriesTitle());
        Glide.with(context)
                .load(item.getWebSeriesImage())
                .into(holder.img);
        holder.txtchannelname.setText(item.getWebseriesGenres().toString());
        webid = item.getWebSeriesId();

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
                Intent intent = new Intent(context, WebseriesActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("genres", genres);
                intent.putExtra("image", image);
//                intent.putExtra("res", restriction);
                intent.putExtra("desc", desc);
                intent.putExtra("cast", cast);
                intent.putExtra("id", webseriesid);
//                intent.putExtra("date",relesedate);
                context.startActivity(intent);
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
            img = itemView.findViewById(R.id.webwatchlist_img);
            txtchannelname = itemView.findViewById(R.id.webwatchlistchannel_name);
            txttitle = itemView.findViewById(R.id.webwatchlist_title);
//            menuimg = itemView.findViewById(R.id.webwatchlistmenu);
//            menuimg.setOnClickListener(this);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
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

        String Url = "https://api.fluntoo.com/webseries/" + user + "/deleteWebSerieswatchlater/" + webid;
        Log.d("url", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebWatchlaterInterface webWatchlaterInterface = retrofit.create(WebWatchlaterInterface.class);
        Call<WebTrending> call = webWatchlaterInterface.deletewatchlist(Url);
        call.enqueue(new Callback<WebTrending>() {
            @Override
            public void onResponse(Call<WebTrending> call, Response<WebTrending> response) {
                Toast.makeText(context.getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<WebTrending> call, Throwable t) {

                Toast.makeText(context.getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, WatchListActivity.class));
                ((AppCompatActivity)context).finish();
            }
        });
    }
}
