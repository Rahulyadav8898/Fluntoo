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

import com.fluntoo.zenberry.Adapter.ChannellistAdapter;
import com.fluntoo.zenberry.ApIInterface.ChannellistInterface;
import com.fluntoo.zenberry.CreateChannelActivity;
import com.fluntoo.zenberry.Model.Channellist;
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

public class Channels_Fragment extends Fragment {
    Button createbtn;

    RecyclerView recyclerView;
    ChannellistAdapter adapter;
    List<Channellist> channellists = new ArrayList<>();

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.channels_fragment, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_channelist);
        createbtn = view.findViewById(R.id.createchannel_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChannellistAdapter(channellists, getContext());
        recyclerView.setAdapter(adapter);
        data();



        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CreateChannelActivity.class));
            }
        });
//


    }

    private void data() {
        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/channel/listchannel/" + user;
        Log.i("end", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChannellistInterface channellistInterface = retrofit.create(ChannellistInterface.class);
        Call<List<Channellist>> call = channellistInterface.getchannelist(Url);
        call.enqueue(new Callback<List<Channellist>>() {
            @Override
            public void onResponse(Call<List<Channellist>> call, Response<List<Channellist>> response) {
                channellists.clear();
                channellists.addAll(response.body());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Channellist>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("error",t.getMessage());
            }
        });

    }
}
