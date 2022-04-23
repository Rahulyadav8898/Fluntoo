package com.fluntoo.zenberry.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.fluntoo.zenberry.Adapter.FlixGenresTitleAdapter;
import com.fluntoo.zenberry.Adapter.FlixLatestAdapter;
import com.fluntoo.zenberry.Adapter.FlixSliderAdapter;
import com.fluntoo.zenberry.Adapter.FlixTrendingAdapter;
import com.fluntoo.zenberry.ApIInterface.FlixGenresInterface;
import com.fluntoo.zenberry.ApIInterface.FlixLatestInterface;
import com.fluntoo.zenberry.ApIInterface.FlixSliderInterface;
import com.fluntoo.zenberry.ApIInterface.FlixTrendingInterface;
import com.fluntoo.zenberry.Model.FlixGenres;
import com.fluntoo.zenberry.Model.FlixLatest;
import com.fluntoo.zenberry.Model.FlixSlider;
import com.fluntoo.zenberry.Model.FlixTRendings;
import com.fluntoo.zenberry.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.playflix.R;


public class Flix_Fragment extends Fragment {

    FlixGenresTitleAdapter recyclerAdapter;
    RecyclerView flixrecylerview;
    List<FlixGenres> flixitem = new ArrayList<>();


    FlixTrendingAdapter trendingAdapter;
    RecyclerView trendingrecylerview;
    List<FlixTRendings> trendinglist = new ArrayList<>();

    FlixLatestAdapter latestAdapter;
    RecyclerView latestrecyclerview;
    List<FlixLatest> latestList = new ArrayList<>();

    RecyclerView recyclerView;
    FlixSliderAdapter adapter;
    List<FlixSlider> sliderlist = new ArrayList<>();

    private Timer timer;
    private int current_position = 0;

    ProgressBar progressBartrending, progressBarlatest;
    ShimmerFrameLayout slidershimmer, shrimmertrending, shrimmerlatest, grenresshimmer;


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.flix_fragment, container, false);

//
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        flixrecylerview = view.findViewById(R.id.recyclerviewflix);
        trendingrecylerview = view.findViewById(R.id.recyclerview_movie_trending);
        latestrecyclerview = view.findViewById(R.id.recyclerview_flix_latest);
        recyclerView = view.findViewById(R.id.slider_flix_recyclerview);
        shrimmerlatest = view.findViewById(R.id.shimmer_flix_latest);

        slidershimmer = view.findViewById(R.id.shimmer_slider);
        shrimmertrending = view.findViewById(R.id.shimmer_flix_trending);
        grenresshimmer = view.findViewById(R.id.shimmer_genres);


        slidershimmer.startShimmerAnimation();
        shrimmertrending.startShimmerAnimation();
        shrimmerlatest.startShimmerAnimation();
        grenresshimmer.startShimmerAnimation();

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.flixrefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                data();
                trending();
                latest();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


////        slider flix
//        LinearLayoutManager llmm=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
//        recyclerView.setLayoutManager(llmm);
//        adapter = new FlixSliderAdapter(getContext(),sliderlist);
//        recyclerView.setAdapter(adapter);
        slide();


//  genres flix
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        flixrecylerview.setLayoutManager(layoutManager);
        recyclerAdapter = new FlixGenresTitleAdapter(flixitem, getContext());
        flixrecylerview.setAdapter(recyclerAdapter);
        data();

//trending
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        trendingrecylerview.setLayoutManager(llm);
        trendingAdapter = new FlixTrendingAdapter(getContext(), trendinglist);
        trendingrecylerview.setAdapter(trendingAdapter);
        trending();
