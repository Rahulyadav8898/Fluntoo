package com.fluntoo.zenberry.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.fluntoo.zenberry.Adapter.WebLatestAdapter;
import com.fluntoo.zenberry.Adapter.WebTrendingAdapter;
import com.fluntoo.zenberry.ApIInterface.WebLatestInterface;
import com.fluntoo.zenberry.ApIInterface.WebSliderInterface;
import com.fluntoo.zenberry.ApIInterface.WebTrendingInterface;
import com.fluntoo.zenberry.Model.FlixSlider;
import com.fluntoo.zenberry.Model.LatestWeb;
import com.fluntoo.zenberry.Model.WebSliderAdapter;
import com.fluntoo.zenberry.Model.WebTrending;
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

public class Webserie_Fragment extends Fragment {
    RecyclerView latestrecyclerview;
    WebLatestAdapter latestAdapter;
    List<LatestWeb> latestWebList = new ArrayList<>();

    RecyclerView trendingrecyclerview;
    WebTrendingAdapter trendingAdapter;
    List<WebTrending> webTrendingList = new ArrayList<>();

    RecyclerView recyclerView;
    WebSliderAdapter adapter;
    List<FlixSlider> sliderList = new ArrayList<>();


    ShimmerFrameLayout shimmerslider, shrimmertrending, shrimmerlatest;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.webseries_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        latestrecyclerview = view.findViewById(R.id.recyclerview_latest_web);
        trendingrecyclerview = view.findViewById(R.id.recyclerview_trending_web);
        recyclerView = view.findViewById(R.id.recyclerview_web_slider);

//        shimmerslider = view.findViewById(R.id.shimmer_web_slider);
//        shrimmertrending = view.findViewById(R.id.shimmer_trending_web);
//        shrimmerlatest = view.findViewById(R.id.shimmer_latest_web);

//
//        shimmerslider.startShimmerAnimation();
//        shrimmertrending.startShimmerAnimation();
//        shrimmerlatest.startShimmerAnimation();

//        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.webrefresh);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                trending();
//                latest();
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        });


        LinearLayoutManager llm = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        latestrecyclerview.setLayoutManager(llm);
        latestAdapter = new WebLatestAdapter(getContext(), latestWebList);
        latestrecyclerview.setAdapter(latestAdapter);
        latest();


        LinearLayoutManager llm2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        trendingrecyclerview.setLayoutManager(llm2);
        trendingAdapter = new WebTrendingAdapter(webTrendingList, getContext());
        trendingrecyclerview.setAdapter(trendingAdapter);
        trending();


        slider();

    }

    private void slider() {
        LinearLayoutManager llm3 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(llm3);
        adapter = new WebSliderAdapter(getContext(), sliderList);
        recyclerView.setAdapter(adapter);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (llm3.findLastCompletelyVisibleItemPosition() < (adapter.getItemCount() - 1)) {
                    llm3.smoothScrollToPosition(recyclerView, new RecyclerView.State(),
                            llm3.findLastCompletelyVisibleItemPosition() + 1);
                } else if (llm3.findLastCompletelyVisibleItemPosition() < (adapter.getItemCount() - 1)) {
                    llm3.smoothScrollToPosition(recyclerView, new RecyclerView.State(),
                            0);
                }
            }
        }, 0, 3000);

        String Url = "https://api.fluntoo.com/slider/Slider/getAllImages";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebSliderInterface webSliderInterface = retrofit.create(WebSliderInterface.class);
        Call<List<FlixSlider>> call = webSliderInterface.getwebslider(Url);
        call.enqueue(new Callback<List<FlixSlider>>() {
            @Override
            public void onResponse(Call<List<FlixSlider>> call, Response<List<FlixSlider>> response) {
                sliderList.clear();
                sliderList.addAll(response.body());
                adapter.notifyDataSetChanged();
//                shimmerslider.stopShimmerAnimation();
//                shimmerslider.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<FlixSlider>> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void trending() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/webseries/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebTrendingInterface webTrendingInterface = retrofit.create(WebTrendingInterface.class);
        Call<List<WebTrending>> call = webTrendingInterface.gettrending();
        call.enqueue(new Callback<List<WebTrending>>() {
            @Override
            public void onResponse(Call<List<WebTrending>> call, Response<List<WebTrending>> response) {
                if (response.isSuccessful()) {
                    webTrendingList.clear();
                    webTrendingList.addAll(response.body());
                    trendingAdapter.notifyDataSetChanged();
//                    shrimmertrending.startShimmerAnimation();
//                    shrimmertrending.setVisibility(View.GONE);
                } else {
                    Toast.makeText(getContext(), "could not load something", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WebTrending>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void latest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/webseries/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebLatestInterface webLatestInterface = retrofit.create(WebLatestInterface.class);
        Call<List<LatestWeb>> call = webLatestInterface.getlatest();
        call.enqueue(new Callback<List<LatestWeb>>() {
            @Override
            public void onResponse(Call<List<LatestWeb>> call, Response<List<LatestWeb>> response) {
                latestWebList.clear();
                latestWebList.addAll(response.body());
                latestAdapter.notifyDataSetChanged();
//                shrimmerlatest.stopShimmerAnimation();
//                shrimmerlatest.setVisibility(View.GONE);


            }

            @Override
            public void onFailure(Call<List<LatestWeb>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
