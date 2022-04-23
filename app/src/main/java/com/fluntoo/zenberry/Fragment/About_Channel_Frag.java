package com.fluntoo.zenberry.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.fluntoo.zenberry.ApIInterface.ChannelINfoInterface;
import com.fluntoo.zenberry.Model.ChannelINfo;
import com.fluntoo.zenberry.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class About_Channel_Frag extends Fragment {
    TextView channelname, views, desc, date;

    String channelid;
    String abc;
    String chanid;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    public static final String DATE_FORMAT_2 = "dd MMM, yyyy";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.about_channel_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        channelname = view.findViewById(R.id.aboutchannelname);
        views = view.findViewById(R.id.aboutviews);
        desc = view.findViewById(R.id.aboutdesc);
        date = view.findViewById(R.id.aboutdate);


        getdata();

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swipechannelabout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getdata();

                swipeRefreshLayout.setRefreshing(false);
            }
        });

//        Intent intent = getActivity().getIntent();
//        channelid = intent.getStringExtra("channeldyanmicid");
//
////        Intent intent1=getActivity().getIntent();
////        channelid=intent1.getStringExtra("channeldyanmicid");
////        abc = intent.getIntExtra("rah", 0);
////        Toast.makeText(getContext(), channelid, Toast.LENGTH_SHORT).show();
//
//
//        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);
//
//        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no vale");
////        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();
//
//        String Url = "https://www.api.playflixx.com/" + user + "/" + channelid;
//        Log.i("url", Url);
//        Log.d("token", name);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ChannelINfoInterface channelINfoInterface = retrofit.create(ChannelINfoInterface.class);
//        Call<ChannelINfo> call = channelINfoInterface.getchannelinfo(Url);
//        call.enqueue(new Callback<ChannelINfo>() {
//            @Override
//            public void onResponse(Call<ChannelINfo> call, Response<ChannelINfo> response) {
//                channelname.setText(response.body().getChannelName());
//                views.setText(response.body().getTotalviews().toString() + " views");
//                desc.setText(response.body().getChannelDescription());
//                date.setText("Joined On " + getCurrentDate(response.body().getChannelDateadded()));
//
//            }
//
//            @Override
//            public void onFailure(Call<ChannelINfo> call, Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    private void getdata() {
        Intent intent = getActivity().getIntent();
        channelid = intent.getStringExtra("channeldyanmicid");

//        Intent intent1=getActivity().getIntent();
//        channelid=intent1.getStringExtra("channeldyanmicid");
//        abc = intent.getIntExtra("rah", 0);
//        Toast.makeText(getContext(), channelid, Toast.LENGTH_SHORT).show();


        SharedPreferences prefs = this.getActivity().getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/channel/" + user + "/" + channelid;
        Log.i("url", Url);
        Log.d("token", name);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ChannelINfoInterface channelINfoInterface = retrofit.create(ChannelINfoInterface.class);
        Call<ChannelINfo> call = channelINfoInterface.getchannelinfo(Url);
        call.enqueue(new Callback<ChannelINfo>() {
            @Override
            public void onResponse(Call<ChannelINfo> call, Response<ChannelINfo> response) {
                channelname.setText(response.body().getChannelName());
                views.setText(response.body().getTotalviews().toString() + " views");
                desc.setText(response.body().getChannelDescription());
//                date.setText("Joined On " + getCurrentDate(response.body().getChannelDateadded()));

            }

            @Override
            public void onFailure(Call<ChannelINfo> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static String getCurrentDate(Long videoDateadded) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }


}
