package com.fluntoo.zenberry.Model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fluntoo.zenberry.Fragment.Channels_Fragment;
import com.fluntoo.zenberry.Fragment.Cloud_Fragment;
import com.fluntoo.zenberry.Fragment.Dashboar_Fragment;
import com.fluntoo.zenberry.Fragment.Playlist_Fragment;
import com.fluntoo.zenberry.Fragment.PremiumPack_Frag;
import com.fluntoo.zenberry.Fragment.StarterPack_Frag;
import com.fluntoo.zenberry.Fragment.Videos_Fragment;
import com.fluntoo.zenberry.Fragment.VipPack_Frag;

public class MySubsAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MySubsAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                StarterPack_Frag starterPack_frag = new StarterPack_Frag();
                return starterPack_frag;
            case 1:
                VipPack_Frag vipPack_frag=new VipPack_Frag();
                return vipPack_frag;
            case 2:
                PremiumPack_Frag premiumPack_frag=new PremiumPack_Frag();
                return premiumPack_frag;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
