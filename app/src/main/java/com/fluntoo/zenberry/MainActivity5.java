package com.fluntoo.zenberry;

import android.annotation.SuppressLint;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.fluntoo.zenberry.Adapter.CommentAdapter;
import com.fluntoo.zenberry.Adapter.PlayerRecomendationAdapter;
import com.fluntoo.zenberry.ApIInterface.CommentsInterface;
import com.fluntoo.zenberry.ApIInterface.DislikeInterface;
import com.fluntoo.zenberry.ApIInterface.LikeInterface;
import com.fluntoo.zenberry.ApIInterface.PlayerRecomendationInterface;
import com.fluntoo.zenberry.ApIInterface.SubscribeInterface;
import com.fluntoo.zenberry.ApIInterface.ViewsInterface;
import com.fluntoo.zenberry.ApIInterface.WatchLAterINterface;
import com.fluntoo.zenberry.Model.Comments;
import com.fluntoo.zenberry.Model.Dislike;
import com.fluntoo.zenberry.Model.GetComments;
import com.fluntoo.zenberry.Model.Likes;
import com.fluntoo.zenberry.Model.PlayerRecommendation;
import com.fluntoo.zenberry.Model.PostItem;
import com.fluntoo.zenberry.Model.Views;
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

public class MainActivity5 extends AppCompatActivity {
    TextView videodesc, videotitle, videochannelname, Vidview, likes, dislikes, tag, subs, subscribetv, subdcribedtv;
    ImageView video_img;
    EditText comment_edt;

    String videod, videov, videot;
    String vviews;
    String vtag;
    String vid;
    String vsubs;
    int cvid;
    int vlikes, vdislikes;
    String video_channel_name;
    String channel_poster;
    private boolean isShowingTrackSelectionDialog;
    private DefaultTrackSelector trackSelector;
    String[] speed = {"0.25x", "0.5x", "Normal", "1.5x", "2x"};
    PlayerView playerView;
    SimpleExoPlayer simpleExoPlayer;
//    String url = "https://www.data.playflixx.com/PlayflixxData/16/Play/Channel/one/Video/Video_MainFile/SarfarazVideo/SarfarazVideo.mpd";


    public static final String TAG = "TAG";


    boolean fullscreen = false;

    //    EditTe,subxt comment_edt;
    Switch commentswitch;
    ImageView dropdown, dropup;
    ImageView sharebtn;
    ImageView pip;

    ImageView dislike1btn, like1btn, subbell, subbell1, watchlater, downloadbtn;
    Boolean isLogin = false;
    CardView cardview;


    public static final String MY_PREFS_NAME = "MyPrefsFile";

    RecyclerView recyclerView;
    List<PlayerRecommendation> recommendationList = new ArrayList<>();
    PlayerRecomendationAdapter adapter;
    ImageView sendcom, likebtn, dislikebtn, reportbtn;

    RecyclerView recyclerViewcomment;
    List<GetComments> commentsList = new ArrayList<>();
    CommentAdapter commentAdapter;

    Integer sid;

    String Url;
    String vidcat;

    String chdid;

    String channeldyanmicid;

    String li;
    String dis;
    String view;
    ProgressBar progressBarrec;
    ShimmerFrameLayout shrimmerec;

