package com.fluntoo.zenberry.Fragment;

import android.content.Intent;
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

import com.fluntoo.zenberry.Adapter.PlaylisAdapter;
import com.fluntoo.zenberry.ApIInterface.PlaylistInterface;
import com.fluntoo.zenberry.CreatePlaylistActivity;
import com.fluntoo.zenberry.Model.Playlist;
import com.fluntoo.zenberry.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.playflix.R;

public class Playlist_Fragment extends Fragment {

    RecyclerView recyclerView;
    PlaylisAdapter adapter;
    List<Playlist> playlist = new ArrayList<>();
    Button createbtn;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.playlist_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_playlist);
        createbtn = view.findViewById(R.id.createplaylist_btn);


        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CreatePlaylistActivity.class));
            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlaylisAdapter(playlist, getContext());
        recyclerView.setAdapter(adapter);
        data();


    }

    private void data() {

        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/playlist/playlist/" + user;
        Log.i("end", Url);
        Log.d("token", name);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PlaylistInterface playlistInterface = retrofit.create(PlaylistInterface.class);
        Call<List<Playlist>> call = playlistInterface.getplaylist(Url, "Bearer " + name);
        call.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                if (response.isSuccessful()) {
                    playlist.clear();
                    playlist.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Playlist Empty", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
