package com.fluntoo.zenberry.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.fluntoo.zenberry.Adapter.ChannelNAmePlaylistAdapter;
import com.fluntoo.zenberry.ApIInterface.ChannelNamePlaylistInterface;
import com.fluntoo.zenberry.ApIInterface.ChannelINfoInterface;
import com.fluntoo.zenberry.Model.ChannelINfo;
import com.fluntoo.zenberry.Model.ChannelPlaylist;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Playlist_Channel_Frag extends Fragment {
    String channelid;
    String abc;
    String chanid;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    RecyclerView recyclerView;
    List<ChannelPlaylist> playlist = new ArrayList<>();
    ChannelNAmePlaylistAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.playlist_channel_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview_playlistchannel);
        getdata();

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swipechannelplaylist);
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
//                String channelname1 = response.body().getChannelName().toString();
//                String sub1 = response.body().getSubscribers().toString();
//                String cuser = response.body().getChannelUserId().toString();
//
//                abc = response.body().getChannelId().toString();
//
//                chanid = response.body().getChannelId().toString();
//
//                LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
//                recyclerView.setLayoutManager(layoutManager2);
//                adapter = new ChannelNAmePlaylistAdapter(playlist, getContext());
//                recyclerView.setAdapter(adapter);
//
//                SharedPreferences prefs1 = getActivity().getSharedPreferences(MY_PREFS_NAME, 0);
//
//                String name1 = prefs1.getString("tokenid", "No name defined");//"No name defined" is the default value.
//                String user1 = prefs1.getString("userId", "no vale");
////                Toast.makeText(getContext(), user1, Toast.LENGTH_SHORT).show();
//
//                String Url1 = "https://www.api.playflixx.com/" + channelname1 + "/playlist";
//                Log.d("url", Url1.toString());
//                Log.d("token", name1);
//                Retrofit retrofit2 = new Retrofit.Builder()
//                        .baseUrl("https://www.api.playflixx.com/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//                ChannelNamePlaylistInterface channelNamePlaylistInterface = retrofit2.create(ChannelNamePlaylistInterface.class);
//                Call<List<ChannelPlaylist>> call1 = channelNamePlaylistInterface.getplaylist(Url1);
//                call1.enqueue(new Callback<List<ChannelPlaylist>>() {
//                    @Override
//                    public void onResponse(Call<List<ChannelPlaylist>> call, Response<List<ChannelPlaylist>> response) {
//
//                        playlist.clear();
//                        playlist.addAll(response.body());
//                        adapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<ChannelPlaylist>> call, Throwable t) {
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
    }

    private void getdata() {
        Intent intent = getActivity().getIntent();
        channelid = intent.getStringExtra("channeldyanmicid");

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
                String channelname1 = response.body().getChannelName().toString();
                String sub1 = response.body().getSubscribers().toString();
                String cuser = response.body().getChannelUserId().toString();

                abc = response.body().getChannelId().toString();

                chanid = response.body().getChannelId().toString();

                LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager2);
                adapter = new ChannelNAmePlaylistAdapter(playlist, getContext());
                recyclerView.setAdapter(adapter);

                SharedPreferences prefs1 = getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

                String name1 = prefs1.getString("tokenid", "No name defined");//"No name defined" is the default value.
                String user1 = prefs1.getString("userId", "no vale");
//                Toast.makeText(getContext(), user1, Toast.LENGTH_SHORT).show();

                String Url1 = "https://api.fluntoo.com/playlist/" + channelname1 + "/playlist";
                Log.d("url8", Url1.toString());
                Log.d("token", name1);
                Retrofit retrofit2 = new Retrofit.Builder()
                        .baseUrl("https://www.api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ChannelNamePlaylistInterface channelNamePlaylistInterface = retrofit2.create(ChannelNamePlaylistInterface.class);
                Call<List<ChannelPlaylist>> call1 = channelNamePlaylistInterface.getplaylist(Url1);
                call1.enqueue(new Callback<List<ChannelPlaylist>>() {
                    @Override
                    public void onResponse(Call<List<ChannelPlaylist>> call, Response<List<ChannelPlaylist>> response) {

                        playlist.clear();
                        playlist.addAll(response.body());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<ChannelPlaylist>> call, Throwable t) {

                    }
                });

            }

            @Override
            public void onFailure(Call<ChannelINfo> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
