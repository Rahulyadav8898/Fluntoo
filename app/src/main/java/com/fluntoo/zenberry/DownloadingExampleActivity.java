package com.fluntoo.zenberry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DownloadingExampleActivity extends AppCompatActivity{
//        implements View.OnClickListener {
//
//    private Button btnStartDownload;
//    private EditText etUrl;
//    private Switch useConfigFile;
//    private ProgressBar progressBar;
//    private TextView tvDownloadStatus;
//    private TextView tvCommandOutput;
//    private ProgressBar pbLoading;
//
//    private boolean downloading = false;
////    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
////
//    private final DownloadProgressCallback callback = new DownloadProgressCallback() {
//        @Override
//        public void onProgressUpdate(float progress, long etaInSeconds) {
//            runOnUiThread(() -> {
//                        progressBar.setProgress((int) progress);
//                        tvDownloadStatus.setText(String.valueOf(progress) + "% (ETA " + String.valueOf(etaInSeconds) + " seconds)");
//                    }
//            );
//        }
//    };
//
//    private static final String TAG = "DownloadingExample";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloading_example);
//        initViews();
//        initListeners();

    }

//    private void initViews() {
//        btnStartDownload = findViewById(R.id.btn_start_download);
//        etUrl = findViewById(R.id.et_url);
//        useConfigFile = findViewById(R.id.use_config_file);
//        progressBar = findViewById(R.id.progress_bar);
//        tvDownloadStatus = findViewById(R.id.tv_status);
//        pbLoading = findViewById(R.id.pb_status);
//        tvCommandOutput = findViewById(R.id.tv_command_output);
//    }
//
//    private void initListeners() {
//        btnStartDownload.setOnClickListener(DownloadingExampleActivity.this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.btn_start_download) {
//            startDownload();
//        }
//    }
//
//    private void startDownload() {
//        if (downloading) {
//            Toast.makeText(DownloadingExampleActivity.this, "cannot start download. a download is already in progress", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        if (!isStoragePermissionGranted()) {
//            Toast.makeText(DownloadingExampleActivity.this, "grant storage permission and retry", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        String url = etUrl.getText().toString().trim();
//        if (TextUtils.isEmpty(url)) {
//            etUrl.setError(getString(R.string.url_error));
//            return;
//        }
//
//        YoutubeDLRequest request = new YoutubeDLRequest(url);
//        File youtubeDLDir = getDownloadLocation();
//        File config = new File(youtubeDLDir, "config.txt");
//
//        if (useConfigFile.isChecked() && config.exists()) {
//            request.addOption("--config-location", config.getAbsolutePath());
//        } else {
//            request.addOption("-o", youtubeDLDir.getAbsolutePath() + "/%(title)s.%(ext)s");
//        }
//
//        showStart();
//
//        downloading = true;
//        Disposable disposable = Observable.fromCallable(() -> YoutubeDL.getInstance().execute(request, callback))
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(youtubeDLResponse -> {
//                    pbLoading.setVisibility(View.GONE);
//                    progressBar.setProgress(100);
//                    tvDownloadStatus.setText(getString(R.string.download_complete));
//                    tvCommandOutput.setText(youtubeDLResponse.getOut());
//                    Toast.makeText(DownloadingExampleActivity.this, "download successful", Toast.LENGTH_LONG).show();
//                    downloading = false;
//                }, e -> {
//                    if(BuildConfig.DEBUG) Log.e(TAG,  "failed to download", e);
//                    pbLoading.setVisibility(View.GONE);
//                    tvDownloadStatus.setText(getString(R.string.download_failed));
//                    tvCommandOutput.setText(e.getMessage());
//                    Toast.makeText(DownloadingExampleActivity.this, "download failed", Toast.LENGTH_LONG).show();
//                    downloading = false;
//                });
//        compositeDisposable.add(disposable);
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        compositeDisposable.dispose();
//        super.onDestroy();
//    }
//
//    @NonNull
//    private File getDownloadLocation() {
//        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        File youtubeDLDir = new File(downloadsDir, "youtubedl-android");
//        if (!youtubeDLDir.exists()) youtubeDLDir.mkdir();
//        return youtubeDLDir;
//    }
//
//    private void showStart() {
//        tvDownloadStatus.setText(getString(R.string.download_start));
//        progressBar.setProgress(0);
//        pbLoading.setVisibility(View.VISIBLE);
//    }
//
//    public boolean isStoragePermissionGranted() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                    == PackageManager.PERMISSION_GRANTED) {
//                return true;
//            } else {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
//                return false;
//            }
//        } else {
//            return true;
//        }
//    }
}