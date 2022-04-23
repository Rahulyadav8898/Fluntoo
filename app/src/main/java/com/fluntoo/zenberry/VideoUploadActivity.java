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
import android.media.MediaPlayer;
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
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.fluntoo.zenberry.ApIInterface.CategoryInterface;
import com.fluntoo.zenberry.ApIInterface.LanguagesInterface;
import com.fluntoo.zenberry.ApIInterface.ListChannelInterface;
import com.fluntoo.zenberry.ApIInterface.VideoUploadInterface;
import com.fluntoo.zenberry.Model.Categorys;
import com.fluntoo.zenberry.Model.Languages;
import com.fluntoo.zenberry.Model.ListChannel;
import com.fluntoo.zenberry.Model.VideoUpload;
import com.fluntoo.zenberry.Model.Videoc;
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

//import com.example.playflix.R;

public class VideoUploadActivity extends AppCompatActivity {
    Button imgupload, videoupload, createchannelbtn, btnuplod;
    EditText nametxt, desctxt, tagstxt, categorytxt;
    Spinner spinnerupload, spinnercat;
    TextView textViewposter;
    Spinner spinnerlanunges;
    String channel;
    String lang;
    private static int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_LOAD_IMAGE_2 = 5;

    RadioGroup radiogroup, radiogroupkid;
    RadioButton radioButton;

    String texts;

    String Private;

    private String seasonlist[] = {"season1", "s2"};
    String videodashh, previeww, uidd;

    Bitmap bmp;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    Uri imageUri;
    Uri mVideoURI;
    String selectedImagePath1 = "";
    String selectedImagePath2 = "";

    String textp, textk;

    String textss = "2022-06-02 12:00";
    RelativeLayout layoutvideo;
    private NotificationManagerCompat notificationManager;
    String category;
    Spinner spinnerprivate, spinnerkid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_upload);
//        channelistedt = findViewById(R.id.selectchannel_edt);
        spinnerlanunges = findViewById(R.id.spinnerlanguages);
        spinnercat = findViewById(R.id.spinnercategory);
        spinnerupload = findViewById(R.id.spinnerchannel);
        imgupload = findViewById(R.id.poster_upload_btn);
//        videoupload = findViewById(R.id.video_upload_btn);
        createchannelbtn = findViewById(R.id.create_channel_btn);
        nametxt = findViewById(R.id.title_edtc);
        desctxt = findViewById(R.id.videodesc_edtc);
        tagstxt = findViewById(R.id.tag_edtc);
//        categorytxt = findViewById(R.id.category_edtc);
        btnuplod = findViewById(R.id.submit_btnv);
        layoutvideo = findViewById(R.id.videolayout);
        textViewposter = findViewById(R.id.UploadPostertv);
//        radiogroup = findViewById(R.id.radiogroupone);
//        radiogroupkid = findViewById(R.id.radiogrouptwo);
        spinnerprivate = findViewById(R.id.spinnerprivate);
        spinnerkid = findViewById(R.id.spinnerkids);


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


//        videoselect();

        notificationManager = NotificationManagerCompat.from(this);
//        spinnerupload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                getchannellist();
//
//
//            }
//        });

//         spinnerupload=findViewById(R.id.spinnerchannel);
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),
//                android.R.layout.simple_spinner_dropdown_item,seasonlist);
//        spinnerupload.setAdapter(adapter);

//        private void getchannellist() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.number, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerprivate.setAdapter(adapter);


        spinnerprivate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textp = "false";

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textp = "true";

            }
        });


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.number2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerkid.setAdapter(adapter2);


        spinnerkid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                textk = "false";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textk = "true";

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
                    spinnerupload.setAdapter(adapter);

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


        spinnerupload.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                channel = spinnerupload.getSelectedItem().toString();
                Log.d("hm", channel);
//                Toast.makeText(getApplicationContext(), channel, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                channel = spinnerupload.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), channel, Toast.LENGTH_LONG).show();
                Log.d("hm", channel);


