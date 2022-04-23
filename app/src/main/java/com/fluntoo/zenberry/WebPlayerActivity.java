package com.fluntoo.zenberry;

import android.app.PictureInPictureParams;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;

//import com.example.playflix.R;

public class WebPlayerActivity extends AppCompatActivity {

    String videopath;

    private boolean isShowingTrackSelectionDialog;
    private DefaultTrackSelector trackSelector;
    String[] speed = {"0.25x", "0.5x", "Normal", "1.5x", "2x"};
    PlayerView playerView;
    SimpleExoPlayer simpleExoPlayer;
//    String url = "https://www.data.playflixx.com/PlayflixxData/16/Play/Channel/one/Video/Video_MainFile/SarfarazVideo/SarfarazVideo.mpd";


    public static final String TAG = "TAG";

    boolean fullscreen = false;
    ImageView farwordBtn, rewBtn, setting, speedBtn, pipweb;
    TextView speedTxt;
    ImageView fullscreenButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webseries_player);

        playerView = findViewById(R.id.exoPlayerView_web);
        fullscreenButton = playerView.findViewById(R.id.fullscreen);
        farwordBtn = playerView.findViewById(R.id.fwd);
        rewBtn = playerView.findViewById(R.id.rew);
        setting = playerView.findViewById(R.id.exo_track_selection_view);
        speedBtn = playerView.findViewById(R.id.exo_playback_speed);
        speedTxt = playerView.findViewById(R.id.speed);
        pipweb = findViewById(R.id.pipweb);

        Intent intent = getIntent();
        videopath = intent.getStringExtra("videopath");


        trackSelector = new DefaultTrackSelector(this);
        simpleExoPlayer = new SimpleExoPlayer.Builder(this).setTrackSelector(trackSelector).build();
//        playerView = findViewById(R.id.exoPlayerViewweb);
        playerView.setPlayer(simpleExoPlayer);


        MediaItem mediaItem = MediaItem.fromUri(videopath);
        simpleExoPlayer.addMediaItem(mediaItem);
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();

//        ImageView farwordBtn = playerView.findViewById(R.id.fwd);
//        ImageView rewBtn = playerView.findViewById(R.id.rew);
//        ImageView setting = playerView.findViewById(R.id.exo_track_selection_view);
//        ImageView speedBtn = playerView.findViewById(R.id.exo_playback_speed);
//        TextView speedTxt = playerView.findViewById(R.id.speed);


        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
        params.width = params.MATCH_PARENT;
        params.height = params.MATCH_PARENT;
        playerView.setLayoutParams(params);
        fullscreen = true;


        speedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(WebPlayerActivity.this);
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


//        ImageView fullscreenButton = playerView.findViewById(R.id.fullscreen);

//        fullscreenButton.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SourceLockedOrientationActivity")
//            @Override
//            public void onClick(View view) {
//
//
//                int orientation = WebTrailActivity.this.getResources().getConfiguration().orientation;
//                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
//                    // code for portrait mode
//
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//
//                } else {
//                    // code for landscape mode
//
//                    Toast.makeText(getApplicationContext(), "Land", Toast.LENGTH_SHORT).show();
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//
//                }
//
//
//            }
//        });


//        fullscreenButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (fullscreen) {
//                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.full_screen));
//                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
//                    if (getSupportActionBar() != null) {
//                        getSupportActionBar().show();
//                    }
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
//                    params.width = params.MATCH_PARENT;
//                    params.height = (int) (200 * getApplicationContext().getResources().getDisplayMetrics().density);
//                    playerView.setLayoutParams(params);
//                    fullscreen = false;
////                    videotitle.setVisibility(View.VISIBLE);
////                    videodesc.setVisibility(View.VISIBLE);
//                } else {
//                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.full_screen));
//                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
//                    if (getSupportActionBar() != null) {
//                        getSupportActionBar().hide();
//                    }
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
//                    params.width = params.MATCH_PARENT;
//                    params.height = params.MATCH_PARENT;
//                    playerView.setLayoutParams(params);
//                    fullscreen = true;


//                    videotitle.setVisibility(View.INVISIBLE);
//                    videodesc.setVisibility(View.INVISIBLE);
//                    dropdown.setVisibility(View.INVISIBLE);
//                    dropup.setVisibility(View.INVISIBLE);
//                    tag.setVisibility(View.INVISIBLE);
//                    likebtn.setVisibility(View.INVISIBLE);
//                    dislikebtn.setVisibility(View.INVISIBLE);
//                    sharebtn.setVisibility(View.INVISIBLE);
//                }
//            }
//        });


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
//                fullscreenButton.setVisibility(View.INVISIBLE);

            }
        if (!isInPictureInPictureMode) {
            rewBtn.setVisibility(View.VISIBLE);
            speedBtn.setVisibility(View.VISIBLE);
            farwordBtn.setVisibility(View.VISIBLE);
            setting.setVisibility(View.VISIBLE);
            pipweb.setVisibility(View.VISIBLE);
//            fullscreenButton.setVisibility(View.VISIBLE);
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


}