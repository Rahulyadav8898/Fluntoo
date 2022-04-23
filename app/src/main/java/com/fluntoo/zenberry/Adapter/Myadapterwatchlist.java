package com.fluntoo.zenberry.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fluntoo.zenberry.Fragment.Channels_Fragment;
import com.fluntoo.zenberry.Fragment.Dashboar_Fragment;
import com.fluntoo.zenberry.Fragment.Flixwatchlist_Frag;
import com.fluntoo.zenberry.Fragment.Playlist_Fragment;
import com.fluntoo.zenberry.Fragment.Playwatchist_Frag;
import com.fluntoo.zenberry.Fragment.Videos_Fragment;
import com.fluntoo.zenberry.Fragment.Webwatchlist_Frag;

public class Myadapterwatchlist extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public Myadapterwatchlist(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Playwatchist_Frag playwatchist_frag = new Playwatchist_Frag();
                return playwatchist_frag;
            case 1:
                Flixwatchlist_Frag flixwatchlist_frag = new Flixwatchlist_Frag();
                return flixwatchlist_frag;
            case 2:
                Webwatchlist_Frag webwatchlist_frag = new Webwatchlist_Frag();
                return webwatchlist_frag;
//            case 3:
//                Channels_Fragment channels_fragment=new Channels_Fragment();
//                return channels_fragment;
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