//

            }


        });


        String caturl = "https://api.fluntoo.com/video/getAllNewCategory";

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/video/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoryInterface categoryINterface = retrofit.create(CategoryInterface.class);
        Call<List<Categorys>> call2 = categoryINterface.getcategorys(caturl);
        call2.enqueue(new Callback<List<Categorys>>() {
            @Override
            public void onResponse(Call<List<Categorys>> call, Response<List<Categorys>> response) {
                if (response.isSuccessful()) {
                    ArrayList<String> nameListch = new ArrayList<>();
//                 getresponse=response.body().toString();
                    for (int i = 0; i < response.body().size(); i++) {


//
                        nameListch.add(response.body().get(i).getName());
//                            String imc_met = response.body().get(0).getChannelName();
//                    Log.d("name", nameListch.toString());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, nameListch);
                    spinnercat.setAdapter(adapter);

//

                } else {
                    Toast.makeText(getApplicationContext(), "ChannelList Empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Categorys>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        spinnercat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                category = spinnercat.getSelectedItem().toString();
                Log.d("hm", category);
//                Toast.makeText(getApplicationContext(), channel, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                category = spinnercat.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), category, Toast.LENGTH_LONG).show();
                Log.d("hm", category);


//

            }


        });


        String Urll = "https://api.fluntoo.com/movie/getalllanguages";
        Log.d("url", Urll);

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LanguagesInterface languagesInterface = retrofit1.create(LanguagesInterface.class);
        Call<List<Languages>> call1 = languagesInterface.languages(Urll);
        call1.enqueue(new Callback<List<Languages>>() {
            @Override
            public void onResponse(Call<List<Languages>> call, Response<List<Languages>> response) {
                ArrayList<String> lan = new ArrayList<>();
                lan.addAll(response.body().get(0).getLanguages());

//                        lan.add(response.body().get(a).getLanguages());
//

                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, lan);
                spinnerlanunges.setAdapter(adapter1);

            }

            @Override
            public void onFailure(Call<List<Languages>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        spinnerlanunges.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lang = spinnerlanunges.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), lang, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lang = spinnerlanunges.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), lang, Toast.LENGTH_SHORT).show();

            }
        });

//        }


        createchannelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateChannelActivity.class));
            }
        });

        imgupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                            && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        imageupload();
                    } else {
                        allowPermissionForFile();
                    }
                } else {
                    imageupload();
                }

                imageupload();
            }
        });
//
//        videoupload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
//                            && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//                        videoselect();
//                    } else {
//                        allowPermissionForFile();
//                    }
//                } else {
//                    videoselect();
//                }
//
//                videoselect();
//            }
//        });


        btnuplod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadvideo();

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


    }

    private void allowPermissionForFile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, RESULT_LOAD_IMAGE);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, RESULT_LOAD_IMAGE_2);
        }
    }

    private void videoselect() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), RESULT_LOAD_IMAGE_2);


    }

    private void postcloud() {

        String Urlc = "https://api.cloudflare.com/client/v4/accounts/43d44c20028ea7020f5cf3c0e7d19b84/stream";
        Log.d("check", Urlc);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MultipartBody.Part file = null;

        File files = new File(selectedImagePath1);

//        Log.d("file", file.toString());
        RequestBody filepart = RequestBody.create(MediaType.parse(getContentResolver().getType(mVideoURI)), files);
//        MediaType.parse("image/*")


        MultipartBody.Part filee = MultipartBody.Part.createFormData("file", files.getName(), filepart);
        Log.d("img11", filee.toString());

        VideoUploadInterface videoUploadInterface = retrofit.create(VideoUploadInterface.class);
        Call<Videoc> call = videoUploadInterface.videocup(Urlc, filee);
        Log.d("call", call.toString());
        call.enqueue(new Callback<Videoc>() {
            @Override
            public void onResponse(Call<Videoc> call, Response<Videoc> response) {

                String videodash = response.body().getResult().getPlayback().getDash();
                String uid = response.body().getResult().getUid();
                String preview = response.body().getResult().getPreview();

                videodashh = videodash;
                uidd = uid;
                previeww = preview;
//                String res=response.body().getErrors().get(0).toString();


                Log.d("respp", videodash.toString());
                Toast.makeText(getApplicationContext(), videodash.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Videoc> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("error", t.getMessage());
            }
        });

    }

    private void imageupload() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView img = findViewById(R.id.test_img);
        VideoView vid = findViewById(R.id.test_video);
        MediaController mc;

        mc = new MediaController(this);
        mc.setAnchorView(vid);

        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_LOAD_IMAGE) {
                try {
                    imageUri = data.getData();
                    selectedImagePath2 = generatePath(imageUri, this);

                    InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

                    img.setImageBitmap(selectedImage);
                    textViewposter.setText(selectedImagePath1);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                }

            }

