package com.fluntoo.zenberry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.fluntoo.zenberry.Adapter.GenresAdapter;
import com.fluntoo.zenberry.ApIInterface.GenresInferface;
import com.fluntoo.zenberry.Model.Genres;
//import com.example.playflix.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GenresActivity extends AppCompatActivity {
    List<Genres> genresList = new ArrayList<>();
    RecyclerView recyclerView;
    GenresAdapter adapter;
    ShimmerFrameLayout shimmer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);
        recyclerView = findViewById(R.id.recyclerView_genres);
        shimmer = findViewById(R.id.shimmer_genres2);
        shimmer.startShimmerAnimation();

        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new GenresAdapter(genresList, getApplicationContext());
        recyclerView.setAdapter(adapter);
        data();
    }

    void data() {

        String Url = "https://www.api.playflixx.com/Movie/getAllGenres";
        Log.d("url", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/Movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GenresInferface inferface = retrofit.create(GenresInferface.class);
        Call<List<Genres>> call = inferface.getgenres(Url);
        call.enqueue(new Callback<List<Genres>>() {
            @Override
            public void onResponse(Call<List<Genres>> call, Response<List<Genres>> response) {
                genresList.clear();
                genresList.addAll(response.body());
                Log.d("response", genresList.toString());
                adapter.notifyDataSetChanged();
                shimmer.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Genres>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}