    ImageView farwordBtn, rewBtn, setting, speedBtn;
    TextView speedTxt;
    ImageView fullscreenButton;

    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        playerView = findViewById(R.id.exoPlayerView);
        farwordBtn = playerView.findViewById(R.id.fwd);
        rewBtn = playerView.findViewById(R.id.rew);
        setting = playerView.findViewById(R.id.exo_track_selection_view);
        speedBtn = playerView.findViewById(R.id.exo_playback_speed);
        speedTxt = playerView.findViewById(R.id.speed);
        fullscreenButton = playerView.findViewById(R.id.fullscreen);

//        shrimmerec = findViewById(R.id.shimmer_player_rec);
//        shrimmerec.startShimmerAnimation();
        watchlater = findViewById(R.id.watchlater_btn);
        subdcribedtv = findViewById(R.id.subscribed_tv);
        subbell1 = findViewById(R.id.sub_bell1);
        subbell = findViewById(R.id.sub_bell);
        reportbtn = findViewById(R.id.report_btn);
        pip = findViewById(R.id.pip);
        sendcom = findViewById(R.id.commentsend_btn);
        subs = findViewById(R.id.subs_tv);
        tag = findViewById(R.id.tag_tv);
        sharebtn = findViewById(R.id.share_btn);
        comment_edt = findViewById(R.id.edt_commentp);
        commentswitch = findViewById(R.id.comment_switch);
        dropdown = findViewById(R.id.dropdown);
        dropup = findViewById(R.id.dropup);
        likes = findViewById(R.id.likes_tv);
        dislikes = findViewById(R.id.dilikes_tv);
        likebtn = findViewById(R.id.like_btn);
        dislikebtn = findViewById(R.id.dislike_btn);
        Vidview = findViewById(R.id.views_tv);
        video_img = findViewById(R.id.channel_img);
        videochannelname = findViewById(R.id.channel_nametv);
        dislike1btn = findViewById(R.id.dislikedd1btn);
        like1btn = findViewById(R.id.likedd1btn);
        subscribetv = findViewById(R.id.subscribe_tv);
        cardview = findViewById(R.id.cardviewplayer);

        videodesc = findViewById(R.id.videoDesc);
        videotitle = findViewById(R.id.videoTitleo);
//        playerView=findViewById(R.id.exoPlayerView);
//        videoView = findViewById(R.id.videoView);
        recyclerView = findViewById(R.id.recommend_player_recyclerview);
        recyclerViewcomment = findViewById(R.id.recyclerview_comment);


        Intent intent = getIntent();
        videod = intent.getStringExtra("videodesc");
        videot = intent.getStringExtra("videotitle");
        videov = intent.getStringExtra("videoview");
        vviews = intent.getStringExtra("views").toString();
        channel_poster = intent.getStringExtra("img_channel");
        video_channel_name = intent.getStringExtra("channel_title");
        vlikes = intent.getIntExtra("likes", 0);
        vdislikes = intent.getIntExtra("dislikes", 0);
        vtag = intent.getStringExtra("videoTags");
        vid = intent.getStringExtra("videoId");
        vsubs = intent.getStringExtra("subscribed");
        vidcat = intent.getStringExtra("videoCategory");
        cvid = intent.getIntExtra("channelid", 0);
        chdid = intent.getStringExtra("channeldyanmicid");
        channeldyanmicid = chdid;
        sid = cvid;

//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new PlayerRecomendationAdapter(recommendationList, getApplicationContext());
//        recyclerView.setAdapter(adapter);
//        listdata();

//        Toast.makeText(getApplicationContext(), sid, Toast.LENGTH_SHORT).show();

        subscribetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//
                SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {
                    getsubscribe();
                    subscribetv.setVisibility(View.GONE);
                    subdcribedtv.setVisibility(View.VISIBLE);

                } else {
//                    Toast.makeText(getApplicationContext(), "You are not logged in !!", Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity5.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not " +
                                    "Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), Login_Page.class));
                                    finish();
                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                }


            }

        });

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Channel_Name_Activity.class);
                intent1.putExtra("channeldyanmicid", channeldyanmicid);
//                intent1.getIntExtra("rah", sid);
                startActivity(intent1);

            }
        });

        watchlater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postwatchlater();
                SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {
                    postwatchlater();
                } else {
//                    Toast.makeText(getApplicationContext(), "You are not logged in !!", Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity5.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), Login_Page.class));
                                    finish();
                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();
                }
            }
        });

        subbell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {
                    bell();
                    subbell1.setVisibility(View.VISIBLE);
                    subbell.setVisibility(View.GONE);
                } else {
//                    Toast.makeText(getApplicationContext(), "You are not logged in !!", Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity5.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), Login_Page.class));
                                    finish();
                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                }


            }
        });

        postcoment();
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());
        recyclerViewcomment.setLayoutManager(layoutManager1);
        commentAdapter = new CommentAdapter(commentsList, getApplicationContext());
        recyclerViewcomment.setAdapter(commentAdapter);
        getcomment();

//

//        reportbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "https://fluntoo.com/report";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });

