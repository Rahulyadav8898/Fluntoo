package com.fluntoo.zenberry;

import android.app.PictureInPictureParams;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Rational;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.fluntoo.zenberry.Adapter.FlixRecommendedAdapter;
import com.fluntoo.zenberry.ApIInterface.FlixREcommendedInterface;
import com.fluntoo.zenberry.ApIInterface.FlixwatchlaterInterface;
import com.fluntoo.zenberry.Model.FlixLatest;
import com.fluntoo.zenberry.Model.MovieRecommended;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.playflix.R;

public class FlixPlayerActivity extends AppCompatActivity {

    ImageView pipflix;
    TextView videodesc, videotitle;
    String videod, videov, videot;
    Button sharebtn, downloadbtn, watchbtn;
    private boolean isShowingTrackSelectionDialog;
    private DefaultTrackSelector trackSelector;
    String[] speed = {"0.25x", "0.5x", "Normal", "1.5x", "2x"};
    PlayerView playerView;
    SimpleExoPlayer simpleExoPlayer;
    // String url = "https://www.data.playflixx.com/PlayflixxData/16/Play/Channel/one/Video/Video_MainFile/SarfarazVideo/SarfarazVideo.mpd";
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    ImageView img;
    TextView titletxt, genrestxt, restxt, datetxt, desctxt, casttxt;
    String titlestr, imgstr, genresstr, restr, datestr, descstr, caststr, webidstr, videopath, vid;
    public static final String TAG = "TAG";

    boolean fullscreen = false;
    String Url;
    Long downloadID;

    String filepath = "https://www.data.playflixx.com/PlayflixxData/4/Play/Channel/EvergreenSongs/Video/Video_MainFile/WhatDoMenWant1/WhatDoMenWant1.mpd";

    RecyclerView recyclerView;
    List<MovieRecommended> movieRecommendedList = new ArrayList<>();
    FlixRecommendedAdapter adapter;

    public static final String DATE_FORMAT_2 = "HH:mm:ss";

    ShimmerFrameLayout shimmerrec;
    Boolean isLogin = false;

    //    download
    DownloadManager downloadManager;
    DatabaseProvider databaseProvider;

    DownloadHelper downloadHelper;
    DownloadRequest downloadRequest;

    ImageView farwordBtn, rewBtn, setting, speedBtn;
    TextView speedTxt;
    ImageView fullscreenButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flix_player);
        watchbtn = findViewById(R.id.flix_watchlist_btn);
//        downloadbtn = findViewById(R.id.download_btn);

        playerView = findViewById(R.id.exoPlayerView_flix);
        farwordBtn = playerView.findViewById(R.id.fwd);
        rewBtn = playerView.findViewById(R.id.rew);
        setting = playerView.findViewById(R.id.exo_track_selection_view);
        speedBtn = playerView.findViewById(R.id.exo_playback_speed);
        speedTxt = playerView.findViewById(R.id.speed);

        fullscreenButton = playerView.findViewById(R.id.fullscreen);
        pipflix = findViewById(R.id.pip);


        recyclerView = findViewById(R.id.recylerview_flix_reccommended);
        sharebtn = findViewById(R.id.flix_share_btn);
//        shimmerrec = findViewById(R.id.shimmer_flix_rec);
//        shimmerrec.startShimmerAnimation();

        titletxt = findViewById(R.id.titleweb);
        genrestxt = findViewById(R.id.genresweb);
        img = findViewById(R.id.imgweb);
        restxt = findViewById(R.id.restrictionweb);
        datetxt = findViewById(R.id.dateweb);
//        desctxt = findViewById(R.id.descweb);
        casttxt = findViewById(R.id.castweb);


