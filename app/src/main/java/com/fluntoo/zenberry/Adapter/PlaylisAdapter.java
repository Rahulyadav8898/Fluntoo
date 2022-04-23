package com.fluntoo.zenberry.Adapter;

import android.content.Context;
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
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.DeletePlaylistINterface;
import com.fluntoo.zenberry.Model.Playlist;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaylisAdapter extends RecyclerView.Adapter<PlaylisAdapter.Myviewholder> implements PopupMenu.OnMenuItemClickListener {
    List<Playlist> items = new ArrayList<>();
    Context context;
    String playlistid;


    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public PlaylisAdapter(List<Playlist> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_playlist, parent, false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        Playlist item = items.get(position);
        holder.txttitle.setText(item.getPlaylistTitle());
        holder.txtchannelname.setText(item.getPlayListChannelName());
        Glide.with(context)
                .load(item.getPlayListPosterAdress())
                .into(holder.img);
        playlistid = item.getPlaylistDynamicId().toString();
    }

    @Override
    public int getItemCount() {
        return items.size();
//    return 0;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deletemenu:
                deleteplaylist();
                return true;

            default:
                return false;
        }
    }

    private void deleteplaylist() {

        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
        Toast.makeText(context, user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/playlist/DeletePlaylist/" + playlistid;
        Log.d("url", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DeletePlaylistINterface deletePlaylistINterface = retrofit.create(DeletePlaylistINterface.class);
        Call<Playlist> call = deletePlaylistINterface.deleteplaylist(Url, "Bearer " + name);
        call.enqueue(new Callback<Playlist>() {
            @Override
            public void onResponse(Call<Playlist> call, Response<Playlist> response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Playlist> call, Throwable t) {

                Toast.makeText(context, "Deleted Sucessfully", Toast.LENGTH_SHORT).show();
            }
        });


    }


    public class Myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView txtchannelname, txttitle;
        ImageView menuimg;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.playlist_img);
            txtchannelname = itemView.findViewById(R.id.channel_name);
            txttitle = itemView.findViewById(R.id.playlist_title);
            menuimg = itemView.findViewById(R.id.playlistmenu);
            menuimg.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            showpop(v);
        }
    }

    private void showpop(View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.inflate(R.menu.deletemenu);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }
}
