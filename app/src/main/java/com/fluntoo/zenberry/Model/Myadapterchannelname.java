package com.fluntoo.zenberry.Model;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fluntoo.zenberry.Fragment.About_Channel_Frag;
import com.fluntoo.zenberry.Fragment.Channel_Channel_Frag;
import com.fluntoo.zenberry.Fragment.Community_Channel_Frag;
import com.fluntoo.zenberry.Fragment.Flixwatchlist_Frag;
import com.fluntoo.zenberry.Fragment.Home_Channel_Frag;
import com.fluntoo.zenberry.Fragment.Playlist_Channel_Frag;
import com.fluntoo.zenberry.Fragment.Playwatchist_Frag;
import com.fluntoo.zenberry.Fragment.Video_Channel_Frag;
import com.fluntoo.zenberry.Fragment.Webwatchlist_Frag;

public class Myadapterchannelname extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public Myadapterchannelname(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Home_Channel_Frag home_channel_frag = new Home_Channel_Frag();
                return home_channel_frag;
            case 1:
                Video_Channel_Frag video_channel_frag = new Video_Channel_Frag();
                return video_channel_frag;
            case 2:
                Playlist_Channel_Frag playlist_channel_frag = new Playlist_Channel_Frag();
                return playlist_channel_frag;
//            case 3:
//                Community_Channel_Frag community_channel_frag =new Community_Channel_Frag();
//                return community_channel_frag;
            case 3:
                Channel_Channel_Frag channel_channel_frag =new Channel_Channel_Frag();
                return channel_channel_frag;
            case 4:
                About_Channel_Frag about_channel_frag =new About_Channel_Frag();
                return about_channel_frag;
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

