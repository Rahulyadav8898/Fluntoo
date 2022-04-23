package com.fluntoo.zenberry;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.fluntoo.zenberry.Adapter.FlixGenresAdapter;
import com.fluntoo.zenberry.ApIInterface.FlixGenresInterface;
import com.fluntoo.zenberry.Model.FlixGenresData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.android.volley.RequestQueue;
//import com.example.playflix.R;

public class FlixGenresActivity extends AppCompatActivity {
    RecyclerView rv;
    FlixGenresAdapter adapter;
    List<FlixGenresData> listdata = new ArrayList<>();
    //    private RequestQueue requestQueue;
    String endpoint;
    ShimmerFrameLayout shimmerFrameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flix_genres);
        rv = findViewById(R.id.recyclerview3);
        shimmerFrameLayout = findViewById(R.id.shimmer_genres);
        shimmerFrameLayout.startShimmerAnimation();


        rv.setHasFixedSize(true);
        int numberOfColumns = 3;
        rv.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
//        listdata = new ArrayList<>();

        adapter = new FlixGenresAdapter(this, listdata);
//
//
//

        rv.setAdapter(adapter);

        Intent intent = getIntent();
        endpoint = intent.getStringExtra("genresname");


//        Toast.makeText(getApplicationContext(), endpoint, Toast.LENGTH_SHORT).show();

//        requestQueue = Volley.newRequestQueue(this);
        load();


    }

    private void load() {
        String Url = "https://api.fluntoo.com/movie/Movie/getAll/" + endpoint;
        Log.i("end", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FlixGenresInterface latestInterface = retrofit.create(FlixGenresInterface.class);
        Call<List<FlixGenresData>> data = latestInterface.getUsers(Url);
        data.enqueue(new Callback<List<FlixGenresData>>() {
            @Override
            public void onResponse(Call<List<FlixGenresData>> call, Response<List<FlixGenresData>> response) {
                Log.d("TAG", "Response = " + response.body());
                listdata.clear();
                listdata.addAll(response.body());
                adapter.notifyDataSetChanged();
                shimmerFrameLayout.stopShimmerAnimation();
                shimmerFrameLayout.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onFailure(Call<List<FlixGenresData>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
//        call.enqueue(new Callback<List<Latest>>() {
//            @Override
//            public void onResponse(Call<List<Latest>> call, Response<List<Latest>> response) {
//                Log.d("TAG","Response = "+latestlist.toString());
//                latestlist.clear();
//                latestlist.addAll(response.body());
//                latestAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<List<Latest>> call, Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });

//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(i);
//
//                        FlixGenresData data = new FlixGenresData();
//                        data.setMovieLogo(jsonObject.getString("movieLogo"));
////
//
//                        listdata.add(data);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                adapter.notifyDataSetChanged();
//
//                adapter = new FlixGenresAdapter(getApplicationContext(),listdata);
//
//                rv.setAdapter(adapter);


//                rv.setAdapter(new FlixGenresAdapter(getApplicationContext(),listdata));


    }


}
