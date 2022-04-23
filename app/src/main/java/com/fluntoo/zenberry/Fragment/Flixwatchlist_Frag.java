package com.fluntoo.zenberry.Fragment;

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

import com.fluntoo.zenberry.Adapter.FlixWatchlistAdapter;
import com.fluntoo.zenberry.ApIInterface.FlixwatchlaterInterface;
import com.fluntoo.zenberry.Model.FlixTrending;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Flixwatchlist_Frag extends Fragment {
    RecyclerView recyclerView1;
    FlixWatchlistAdapter adapter1;
    List<FlixTrending> watchlist = new ArrayList<FlixTrending>();
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.flixwatchlist_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView1 = view.findViewById(R.id.recyclerview_flix_watchlist);
//
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(layoutManager);
        adapter1 = new FlixWatchlistAdapter(watchlist, getContext());
        recyclerView1.setAdapter(adapter1);
        data();
    }

    private void data() {
        SharedPreferences prefs = getContext().getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/movie/" + user + "/getmoviewatchlater";
        Log.i("urll", Url);
        Log.d("token", name);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FlixwatchlaterInterface flixwatchlaterInterface = retrofit.create(FlixwatchlaterInterface.class);
        Call<List<FlixTrending>> call = flixwatchlaterInterface.getwatchlist(Url);
        call.enqueue(new Callback<List<FlixTrending>>() {
            @Override
            public void onResponse(Call<List<FlixTrending>> call, Response<List<FlixTrending>> response) {
                if (response.isSuccessful()) {
                    watchlist.clear();
                    watchlist.addAll(response.body());
                    adapter1.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<FlixTrending>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT);

            }
        });

    }
}
