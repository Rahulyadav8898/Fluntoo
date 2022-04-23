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
import com.fluntoo.zenberry.ApIInterface.DeleteChannelInterface;
import com.fluntoo.zenberry.Model.Channellist;
import com.fluntoo.zenberry.R;
//import com.example.playflix.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChannellistAdapter extends RecyclerView.Adapter<ChannellistAdapter.Myview> implements PopupMenu.OnMenuItemClickListener {
    List<Channellist> items = new ArrayList<>();
    Context context;

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    String channelid;

    public ChannellistAdapter(List<Channellist> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_channellist, parent, false);
        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, int position) {

        Channellist item = items.get(position);
        holder.txtsubs.setText(item.getSubscribers().toString());
        holder.txtchannel.setText(item.getChannelName());
        Glide.with(context)
                .load(item.getChannelProfileimagepath())
                .into(holder.img);
        channelid = item.getChannelId().toString();

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.deletemenu:
                deletechannel();
                return true;

            default:
                return false;
        }
    }

    private void deletechannel() {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(context, user, Toast.LENGTH_SHORT).show();
//

        String Url = "https://api.fluntoo.com/channel/" + user + "/deleteChannel/" + channelid;
        Log.d("url", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DeleteChannelInterface deleteChannelInterface = retrofit.create(DeleteChannelInterface.class);
        Call<Channellist> call = deleteChannelInterface.deletechannel(Url, "Bearer " + name);
        call.enqueue(new Callback<Channellist>() {
            @Override
            public void onResponse(Call<Channellist> call, Response<Channellist> response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Channellist> call, Throwable t) {
                Toast.makeText(context, "Deleted Sucessfully", Toast.LENGTH_SHORT).show();
            }
        });


    }


    public class Myview extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView img;
        TextView txtchannel, txtsubs;
        ImageView menuimg;

        public Myview(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.channel_img);
            txtchannel = itemView.findViewById(R.id.channel_channelname);
            txtsubs = itemView.findViewById(R.id.subscribertv);
            menuimg = itemView.findViewById(R.id.menuimg);
            menuimg.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("check", "onclick " + getAdapterPosition());
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
