package com.fluntoo.zenberry;

import static com.fluntoo.zenberry.App.CHANNEL_3_ID;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Adapter.Music_Reccommendation_Adapter;
import com.fluntoo.zenberry.ApIInterface.LikeMusicINterface;
import com.fluntoo.zenberry.ApIInterface.MusicINterface;
import com.fluntoo.zenberry.Model.Music;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusicPlayerActivity extends AppCompatActivity {
    SimpleExoPlayer simpleExoPlayer;
    PlayerView playerView;

    String urlmusic, urlpic, urlname, urlid;
    ImageView img, repeat;
    TextView textViewm;
    CardView cardViewmain, cardViewarrow, cardViewarrow2;

    ImageView likeimg, likedimg;
    //    ImageView play, pause;
    RecyclerView recyclerView;
    List<Music> musicItems = new ArrayList<>();
    private Music_Reccommendation_Adapter adapter;
    LinearLayoutManager layoutManager;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    NotificationCompat.Builder notification;

    private DefaultTrackSelector trackSelector;
    ImageView farwordBtn, rewBtn;

    String id;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        img = findViewById(R.id.imgmusic);
        textViewm = findViewById(R.id.title_music);

//
        playerView = findViewById(R.id.playerviewm);
        farwordBtn = playerView.findViewById(R.id.formusic);
        rewBtn = playerView.findViewById(R.id.revmusic);
//        pause = findViewById(R.id.exo_pausem);
//        play = findViewById(R.id.exo_playm);

        repeat = findViewById(R.id.repeatmusic);

        likeimg = findViewById(R.id.likemusic);
        likedimg = findViewById(R.id.likedmusic);

        recyclerView = findViewById(R.id.recyclerview_music_reccommendation);
        cardViewmain = findViewById(R.id.cardviewmusic);
        cardViewarrow = findViewById(R.id.arrow_music);
        cardViewarrow2 = findViewById(R.id.arrow_music2);


        notificationManager = NotificationManagerCompat.from(this);

        cardViewarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewarrow.setVisibility(View.INVISIBLE);
                cardViewmain.setVisibility(View.INVISIBLE);
                cardViewarrow2.setVisibility(View.VISIBLE);
            }
        });

        cardViewarrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewarrow.setVisibility(View.VISIBLE);
                cardViewmain.setVisibility(View.VISIBLE);
                cardViewarrow2.setVisibility(View.INVISIBLE);
            }
        });

        Intent intent = getIntent();
//        urlmusic = intent.getStringExtra("musicurl");
        urlpic = intent.getStringExtra("musicpic");
        urlname = intent.getStringExtra("musicname");
        urlid = intent.getStringExtra("musiclike");
        String id = urlid;

        Glide.with(getApplicationContext())
                .load(urlpic)
                .into(img);
        textViewm.setText(urlname);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Music_Reccommendation_Adapter(musicItems, getApplicationContext());
        recyclerView.setAdapter(adapter);
        list();

        likeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postlike();
                likeimg.setVisibility(View.GONE);
                likedimg.setVisibility(View.VISIBLE);

            }
        });


        trackSelector = new DefaultTrackSelector(this);
        simpleExoPlayer = new SimpleExoPlayer.Builder(this).setTrackSelector(trackSelector).build();
//        playerView = findViewById(R.id.exoPlayerView);

        playerView = findViewById(R.id.playerviewm);

        playerView.setPlayer(simpleExoPlayer);


        MediaItem mediaItem = MediaItem.fromUri(urlmusic);
        simpleExoPlayer.addMediaItem(mediaItem);
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();
        getnotify();


        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


//
        farwordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                simpleExoPlayer.seekTo(simpleExoPlayer.getCurrentPosition() + 10000);

            }
        });

        rewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long num = simpleExoPlayer.getCurrentPosition() - 10000;
                if (num < 0) {
                    simpleExoPlayer.seekTo(0);

                } else {
                    simpleExoPlayer.seekTo(simpleExoPlayer.getCurrentPosition() - 10000);

                }
            }
        });


