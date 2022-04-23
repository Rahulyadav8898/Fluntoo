package com.fluntoo.zenberry.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.ChannelINfoInterface;
import com.fluntoo.zenberry.ApIInterface.PopularCHannelInterface;
import com.fluntoo.zenberry.ApIInterface.SubscribeInterface;
import com.fluntoo.zenberry.Model.ChannelINfo;
import com.fluntoo.zenberry.Model.ChannelPopular;
import com.fluntoo.zenberry.Model.ChannelPopularAdapter;
import com.fluntoo.zenberry.Model.PostItem;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home_Channel_Frag extends Fragment {
    ImageView coverimg, profileimg;
    TextView sub, channelname;
    Button subbtn, subsdbtn;

    String channelid;
    String abc;
    String chanid;
//
//    RecyclerView reccyclerview;
//    List<ChannelNameVideoList> video = new ArrayList<>();
//    ChannelNameHomeAdapter adapter;

    RecyclerView reccyclerview;
    List<ChannelPopular> videolist = new ArrayList<>();
    ChannelPopularAdapter adapter;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_channel_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        coverimg = view.findViewById(R.id.channelname_coverpic);
        profileimg = view.findViewById(R.id.channelname_profilepic);
        sub = view.findViewById(R.id.subscribertvchannelname);
        channelname = view.findViewById(R.id.channelname_tv);
        subbtn = view.findViewById(R.id.subscribe_btn);
        subsdbtn = view.findViewById(R.id.subscribed_btn);
        reccyclerview = view.findViewById(R.id.recyclerview_pop);

        getdata();

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swipechannelhome);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getdata();

                swipeRefreshLayout.setRefreshing(false);
            }
        });

