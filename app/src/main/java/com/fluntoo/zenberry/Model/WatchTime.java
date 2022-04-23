package com.fluntoo.zenberry.Model;

import android.text.format.Time;

public class WatchTime {
    private Time watchTimes;

    public WatchTime(Time watchTimes) {
        this.watchTimes = watchTimes;
    }

    public Time getWatchTimes() {
        return watchTimes;
    }

    public void setWatchTimes(Time watchTimes) {
        this.watchTimes = watchTimes;
    }
}