//
        findViewById(R.id.exo_pausem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                simpleExoPlayer.play();

            }
        });

        findViewById(R.id.exo_pausem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleExoPlayer.pause();


            }
        });

//
//       play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                simpleExoPlayer.play();
//
//
//            }
//        });
//      pause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                simpleExoPlayer.pause();
//
//            }
//        });


        simpleExoPlayer.addListener(new com.google.android.exoplayer2.Player.Listener() {
            @Override
            public void onPlaybackStateChanged(int state) {
                if (state == ExoPlayer.STATE_ENDED) {


                }

            }
        });


        playerView.setControllerVisibilityListener(new PlayerControlView.VisibilityListener() {
            @Override
            public void onVisibilityChange(int visibility) {

            }
        });


//        initplayer();


    }

    public Bitmap getBitmapFromURL(String strURL) {
        Intent intent = getIntent();
        urlmusic = intent.getStringExtra("musicurl");
        urlpic = intent.getStringExtra("musicpic");
        try {

            URL url = new URL(urlpic);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private void getnotify() {


        final int progressMax = 100;
//        Bitmap bitmap = getBitmapFromURL(urlpic);


        Bitmap bit = null;
        try {
            bit = BitmapFactory.decodeStream((InputStream) new URL(urlpic).getContent());
        } catch (Exception e) {
//            Toast.makeText(getApplicationContext(), "not load", Toast.LENGTH_LONG).show();
        }


        notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_3_ID)
                .setSmallIcon(R.drawable.app_icon)
                .setContentTitle(urlname)
//                .setContentText("uploading....")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .addAction(R.drawable.ic_play_arrow_black_24dp, "play", null)
                .addAction(R.drawable.arrow, "pause", null)
                .setLargeIcon(bit)
//                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle())
                .setOngoing(false);
//                .setOnlyAlertOnce(true);
//                .setProgress(progressMax, 0, true);


        notificationManager.notify(1, notification.build());

    }

    private void postlike() {
        Intent intent = getIntent();
        urlmusic = intent.getStringExtra("musicurl");
        urlpic = intent.getStringExtra("musicpic");
        urlname = intent.getStringExtra("musicname");
        urlid = intent.getStringExtra("musiclike");

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no value");

        String url = "https://www.api.playflixx.com/" + user + "/addlike/" + urlid;
        Log.d("url1", url.toString());


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LikeMusicINterface likeMusicINterface = retrofit.create(LikeMusicINterface.class);
        Call<Music> call = likeMusicINterface.postlike(url);
        call.enqueue(new Callback<Music>() {
            @Override
            public void onResponse(Call<Music> call, Response<Music> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Music> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void list() {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no value");

        String url = "https://www.api.playflixx.com/getmusic/" + user;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MusicINterface musicINterface = retrofit.create(MusicINterface.class);
        Call<List<Music>> call = musicINterface.getmusic(url);
        call.enqueue(new Callback<List<Music>>() {
            @Override
            public void onResponse(Call<List<Music>> call, Response<List<Music>> response) {
                musicItems.clear();
                musicItems.addAll(response.body());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Music>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
            }
        });

    }


//    private void initplayer() {
//
//        playerView = findViewById(R.id.playerviewm);
//        playerView.setControllerShowTimeoutMs(0);
//        playerView.setCameraDistance(30);
//        SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer.Builder(this).build();
//        playerView.setPlayer(simpleExoPlayer);
//        DataSource.Factory datasourcefactory = new DefaultDataSourceFactory(this,
//                Util.getUserAgent(this, "app"));
//        MediaSource audiosource = new ProgressiveMediaSource.Factory(datasourcefactory).createMediaSource(Uri.parse(urlmusic));
//        simpleExoPlayer.prepare(audiosource);
//        simpleExoPlayer.setPlayWhenReady(true);
//
//
//    }

    protected void releasePlayer() {
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            simpleExoPlayer = null;
            trackSelector = null;
        }

    }


    @Override
    public void onStop() {
        super.onStop();

        releasePlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notification
                .setOngoing(false);
//        notificationManager.notify(1, notification.build());
    }
}