//


        commentswitch.setChecked(false);
        commentswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    comment_edt.setVisibility(View.VISIBLE);
                    sendcom.setVisibility(View.VISIBLE);
                    recyclerViewcomment.setVisibility(View.VISIBLE);
                } else {


                    comment_edt.setVisibility(View.GONE);
                    sendcom.setVisibility(View.GONE);
                    recyclerViewcomment.setVisibility(View.GONE);
                }

            }
        });

        //check the current state before we display the screen


        Url = "https://fluntoo.com/VideoPlay/" + vid;
        Log.i("Tag", Url);

//        videodesc.setText(videod);
        videotitle.setText(videot);
        Vidview.setText(vviews + " views");
        view = vviews;
        Log.d("view", view);

        videochannelname.setText(video_channel_name);
        Glide.with(getApplicationContext())
                .load(channel_poster)
                .into(video_img);
        likes.setText(vlikes + " likes");
        li = String.valueOf(vlikes);
        Log.d("like", li);

        dislikes.setText(vdislikes + " dislikes");
        dis = String.valueOf(vdislikes);
        Log.d("dislike", dis);

        tag.setText("#" + vtag);
        subs.setText(vsubs);

//        likebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                postlike();
//            }
//        });


        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

        pip.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                PictureInPictureParams pipp = new PictureInPictureParams.Builder()
                        .setAspectRatio(new Rational(2, 1))
                        .build();
                enterPictureInPictureMode(pipp);
            }
        });

//
        trackSelector = new DefaultTrackSelector(this);
        simpleExoPlayer = new SimpleExoPlayer.Builder(this).setTrackSelector(trackSelector).build();
//        playerView = findViewById(R.id.exoPlayerView);
        playerView.setPlayer(simpleExoPlayer);


        MediaItem mediaItem = MediaItem.fromUri(videov);
        simpleExoPlayer.addMediaItem(mediaItem);
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();

        getViews();

