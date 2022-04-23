package com.fluntoo.zenberry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.fluntoo.zenberry.Model.MySubsAdapter;
import com.google.android.material.tabs.TabLayout;

public class SubscriptionMainActivity extends AppCompatActivity  {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_main);
        tabLayout = findViewById(R.id.tabLayoutsubs);
        viewPager = findViewById(R.id.viewPagersubs);


        tabLayout.addTab(tabLayout.newTab().setText("STARTER"));
        tabLayout.addTab(tabLayout.newTab().setText("VIP"));
        tabLayout.addTab(tabLayout.newTab().setText("PREMIUM"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        final MySubsAdapter adapter1 = new MySubsAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter1);

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