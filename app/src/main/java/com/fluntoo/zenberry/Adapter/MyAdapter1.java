package com.fluntoo.zenberry.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fluntoo.zenberry.Fragment.Epd_Frag;
import com.fluntoo.zenberry.Fragment.MoreWeb_Frag;

public class MyAdapter1  extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter1(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Epd_Frag epd_frag = new Epd_Frag();
                return epd_frag;
            case 1:
                MoreWeb_Frag moreWeb_frag=new MoreWeb_Frag();
                return moreWeb_frag;

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
