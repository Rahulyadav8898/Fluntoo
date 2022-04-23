package com.fluntoo.zenberry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.fluntoo.zenberry.Adapter.WebEpisodeAdapter;
import com.fluntoo.zenberry.Adapter.WebRecommendedAdapter;
import com.fluntoo.zenberry.ApIInterface.WebRecommendedInterface;
import com.fluntoo.zenberry.ApIInterface.WebWatchlaterInterface;
import com.fluntoo.zenberry.ApIInterface.WebseriesInterface;
import com.fluntoo.zenberry.Model.WebEpisodes;
import com.fluntoo.zenberry.Model.WebRecommended;
import com.fluntoo.zenberry.Model.WebSeasons;
import com.fluntoo.zenberry.Model.WebTrending;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.playflix.R;

public class WebseriesActivity extends AppCompatActivity {
    private boolean isShowingTrackSelectionDialog;
    private DefaultTrackSelector trackSelector;
    String[] speed = {"0.25x", "0.5x", "Normal", "1.5x", "2x"};
    PlayerView playerView;
    SimpleExoPlayer simpleExoPlayer;
    public static final String TAG = "TAG";
    Spinner spinner;
    String imc_met;
    String abc;
    boolean fullscreen = false;
    ImageView img, img1;
    TextView titletxt, genrestxt, restxt, datetxt, desctxt, casttxt;
    String titlestr, imgstr, genresstr, restr, datestr, descstr, caststr, webidstr, videopath;
    String abcde = "";
    Button watchlater, sharebutton;
    String Url;


    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private String seasonlist[] = {"season1", "s2"};
    List<WebSeasons> webSeasonslist = new ArrayList<>();

    String web;

    RecyclerView edprecyclerview;
    List<WebEpisodes> epdlist = new ArrayList<>();
    WebEpisodeAdapter epdadapter;

    RecyclerView recyclerView;
    List<WebRecommended> webRecommendedList = new ArrayList<>();
    WebRecommendedAdapter adapter;

    private Timer timer;
    private int current_position = 0;
    ShimmerFrameLayout shimmerepd, shimmerrec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webseries);
        edprecyclerview = findViewById(R.id.web_episodes_recyclerview);
        recyclerView = findViewById(R.id.recyclerview_recommended_web);
//        shimmerepd = findViewById(R.id.shimmer_web_epd);
//        shimmerrec = findViewById(R.id.shimmer_web_rec);
        watchlater = findViewById(R.id.web_watchlist_btn);

        spinner = findViewById(R.id.spinner);
        titletxt = findViewById(R.id.titleweb);
        genrestxt = findViewById(R.id.genresweb);
        img = findViewById(R.id.imgweb);
        img1 = findViewById(R.id.img1);
        restxt = findViewById(R.id.restrictionweb);
        datetxt = findViewById(R.id.dateweb);
//        desctxt = findViewById(R.id.descweb);
        casttxt = findViewById(R.id.castweb);
        sharebutton = findViewById(R.id.web_share_btn);


//        shimmerepd.startShimmerAnimation();
//        shimmerrec.startShimmerAnimation();


//
//        Spinner spinner=findViewById(R.id.spinner);
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),
//                android.R.layout.simple_spinner_dropdown_item,seasonlist);
//        spinner.setAdapter(adapter);


        Intent intent = getIntent();
        titlestr = intent.getStringExtra("title");
        genresstr = intent.getStringExtra("genres");
        imgstr = intent.getStringExtra("image");
        restr = intent.getStringExtra("res");
        descstr = intent.getStringExtra("desc");
        caststr = intent.getStringExtra("cast");
        webidstr = intent.getStringExtra("id");
        videopath = intent.getStringExtra("videopath");
        datestr = intent.getStringExtra("date");

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
        myEdit.putString("name", webidstr.toString());


// Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
        myEdit.commit();


        titletxt.setText(titlestr);
        genrestxt.setText(genresstr);
        Glide.with(getApplicationContext())
                .load(imgstr)
                .into(img);
        Glide.with(getApplicationContext())
                .load(imgstr)
                .into(img1);
        restxt.setText(restr);
        datetxt.setText(datestr);
//        desctxt.setText(descstr);
        casttxt.setText(caststr);

        Url = "https://fluntoo.com/WebSeriesStream/" + webidstr;
        Log.d("url", Url);

        LinearLayoutManager linearLayoutManagerTre = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        edprecyclerview.setLayoutManager(linearLayoutManagerTre);
        epdadapter = new WebEpisodeAdapter(getApplicationContext(), epdlist);
        edprecyclerview.setAdapter(epdadapter);
        epd();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new WebRecommendedAdapter(getApplicationContext(), webRecommendedList);
        recyclerView.setAdapter(adapter);
//        getrecommended();


        getseason();

        watchlater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Addtowatchlater();
            }
        });

        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                // Add data to the intent, the receiving app will decide
                // what to do with it.
                share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                share.putExtra(Intent.EXTRA_TEXT, Url);

                startActivity(Intent.createChooser(share, "Share link!"));

            }
        });


    }

    private void Addtowatchlater() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");

