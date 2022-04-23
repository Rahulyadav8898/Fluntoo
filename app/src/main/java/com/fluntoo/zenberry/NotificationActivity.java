package com.fluntoo.zenberry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.Adapter.NotificationAdapter;
import com.fluntoo.zenberry.ApIInterface.NotificationInterface;
import com.fluntoo.zenberry.Model.Notification;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Notification> notificationList = new ArrayList<>();
    NotificationAdapter adapter;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        recyclerView = findViewById(R.id.recyclerview_nitification);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NotificationAdapter(getApplicationContext(), notificationList);
        recyclerView.setAdapter(adapter);
        noitification();

    }

    private void noitification() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
        String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no value");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();
        String Url = "https://api.fluntoo.com/aboutme/getAllNotification/" + user;
        Log.d("url", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NotificationInterface notificationInterface = retrofit.create(NotificationInterface.class);
        Call<List<Notification>> call = notificationInterface.getnotificaton(Url, "Bearer " + token);
        call.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                if (response.isSuccessful()) {
                    notificationList.clear();
                    notificationList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(), "Notification is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void startService(View v) {
        String input = "textis written";
        Intent serviceintent = new Intent(this, ExampleService.class);
        serviceintent.putExtra("inputExtra", input);

        startService(serviceintent);


    }

    public void stopService(View v) {
        Intent serviceintent = new Intent(this, ExampleService.class);
        stopService(serviceintent);
    }
}