//        playerView=findViewById(R.id.exoPlayerView);
//        videoView = findViewById(R.id.videoView);


        Intent intent = getIntent();
        titlestr = intent.getStringExtra("title");
        genresstr = intent.getStringExtra("genres");
        imgstr = intent.getStringExtra("image");
        restr = intent.getStringExtra("res");
        descstr = intent.getStringExtra("desc");
        caststr = intent.getStringExtra("cast");
        webidstr = intent.getStringExtra("id");
        videopath = intent.getStringExtra("videopath");
        videov = intent.getStringExtra("videov");
        vid = intent.getStringExtra("id");
//        datestr = intent.getStringExtra("date");


        Url = "https://fluntoo.com/VideoPlay/" + vid;
        Log.i("Tag", Url);

        titletxt.setText(titlestr);
        genrestxt.setText(genresstr);
        Glide.with(getApplicationContext())
                .load(imgstr)
                .into(img);
        restxt.setText(restr);
        datetxt.setText(datestr);
//        desctxt.setText(descstr);
        casttxt.setText(caststr);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new FlixRecommendedAdapter(getApplicationContext(), movieRecommendedList);
        recyclerView.setAdapter(adapter);
        getrecommended();


        watchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postwatchlist();
            }
        });


        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                // Add data to the intent, the receiving app will decide
                // what to do with it.
                share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                share.putExtra(Intent.EXTRA_TEXT, Url);

                startActivity(Intent.createChooser(share, "Share link!"));
            }
        });


        pipflix.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                PictureInPictureParams pipp = new PictureInPictureParams.Builder()
                        .setAspectRatio(new Rational(2, 1))
                        .build();
                enterPictureInPictureMode(pipp);

            }
        });

        getwatch();
        trackSelector = new DefaultTrackSelector(this);
        simpleExoPlayer = new SimpleExoPlayer.Builder(this).setTrackSelector(trackSelector).build();
//        playerView = findViewById(R.id.exoPlayerView_flix);
        playerView.setPlayer(simpleExoPlayer);


        MediaItem mediaItem = MediaItem.fromUri(videov);
        simpleExoPlayer.addMediaItem(mediaItem);
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();

//        downloadbtn.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ServiceCast")
//            @Override
//            public void onClick(View v) {
//
//                Uri Download_Uri = Uri.parse(filepath);
////                Uri Download_Uri = Uri.parse(filepath);
//                Log.d("downloadurl", videov);
//
//                android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(Download_Uri);
//
//                //Restrict the types of networks over which this download may proceed.
//                request.setAllowedNetworkTypes(android.app.DownloadManager.Request.NETWORK_WIFI | android.app.DownloadManager.Request.NETWORK_MOBILE);
//                //Set whether this download may proceed over a roaming connection.
//                request.setAllowedOverRoaming(false);
//                // Visibility of the download Notification
//                request.setNotificationVisibility(android.app.DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                //Set the title of this download, to be displayed in notifications (if enabled).
//                request.setTitle("Downloading");
//                //Set a description of this download, to be displayed in notifications (if enabled)
//                request.setDescription("Downloading File");
//
//                //Set the local destination for the downloaded file to a path within the application's external files directory
//                /*request.setDestinationInExternalFilesDir(MainActivity.this, Environment.DIRECTORY_MOVIES, "Shivam196.mp4");*/ //For private destination
//
//                //Set the local destination for the downloaded file to a path within the application's external files directory
//
////                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_MOVIES, "Offline"); // for public destination
//                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_MOVIES, "offlinevideos");
//
//                android.app.DownloadManager downloadManager = (android.app.DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//
//                downloadID = downloadManager.enqueue(request);
//
//
////  another download code
//
////                 enqueue puts the download request in the queue.
////endshere
//
//////  another download code
//
////
////                downloadHelper.prepare(new DownloadHelper.Callback() {
////                    @Override
////                    public void onPrepared(DownloadHelper helper) {
////                        // Preparation completes. Now other DownloadHelper methods can be called.
////                        DownloadHelper myDownloadHelper = helper;
////                        for (int i = 0; i < helper.getPeriodCount(); i++) {
////                            TrackGroupArray trackGroups = helper.getTrackGroups(i);
////                            for (int j = 0; j < trackGroups.length; j++) {
////                                TrackGroup trackGroup = trackGroups.get(j);
////                                for (int k = 0; k < trackGroup.length; k++) {
////                                    Format track = trackGroup.getFormat(k);
////                                    if (shouldDownload(track)) {
////                                        TrackKey trackKeys = null;
////                                        trackKeys.add(new TrackKey(trackGroups, trackGroup, track));
////                                    }
////                                }
////                            }
////                        }
////
////
////                    }
////
////                    @Override
////                    public void onPrepareError(DownloadHelper helper, IOException e) {
////                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
////                    }
////
////
////                });
////
////                TrackKey trackKey=null;
////                DefaultTrackSelector.Parameters qualityParams = ((DefaultTrackSelector) trackSelector).getParameters().buildUpon()
////                        .setMaxVideoSize(trackKey.getTrackFormat().width, trackKey.getTrackFormat().height)
////                        .setMaxVideoBitrate(trackKey.getTrackFormat().bitrate)
////                        .build();
////                DownloadHelper helper=null;
////                for (int periodIndex = 0; periodIndex < helper.getPeriodCount(); periodIndex++) {
////                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo = helper.getMappedTrackInfo(/* periodIndex= */ periodIndex);
////                    helper.clearTrackSelections(periodIndex);
////                    for (int i = 0; i < mappedTrackInfo.getRendererCount(); i++) {
//////                        TrackGroupArray rendererTrackGroups = mappedTrackInfo.getTrackGroups(i);
////                        helper.addTrackSelection(
////                                periodIndex,
////                                qualityParams);
////                    }
////
////                }
////
////
////
////                downloadRequest = helper.getDownloadRequest(Util.getUtf8Bytes(filepath));
////                if (downloadRequest.streamKeys.isEmpty()) {
////                    // All tracks were deselected in the dialog. Don't start the download.
////                    return;
////                }
////
////
////                downloadManager.addDownload(downloadRequest);
//
//            }
//        });
//        download

