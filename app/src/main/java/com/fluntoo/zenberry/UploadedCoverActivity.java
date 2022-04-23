package com.fluntoo.zenberry;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.Adapter.UploadedCoverAdapter;
import com.fluntoo.zenberry.ApIInterface.UploadedInterface;
import com.fluntoo.zenberry.Model.UploadedCover;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadedCoverActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UploadedCoverAdapter adapter;
    List<UploadedCover> uploadlist = new ArrayList<>();

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    String image;
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploaded_cover);

        recyclerView = findViewById(R.id.uploadedcover_recyclerview);

        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UploadedCoverAdapter(uploadlist, getApplicationContext());
        recyclerView.setAdapter(adapter);

        listdata();


    }

    private void listdata() {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");

        String Url = "https://api.fluntoo.com/aboutme/getGallery/" + user;
        Log.i("end", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UploadedInterface uploadedInterface = retrofit.create(UploadedInterface.class);
        Call<List<UploadedCover>> call = uploadedInterface.getCover(Url);
        call.enqueue(new Callback<List<UploadedCover>>() {
            @Override
            public void onResponse(Call<List<UploadedCover>> call, Response<List<UploadedCover>> response) {

                uploadlist.clear();
                uploadlist.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<UploadedCover>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}