package com.fluntoo.zenberry;

import android.app.PictureInPictureParams;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Rational;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.Adapter.WebEpisodeAdapter;
import com.fluntoo.zenberry.Adapter.WebRecommendedAdapter;
import com.fluntoo.zenberry.ApIInterface.WebRecommendedInterface;
import com.fluntoo.zenberry.ApIInterface.WebseriesInterface;
import com.fluntoo.zenberry.Model.WebEpisodes;
import com.fluntoo.zenberry.Model.WebRecommended;
import com.fluntoo.zenberry.Model.WebSeasons;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebseriesPlayerActivity extends AppCompatActivity {

    String videopath;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    private boolean isShowingTrackSelectionDialog;
    private DefaultTrackSelector trackSelector;
    String[] speed = {"0.25x", "0.5x", "Normal", "1.5x", "2x"};
    PlayerView playerView;
    SimpleExoPlayer simpleExoPlayer;

    boolean fullscreen = false;
    ImageView farwordBtn, rewBtn, setting, speedBtn, pipweb;
    TextView speedTxt;
    ImageView fullscreenButton;
    Spinner spinner;

    RecyclerView edprecyclerview;
    List<WebEpisodes> epdlist = new ArrayList<>();
    WebEpisodeAdapter epdadapter;

    RecyclerView recyclerView;
    List<WebRecommended> webRecommendedList = new ArrayList<>();
    WebRecommendedAdapter adapter;

    String titlestr, imgstr, genresstr, restr, datestr, descstr, caststr, webidstr, videopath1;
    String epid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webseries_player2);

        edprecyclerview = findViewById(R.id.web_episodes_recyclerview);
        recyclerView = findViewById(R.id.recyclerview_recommended_web);
        playerView = findViewById(R.id.exoPlayerView_web);
        fullscreenButton = playerView.findViewById(R.id.fullscreen);
        farwordBtn = playerView.findViewById(R.id.fwd);
        rewBtn = playerView.findViewById(R.id.rew);
        setting = playerView.findViewById(R.id.exo_track_selection_view);
        speedBtn = playerView.findViewById(R.id.exo_playback_speed);
        speedTxt = playerView.findViewById(R.id.speed);
        pipweb = findViewById(R.id.pipweb);

        spinner = findViewById(R.id.spinner);

        Intent intent = getIntent();
        videopath = intent.getStringExtra("videopath");


//        Intent intent2 = getIntent();
//        titlestr = intent.getStringExtra("title");
//        genresstr = intent.getStringExtra("genres");
//        imgstr = intent.getStringExtra("image");
//        restr = intent.getStringExtra("res");
//        descstr = intent.getStringExtra("desc");
//        caststr = intent.getStringExtra("cast");
//        webidstr = intent.getStringExtra("id");
//        videopath = intent.getStringExtra("videopath");
//        datestr = intent.getStringExtra("date");

        trackSelector = new DefaultTrackSelector(this);
        simpleExoPlayer = new SimpleExoPlayer.Builder(this).setTrackSelector(trackSelector).build();
//        playerView = findViewById(R.id.exoPlayerViewweb);
        playerView.setPlayer(simpleExoPlayer);


        MediaItem mediaItem = MediaItem.fromUri(videopath);
        simpleExoPlayer.addMediaItem(mediaItem);
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();

        ImageView farwordBtn = playerView.findViewById(R.id.fwd);
        ImageView rewBtn = playerView.findViewById(R.id.rew);
        ImageView setting = playerView.findViewById(R.id.exo_track_selection_view);
        ImageView speedBtn = playerView.findViewById(R.id.exo_playback_speed);
        TextView speedTxt = playerView.findViewById(R.id.speed);
