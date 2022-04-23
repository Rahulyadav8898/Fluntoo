package com.fluntoo.zenberry.Fragment;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.fluntoo.zenberry.Adapter.CategoryAdapter;
import com.fluntoo.zenberry.Adapter.LatestAdapter;
import com.fluntoo.zenberry.Adapter.PostAdapterInterface;
import com.fluntoo.zenberry.Adapter.PostRecyclerAdapter;
import com.fluntoo.zenberry.Adapter.TrendingAdapter;
import com.fluntoo.zenberry.ApIInterface.CategoryInterface;
import com.fluntoo.zenberry.ApIInterface.LatestInterface;
import com.fluntoo.zenberry.ApIInterface.PlayFragmentInterface;
import com.fluntoo.zenberry.ApIInterface.TrendingInterface;
import com.fluntoo.zenberry.Model.Category;
import com.fluntoo.zenberry.Model.Latest;
import com.fluntoo.zenberry.Model.PostItem;
import com.fluntoo.zenberry.Model.Trending;
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

public class Home_Fragment extends Fragment implements PostAdapterInterface {
    RecyclerView recyclerView;
    PostRecyclerAdapter recyclerAdapter;

    LinearLayoutManager layoutManager;

    RecyclerView trendrecyclerview;
    List<PostItem> postItems = new ArrayList<>();
    List<Trending> trendingList = new ArrayList<>();
    private TrendingAdapter trendingAdapter;

    RecyclerView latestrecyclerview;
    List<Latest> latestlist = new ArrayList<>();


    int currentitems;
    int totalItemCount;
    int lastVisibleItem;


    CardView cardview;
    private LatestAdapter latestAdapter;

    private CategoryAdapter catAdapter;
    List<Category> catlist = new ArrayList<>();
    String user;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    public static final String MY_PREFS_NAME1 = "MyPrefsFile1";

    ShimmerFrameLayout shrimmer, shrimmertrending, shimmerlatest;

    //check
    Boolean isLogin = false;
    Boolean isscrolling = false;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home__fragment, container, false);

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        recyclerView = view.findViewById(R.id.recyclerView);
        cardview = view.findViewById(R.id.card);
//
//        shrimmer = view.findViewById(R.id.shimmer_view_container);
//        shrimmertrending = view.findViewById(R.id.shimmer_trending);
//        shimmerlatest = view.findViewById(R.id.shimmerlatest);
//        shrimmer.startShimmerAnimation();
//        shimmerlatest.startShimmerAnimation();
//        shrimmertrending.startShimmerAnimation();

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listdata();
                trending();
                latest();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
//
        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

        String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no value");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();
//        Log.d("token", token);
        String abc = user;
        Log.d("abc", abc);

//checking boolean login forgetpass
        SharedPreferences.Editor editor = getContext().getSharedPreferences(MY_PREFS_NAME1, 0).edit();
        editor.putString("userId1", abc);
        editor.clear();
        editor.putBoolean("isLogin", false);
        editor.apply();

//        trendrecyclerview = view.findViewById(R.id.recyclerView_trending);
//        LinearLayoutManager linearLayoutManagerTre = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        trendrecyclerview.setLayoutManager(linearLayoutManagerTre);
//        trendingAdapter = new TrendingAdapter(getContext(), trendingList);
//        trendrecyclerview.setAdapter(trendingAdapter);
//        trending();

        recyclerView = view.findViewById(R.id.recyclerVieww);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerAdapter = new PostRecyclerAdapter(getContext(), postItems, this);
//        recyclerView.setAdapter(recyclerAdapter);
        listdata();

        //alllistdata i.e getallvideolist

//        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                if (dy== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
//                    isscrolling = true;
//                }
//
//            }
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                currentitems = layoutManager.getChildCount();
//                totalItemCount = layoutManager.getItemCount();
//                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
//
//                if (isscrolling && (currentitems + lastVisibleItem == totalItemCount)) {
//
//                    // End has been reached
//                    // do something
//                    listdata();
//
//
//                }
//            }
//
//        });

//        trendingrecyclerview

        trendrecyclerview = view.findViewById(R.id.recyclerView_trending);
        LinearLayoutManager linearLayoutManagerTre = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        trendrecyclerview.setLayoutManager(linearLayoutManagerTre);
        trendingAdapter = new TrendingAdapter(getContext(), trendingList);
        trendrecyclerview.setAdapter(trendingAdapter);
        trending();

        //latestvideo

//        pb.setVisibility(View.VISIBLE);
        latestrecyclerview = view.findViewById(R.id.recyclerview_latest);
        LinearLayoutManager linearLayoutManagerlat = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        latestrecyclerview.setLayoutManager(linearLayoutManagerlat);
        latestAdapter = new LatestAdapter(getContext(), latestlist);
        latestrecyclerview.setAdapter(latestAdapter);
        latest();

