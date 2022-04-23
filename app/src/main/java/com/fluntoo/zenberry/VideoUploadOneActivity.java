package com.fluntoo.zenberry;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.fluntoo.zenberry.ApIInterface.VideoUploadInterface;
import com.fluntoo.zenberry.Model.Videoc;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoUploadOneActivity extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1000000;

    Uri mVideoURI;
    String selectedImagePath1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_upload_one);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                videoselect();
            } else {
                allowPermissionForFile();
            }
        } else {
            videoselect();
        }

        videoselect();
    }

    private void allowPermissionForFile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, RESULT_LOAD_IMAGE);
        }
    }

    private void videoselect() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), RESULT_LOAD_IMAGE);

        
    }
    private void postcloud() {

        String Urlc = "https://api.cloudflare.com/client/v4/accounts/43d44c20028ea7020f5cf3c0e7d19b84/stream";
        Log.d("check", Urlc);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MultipartBody.Part filee = null;

        File files = new File(selectedImagePath1);

//        Log.d("file", file.toString());
        RequestBody filepart = RequestBody.create(MediaType.parse(getContentResolver().getType(mVideoURI)), files);
//        MediaType.parse("image/*")


         filee = MultipartBody.Part.createFormData("file", files.getName(), filepart);
        Log.d("img12", filee.toString());

        VideoUploadInterface videoUploadInterface = retrofit.create(VideoUploadInterface.class);
        Call<Videoc> call = videoUploadInterface.videocup(Urlc, filee);
        Log.d("call", call.toString());
        call.enqueue(new Callback<Videoc>() {
            @Override
            public void onResponse(Call<Videoc> call, Response<Videoc> response) {

                String res = response.body().getResult().getPlayback().getDash();
//                String res=response.body().getErrors().get(0).toString();
                Log.d("respp", res.toString());
                Toast.makeText(getApplicationContext(), res.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Videoc> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("error", t.getMessage());
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView img = findViewById(R.id.test_img);
        VideoView vid = findViewById(R.id.test_video);
        MediaController mc;

        mc = new MediaController(this);
        mc.setAnchorView(vid);



//        if (resultCode != RESULT_OK) return;

            if (requestCode == RESULT_LOAD_IMAGE) {
                mVideoURI = data.getData();

                selectedImagePath1 = generatePath(mVideoURI, this);

                postcloud();

//                vid.setMediaController(mc);
//
//                vid.setVideoURI(mVideoURI);
//
//                vid.requestFocus();
//                vid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                    //                 Close the progress bar and play the video
//                    public void onPrepared(MediaPlayer mp) {
//
//                        vid.start();
//                    }
//
//                });

            }


        }

    public static String generatePath(Uri uri, Context context) {

        String filePath = null;
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        if (isKitKat) {
            filePath = generateFromKitkat(uri, context);
        }

        if (filePath != null) {
            return filePath;
        }

        Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.MediaColumns.DATA}, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
                filePath = cursor.getString(columnIndex);
            }
            cursor.close();
        }
        return filePath == null ? uri.getPath() : filePath;
    }

    @TargetApi(19)
    private static String generateFromKitkat(Uri uri, Context context) {
        String filePath = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String wholeID = DocumentsContract.getDocumentId(uri);

            String id = wholeID.split(":")[1];

            String[] column = {MediaStore.Video.Media.DATA};
            String sel = MediaStore.Video.Media._ID + "=?";

            Cursor cursor = context.getContentResolver().
                    query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                            column, sel, new String[]{id}, null);


            int columnIndex = cursor.getColumnIndex(column[0]);

            if (cursor.moveToFirst()) {
                filePath = cursor.getString(columnIndex);
            }

            cursor.close();
        }
        return filePath;
    }


//
    }