//        ImageView pip=playerView.findViewById(R.id.pip);

        Intent intent3 = getIntent();
        epid = intent3.getStringExtra("epdid");

        getseason();


        LinearLayoutManager linearLayoutManagerTre = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        edprecyclerview.setLayoutManager(linearLayoutManagerTre);
        epdadapter = new WebEpisodeAdapter(getApplicationContext(), epdlist);
        edprecyclerview.setAdapter(epdadapter);
        epd();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new WebRecommendedAdapter(getApplicationContext(), webRecommendedList);
        recyclerView.setAdapter(adapter);
        getrecommended();


        pipweb.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                PictureInPictureParams pipp = new PictureInPictureParams.Builder()
                        .setAspectRatio(new Rational(2, 1))
                        .build();
                enterPictureInPictureMode(pipp);

            }
        });


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

    private void getrecommended() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();


        String Url = " https://api.fluntoo.com/movie/rightsiderecommended/" + user + "/" + epid;
        Log.d("urlcheck", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebRecommendedInterface webRecommendedInterface = retrofit.create(WebRecommendedInterface.class);
        Call<List<WebRecommended>> call = webRecommendedInterface.getwebrec(Url);
        call.enqueue(new Callback<List<WebRecommended>>() {
            @Override
            public void onResponse(Call<List<WebRecommended>> call, Response<List<WebRecommended>> response) {
                webRecommendedList.clear();
                webRecommendedList.addAll(response.body());
                adapter.notifyDataSetChanged();
//                shimmerrec.stopShimmerAnimation();
//                shimmerrec.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<WebRecommended>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void epd() {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String end = spinner.getSelectedItem().toString();
                Log.d("hm", end);
//                Toast.makeText(getApplicationContext(), end, Toast.LENGTH_SHORT).show();
                String Url = "https://api.fluntoo.com/webseries/WebSeries/GetEpisode/" + end;
                Log.d("check", Url);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                WebseriesInterface webseriesInterface = retrofit.create(WebseriesInterface.class);
                Call<List<WebEpisodes>> call = webseriesInterface.getepds(Url);
                call.enqueue(new Callback<List<WebEpisodes>>() {
                    @Override
                    public void onResponse(Call<List<WebEpisodes>> call, Response<List<WebEpisodes>> response) {
                        if (response.isSuccessful()) {
                            epdlist.clear();
                            epdlist.addAll(response.body());
                            epdadapter.notifyDataSetChanged();
//                            shimmerepd.stopShimmerAnimation();
//                            shimmerepd.setVisibility(View.GONE);

                        } else {
                            Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<List<WebEpisodes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                String end = spinner.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), end, Toast.LENGTH_LONG).show();
                Log.d("hm", end);

                String Url = "https://api.fluntoo.com/webseries/WebSeries/GetEpisode/" + end;
                Log.d("check", Url);


//

            }


        });
    }

    private void getseason() {

        SharedPreferences sh = getSharedPreferences("MySharedPref", 0);

// The value will be default as empty string because for
// the very first time when the app is opened, there is nothing to show
        String s1 = sh.getString("name", "null");

        String Url = "https://api.fluntoo.com/webseries/WebSeries/GetSeason/" + s1;
        Log.d("url", Url);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebseriesInterface webseriesInterface = retrofit.create(WebseriesInterface.class);
        Call<List<WebSeasons>> call = webseriesInterface.getseason(Url);
        call.enqueue(new Callback<List<WebSeasons>>() {
            @Override
            public void onResponse(Call<List<WebSeasons>> call, Response<List<WebSeasons>> response) {

                if (response.isSuccessful()) {
                    ArrayList<String> nameList = new ArrayList<>();
//                 getresponse=response.body().toString();
                    for (int i = 0; i < response.body().size(); i++) {


//                    WebSeasons seasons = new WebSeasons();
//                    String name= seasons.getSeasonName();
                        nameList.add(response.body().get(i).getSeasonName());
                        String imc_met = response.body().get(0).getSeasonName();
//                    Log.d("name", name);
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, nameList);
                    spinner.setAdapter(adapter);


                } else {
                    Toast.makeText(getApplicationContext(), "season empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WebSeasons>> call, Throwable t) {

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
                pipweb.setVisibility(View.INVISIBLE);
                fullscreenButton.setVisibility(View.INVISIBLE);
            }

        if (!isInPictureInPictureMode) {
            rewBtn.setVisibility(View.VISIBLE);
            speedBtn.setVisibility(View.VISIBLE);
            farwordBtn.setVisibility(View.VISIBLE);
            setting.setVisibility(View.VISIBLE);
            pipweb.setVisibility(View.VISIBLE);
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
}