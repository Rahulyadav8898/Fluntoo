package com.fluntoo.zenberry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Adapter.MyAdapter1;
import com.fluntoo.zenberry.ApIInterface.WebseriesInterface;
import com.fluntoo.zenberry.Model.WebSeasons;
//import com.example.playflix.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebseriesInfoActivity extends AppCompatActivity {
    Button downloadbtn;
    TextView title, cast, desc, ageres,genrestxt;
    ImageView img;
    TabLayout tabLayout1;
    ViewPager viewPager1;
    String titlestr, imgstr, genresstr, restr, datestr, descstr, caststr, webidstr, videopath;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webseries_info);


        tabLayout1 = (TabLayout) findViewById(R.id.tabLayout1);
        viewPager1 = (ViewPager) findViewById(R.id.viewPager1);

        spinner = findViewById(R.id.spinner);

        getseason();

        tabLayout1.addTab(tabLayout1.newTab().setText("Episodes"));
        tabLayout1.addTab(tabLayout1.newTab().setText("More Like This"));

        final MyAdapter1 adapter1 = new MyAdapter1(this, getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(adapter1);

        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        downloadbtn = findViewById(R.id.download_btn_info);
        title = findViewById(R.id.title_info);
        cast = findViewById(R.id.cast_tv_info);
        desc = findViewById(R.id.desc_tv_info);
        ageres = findViewById(R.id.agerest_tv_info);
        img = findViewById(R.id.imginfo);
        genrestxt=findViewById(R.id.genres_tv_info);


        Intent intent = getIntent();
        titlestr = intent.getStringExtra("title");
        genresstr = intent.getStringExtra("genres");
        imgstr = intent.getStringExtra("image");
        restr = intent.getStringExtra("res");
        descstr = intent.getStringExtra("desc");
        caststr = intent.getStringExtra("cast");
        webidstr = intent.getStringExtra("id");
        videopath = intent.getStringExtra("videopath");

        title.setText(titlestr);
        genrestxt.setText(genresstr);
        Glide.with(getApplicationContext())
                .load(imgstr)
                .into(img);
        ageres.setText(restr);
//        datetxt.setText(datestr);
        desc.setText(descstr);
        cast.setText(caststr);

    }

    private void getseason() {
        Intent intent=getIntent();
       webidstr= intent.getStringExtra("id");

        String Url = "https://www.api.playflixx.com/WebSeries/GetSeason/" + webidstr;
        Log.d("url",Url);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebseriesInterface webseriesInterface = retrofit.create(WebseriesInterface.class);
        Call<List<WebSeasons>> call = webseriesInterface.getseason(Url);
        call.enqueue(new Callback<List<WebSeasons>>()

        {
            @Override
            public void onResponse
                    (Call < List < WebSeasons >> call, Response< List < WebSeasons >> response){

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


            }

            @Override
            public void onFailure (Call < List < WebSeasons >> call, Throwable t){

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}