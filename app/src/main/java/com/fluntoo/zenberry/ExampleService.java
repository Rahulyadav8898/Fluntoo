package com.fluntoo.zenberry;

import static com.fluntoo.zenberry.App.CHANNEL_1_ID;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ExampleService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setContentTitle(input)
                .setContentTitle("text")
                .setSmallIcon(R.drawable.app_icon)
                .build();

        startForeground(1, notification);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
