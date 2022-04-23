package com.fluntoo.zenberry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
//        implements View.OnClickListener {

//    private Button btnStreamingExample;
//    private Button btnDownloadingExample;
//    private Button btnCommandExample;
//    private Button btnUpdate;
//    private ProgressBar progressBar;
//
//    private boolean updating = false;
//    private CompositeDisposable compositeDisposable = new CompositeDisposable();
//
//    private static final String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        initViews();
//        initListeners();
    }
//
//    private void initListeners() {
//        btnStreamingExample.setOnClickListener(this);
//        btnDownloadingExample.setOnClickListener(this);
//        btnCommandExample.setOnClickListener(this);
//        btnUpdate.setOnClickListener(this);
//    }
//
//    private void initViews() {
//        btnStreamingExample = findViewById(R.id.btn_streaming_example);
//        btnDownloadingExample = findViewById(R.id.btn_downloading_example);
//        btnCommandExample = findViewById(R.id.btn_command_example);
//        btnUpdate = findViewById(R.id.btn_update);
//        progressBar = findViewById(R.id.progress_bar);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_streaming_example: {
//                Intent i = new Intent(MainActivity2.this, StreamingExampleActivity.class);
//                startActivity(i);
//                break;
//            }
//            case R.id.btn_downloading_example: {
//                Intent i = new Intent(MainActivity2.this, DownloadingExampleActivity.class);
//                startActivity(i);
//                break;
//            }
//            case R.id.btn_command_example: {
//                Intent i = new Intent(MainActivity2.this, CommandExampleActivity.class);
//                startActivity(i);
//                break;
//            }
//            case R.id.btn_update: {
//                updateYoutubeDL();
//                break;
//            }
//        }
//    }
//
//    private void updateYoutubeDL() {
//        if (updating) {
//            Toast.makeText(MainActivity2.this, "update is already in progress", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        updating = true;
//        progressBar.setVisibility(View.VISIBLE);
//        Disposable disposable = Observable.fromCallable(() -> YoutubeDL.getInstance().updateYoutubeDL(getApplication()))
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(status -> {
//                    progressBar.setVisibility(View.GONE);
//                    switch (status) {
//                        case YoutubeDL.UpdateStatus.DONE:
//                            Toast.makeText(MainActivity2.this, "update successful", Toast.LENGTH_LONG).show();
//                            break;
//                        case YoutubeDL.UpdateStatus.ALREADY_UP_TO_DATE:
//                            Toast.makeText(MainActivity2.this, "already up to date", Toast.LENGTH_LONG).show();
//                            break;
//                        default:
//                            Toast.makeText(MainActivity2.this, status.toString(), Toast.LENGTH_LONG).show();
//                            break;
//                    }
//                    updating = false;
//                }, e -> {
//                    if (BuildConfig.DEBUG) Log.e(TAG, "failed to update", e);
//                    progressBar.setVisibility(View.GONE);
//                    Toast.makeText(MainActivity2.this, "update failed", Toast.LENGTH_LONG).show();
//                    updating = false;
//                });
//        compositeDisposable.add(disposable);
//    }
}