//categoryrecyclerview
        RecyclerView recyclerViewcat = view.findViewById(R.id.recyclerview_cat);
        LinearLayoutManager layoutManagercat = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewcat.setLayoutManager(layoutManagercat);
        catAdapter = new CategoryAdapter(getContext(), (ArrayList<Category>) catlist);
        recyclerViewcat.setAdapter(catAdapter);
        category();


//statusrecyclerview
//        RecyclerView recyclerViewstatus=view.findViewById(R.id.recyclerview_status);
//        LinearLayoutManager layoutManager2=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
//        recyclerViewstatus.setLayoutManager(layoutManager2);
//String []abc={"R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background","R.drawable.ic_launcher_background"};
//        recyclerViewstatus.setAdapter(new StatusAdapter(abc));
//    }

    }


    private void category() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/video/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoryInterface categoryINterface = retrofit.create(CategoryInterface.class);
        Call<List<Category>> call = categoryINterface.getcategory();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    catlist.clear();
                    catlist.addAll(response.body());
                    catAdapter.notifyDataSetChanged();
                }
//                else {
//                    Intent intent = new Intent(getContext(), ServerNotWorkingActivity.class);
//                    startActivity(intent);
//                }

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void latest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/video/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LatestInterface latestInterface = retrofit.create(LatestInterface.class);
        Call<List<Latest>> call = latestInterface.getlatest();
        call.enqueue(new Callback<List<Latest>>() {
            @Override
            public void onResponse(Call<List<Latest>> call, Response<List<Latest>> response) {
                Log.d("TAG", "Response = " + latestlist.toString());

                if (response.isSuccessful()) {
                    latestlist.clear();
                    latestlist.addAll(response.body());
                    latestAdapter.notifyDataSetChanged();
//                    shimmerlatest.stopShimmerAnimation();
//                    shimmerlatest.setVisibility(View.GONE);

                } else {
//                    Intent intent = new Intent(getContext(), ServerNotWorkingActivity.class);
//                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<List<Latest>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void trending() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/video/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TrendingInterface trendingInterface = retrofit.create(TrendingInterface.class);
        Call<List<Trending>> call = trendingInterface.gettrending();
        call.enqueue(new Callback<List<Trending>>() {
            @Override
            public void onResponse(Call<List<Trending>> call, Response<List<Trending>> response) {
                Log.d("TAG", "Response = " + trendingList.toString());
                if (response.isSuccessful()) {
                    trendingList.clear();
                    trendingList.addAll(response.body());
                    trendingAdapter.notifyDataSetChanged();
//                    shrimmertrending.stopShimmerAnimation();
//                    shrimmertrending.setVisibility(View.GONE);
                } else {
//                    Intent intent = new Intent(getContext(), ServerNotWorkingActivity.class);
//                    startActivity(intent);

                }
            }

            @Override
            public void onFailure(Call<List<Trending>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void listdata() {

        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

        String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no value");


        String Url = "https://api.fluntoo.com/video/getmoredatalimit/" + user;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/video/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlayFragmentInterface playFragmentInterface = retrofit.create(PlayFragmentInterface.class);
        Call<List<PostItem>> call = playFragmentInterface.getdata(Url);
        call.enqueue(new Callback<List<PostItem>>() {
            @Override
            public void onResponse(Call<List<PostItem>> call, Response<List<PostItem>> response) {

                if (response.isSuccessful()) {
//
                    if (recyclerAdapter !=null){
//                        postItems.addAll(response.body());
//                        recyclerAdapter.notifyDataSetChanged();
                        recyclerAdapter.adddata(response.body());
                    }
                    else{
                        postItems.clear();
                        setAdapter(response.body());
//                        recyclerAdapter = new PostRecyclerAdapter(getContext(), postItems, this);
//                        recyclerView.setAdapter(recyclerAdapter);

                    }
//                    postItems.clear();
//                    postItems.addAll(response.body());
//                    recyclerAdapter.notifyDataSetChanged();

//                    }else {
//                       setAdapter(response.body());
//                    }

//                    shrimmer.stopShimmerAnimation();
//                    shrimmer.setVisibility(View.GONE);

                } else {
                    Toast.makeText(getContext(), "You Skipped Login", Toast.LENGTH_SHORT).show();
                }
//                progressBarscroll.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<PostItem>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
    private void setAdapter(List<PostItem> body){
        isscrolling=true;
        recyclerAdapter = new PostRecyclerAdapter(getContext(), body,this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onResume() {

        super.onResume();
//        shrimmer.startShimmerAnimation();
//        shrimmertrending.startShimmerAnimation();
//        shimmerlatest.startShimmerAnimation();
    }

    @Override
    public void onPause() {
//        shrimmer.stopShimmerAnimation();
//        shrimmertrending.stopShimmerAnimation();
//        shimmerlatest.stopShimmerAnimation();

        super.onPause();

    }

    @Override
    public void onMethodCallback() {
        listdata();
    }


}