//endshere
        try {
            long time = playerView.getPlayer().getCurrentPosition();
            Log.d("time", String.valueOf(time));
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

////
        ImageView farwordBtn = playerView.findViewById(R.id.fwd);
        ImageView rewBtn = playerView.findViewById(R.id.rew);
        ImageView setting = playerView.findViewById(R.id.exo_track_selection_view);
        ImageView speedBtn = playerView.findViewById(R.id.exo_playback_speed);
        TextView speedTxt = playerView.findViewById(R.id.speed);
//        ImageView pip=playerView.findViewById(R.id.pip);

        speedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("Set Speed");
                builder.setItems(speed, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // the user clicked on colors[which]

                        if (which == 0) {

                            speedTxt.setVisibility(View.VISIBLE);
                            speedTxt.setText("0.25X");
                            PlaybackParameters param = new PlaybackParameters(0.5f);
                            simpleExoPlayer.setPlaybackParameters(param);


                        }
                        if (which == 1) {

                            speedTxt.setVisibility(View.VISIBLE);
                            speedTxt.setText("0.5X");
                            PlaybackParameters param = new PlaybackParameters(0.5f);
                            simpleExoPlayer.setPlaybackParameters(param);


                        }
                        if (which == 2) {

                            speedTxt.setVisibility(View.GONE);
                            PlaybackParameters param = new PlaybackParameters(1f);
                            simpleExoPlayer.setPlaybackParameters(param);


                        }
                        if (which == 3) {
                            speedTxt.setVisibility(View.VISIBLE);
                            speedTxt.setText("1.5X");
                            PlaybackParameters param = new PlaybackParameters(1.5f);
                            simpleExoPlayer.setPlaybackParameters(param);

                        }
                        if (which == 4) {


                            speedTxt.setVisibility(View.VISIBLE);
                            speedTxt.setText("2X");

                            PlaybackParameters param = new PlaybackParameters(2f);
                            simpleExoPlayer.setPlaybackParameters(param);


                        }


                    }
                });
                builder.show();


            }
        });


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

