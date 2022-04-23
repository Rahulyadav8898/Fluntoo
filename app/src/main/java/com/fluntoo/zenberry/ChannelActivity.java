package com.fluntoo.zenberry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fluntoo.zenberry.Adapter.ChannellistAdapter;
import com.fluntoo.zenberry.ApIInterface.ChannellistInterface;
import com.fluntoo.zenberry.Model.Channellist;
//import com.example.playflix.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChannelActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ChannellistAdapter adapter;
    List<Channellist> channellists=new ArrayList<>();

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        recyclerView=findViewById(R.id.recyclerview_channelist);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChannellistAdapter(channellists, getApplicationContext());
        recyclerView.setAdapter(adapter);
        data();



    }

    private void data() {

        SharedPreferences prefs =getSharedPreferences(MY_PREFS_NAME,0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user=prefs.getString("userId","no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://www.api.playflixx.com/listchannel/"+user;
        Log.i("end",Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChannellistInterface channellistInterface=retrofit.create(ChannellistInterface.class);
        Call<List<Channellist>> call=channellistInterface.getchannelist(Url);
        call.enqueue(new Callback<List<Channellist>>() {
            @Override
            public void onResponse(Call<List<Channellist>> call, Response<List<Channellist>> response) {
                channellists.clear();
                channellists.addAll(response.body());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Channellist>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}