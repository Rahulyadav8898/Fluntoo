package com.fluntoo.zenberry;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;


public class App extends Application {
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";
    public static final String CHANNEL_3_ID = "channel3";


//
    private static final String TAG = "App";



    @Override
    public void onCreate() {
        super.onCreate();

        createNotification();
//

//        configureRxJavaErrorHandler();
//        Completable.fromAction(this::initLibraries).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableCompletableObserver() {
//            @Override
//            public void onComplete() {
//                // it worked
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                if(BuildConfig.DEBUG) Log.e(TAG, "failed to initialize youtubedl-android", e);
//                Toast.makeText(getApplicationContext(), "initialization failed: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

//    private void configureRxJavaErrorHandler() {
//        RxJavaPlugins.setErrorHandler(e -> {
//
//            if (e instanceof UndeliverableException) {
//                // As UndeliverableException is a wrapper, get the cause of it to get the "real" exception
//                e = e.getCause();
//            }
//
//            if (e instanceof InterruptedException) {
//                // fine, some blocking code was interrupted by a dispose call
//                return;
//            }
//
//            Log.e(TAG, "Undeliverable exception received, not sure what to do", e);
//        });
//    }
//
//    private void initLibraries() throws YoutubeDLException {
//        YoutubeDL.getInstance().init(this);
//        FFmpeg.getInstance().init(this);
//    }



    private void createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel1", NotificationManager.IMPORTANCE_LOW
            );
            channel1.setDescription("channel 1");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel2", NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("channel 1");
//music start here

            NotificationChannel channel3 = new NotificationChannel(
                    CHANNEL_3_ID,
                    "Channel3", NotificationManager.IMPORTANCE_HIGH
            );
            channel3.setDescription("channel 3");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
//            music
            manager.createNotificationChannel(channel3);

        }
    }

}
