package com.fluntoo.zenberry.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.Adapter.LatestMusicAdapter;
import com.fluntoo.zenberry.Adapter.Music_Fav_Adapter;
import com.fluntoo.zenberry.Adapter.TrendingMusicAdapter;
import com.fluntoo.zenberry.Model.LatestMusic;
import com.fluntoo.zenberry.Model.Music;
import com.fluntoo.zenberry.Model.TrendingMusic;
import com.fluntoo.zenberry.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Music_Frag extends Fragment {

    RecyclerView recyclerView;
    List<Music> musicItems = new ArrayList<>();
    private Music_Fav_Adapter adapter;
    LinearLayoutManager layoutManager;

    RecyclerView recyclerViewlatest;
    List<LatestMusic> latestMusicList = new ArrayList<>();
    private LatestMusicAdapter latestadapter;
    LinearLayoutManager latestlayoutManager;


    RecyclerView recyclerViewtrending;
    List<TrendingMusic> TrendingMusicList = new ArrayList<>();
    private TrendingMusicAdapter Trendingadapter;
    LinearLayoutManager TrendinglayoutManager;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    CardView cardViewmain,cardViewarrow,cardViewarrow2;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

//        return inflater.inflate(R.layout.music_fragment, container, false);
        return inflater.inflate(R.layout.comingsoon, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//
//        recyclerView = view.findViewById(R.id.music_fav_recyclerview);
//        recyclerViewlatest = view.findViewById(R.id.music_latest_recyclerview);
//        recyclerViewtrending = view.findViewById(R.id.music_trending_recyclerview);
//        cardViewmain=view.findViewById(R.id.cardviewmusic);
//        cardViewarrow=view.findViewById(R.id.arrow_music);
//        cardViewarrow2=view.findViewById(R.id.arrow_music2);
//
//        cardViewarrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardViewarrow.setVisibility(View.INVISIBLE);
//                cardViewmain.setVisibility(View.INVISIBLE);
//                cardViewarrow2.setVisibility(View.VISIBLE);
//            }
//        });
//
//        cardViewarrow2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardViewarrow.setVisibility(View.VISIBLE);
//                cardViewmain.setVisibility(View.VISIBLE);
//                cardViewarrow2.setVisibility(View.INVISIBLE);
//
//            }
//        });
//
//        latestlayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewlatest.setLayoutManager(latestlayoutManager);
//        latestadapter = new LatestMusicAdapter(latestMusicList, getContext());
//        recyclerViewlatest.setAdapter(latestadapter);
//        latestmusic();
//
//        TrendinglayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewtrending.setLayoutManager(TrendinglayoutManager);
//        Trendingadapter = new TrendingMusicAdapter(getContext(), TrendingMusicList);
//        recyclerViewtrending.setAdapter(Trendingadapter);
//        Trendingmusic();
//
//
//        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new Music_Fav_Adapter(musicItems, getContext());
//        recyclerView.setAdapter(adapter);
//        favmusic();
//
//
//    }
//
//    private void Trendingmusic() {
//
//        String url1 = "https://api.fluntoo.com/studio/play/Trending";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        MusicINterface musicINterface = retrofit.create(MusicINterface.class);
//        Call<List<TrendingMusic>> call = musicINterface.gettrendingmusic(url1);
//        call.enqueue(new Callback<List<TrendingMusic>>() {
//            @Override
//            public void onResponse(Call<List<TrendingMusic>> call, Response<List<TrendingMusic>> response) {
//                TrendingMusicList.clear();
//                TrendingMusicList.addAll(response.body());
//                Trendingadapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onFailure(Call<List<TrendingMusic>> call, Throwable t) {
//                Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void latestmusic() {
//
//        String url1 = "https://www.api.playflixx.com/latestmusic";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        MusicINterface musicINterface = retrofit.create(MusicINterface.class);
//        Call<List<LatestMusic>> call = musicINterface.getlatestmusic(url1);
//        call.enqueue(new Callback<List<LatestMusic>>() {
//            @Override
//            public void onResponse(Call<List<LatestMusic>> call, Response<List<LatestMusic>> response) {
//
//                latestMusicList.clear();
//                latestMusicList.addAll(response.body());
//                latestadapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<List<LatestMusic>> call, Throwable t) {
//                Toast.makeText(getContext(), "FAil", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//
//    private void favmusic() {
//
//
//        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);
//
//        String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no value");
//
//        String url = "https://www.api.playflixx.com/getmusic/" + user;
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        MusicINterface musicINterface = retrofit.create(MusicINterface.class);
//        Call<List<Music>> call = musicINterface.getmusic(url);
//        call.enqueue(new Callback<List<Music>>() {
//            @Override
//            public void onResponse(Call<List<Music>> call, Response<List<Music>> response) {
//                musicItems.clear();
//                musicItems.addAll(response.body());
//                adapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Music>> call, Throwable t) {
//                Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
//            }
//        });
//
    }
}