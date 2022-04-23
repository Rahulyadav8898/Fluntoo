package com.fluntoo.zenberry;

import static com.fluntoo.zenberry.App.CHANNEL_1_ID;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.fluntoo.zenberry.ApIInterface.CreatePlaylistInterface;
import com.fluntoo.zenberry.ApIInterface.ListChannelInterface;
import com.fluntoo.zenberry.ApIInterface.SpinnerVideolist;
import com.fluntoo.zenberry.Model.CreatePlaylist;
import com.fluntoo.zenberry.Model.ListChannel;
import com.fluntoo.zenberry.Model.SpinnerVideo;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreatePlaylistActivity extends AppCompatActivity {
    EditText playlisttitle, playlistdesc, playlistcat, playlisttag;
    Spinner spinnervideo, spinnerchannel;
    ImageView img;
    Button selectbtn, Uploadbtn;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    String channel, video;

    private static int RESULT_LOAD_IMAGE = 1;
    Uri imageUri;
    String selectedImagePath1 = "";
    RelativeLayout layoutplaylist;

    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_playlist);
        spinnerchannel = findViewById(R.id.spinnerchannelname);
        spinnervideo = findViewById(R.id.spinnervideoname);
        playlisttitle = findViewById(R.id.edt_playlisttitle);
        playlistcat = findViewById(R.id.edt_playlistcat);
        playlistdesc = findViewById(R.id.edt_playlistdesc);
        playlisttag = findViewById(R.id.edt_playlisttag);
        selectbtn = findViewById(R.id.playlistselect_btn);
        Uploadbtn = findViewById(R.id.playlistuploadbtn);
        img = findViewById(R.id.imgselect);
        layoutplaylist = findViewById(R.id.layoutplaylist);

        notificationManager = NotificationManagerCompat.from(this);

        Uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createplaylist();

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        SystemClock.sleep(2000);
//                        for (int progress = 0; progress <= progressMax; progress += 20) {
////                            notification.setProgress(progressMax, progress, false);
////                            notificationManager.notify(1, notification.build());
//                            SystemClock.sleep(1000);
//                        }
//                        notification.setContentText("Uploaded")
//                                .setProgress(0, 0, false)
//                                .setOngoing(false);
//                        notificationManager.notify(1, notification.build());
//                    }
//                }).start();

            }
        });

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();


        String Url = "https://api.fluntoo.com/channel/listchannel/" + user;
        Log.d("comment", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ListChannelInterface listChannelInterface = retrofit.create(ListChannelInterface.class);
        Call<List<ListChannel>> call = listChannelInterface.getchannelist(Url);
        call.enqueue(new Callback<List<ListChannel>>() {
            @Override
            public void onResponse(Call<List<ListChannel>> call, Response<List<ListChannel>> response) {
                if (response.isSuccessful()) {
                    ArrayList<String> nameListch = new ArrayList<>();
//                 getresponse=response.body().toString();
                    for (int i = 0; i < response.body().size(); i++) {


//
                        nameListch.add(response.body().get(i).getChannelName());
//                            String imc_met = response.body().get(0).getChannelName();
//                    Log.d("name", nameListch.toString());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, nameListch);
                    spinnerchannel.setAdapter(adapter);

//

                } else {
                    Toast.makeText(getApplicationContext(), "ChannelList Empty", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<ListChannel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT);

            }
        });

        spinnerchannel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                channel = spinnerchannel.getSelectedItem().toString();
                Log.d("hm", channel);
//                Toast.makeText(getApplicationContext(), channel, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                channel = spinnerchannel.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), channel, Toast.LENGTH_LONG).show();
                Log.d("hm", channel);


            }
        });


        SharedPreferences prefs1 = getSharedPreferences(MY_PREFS_NAME, 0);

        String name1 = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user1 = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();


        String Url1 = "https://api.fluntoo.com/video/" + user + "/getallvideolist";
        Log.d("comment", Url1);

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpinnerVideolist spinnerVideolist = retrofit1.create(SpinnerVideolist.class);
        Call<List<SpinnerVideo>> call1 = spinnerVideolist.getchannelist(Url1, "Bearer " + name1);
        call1.enqueue(new Callback<List<SpinnerVideo>>() {
            @Override
            public void onResponse(Call<List<SpinnerVideo>> call, Response<List<SpinnerVideo>> response) {


                ArrayList<String> videolist = new ArrayList<>();
//                 getresponse=response.body().toString();
                for (int i = 0; i < response.body().size(); i++) {


//
                    videolist.add(response.body().get(i).getVideoId());
//                            String imc_met = response.body().get(0).getChannelName();
//                    Log.d("name", nameListch.toString());
                }

                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, videolist);
                spinnervideo.setAdapter(adapter1);

//
            }

            @Override
            public void onFailure(Call<List<SpinnerVideo>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        spinnervideo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                video = spinnervideo.getSelectedItem().toString();
                Log.d("hm", video);
//                Toast.makeText(getApplicationContext(), video, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                video = spinnervideo.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), video, Toast.LENGTH_LONG).show();
                Log.d("hm", video);

            }
        });

        selectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                            && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        select();
                    } else {
                        allowPermissionForFile();
                    }
                } else {
                    select();
                }

                select();
            }

        });


    }

    private void createplaylist() {
        final int progressMax = 100;

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_1_ID)
                .setSmallIcon(R.drawable.app_icon)
                .setContentTitle("Uploding")
                .setContentText("uploading....")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setProgress(progressMax, 0, true);


        notificationManager.notify(1, notification.build());


        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();


        String Url = "https://api.fluntoo.com/playlist/createplaylist/" + user;
        Log.d("check", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MultipartBody.Part videoo = null;
        RequestBody titlepart = RequestBody.create(MediaType.parse("text/plain"), playlisttitle.getText().toString());
        RequestBody descpart = RequestBody.create(MediaType.parse("text/plain"), playlistdesc.getText().toString());
        RequestBody tagpart = RequestBody.create(MediaType.parse("text/plain"), playlisttag.getText().toString());
        RequestBody catpart = RequestBody.create(MediaType.parse("text/plain"), playlistcat.getText().toString());
        RequestBody channell = RequestBody.create(MediaType.parse("text/plain"), channel.toString());
        RequestBody videolistpart = RequestBody.create(MediaType.parse("text/plain"), video.toString());

        File file = new File(selectedImagePath1);

        Log.d("file", file.toString());
        RequestBody videopart = RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri)), file);
