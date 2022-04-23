package com.fluntoo.zenberry;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.Adapter.UploadedProfileAdapter;
import com.fluntoo.zenberry.ApIInterface.UploadedInterface;
import com.fluntoo.zenberry.Model.UploadedProfile;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadedProfileActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UploadedProfileAdapter adapter;
    List<UploadedProfile> uploadlist = new ArrayList<>();

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploaded_profile);
        recyclerView = findViewById(R.id.recyclerview_profileuploaded);

        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UploadedProfileAdapter(uploadlist, getApplicationContext());
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
        Call<List<UploadedProfile>> call = uploadedInterface.getpro(Url);
        call.enqueue(new Callback<List<UploadedProfile>>() {
            @Override
            public void onResponse(Call<List<UploadedProfile>> call, Response<List<UploadedProfile>> response) {
                uploadlist.clear();
                uploadlist.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<UploadedProfile>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}