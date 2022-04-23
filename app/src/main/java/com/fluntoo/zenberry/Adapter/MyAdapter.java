package com.fluntoo.zenberry.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fluntoo.zenberry.Fragment.Channels_Fragment;
import com.fluntoo.zenberry.Fragment.Cloud_Fragment;

import com.fluntoo.zenberry.Fragment.Dashboar_Fragment;
import com.fluntoo.zenberry.Fragment.Playlist_Fragment;
import com.fluntoo.zenberry.Fragment.Videos_Fragment;

public class MyAdapter   extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Dashboar_Fragment dashboard_fragment = new Dashboar_Fragment();
                return dashboard_fragment;
            case 1:
                Videos_Fragment videos_fragment=new Videos_Fragment();
                return videos_fragment;
            case 2:
                Playlist_Fragment playlist_fragment=new Playlist_Fragment();
                return playlist_fragment;
            case 3:
                Channels_Fragment channels_fragment=new Channels_Fragment();
                return channels_fragment;
//            case 4:
//                Cloud_Fragment cloud_fragment=new Cloud_Fragment();
//                return cloud_fragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