//        String Url = " https://www.api.playflixx.com/" + user + "/WebSerieswatchlater/" + webidstr;
        String Url = " https://api.fluntoo.com/webseries/" + user + "/WebSerieswatchlater/" + webidstr;
        Log.d("urlcheck", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebWatchlaterInterface webWatchlaterInterface = retrofit.create(WebWatchlaterInterface.class);
        Call<WebTrending> call = webWatchlaterInterface.postwatchlater(Url);
        call.enqueue(new Callback<WebTrending>() {
            @Override
            public void onResponse(Call<WebTrending> call, Response<WebTrending> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT);
            }

            @Override
            public void onFailure(Call<WebTrending> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT);

            }
        });
    }


    private void getrecommended() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();


        String Url = " https://api.fluntoo.com/movie/rightsiderecommended/" + user + "/" + webidstr;
        Log.d("urlcheck", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebRecommendedInterface webRecommendedInterface = retrofit.create(WebRecommendedInterface.class);
        Call<List<WebRecommended>> call = webRecommendedInterface.getwebrec(Url);
        call.enqueue(new Callback<List<WebRecommended>>() {
            @Override
            public void onResponse(Call<List<WebRecommended>> call, Response<List<WebRecommended>> response) {
                webRecommendedList.clear();
                webRecommendedList.addAll(response.body());
                adapter.notifyDataSetChanged();
//                shimmerrec.stopShimmerAnimation();
//                shimmerrec.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<WebRecommended>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getseason() {


        String Url = "https://api.fluntoo.com/webseries/WebSeries/GetSeason/" + webidstr;
        Log.d("url", Url);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebseriesInterface webseriesInterface = retrofit.create(WebseriesInterface.class);
        Call<List<WebSeasons>> call = webseriesInterface.getseason(Url);
        call.enqueue(new Callback<List<WebSeasons>>() {
            @Override
            public void onResponse(Call<List<WebSeasons>> call, Response<List<WebSeasons>> response) {

                if (response.isSuccessful()) {
                    ArrayList<String> nameList = new ArrayList<>();
//                 getresponse=response.body().toString();
                    for (int i = 0; i < response.body().size(); i++) {


//                    WebSeasons seasons = new WebSeasons();
//                    String name= seasons.getSeasonName();
                        nameList.add(response.body().get(i).getSeasonName());
                        String imc_met = response.body().get(0).getSeasonName();
//                    Log.d("name", name);
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, nameList);
                    spinner.setAdapter(adapter);


                } else {
                    Toast.makeText(getApplicationContext(), "season empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WebSeasons>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    void epd() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String end = spinner.getSelectedItem().toString();
                Log.d("hm", end);
//                Toast.makeText(getApplicationContext(), end, Toast.LENGTH_SHORT).show();
                String Url = "https://api.fluntoo.com/webseries/WebSeries/GetEpisode/" + end;
                Log.d("check", Url);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                WebseriesInterface webseriesInterface = retrofit.create(WebseriesInterface.class);
                Call<List<WebEpisodes>> call = webseriesInterface.getepds(Url);
                call.enqueue(new Callback<List<WebEpisodes>>() {
                    @Override
                    public void onResponse(Call<List<WebEpisodes>> call, Response<List<WebEpisodes>> response) {
                        if (response.isSuccessful()) {
                            epdlist.clear();
                            epdlist.addAll(response.body());
                            epdadapter.notifyDataSetChanged();
//                            shimmerepd.stopShimmerAnimation();
//                            shimmerepd.setVisibility(View.GONE);

                        } else {
                            Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<List<WebEpisodes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                String end = spinner.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), end, Toast.LENGTH_LONG).show();
                Log.d("hm", end);

                String Url = "https://api.fluntoo.com/webseries/WebSeries/GetEpisode/" + end;
                Log.d("check", Url);


//

            }


        });


//        String Url = "https://www.api.playflixx.com/WebSeries/GetEpisode/Demo webseries";

//
//        String Url = "https://www.api.playflixx.com/WebSeries/GetEpisode/" +end;
//        Log.d("check", Url);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        WebseriesInterface webseriesInterface = retrofit.create(WebseriesInterface.class);
//        Call<List<WebEpisodes>> call = webseriesInterface.getepds(Url);
//        call.enqueue(new Callback<List<WebEpisodes>>() {
//            @Override
//            public void onResponse(Call<List<WebEpisodes>> call, Response<List<WebEpisodes>> response) {
//                if (response.isSuccessful()) {
//                    epdlist.clear();
//                    epdlist.addAll(response.body());
//                    epdadapter.notifyDataSetChanged();
//
//                } else {
//                    Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<WebEpisodes>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }


    protected void releasePlayer() {
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            simpleExoPlayer = null;
            trackSelector = null;
        }

    }


    @Override
    public void onStop() {
        super.onStop();

        releasePlayer();
    }


}