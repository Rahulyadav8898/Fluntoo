package com.fluntoo.zenberry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.Adapter.CategoryRecommendedAdapter;
import com.fluntoo.zenberry.ApIInterface.VideoPlayInterface;
import com.fluntoo.zenberry.Model.Category;
//import com.example.playflix.R;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
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

public class CategoryPlayerActivity extends AppCompatActivity {

    TextView videodesc, videotitle, Vidview, videochannelname, likes, dislikes, tag,subs;
    ImageView video_img;
    EditText comment_edt;
    Switch commentswitch;

    String videod;
    String videov;
    String videot;
    String vviews;
    String video_channel_name;
    String channel_poster;
    String vlikes;
    String vdislikes;
    String vtag;
    String vsubs;
    String vid;
    private boolean isShowingTrackSelectionDialog;
    private DefaultTrackSelector trackSelector;
    String[] speed = {"0.25x", "0.5x", "Normal", "1.5x", "2x"};
    PlayerView playerView;
    SimpleExoPlayer simpleExoPlayer;
    ImageView dropdown, dropup;
    ImageView sharebtn;

    public static final String TAG = "TAG";

    boolean fullscreen = false;
    String Url;

    RecyclerView recyclerView_cat_rec;
    List<Category> clist = new ArrayList<>();
    //        List<Video> videoList=new ArrayList<>();
    CategoryRecommendedAdapter categoryRecommendedAdapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_player);
        comment_edt = findViewById(R.id.edt_comment);
        commentswitch = findViewById(R.id.comment_switch);
        videodesc = findViewById(R.id.videoDesc);
        videotitle = findViewById(R.id.videoTitleo);
        Vidview = findViewById(R.id.views_tv);
        sharebtn = findViewById(R.id.share_btn);
        video_img = findViewById(R.id.channel_img);
        videochannelname = findViewById(R.id.channel_nametv);


        dropdown = findViewById(R.id.dropdown);
        dropup = findViewById(R.id.dropup);

//        playerView=findViewById(R.id.exoPlayerView);
//        videoView = findViewById(R.id.videoView);


        Intent intent = getIntent();
        videod = intent.getStringExtra("videodesc");
        videot = intent.getStringExtra("videotitle");
        videov = intent.getStringExtra("videoview");

        vviews = intent.getStringExtra("views").toString();
        channel_poster = intent.getStringExtra("img_channel");
        video_channel_name = intent.getStringExtra("channel_title");
        vlikes = intent.getStringExtra("likes");
        vdislikes = intent.getStringExtra("dislikes");
        vtag = intent.getStringExtra("videoTags");
        vid = intent.getStringExtra("videoId");
        vsubs=intent.getStringExtra("subscribed");


//        videodesc.setText(videod);

        videotitle.setText(videot);
        Vidview.setText(vviews + " views");
        videochannelname.setText(video_channel_name);
        Glide.with(getApplicationContext())
                .load(channel_poster)
                .into(video_img);
//        likes.setText(vlikes + " likes");
//        dislikes.setText(vdislikes + " dislikes");
//        tag.setText("#" + vtag);
//        subs.setText(vsubs);


        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });



        recyclerviewdata();

        dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dropdown.setVisibility(View.INVISIBLE);
                videodesc.setText(videod);
                dropup.setVisibility(View.VISIBLE);
                videodesc.setVisibility(View.VISIBLE);


            }
//

        });
        dropup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropup.setVisibility(View.GONE);
                dropdown.setVisibility(View.VISIBLE);
                videodesc.setVisibility(View.GONE);
            }
        });

//        dropdown.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                videodesc.setText(videod);
//                dropdown.setVisibility(View.INVISIBLE);
//                dropup.setVisibility(View.VISIBLE);
//
//            }
//        });

//        dropup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                videodesc.setVisibility(View.INVISIBLE);
//                dropdown.setVisibility(View.VISIBLE);
//                dropup.setVisibility(View.INVISIBLE);
//            }
//        });


//
        trackSelector = new DefaultTrackSelector(this);
        simpleExoPlayer = new SimpleExoPlayer.Builder(this).setTrackSelector(trackSelector).build();
        playerView = findViewById(R.id.exoPlayerView);
        playerView.setPlayer(simpleExoPlayer);


        MediaItem mediaItem = MediaItem.fromUri(videov);
        simpleExoPlayer.addMediaItem(mediaItem);
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();

        ImageView farwordBtn = playerView.findViewById(R.id.fwd);
        ImageView rewBtn = playerView.findViewById(R.id.rew);
        ImageView setting = playerView.findViewById(R.id.exo_track_selection_view);
        ImageView speedBtn = playerView.findViewById(R.id.exo_playback_speed);
        TextView speedTxt = playerView.findViewById(R.id.speed);

        speedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(CategoryPlayerActivity.this);
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

        ImageView fullscreenButton = playerView.findViewById(R.id.fullscreen);

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
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(CategoryPlayerActivity.this, R.drawable.full_screen));
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().show();
                    }
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = (int) (200 * getApplicationContext().getResources().getDisplayMetrics().density);
                    playerView.setLayoutParams(params);
                    fullscreen = false;
                    videotitle.setVisibility(View.VISIBLE);
                    videodesc.setVisibility(View.VISIBLE);
                } else {
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(CategoryPlayerActivity.this, R.drawable.full_screen));
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
                    videotitle.setVisibility(View.INVISIBLE);
                    videodesc.setVisibility(View.INVISIBLE);
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


        simpleExoPlayer.addListener(new Player.Listener() {
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

    private void share() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
        share.putExtra(Intent.EXTRA_TEXT, Url);

        startActivity(Intent.createChooser(share, "Share link!"));
    }

    private void recyclerviewdata() {


        recyclerView_cat_rec = findViewById(R.id.recylerview_rec);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView_cat_rec.setLayoutManager(layoutManager);
        categoryRecommendedAdapter = new CategoryRecommendedAdapter(getApplicationContext(), clist);
        recyclerView_cat_rec.setAdapter(categoryRecommendedAdapter);
        data();


    }

    private void data() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideoPlayInterface videoPlayInterface = retrofit.create(VideoPlayInterface.class);
        Call<List<Category>> call = videoPlayInterface.getCategory("description");
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                clist.clear();
                clist.addAll(response.body());
//                CategoryRecommendedAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


//
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