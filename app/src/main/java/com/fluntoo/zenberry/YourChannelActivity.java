package com.fluntoo.zenberry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import com.fluntoo.zenberry.Adapter.MyAdapter;
//import com.example.playflix.R;
import com.google.android.material.tabs.TabLayout;

public class YourChannelActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TextView name;
    Toolbar toolbar;


    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_channel);

//         toolbar = findViewById(R.id.toolbar_yourchannel);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        name = findViewById(R.id.username);

        getname();

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));
        tabLayout.addTab(tabLayout.newTab().setText("Playlist"));
        tabLayout.addTab(tabLayout.newTab().setText("Channel"));
//        tabLayout.addTab(tabLayout.newTab().setText("Clouds"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MyAdapter adapter = new MyAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void getname() {
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
//
//        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();
//
//
//        String Url = "https://www.api.playflixx.com/getAboutme/" + user;
//        Log.d("comment", Url);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        AboutmeInterface aboutmeInterface = retrofit.create(AboutmeInterface.class);
//        Call<Aboutme> call = aboutmeInterface.getaboutme(Url);
//        call.enqueue(new Callback<Aboutme>() {
//            @Override
//            public void onResponse(Call<Aboutme> call, Response<Aboutme> response) {
//                if (response.isSuccessful()) {
//                    String aboutme = response.body().getUserName();
//                    getSupportActionBar().setTitle(aboutme);
//                    toolbar.setTitle(aboutme);
////                    titleName = response.body().getData().getAttributeName();
////                    getSupportActionBar().setTitle(titleName);
////                    toolbar.setTitle(titleName);
//
//                }
////                if(user.isEmpty()) {
////                    channelimg.setImageResource(R.drawable.ic_launcher_background);
////                    profileimg.setImageResource(R.drawable.ic_launcher_background);
////                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Aboutme> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


    }


}