//        Intent intent = getActivity().getIntent();
//        channelid = intent.getStringExtra("channeldyanmicid");
//
////        Intent intent1=getActivity().getIntent();
////        channelid=intent1.getStringExtra("channeldyanmicid");
////        abc = intent.getIntExtra("rah", 0);
////        Toast.makeText(getContext(), channelid, Toast.LENGTH_SHORT).show();
//
//
//        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);
//
//        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no vale");
////        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();
//
//        String Url = "https://www.api.playflixx.com/" + user + "/" + channelid;
//        Log.i("url", Url);
//        Log.d("token", name);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ChannelINfoInterface channelINfoInterface = retrofit.create(ChannelINfoInterface.class);
//        Call<ChannelINfo> call = channelINfoInterface.getchannelinfo(Url);
//        call.enqueue(new Callback<ChannelINfo>() {
//            @Override
//            public void onResponse(Call<ChannelINfo> call, Response<ChannelINfo> response) {
//                String coverpic = response.body().getChannelProfilecoverpath().toString();
//                String profilepic = response.body().getChannelProfileimagepath().toString();
//                String channelname1 = response.body().getChannelName();
//                String sub1 = response.body().getSubscribers().toString();
//
//                abc = response.body().getChannelId().toString();
//
////                chanid = response.body().getChannelId().toString();
//                chanid = response.body().getChanneldynamicId().toString();
//                channelname.setText(channelname1);
//
//
//                sub.setText(sub1 + " subscribers");
//
//                Glide.with(getContext())
//                        .load(coverpic.toString())
//                        .into(coverimg);
//
//                Glide.with(getContext())
//                        .load(profilepic.toString())
//                        .into(profileimg);
////                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
////                reccyclerview.setLayoutManager(layoutManager);
////                adapter = new ChannelNameHomeAdapter(video, getContext());
////                reccyclerview.setAdapter(adapter);
//////        list();
////                SharedPreferences prefs1 = getActivity().getSharedPreferences(MY_PREFS_NAME, 0);
////
////                String name1 = prefs1.getString("tokenid", "No name defined");//"No name defined" is the default value.
////                String user1 = prefs1.getString("userId", "no vale");
//////                Toast.makeText(getContext(), user1, Toast.LENGTH_SHORT).show();
////
////                String Url1 = "https://www.api.playflixx.com/getallvideolist/" + abc;
////                Log.d("urlchan", Url1.toString());
////                Log.d("token", name1);
////                Retrofit retrofit2 = new Retrofit.Builder()
////                        .baseUrl("https://www.api.playflixx.com/")
////                        .addConverterFactory(GsonConverterFactory.create())
////                        .build();
////                ChannelNameVideoInterface channelNameVideoInterface = retrofit2.create(ChannelNameVideoInterface.class);
////                Call<List<ChannelNameVideoList>> call2 = channelNameVideoInterface.getvideolist(Url1);
////                call2.enqueue(new Callback<List<ChannelNameVideoList>>() {
////                    @Override
////                    public void onResponse(Call<List<ChannelNameVideoList>> call, Response<List<ChannelNameVideoList>> response) {
////
////                        video.clear();
////                        video.addAll(response.body());
////                        adapter.notifyDataSetChanged();
////
////                    }
////
////                    @Override
////                    public void onFailure(Call<List<ChannelNameVideoList>> call, Throwable t) {
////                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
////                    }
////                });
//
//
//                LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
//                reccyclerview.setLayoutManager(layoutManager2);
//                adapter = new ChannelPopularAdapter(videolist, getContext());
//                reccyclerview.setAdapter(adapter);
//
//
//                SharedPreferences prefs1 = getActivity().getSharedPreferences(MY_PREFS_NAME, 0);
//
//                String name1 = prefs1.getString("tokenid", "No name defined");//"No name defined" is the default value.
//                String user1 = prefs1.getString("userId", "no vale");
////                Toast.makeText(getContext(), user1, Toast.LENGTH_SHORT).show();
//
//                String Url1 = "https://www.api.playflixx.com/popularvideo/"+channelid;
//                Log.d("url", Url1.toString());
//                Log.d("token", name1);
//                Retrofit retrofit2 = new Retrofit.Builder()
//                        .baseUrl("https://www.api.playflixx.com/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                PopularCHannelInterface popularCHannelInterface = retrofit2.create(PopularCHannelInterface.class);
//                Call<List<ChannelPopular>> call1 = popularCHannelInterface.getlist(Url1);
//                call1.enqueue(new Callback<List<ChannelPopular>>() {
//                    @Override
//                    public void onResponse(Call<List<ChannelPopular>> call, Response<List<ChannelPopular>> response) {
//                        videolist.clear();
//                        videolist.addAll(response.body());
//                        adapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<ChannelPopular>> call, Throwable t) {
//
//
//                    }
//                });
//
//            }
//
//            @Override
//            public void onFailure(Call<ChannelINfo> call, Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        subbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, 0);
//
//                String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//                String user = prefs.getString("userId", "no vale");
////        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();
//
//
//                String Url = "https://www.api.playflixx.com/" + user + "/subscribe/" + abc;
//                Log.i("end", Url);
//                Log.d("token", name);
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl("https://www.api.playflixx.com/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                SubscribeInterface subscribeInterface = retrofit.create(SubscribeInterface.class);
//                Call<PostItem> call1 = subscribeInterface.getsubcribe(Url, "Bearer " + name);
//                call1.enqueue(new Callback<PostItem>() {
//                    @Override
//                    public void onResponse(Call<PostItem> call, Response<PostItem> response) {
//                        Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<PostItem> call, Throwable t) {
//
//                        Toast.makeText(getContext(), "subcribed", Toast.LENGTH_SHORT).show();
//                        subbtn.setVisibility(View.GONE);
//                        subsdbtn.setVisibility(View.VISIBLE);
//
//                    }
//                });
//            }
//        });


    }

    private void getdata() {
        Intent intent = getActivity().getIntent();
        channelid = intent.getStringExtra("channeldyanmicid");
//        Log.d("id",chanid);

//        Intent intent1=getActivity().getIntent();
//        channelid=intent1.getStringExtra("channeldyanmicid");
//        abc = intent.getIntExtra("rah", 0);
//        Toast.makeText(getContext(), channelid, Toast.LENGTH_SHORT).show();


        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/channel/" + user + "/" + channelid;
        Log.i("url", Url);
        Log.d("token", name);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ChannelINfoInterface channelINfoInterface = retrofit.create(ChannelINfoInterface.class);
        Call<ChannelINfo> call = channelINfoInterface.getchannelinfo(Url);
        call.enqueue(new Callback<ChannelINfo>() {
            @Override
            public void onResponse(Call<ChannelINfo> call, Response<ChannelINfo> response) {
                String coverpic = response.body().getChannelProfilecoverpath().toString();
                String profilepic = response.body().getChannelProfileimagepath().toString();
                String channelname1 = response.body().getChannelName();
                String sub1 = response.body().getSubscribers().toString();

                abc = response.body().getChannelId().toString();

//                chanid = response.body().getChannelId().toString();
                chanid = response.body().getChanneldynamicId().toString();
                channelname.setText(channelname1);


                sub.setText(sub1 + " subscribers");

                Glide.with(getContext())
                        .load(coverpic.toString())
                        .into(coverimg);

                Glide.with(getContext())
                        .load(profilepic.toString())
                        .into(profileimg);

//                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//                reccyclerview.setLayoutManager(layoutManager);
//                adapter = new ChannelNameHomeAdapter(video, getContext());
//                reccyclerview.setAdapter(adapter);
////        list();
//                SharedPreferences prefs1 = getActivity().getSharedPreferences(MY_PREFS_NAME, 0);
//
//                String name1 = prefs1.getString("tokenid", "No name defined");//"No name defined" is the default value.
//                String user1 = prefs1.getString("userId", "no vale");
////                Toast.makeText(getContext(), user1, Toast.LENGTH_SHORT).show();
//
//                String Url1 = "https://www.api.playflixx.com/getallvideolist/" + abc;
//                Log.d("urlchan", Url1.toString());
//                Log.d("token", name1);
//                Retrofit retrofit2 = new Retrofit.Builder()
//                        .baseUrl("https://www.api.playflixx.com/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                ChannelNameVideoInterface channelNameVideoInterface = retrofit2.create(ChannelNameVideoInterface.class);
//                Call<List<ChannelNameVideoList>> call2 = channelNameVideoInterface.getvideolist(Url1);
//                call2.enqueue(new Callback<List<ChannelNameVideoList>>() {
//                    @Override
//                    public void onResponse(Call<List<ChannelNameVideoList>> call, Response<List<ChannelNameVideoList>> response) {
//
//                        video.clear();
//                        video.addAll(response.body());
//                        adapter.notifyDataSetChanged();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<ChannelNameVideoList>> call, Throwable t) {
//                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });


                LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
                reccyclerview.setLayoutManager(layoutManager2);
                adapter = new ChannelPopularAdapter(videolist, getContext());
                reccyclerview.setAdapter(adapter);


                SharedPreferences prefs1 = getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

                String name1 = prefs1.getString("tokenid", "No name defined");//"No name defined" is the default value.
                String user1 = prefs1.getString("userId", "no vale");
//                Toast.makeText(getContext(), user1, Toast.LENGTH_SHORT).show();

                String Url1 = "https://api.fluntoo.com/video/popularvideo/" + channelid;
                Log.d("urlll", Url1.toString());
                Log.d("token", name1);
                Retrofit retrofit2 = new Retrofit.Builder()
                        .baseUrl("https://www.api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                PopularCHannelInterface popularCHannelInterface = retrofit2.create(PopularCHannelInterface.class);
                Call<List<ChannelPopular>> call1 = popularCHannelInterface.getlist(Url1);
                call1.enqueue(new Callback<List<ChannelPopular>>() {
                    @Override
                    public void onResponse(Call<List<ChannelPopular>> call, Response<List<ChannelPopular>> response) {
                        videolist.clear();
                        videolist.addAll(response.body());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<ChannelPopular>> call, Throwable t) {


                    }
                });

            }

            @Override
            public void onFailure(Call<ChannelINfo> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

                String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
                String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();


                String Url = "https://api.fluntoo.com/video/" + user + "/subscribe/" + abc;
                Log.i("end", Url);
                Log.d("token", name);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                SubscribeInterface subscribeInterface = retrofit.create(SubscribeInterface.class);
                Call<PostItem> call1 = subscribeInterface.getsubcribe(Url, "Bearer " + name);
                call1.enqueue(new Callback<PostItem>() {
                    @Override
                    public void onResponse(Call<PostItem> call, Response<PostItem> response) {
                        Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<PostItem> call, Throwable t) {

                        Toast.makeText(getContext(), "subcribed", Toast.LENGTH_SHORT).show();
                        subbtn.setVisibility(View.GONE);
                        subsdbtn.setVisibility(View.VISIBLE);

                    }
                });
            }
        });

    }


}
