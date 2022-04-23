package com.fluntoo.zenberry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.fluntoo.zenberry.Adapter.Myadapterwatchlist;
import com.fluntoo.zenberry.Model.Myadapterchannelname;
import com.google.android.material.tabs.TabLayout;

public class Channel_Name_Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_name);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutchannelname);
        viewPager = (ViewPager) findViewById(R.id.viewPagerchannelname);

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));
        tabLayout.addTab(tabLayout.newTab().setText("Playlist"));
//        tabLayout.addTab(tabLayout.newTab().setText("Community"));
        tabLayout.addTab(tabLayout.newTab().setText("Channels"));
        tabLayout.addTab(tabLayout.newTab().setText("About"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final Myadapterchannelname adapterr = new Myadapterchannelname(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapterr);

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
}