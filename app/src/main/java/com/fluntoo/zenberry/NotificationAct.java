package com.fluntoo.zenberry;

import static com.fluntoo.zenberry.App.CHANNEL_1_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NotificationAct extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;


    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);
        b1 = (Button) findViewById(R.id.btnShownoti);
        notificationManager = NotificationManagerCompat.from(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int progressMax = 100;

                NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.app_icon)
                        .setContentTitle("Uploding")
                        .setContentText("uploading....")
                        .setPriority(NotificationCompat.PRIORITY_LOW)
                        .setOngoing(true)
                        .setOnlyAlertOnce(true)
                        .setProgress(progressMax, 0, true);


                notificationManager.notify(1, notification.build());

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);
                        for (int progress = 0; progress <= progressMax; progress += 20) {
//                            notification.setProgress(progressMax, progress, false);
//                            notificationManager.notify(1, notification.build());
                            SystemClock.sleep(1000);
                        }
                        notification.setContentText("Uploaded")
                                .setProgress(0, 0, false)
                                .setOngoing(false);
                        notificationManager.notify(1, notification.build());
                    }
                }).start();
            }
        });

    }


}