//latest
        LinearLayoutManager llm2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        latestrecyclerview.setLayoutManager(llm2);
        latestAdapter = new FlixLatestAdapter(latestList, getContext());
        latestrecyclerview.setAdapter(latestAdapter);
        latest();

    }

    private void latest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlixLatestInterface flixLatestInterface = retrofit.create(FlixLatestInterface.class);
        Call<List<FlixLatest>> call = flixLatestInterface.getlatest();
        call.enqueue(new Callback<List<FlixLatest>>() {
            @Override
            public void onResponse(Call<List<FlixLatest>> call, Response<List<FlixLatest>> response) {
                latestList.clear();
                latestList.addAll(response.body());
                latestAdapter.notifyDataSetChanged();
                shrimmerlatest.stopShimmerAnimation();
                shrimmerlatest.setVisibility(View.GONE);


            }

            @Override
            public void onFailure(Call<List<FlixLatest>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void trending() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FlixTrendingInterface flixTrendingInterface = retrofit.create(FlixTrendingInterface.class);
        Call<List<FlixTRendings>> call = flixTrendingInterface.gettrending();
        call.enqueue(new Callback<List<FlixTRendings>>() {
            @Override
            public void onResponse(Call<List<FlixTRendings>> call, Response<List<FlixTRendings>> response) {
                trendinglist.clear();
                trendinglist.addAll(response.body());
                trendingAdapter.notifyDataSetChanged();
                shrimmertrending.startShimmerAnimation();
                shrimmertrending.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<FlixTRendings>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    void data() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/movie/Movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlixGenresInterface flixGenresInterface = retrofit.create(FlixGenresInterface.class);
        Call<List<FlixGenres>> call = flixGenresInterface.getdata();
        call.enqueue(new Callback<List<FlixGenres>>() {
            @Override
            public void onResponse(Call<List<FlixGenres>> call, Response<List<FlixGenres>> response) {
                flixitem.clear();
                flixitem.addAll(response.body());
                recyclerAdapter.notifyDataSetChanged();
                grenresshimmer.stopShimmerAnimation();
                grenresshimmer.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<FlixGenres>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    void slide() {
        //        slider flix
        LinearLayoutManager llmm = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(llmm);
        adapter = new FlixSliderAdapter(getContext(), sliderlist);
        recyclerView.setAdapter(adapter);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (llmm.findLastCompletelyVisibleItemPosition() < (adapter.getItemCount() - 1)) {
                    llmm.smoothScrollToPosition(recyclerView, new RecyclerView.State(),
                            llmm.findLastCompletelyVisibleItemPosition() + 1);
                } else if (llmm.findLastCompletelyVisibleItemPosition() < (adapter.getItemCount() - 1)) {
                    llmm.smoothScrollToPosition(recyclerView, new RecyclerView.State(),
                            0);
                }
            }
        }, 0, 3000);

        String Url = "https://api.fluntoo.com/slider/Slider/getAllImages";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/Movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FlixSliderInterface flixsliderinterface = retrofit.create(FlixSliderInterface.class);
        Call<List<FlixSlider>> call = flixsliderinterface.getslider(Url);
        call.enqueue(new Callback<List<FlixSlider>>() {
            @Override
            public void onResponse(Call<List<FlixSlider>> call, Response<List<FlixSlider>> response) {
                sliderlist.clear();
                sliderlist.addAll(response.body());
                adapter.notifyDataSetChanged();
                slidershimmer.stopShimmerAnimation();
                slidershimmer.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<FlixSlider>> call, Throwable t) {

//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
//        slidershimmer.startShimmerAnimation();
//        shrimmerlatest.startShimmerAnimation();
//        shrimmertrending.startShimmerAnimation();

    }

    @Override
    public void onPause() {
//        slidershimmer.stopShimmerAnimation();
//        shrimmertrending.stopShimmerAnimation();
//        shrimmerlatest.stopShimmerAnimation();
        super.onPause();
    }

    //    private void createslide(){
//
//        final Handler handler=new Handler();
//        final Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                if(current_position==sliderlist.size())
//                    current_position=0;
//                recyclerView
//
//            }
//        }
//
//
//
//    }
}
