package com.fluntoo.zenberry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.fluntoo.zenberry.Adapter.MyAdapter;
import com.fluntoo.zenberry.Adapter.Myadapterwatchlist;
import com.fluntoo.zenberry.Adapter.PlaylisAdapter;
import com.fluntoo.zenberry.Adapter.WatchLIstAdapter;
import com.fluntoo.zenberry.ApIInterface.PlaylistInterface;
import com.fluntoo.zenberry.ApIInterface.WatchLAterINterface;
import com.fluntoo.zenberry.Model.Playlist;
import com.fluntoo.zenberry.Model.Playwatchlater;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WatchListActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;


    RecyclerView recyclerView;
    WatchLIstAdapter adapter;
    List<Playwatchlater> watchlist = new ArrayList<>();
    Button createbtn;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_list);
//        recyclerView = findViewById(R.id.watchlist_play_recyclerview);
////
////        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
////        recyclerView.setLayoutManager(layoutManager);
////        adapter = new WatchLIstAdapter(watchlist, getApplicationContext());
////        recyclerView.setAdapter(adapter);
////        data();
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutw);
        viewPager = (ViewPager) findViewById(R.id.viewPagerw);

        tabLayout.addTab(tabLayout.newTab().setText("Videos"));
        tabLayout.addTab(tabLayout.newTab().setText("Movies"));
        tabLayout.addTab(tabLayout.newTab().setText("WebSeries"));
//        tabLayout.addTab(tabLayout.newTab().setText("Channel"));
//        tabLayout.addTab(tabLayout.newTab().setText("Clouds"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final Myadapterwatchlist adapter = new Myadapterwatchlist(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

//    private void data() {
//
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
//
//        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no vale");
////        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();
//
//        String Url = "https://www.api.playflixx.com/" + user + "/getwatchlater";
//        Log.i("end", Url);
//        Log.d("token", name);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        WatchLAterINterface watchLAterINterface = retrofit.create(WatchLAterINterface.class);
//        Call<List<Playwatchlater>> call = watchLAterINterface.getwatchlist(Url);
//        call.enqueue(new Callback<List<Playwatchlater>>() {
//            @Override
//            public void onResponse(Call<List<Playwatchlater>> call, Response<List<Playwatchlater>> response) {
//                if (response.isSuccessful()) {
//                    watchlist.clear();
//                    watchlist.addAll(response.body());
//                    adapter.notifyDataSetChanged();
//                } else {
//                    Toast.makeText(getApplicationContext(), "watchlist Empty", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Playwatchlater>> call, Throwable t) {
//
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
}