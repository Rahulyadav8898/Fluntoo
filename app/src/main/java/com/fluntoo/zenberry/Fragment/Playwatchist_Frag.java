package com.fluntoo.zenberry.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.Adapter.WatchLIstAdapter;
import com.fluntoo.zenberry.ApIInterface.WatchLAterINterface;
import com.fluntoo.zenberry.Model.Playwatchlater;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Playwatchist_Frag extends Fragment {

    RecyclerView recyclerView;
    WatchLIstAdapter adapter;
    List<Playwatchlater> watchlist = new ArrayList<>();
    Button createbtn;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.playwatchlist_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.watchlist_play_recyclerview);
//
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new WatchLIstAdapter(watchlist, getContext());
        recyclerView.setAdapter(adapter);
        data();
    }

    private void data() {

        SharedPreferences prefs = getContext().getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/video/" + user + "/getwatchlater";
        Log.i("end", Url);
        Log.d("token", name);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WatchLAterINterface watchLAterINterface = retrofit.create(WatchLAterINterface.class);
        Call<List<Playwatchlater>> call = watchLAterINterface.getwatchlist(Url);
        call.enqueue(new Callback<List<Playwatchlater>>() {
            @Override
            public void onResponse(Call<List<Playwatchlater>> call, Response<List<Playwatchlater>> response) {
                if (response.isSuccessful()) {
                    watchlist.clear();
                    watchlist.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<Playwatchlater>> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