//        ImageView fullscreenButton = playerView.findViewById(R.id.fullscreen);

//        fullscreenButton.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SourceLockedOrientationActivity")
//            @Override
//            public void onClick(View view) {
//
//
//                int orientation = Player.this.getResources().getConfiguration().orientation;
//                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
//                    // code for portrait mode
//
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//
//                } else {
//                    // code for landscape mode
//
//                    Toast.makeText(Player.this, "Land", Toast.LENGTH_SHORT).show();
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//
//                }
//
//
//            }
//        });


        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fullscreen) {
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.full_screen));
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().show();
                    }
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) playerView.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = (int) (200 * getApplicationContext().getResources().getDisplayMetrics().density);
                    playerView.setLayoutParams(params);
                    fullscreen = false;
//                    videotitle.setVisibility(View.VISIBLE);
//                    videodesc.setVisibility(View.VISIBLE);
                } else {
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.full_screen));
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().hide();
                    }
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) playerView.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = params.MATCH_PARENT;
                    playerView.setLayoutParams(params);
                    fullscreen = true;
//                    videotitle.setVisibility(View.INVISIBLE);
//                    videodesc.setVisibility(View.INVISIBLE);
                }
            }
        });


        findViewById(R.id.exo_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                simpleExoPlayer.play();

            }
        });
        findViewById(R.id.exo_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                simpleExoPlayer.pause();

            }
        });


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

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowingTrackSelectionDialog
                        && TrackSelectionDialog.willHaveContent(trackSelector)) {
                    isShowingTrackSelectionDialog = true;
                    TrackSelectionDialog trackSelectionDialog =
                            TrackSelectionDialog.createForTrackSelector(
                                    trackSelector,
                                    /* onDismissListener= */ dismissedDialog -> isShowingTrackSelectionDialog = false);
                    trackSelectionDialog.show(getSupportFragmentManager(), null);


                }

