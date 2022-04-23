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

import com.fluntoo.zenberry.Adapter.VideolistAdapter;
import com.fluntoo.zenberry.ApIInterface.VideolistInterface;
import com.fluntoo.zenberry.Model.Videolist;
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

public class Videos_Fragment extends Fragment {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    public static final String MY_PREFS_NAME1 = "MyPrefsFile1";
    RecyclerView recyclerView;
    List<Videolist> videolist = new ArrayList<>();
    VideolistAdapter adapter;


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.videos_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_videolist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new VideolistAdapter(videolist, getContext());
        recyclerView.setAdapter(adapter);
        data();


    }


    private void data() {
        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

        String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no value");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();
        Log.d("token", token);
        String abc = user;
        Log.d("abc", abc);

//        SharedPreferences.Editor editor = getContext().getSharedPreferences(MY_PREFS_NAME1, 0).edit();
//        editor.putString("userId1", abc);
//        editor.apply();
//


        String Url = "https://api.fluntoo.com/video/" + user + "/getallvideolist";
        Log.i("end", Url);
        String auth = "Bearer " + token;
        Log.d("auth", auth);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VideolistInterface videolistInterface = retrofit.create(VideolistInterface.class);
        Call<List<Videolist>> call = videolistInterface.getVideoslist("Bearer " + token, Url);
        Log.d("check", call.toString());
        call.enqueue(new Callback<List<Videolist>>() {
            @Override
            public void onResponse(Call<List<Videolist>> call, Response<List<Videolist>> response) {

                if (response.isSuccessful()) {
                    videolist.clear();
                    videolist.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Videolist is Empty", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), response.toString(), Toast.LENGTH_LONG).show();
                }
//            Toast.makeText(getContext(),"failed videolist",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Videolist>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}