//        ImageView farwordBtn = playerView.findViewById(R.id.fwd);
//        ImageView rewBtn = playerView.findViewById(R.id.rew);
//        ImageView setting = playerView.findViewById(R.id.exo_track_selection_view);
//        ImageView speedBtn = playerView.findViewById(R.id.exo_playback_speed);
//        TextView speedTxt = playerView.findViewById(R.id.speed);
//        ImageView pip=playerView.findViewById(R.id.pip);


        likebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {

                    dislike1btn.setVisibility(View.GONE);
                    dislikebtn.setVisibility(View.VISIBLE);
                    postlike();
                } else {
//                    Toast.makeText(getApplicationContext(), "You are not logged in !!", Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity5.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), Login_Page.class));
                                    finish();
                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                }


            }
        });

        dislikebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {
                    like1btn.setVisibility(View.GONE);
                    likebtn.setVisibility(View.VISIBLE);
                    postdislike();

                } else {
//                    Toast.makeText(getApplicationContext(), "You are not logged in !!", Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity5.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), Login_Page.class));
                                    finish();
                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                }

            }
        });

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


        speedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity5.this);
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
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(MainActivity5.this, R.drawable.full_screen));
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
//                    videotitle.setVisibility(View.VISIBLE);
//                    videodesc.setVisibility(View.VISIBLE);
                } else {
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(MainActivity5.this, R.drawable.full_screen));
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
//                    videotitle.setVisibility(View.INVISIBLE);
//                    videodesc.setVisibility(View.INVISIBLE);
//                    dropdown.setVisibility(View.INVISIBLE);
//                    dropup.setVisibility(View.INVISIBLE);
//                    tag.setVisibility(View.INVISIBLE);
//                    likebtn.setVisibility(View.INVISIBLE);
//                    dislikebtn.setVisibility(View.INVISIBLE);
//                    sharebtn.setVisibility(View.INVISIBLE);
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

    private void postwatchlater() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");


        String Url = "https://www.api.playflixx.com/" + user + "/watchlater/" + vid;
        Log.d("watch", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WatchLAterINterface watchLAterINterface = retrofit.create(WatchLAterINterface.class);
        Call<PostItem> call = watchLAterINterface.watchpost(Url);
        call.enqueue(new Callback<PostItem>() {
            @Override
            public void onResponse(Call<PostItem> call, Response<PostItem> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostItem> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void bell() {

        String belllicon = "on";
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");


        String Url = "https://www.api.playflixx.com/" + user + "/subscribe/" + cvid;
        Log.d("view", Url);
        long v = Long.parseLong(String.valueOf(user));
        long c = Long.parseLong(String.valueOf(cvid));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SubscribeInterface subscribeInterface = retrofit.create(SubscribeInterface.class);
        Call<PostItem> call = subscribeInterface.getbell(Url, "Bearer " + name,
                v, c, belllicon);
        call.enqueue(new Callback<PostItem>() {
            @Override
            public void onResponse(Call<PostItem> call, Response<PostItem> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostItem> call, Throwable t) {

//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void getsubscribe() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");


        String Url = "https://www.api.playflixx.com/" + user + "/subscribe/" + cvid;
        Log.d("urlview", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SubscribeInterface subscribeInterface = retrofit.create(SubscribeInterface.class);
        Call<PostItem> call = subscribeInterface.getsubcribe(Url, "Bearer " + name);
        call.enqueue(new Callback<PostItem>() {
            @Override
            public void onResponse(Call<PostItem> call, Response<PostItem> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostItem> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void getViews() {
        String Url = "https://www.api.playflixx.com/views/" + vid;
        Log.d("urlview", Url);

        long viewss = 1;
        long v = viewss + Long.parseLong(view);
        Log.d("v", String.valueOf(v));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ViewsInterface viewsInterface = retrofit.create(ViewsInterface.class);
        Call<Views> call = viewsInterface.putview(Url, v);
        call.enqueue(new Callback<Views>() {
            @Override
            public void onResponse(Call<Views> call, Response<Views> response) {


            }

            @Override
            public void onFailure(Call<Views> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getcomment() {
        Intent intent = getIntent();
        vid = intent.getStringExtra("videoId");

        String Url = "https://www.api.playflixx.com/videocomments/" + vid;
        Log.d("commenturl", Url);
//        String Url="https://www.api.playflixx.com/videocomments/Jl3T1tTSWOzhEg";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CommentsInterface commentsInterface = retrofit.create(CommentsInterface.class);
        Call<List<GetComments>> call = commentsInterface.getcomment(Url);
        call.enqueue(new Callback<List<GetComments>>() {
            @Override
            public void onResponse(Call<List<GetComments>> call, Response<List<GetComments>> response) {
                if (response.isSuccessful()) {
                    commentsList.clear();
                    commentsList.addAll(response.body());
                    commentAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<GetComments>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Commented Sucessfully", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void postdislike() {
        long dislikess = 1;
        String Url = "https://www.api.playflixx.com/videodislikes/" + vid;
        Log.d("lik", Url);

        long d = dislikess + Long.parseLong(dis);
        Log.d("dis", String.valueOf(d));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        DislikeInterface dislikeInterface = retrofit.create(DislikeInterface.class);
        Call<Dislike> call = dislikeInterface.putdislike(Url, d);

        call.enqueue(new Callback<Dislike>() {
            @Override
            public void onResponse(Call<Dislike> call, Response<Dislike> response) {

                Log.d("check", response.toString());

                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Dislike> call, Throwable t) {

//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                dislikebtn.setVisibility(View.INVISIBLE);
                dislike1btn.setVisibility(View.VISIBLE);
                dislikes.setText(d + " dislikes");
            }
        });

    }

    private void postlike() {

        long likess = 1;

        String Url = "https://www.api.playflixx.com/videolikes/" + vid;

        Log.d("lik", Url);


        long sum = likess + Long.parseLong(li);
        Log.d("sum", String.valueOf(sum));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        LikeInterface likeInterface = retrofit.create(LikeInterface.class);
        Call<Likes> call = likeInterface.putlike(Url, sum);

        call.enqueue(new Callback<Likes>() {
            @Override
            public void onResponse(Call<Likes> call, Response<Likes> response) {

//                likes.setText("" + like);
//
                Log.d("check", likes.toString());

                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<Likes> call, Throwable t) {

//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                likebtn.setVisibility(View.INVISIBLE);
                like1btn.setVisibility(View.VISIBLE);
                likes.setText(sum + " likes");
            }
        });


    }

    private void postcoment() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();


        sendcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {

                    String commenttxt = comment_edt.getText().toString();
                    String Url = "https://www.api.playflixx.com/" + user + "/videocomments/" + vid;
                    Log.d("comment", Url);

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://www.api.playflixx.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    CommentsInterface commentsInterface = retrofit.create(CommentsInterface.class);
//                Comments comment = new Comments();
                    Call<Comments> call = commentsInterface.postcomment(Url, commenttxt);
                    call.enqueue(new Callback<Comments>() {
                        @Override
                        public void onResponse(Call<Comments> call, Response<Comments> response) {
                            if (response.isSuccessful()) {

//
                                Toast.makeText(getApplicationContext(), "succesful", Toast.LENGTH_SHORT);
//                            String co= String.valueOf(response.body());
//                            Log.d("co",co);
//                            Toast.makeText(getApplicationContext(),co,Toast.LENGTH_SHORT).show();


                            }

                        }

                        @Override
                        public void onFailure(Call<Comments> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "sucessfully commented", Toast.LENGTH_SHORT).show();
                            Log.d("ero", t.toString());
                        }
                    });


                } else {
//                   Toast.makeText(getApplicationContext(),"Pls Login first ",Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity5.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), Login_Page.class));
                                    finish();
                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                }


            }

        });


    }


    private void listdata() {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();

        String vidcat = intent.getStringExtra("videoCategory");
//        Log.d("ccc",vidcat);

//        String Url = "https://www.api.playflixx.com/" + user + "/getallvideolist";
//        String Url="https://www.api.playflixx.com/recommendedvideo/"+user;

        String Url = "https://www.api.playflixx.com/videoplay/" + vidcat;
        Log.i("end", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PlayerRecomendationInterface playerRecomendationInterface = retrofit.create(PlayerRecomendationInterface.class);
        Call<List<PlayerRecommendation>> call = playerRecomendationInterface.getrecomendedlist(Url);
        call.enqueue(new Callback<List<PlayerRecommendation>>() {
            @Override
            public void onResponse(Call<List<PlayerRecommendation>> call, Response<List<PlayerRecommendation>> response) {
                recommendationList.clear();
                recommendationList.addAll(response.body());
                adapter.notifyDataSetChanged();
//                shrimmerec.stopShimmerAnimation();
//                shrimmerec.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<PlayerRecommendation>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
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
//            finish();
            if (isInPictureInPictureMode) {
                rewBtn.setVisibility(View.INVISIBLE);
                speedBtn.setVisibility(View.INVISIBLE);
                farwordBtn.setVisibility(View.INVISIBLE);
                setting.setVisibility(View.INVISIBLE);
                pip.setVisibility(View.INVISIBLE);
                fullscreenButton.setVisibility(View.INVISIBLE);

            }
        if (!isInPictureInPictureMode) {
            rewBtn.setVisibility(View.VISIBLE);
            speedBtn.setVisibility(View.VISIBLE);
            farwordBtn.setVisibility(View.VISIBLE);
            setting.setVisibility(View.VISIBLE);
            pip.setVisibility(View.VISIBLE);
            fullscreenButton.setVisibility(View.VISIBLE);

            Intent intent = getIntent();
            videod = intent.getStringExtra("videodesc");
            videot = intent.getStringExtra("videotitle");
            videov = intent.getStringExtra("videoview");
            vviews = intent.getStringExtra("views").toString();
            channel_poster = intent.getStringExtra("img_channel");
            video_channel_name = intent.getStringExtra("channel_title");
            vlikes = intent.getIntExtra("likes", 0);
            vdislikes = intent.getIntExtra("dislikes", 0);
            vtag = intent.getStringExtra("videoTags");
            vid = intent.getStringExtra("videoId");
            vsubs = intent.getStringExtra("subscribed");
            vidcat = intent.getStringExtra("videoCategory");
            cvid = intent.getIntExtra("channelid", 0);
            chdid = intent.getStringExtra("channeldyanmicid");

        }


        super.onPictureInPictureModeChanged(isInPictureInPictureMode);

    }


}



