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

import com.fluntoo.zenberry.Adapter.WebWatchlistAdapter;
import com.fluntoo.zenberry.ApIInterface.WebWatchlaterInterface;
import com.fluntoo.zenberry.Model.WebTrending;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Webwatchlist_Frag extends Fragment {
    RecyclerView recyclerView;
    WebWatchlistAdapter adapter;
    List<WebTrending> watchlist = new ArrayList<>();
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.webwatchlist_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_web_watchlist);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new WebWatchlistAdapter(watchlist, getContext());
        recyclerView.setAdapter(adapter);
        data();

    }

    private void data() {
        SharedPreferences prefs = getContext().getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/webseries/" + user + "/getWebSerieswatchlater";
        Log.i("url", Url);
        Log.d("token", name);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebWatchlaterInterface webWatchlaterInterface = retrofit.create(WebWatchlaterInterface.class);
        Call<List<WebTrending>> call = webWatchlaterInterface.getwatchlist(Url);
        call.enqueue(new Callback<List<WebTrending>>() {
            @Override
            public void onResponse(Call<List<WebTrending>> call, Response<List<WebTrending>> response) {
                if (response.isSuccessful()) {
                    watchlist.clear();
                    watchlist.addAll(response.body());
                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<List<WebTrending>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
