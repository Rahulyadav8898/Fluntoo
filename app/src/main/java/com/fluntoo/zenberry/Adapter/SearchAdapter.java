package com.fluntoo.zenberry.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.ApIInterface.SearchInterface;
import com.fluntoo.zenberry.Model.Search;
import com.fluntoo.zenberry.Player;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.playflix.R;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.myviewhold> {

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    ArrayList<String> items = new ArrayList<>();
    Context context;
    public static final String DATE_FORMAT_2 = "dd MMM, yyyy";

    String resp;

    public SearchAdapter(ArrayList<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    //    public static String getCurrentDate(Long videoDateadded) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
//        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//        Date today = Calendar.getInstance().getTime();
//        return dateFormat.format(today);
//    }

    @NonNull
    @Override
    public myviewhold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_search, parent, false);
        return new myviewhold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewhold holder, int position) {


        String ress = items.get(position);
        holder.title.setText(ress);

        resp = ress;
        Log.d("ea", resp);


//        Search item=items.get(position);
//        holder.views.setText(item.getViews().toString());
////        holder.time.setText(item.getVideoDateadded().toString());
//        holder.time.setText(getCurrentDate(item.getVideoDateadded()));
//        holder.title.setText(item.getVideoTitle());
//        holder.channelname.setText(item.getVideoChannelName());
//        Glide.with(context)
//                .load(item.getVideoPosterpath())
//                .into(holder.videoView);
//        Glide.with(context)
//                .load(item.getVideoChannelImage())
//                .into(holder.img);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(v.getContext(), Player.class);
//                intent.putExtra("videodesc",item.getVideoDescription());
//                intent.putExtra("videotitle",item.getVideoTitle());
//                intent.putExtra("videoview",item.getVideoFilepath());
//                intent.putExtra("likes",item.getLikes());
//                intent.putExtra("dislikes",item.getDislikes());
//                intent.putExtra("subscribed", (Bundle) item.getSubscribed());
//                intent.putExtra("views",item.getViews().toString());
//                intent.putExtra("videoCategory",item.getVideoCategory());
//                intent.putExtra("img_channel",item.getVideoChannelImage().toString());
//                intent.putExtra("channel_title",item.getVideoChannelName());
//                intent.putExtra("videoTags",item.getVideoTags());
//
//                intent.putExtra("videoId",item.getVideoId());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                v.getContext().startActivity(intent);
//
//            }
//        });.

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://api.fluntoo.com/search/keyword/search/play";
                SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
                String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
                String user = prefs.getString("userId", "no value");
                Long userid = Long.parseLong(user);

                Log.d("url", url);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                SearchInterface searchInterface = retrofit.create(SearchInterface.class);
                Call<List<Search>> call = searchInterface.getsearchlist(url, ress, user);
                call.enqueue(new Callback<List<Search>>() {

                    public void onResponse(Call<List<Search>> call, Response<List<Search>> response) {
                        Search res = (Search) response.body().get(0);
//                        Toast.makeText(context, res.getChannelName().toString(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(v.getContext(), Player.class);
                        intent.putExtra("videodesc", res.getVideoDescription());
                        intent.putExtra("videotitle", res.getVideoTitle());
                        intent.putExtra("videoview", res.getVideoFilepath());
                        intent.putExtra("likes", res.getLikes());
                        intent.putExtra("dislikes", res.getDislikes());
                        intent.putExtra("subscribed", (Bundle) res.getSubscribed());
                        intent.putExtra("views", res.getViews().toString());
                        intent.putExtra("img_channel", res.getVideoChannelImage().toString());
                        intent.putExtra("channel_title", res.getVideoChannelName());
                        intent.putExtra("videoTags", res.getVideoTags());
                        intent.putExtra("videoCategory", res.getVideoCategory());
                        intent.putExtra("videoId", res.getVideoId());
                        intent.putExtra("channelid", res.getVideoChannelId());
                        intent.putExtra("channeldyanmicid", res.getChanneldynamicid());

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        v.getContext().startActivity(intent);
                        ((Activity) v.getContext()).finish();


                    }

                    @Override
                    public void onFailure(Call<List<Search>> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("error", t.toString());
                    }
                });
            }
        });

    }

//    private void getvideo() {
////        Toast.makeText(context,resp, Toast.LENGTH_SHORT).show();
//
//
//
//
//    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myviewhold extends RecyclerView.ViewHolder {
        ImageView videoView;
        ImageView img;
        TextView views, title, channelname, time;


        public myviewhold(@NonNull View itemView) {
            super(itemView);
//            img = itemView.findViewById(R.id.imageView01);
//            videoView = itemView.findViewById(R.id.playVideoView01);
//            views = itemView.findViewById(R.id.postViews);
            title = itemView.findViewById(R.id.textViewTitle);
//            channelname = itemView.findViewById(R.id.channelName);
//            time = itemView.findViewById(R.id.postTime);
//            videoView = itemView.findViewById(R.id.playVideoView01);
        }
    }
}