//        MediaType.parse("image/*")


        videoo = MultipartBody.Part.createFormData("PlaylistVideoPoster", file.getName(), videopart);
        Log.d("img", videoo.toString());

        CreatePlaylistInterface createPlaylistInterface = retrofit.create(CreatePlaylistInterface.class);
        Call<CreatePlaylist> call = createPlaylistInterface.createplaylist("Bearer " + name, Url,
                titlepart, descpart, catpart, tagpart, channell, videolistpart, videoo);
        call.enqueue(new Callback<CreatePlaylist>() {
            @Override
            public void onResponse(Call<CreatePlaylist> call, Response<CreatePlaylist> response) {
//                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

                Snackbar snackbar = Snackbar
                        .make(layoutplaylist, response.toString(), Snackbar.LENGTH_LONG);
                snackbar.show();
                Log.d("res", response.toString());
            }

            @Override
            public void onFailure(Call<CreatePlaylist> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "sucessful", Toast.LENGTH_SHORT).show();

                notification.setContentText("Uploaded")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                notificationManager.notify(1, notification.build());
                Snackbar snackbar = Snackbar
                        .make(layoutplaylist, "Sucessfully Created Playlist", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });


    }

    private void select() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMAGE);

    }

    private void allowPermissionForFile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, RESULT_LOAD_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView img = findViewById(R.id.imgselect);
        VideoView vid = findViewById(R.id.test_video);

        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_LOAD_IMAGE) {
                try {
                    imageUri = data.getData();
                    selectedImagePath1 = generatePath(imageUri, this);

                    InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

                    img.setImageBitmap(selectedImage);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                }

            }


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

}