//              pip.setOnClickListener(new View.OnClickListener() {
//                  @Override
//                  public void onClick(View v) {
//
//
//                  }
//              });

            }
        });


    }


    private void postwatchlist() {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

//        String Url = "https://www.api.playflixx.com/" + user + "/moviewatchlater/" + vid;
        String Url = "https://api.fluntoo.com/movie/" + user + "/moviewatchlater/" + vid;
        Log.d("Postwatch", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FlixwatchlaterInterface flixwatchlaterInterface = retrofit.create(FlixwatchlaterInterface.class);
        Call<FlixLatest> call = flixwatchlaterInterface.postwatchlater(Url);
        call.enqueue(new Callback<FlixLatest>() {
            @Override
            public void onResponse(Call<FlixLatest> call, Response<FlixLatest> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT);

            }

            @Override
            public void onFailure(Call<FlixLatest> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT);
            }
        });


    }

    private void getwatch() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://www.api.playflixx.com/" + user + "/watchedTime/" + vid;
        Log.d("Post", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        ContinueWatchingInterface continueWatchingInterface=retrofit.create(ContinueWatchingInterface.class);
//        Call<WatchTime> call=continueWatchingInterface.getwatchtime(Url,);
//        call.enqueue(new Callback<WatchTime>() {
//            @Override
//            public void onResponse(Call<WatchTime> call, Response<WatchTime> response) {
//                Toast.makeText(getApplicationContext(),"Succesful",Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<WatchTime> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }

    private void getrecommended() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/movie/rightsiderecommended/" + user + "/" + vid;
        Log.d("url", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FlixREcommendedInterface flixREcommendedInterface = retrofit.create(FlixREcommendedInterface.class);
        Call<List<MovieRecommended>> call = flixREcommendedInterface.getrec(Url);
        call.enqueue(new Callback<List<MovieRecommended>>() {
            @Override
            public void onResponse(Call<List<MovieRecommended>> call, Response<List<MovieRecommended>> response) {
                movieRecommendedList.clear();
                movieRecommendedList.addAll(response.body());
                adapter.notifyDataSetChanged();
//                shimmerrec.stopShimmerAnimation();
//                shimmerrec.setVisibility(View.GONE);


            }

            @Override
            public void onFailure(Call<List<MovieRecommended>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onUserLeaveHint() {
        PictureInPictureParams pipp = new PictureInPictureParams.Builder()
                .setAspectRatio(new Rational(2, 1))
                .build();
        enterPictureInPictureMode(pipp);

        super.onUserLeaveHint();
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (isInPictureInPictureMode)

//            getSupportActionBar().hide();
            if (isInPictureInPictureMode) {
                rewBtn.setVisibility(View.INVISIBLE);
                speedBtn.setVisibility(View.INVISIBLE);
                farwordBtn.setVisibility(View.INVISIBLE);
                setting.setVisibility(View.INVISIBLE);
                pipflix.setVisibility(View.INVISIBLE);
                fullscreenButton.setVisibility(View.INVISIBLE);

            }
        if (!isInPictureInPictureMode) {
            rewBtn.setVisibility(View.VISIBLE);
            speedBtn.setVisibility(View.VISIBLE);
            farwordBtn.setVisibility(View.VISIBLE);
            setting.setVisibility(View.VISIBLE);
            pipflix.setVisibility(View.VISIBLE);
            fullscreenButton.setVisibility(View.VISIBLE);
        }

        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

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
    public void onBackPressed() {
        super.onBackPressed();


    }

    private void encryptFile(String filepath) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeyException {
        int read;

        FileInputStream fis = new FileInputStream(new File(videov));
        File outfile = new File(Environment.getExternalStorageDirectory() + "/" + "name" + "/" + "test2_enc.mp4");
        if (!outfile.exists())
            outfile.createNewFile();

        FileOutputStream fos = new FileOutputStream(outfile);

        Cipher encipher = Cipher.getInstance("AES");

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        //byte key[] = {0x00,0x32,0x22,0x11,0x00,0x00,0x00,0x00,0x00,0x23,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
        SecretKey skey = kgen.generateKey();

        encipher.init(Cipher.ENCRYPT_MODE, skey);
        CipherInputStream cis = new CipherInputStream(fis, encipher);

        byte[] buffer = new byte[1024]; // buffer can read file line by line to increase speed
        while ((read = cis.read(buffer)) >= 0) {
            fos.write(buffer, 0, read);
            fos.flush();
        }
        fos.close();
        Toast.makeText(this, "File encrypted", Toast.LENGTH_SHORT).show();

        //call method for decrypt file.
        decryptFile(Environment.getExternalStorageDirectory() + "/" + "name" + "/" + "test_enc.mp4", skey);
    }


    private void decryptFile(String encryptFilePath, SecretKey secretKey) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        int read;
        File outfile = new File(encryptFilePath);
        File decfile = new File(Environment.getExternalStorageDirectory() + "/" + "name" + "/" + "test_dec.mp4");
        if (!decfile.exists())
            decfile.createNewFile();

        FileOutputStream decfos = new FileOutputStream(decfile);
        FileInputStream encfis = new FileInputStream(outfile);

        Cipher decipher = Cipher.getInstance("AES");

        decipher.init(Cipher.DECRYPT_MODE, secretKey);
        CipherOutputStream cos = new CipherOutputStream(decfos, decipher);

        byte[] buffer = new byte[1024]; // buffer can read file line by line to increase speed
        while ((read = encfis.read(buffer)) >= 0) {
            cos.write(buffer, 0, read);
            cos.flush();
        }
        cos.close();
        Toast.makeText(this, "File decrypted", Toast.LENGTH_SHORT).show();
    }


    private boolean shouldDownload(Format track) {
        return track.height != 240 && track.sampleMimeType.equalsIgnoreCase("video/avc");
    }

}