//        if (resultCode != RESULT_OK) return;

            if (requestCode == RESULT_LOAD_IMAGE_2) {
                mVideoURI = data.getData();

                selectedImagePath1 = generatePath(mVideoURI, this);

                postcloud();

                vid.setMediaController(mc);

                vid.setVideoURI(mVideoURI);

                vid.requestFocus();
                vid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    //                 Close the progress bar and play the video
                    public void onPrepared(MediaPlayer mp) {

                        vid.start();
                    }

                });

            }


        }

//
    }


    private void uploadvideo() {


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
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();


        String Url = "https://api.fluntoo.com/video/" + user + "/" + channel + "/" + "uploadvideo";
        Log.d("check", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MultipartBody.Part videoo = null;
//        MultipartBody.Part imgg = null;
        MultipartBody.Part srtfile = null;

        RequestBody namepart = RequestBody.create(MediaType.parse("text/plain"), nametxt.getText().toString());
        RequestBody descpart = RequestBody.create(MediaType.parse("text/plain"), desctxt.getText().toString());
        RequestBody tagpart = RequestBody.create(MediaType.parse("text/plain"), tagstxt.getText().toString());
        RequestBody catpart = RequestBody.create(MediaType.parse("text/plain"), category.toString());
        RequestBody lanpart = RequestBody.create(MediaType.parse("text/plain"), lang.toString());
        RequestBody videod = RequestBody.create(MediaType.parse("text/plain"), videodashh.toString());
        RequestBody prev = RequestBody.create(MediaType.parse("text/plain"), previeww.toString());
        RequestBody ui = RequestBody.create(MediaType.parse("text/plain"), uidd.toString());
        RequestBody textpp = RequestBody.create(MediaType.parse("text/plain"), textp.toString());
        RequestBody textkk = RequestBody.create(MediaType.parse("text/plain"), textk.toString());
        RequestBody texts = RequestBody.create(MediaType.parse("text/plain"), textss);


        File file = new File(selectedImagePath1);

        Log.d("file", file.toString());
        RequestBody videopart = RequestBody.create(MediaType.parse(getContentResolver().getType(mVideoURI)), file);
//        MediaType.parse("image/*")


        videoo = MultipartBody.Part.createFormData("VideoFile", file.getName(), videopart);
        Log.d("img", videoo.toString());

        File file2 = new File(selectedImagePath2);

        Log.d("file", file.toString());
        RequestBody imagepart = RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri)), file2);
//        MediaType.parse("image/*")


        MultipartBody.Part imgg = MultipartBody.Part.createFormData("VideoPoster", file2.getName(), imagepart);
        Log.d("img", imgg.toString());

//        postcloud();

        VideoUploadInterface videoUploadInterface = retrofit.create(VideoUploadInterface.class);
        Call<VideoUpload> call = videoUploadInterface.videoupload("Bearer " + name,
                Url, namepart, descpart, tagpart, catpart, videod, imgg, lanpart, ui, textpp, textkk);
        Log.d("call", call.toString());
        call.enqueue(new Callback<VideoUpload>() {
            @Override
            public void onResponse(Call<VideoUpload> call, Response<VideoUpload> response) {
//                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();


//                Snackbar snackbar = Snackbar
//                        .make(layoutvideo, response.toString(), Snackbar.LENGTH_LONG);
//                snackbar.show();
//
//                Log.d("res", response.toString());

            }

            @Override
            public void onFailure(Call<VideoUpload> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Sucessful", Toast.LENGTH_SHORT).show();


                Snackbar snackbar = Snackbar
                        .make(layoutvideo, "successfully uploaded", Snackbar.LENGTH_LONG);
                snackbar.show();

                notification.setContentText("Uploaded")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                notificationManager.notify(1, notification.build());


                Log.d("er", t.toString());

            }
        });


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


