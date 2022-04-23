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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.fluntoo.zenberry.ApIInterface.CreateChannelInterface;
import com.fluntoo.zenberry.Model.CreateChannel;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.playflix.R;

public class CreateChannelActivity extends AppCompatActivity {

    EditText name1, desc;
    EditText facebook, twitter, linkedin, gogglebusiness, instagram;

    Button profilebtn, coverbtn, submittbn;
    public static final int RESULT_LOAD_IMAGE = 1;
    public static final int RESULT_LOAD_IMAGE2 = 2;


    public static final String MY_PREFS_NAME = "MyPrefsFile";
    Uri imageUri2;
    Uri imageUri;
    String selectedImagePath1 = "";
    String selectedImagePath2 = "";
    RelativeLayout layoutchannel;


    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_channel);

        name1 = findViewById(R.id.channelnamee_edt);
        desc = findViewById(R.id.channeldesc_edt);
        profilebtn = findViewById(R.id.profile_img_btn);
        coverbtn = findViewById(R.id.channel_img_btn);
        submittbn = findViewById(R.id.submitcc_btn);
        facebook = findViewById(R.id.insta_edt);
        twitter = findViewById(R.id.twitter_edt);
        linkedin = findViewById(R.id.linkdin_edt);
        gogglebusiness = findViewById(R.id.business_edt);
        instagram = findViewById(R.id.insta_edt);
        layoutchannel = findViewById(R.id.layoutchannel);

        notificationManager = NotificationManagerCompat.from(this);

        submittbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upload();

//                upload();


//
            }
        });

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                            && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        profile();
                    } else {
                        allowPermissionForFile();
                    }
                } else {
                    profile();
                }

//                if (needRequestRuntimePermissions()) {
//                    if (!checkPermissionForWriteExtertalStorage()) {
//                        try {
//                            requestPermissionForWriteExtertalStorage();
//                        } catch (Exception e) {
//                            Log.e("error", e.toString());
//                        }
//                    } else {
//                        profile();
//                    }
//                } else {
//                    profile();
//                }
//
                profile();
            }
        });
        coverbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                            && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        coverprofile();
                    } else {
                        allowPermissionForFile();
                    }
                } else {
                    coverprofile();
                }

//                if (needRequestRuntimePermissions()) {
//                    if (!checkPermissionForWriteExtertalStorage()) {
//                        try {
//                            requestPermissionForWriteExtertalStorage();
//                        } catch (Exception e) {
//                            Log.e("error", e.toString());
//                        }
//                    } else {
//                        coverprofile();
//                    }
//                } else {
//                    coverprofile();
//                }
//
//
                coverprofile();
            }
        });


    }

    private void allowPermissionForFile() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, 101);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, 102);
        }
    }

//
//    private boolean needRequestRuntimePermissions() {
//        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
//    }
//
//    private boolean checkPermissionForWriteExtertalStorage() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            int result = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//            return result == PackageManager.PERMISSION_GRANTED;
//        }
//        return false;
//    }
//
//    private void requestPermissionForWriteExtertalStorage() throws Exception {
//        try {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}
//                    , 101);
//        } catch (Exception e) {
//            Log.e("error", e.toString());
//            throw e;
//        }
//    }


//    private void createchannel() {
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
//
//        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();
//        String Url = "https://www.api.playflixx.com/createchannel/" + user;
//        Log.d("comment", Url);
//
//
//
////        Retrofit retrofit = new Retrofit.Builder()
////                .baseUrl("https://www.api.playflixx.com/")
////                .addConverterFactory(GsonConverterFactory.create())
////                .build();
////        CreateChannelInterface createChannelInterface = retrofit.create(CreateChannelInterface.class);
//////        Call<CreateChannel> call = createChannelInterface.createchannel(Url, namee,descc, file1, file2);
////        call.enqueue(new Callback<CreateChannel>() {
////            @Override
////            public void onResponse(Call<CreateChannel> call, Response<CreateChannel> response) {
////
////            }
////
////            @Override
////            public void onFailure(Call<CreateChannel> call, Throwable t) {
////                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
////            }
////        });
//
//
//    }

    private void coverprofile() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        photoPickerIntent.putExtra(Intent.EXTRA_LOCAL_ONLY, true); // this is the flag that does the trick
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMAGE2);


    }


    private void profile() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        photoPickerIntent.putExtra(Intent.EXTRA_LOCAL_ONLY, true); // this is the flag that does the trick
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMAGE);

//

//

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView img = findViewById(R.id.imgprof);
        ImageView img2 = findViewById(R.id.imgcover);

        if (resultCode == RESULT_OK) {

            if (requestCode == RESULT_LOAD_IMAGE) {
                try {
                    imageUri = data.getData();

                    selectedImagePath1 = generatePath(imageUri, this);

//                    Log.d("data", file.toString());

                    InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);


                    img.setImageBitmap(selectedImage);


//                createchannel(imageUri,imageUri2);

//                uploadFile(imageUri);
//
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    Log.d("e", e.toString());
                }
            } else {
                Toast.makeText(getApplicationContext(), "select", Toast.LENGTH_SHORT).show();
            }
            if (requestCode == RESULT_LOAD_IMAGE2) {
                try {


                    imageUri2 = data.getData();
//                    Log.d("data", imageUri2.toString());
                    selectedImagePath2 = generatePath(imageUri2, this);


//                    Log.d("file", imageUri2.toString());

                    InputStream imageStream2 = getContentResolver().openInputStream(imageUri2);
                    Bitmap selectedImage2 = BitmapFactory.decodeStream(imageStream2);


                    img2.setImageBitmap(selectedImage2);


//                createchannel(imageUri,imageUri2);

//                uploadFile(imageUri);
//
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    Log.d("e", e.toString());
                }
            } else {
                Toast.makeText(getApplicationContext(), "selectp", Toast.LENGTH_SHORT).show();
            }

        }
//
    }


//    private void uploadFile(Uri imageUri) {
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
//
//        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();
//        String Url = "https://www.api.playflixx.com/createchannel/" + user;
//        Log.d("comment", Url);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RequestBody namepart=RequestBody.create(MediaType.parse("text/plain"),name1.getText().toString());
//        RequestBody descpart=RequestBody.create(MediaType.parse("text/plain"),desc.getText().toString());
//
//        File file=new File(imageUri.getPath());
//        RequestBody filepart=RequestBody.create(MediaType.parse("image/*"),file);
//
//        File file2=new File(imageUri.getPath());
//        RequestBody filepart2=RequestBody.create(MediaType.parse("image/*"),file2);
//
////        RequestBody filepart1=RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri)),
////                FileUtils.getFile(this,imageUri);
////        MultipartBody.Part file=MultipartBody.Part.createFormData(""))
//
//
//        CreateChannelInterface createChannelInterface=retrofit.create(CreateChannelInterface.class);
//        Call<ResponseBody> call=createChannelInterface.createchannel("Bearer "+name,Url,namepart,descpart,filepart,filepart2);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Toast.makeText(getApplicationContext(),"succesful",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }


//    private void createchannel(Uri imageUri, Uri imageUri2) {
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
//        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();
//        String Url = "https://www.api.playflixx.com/createchannel/" + user;
//        Log.d("comment", Url);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RequestBody namepart = RequestBody.create(MediaType.parse("text/plain"), name1.getText().toString());
//        RequestBody descpart = RequestBody.create(MediaType.parse("text/plain"), desc.getText().toString());
//
//
//            File file = new File(imageUri.getPath());
//            Log.d("file", file.toString());
//            RequestBody filepart = RequestBody.create(MediaType.parse("image/*"), file);
//
//
//            File file2 = new File(imageUri2.getPath());
//            RequestBody filepart2 = RequestBody.create(MediaType.parse("image/*"), file2);
//
////
////        RequestBody filepart1=RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri)),
////                FileUtils.getFile(this,imageUri);
////        MultipartBody.Part file=MultipartBody.Part.createFormData(""))
//
//
//        CreateChannelInterface createChannelInterface = retrofit.create(CreateChannelInterface.class);
//        Call<CreateChannel> call = createChannelInterface.createchannel("Bearer " + name, Url, namepart, descpart, filepart, filepart2);
//        call.enqueue(new Callback<CreateChannel>() {
//            @Override
//            public void onResponse(Call<CreateChannel> call, Response<CreateChannel> response) {
//                Toast.makeText(getApplicationContext(), "succesful", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<CreateChannel> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }

    private void upload() {

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

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(2000);
//                for (int progress = 0; progress <= progressMax; progress += 20) {
////                            notification.setProgress(progressMax, progress, false);
////                            notificationManager.notify(1, notification.build());
//                    SystemClock.sleep(1000);
//                }
//                notification.setContentText("Uploaded")
//                        .setProgress(0, 0, false)
//                        .setOngoing(false);
//                notificationManager.notify(1, notification.build());
//            }
//        }).start();

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
        String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no value");
        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();
        String Url = "https://api.fluntoo.com/channel/createchannel/" + user;
        Log.d("url", Url);
        Log.d("token", token);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MultipartBody.Part image1 = null;
        MultipartBody.Part image2 = null;


//        MultipartBody.Part filepart=null;
//        MultipartBody.Part filepart2=null;

//        "text/plain"
        RequestBody namepart = RequestBody.create(MediaType.parse("text/plain"), name1.getText().toString());
        RequestBody descpart = RequestBody.create(MediaType.parse("text/plain"), desc.getText().toString());
        RequestBody twitterpart = RequestBody.create(MediaType.parse("text/plain"), twitter.getText().toString());
        RequestBody facebookpart = RequestBody.create(MediaType.parse("text/plain"), facebook.getText().toString());
        RequestBody linkedinpart = RequestBody.create(MediaType.parse("text/plain"), linkedin.getText().toString());
        RequestBody gogglebusinesspart = RequestBody.create(MediaType.parse("text/plain"), gogglebusiness.getText().toString());
        RequestBody instapart = RequestBody.create(MediaType.parse("text/plain"), instagram.getText().toString());

        Log.d("img", namepart.toString());
        Log.d("img", descpart.toString());

//        Uri uri = Uri.parse("android.resource:com.example.playflix/drawable/app_logo.png");
//        File file=new File(imageUri.getPath());


        File file = new File(selectedImagePath1);

        Log.d("file", file.toString());
        RequestBody filepart = RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri)), file);
//        MediaType.parse("image/*")


        image1 = MultipartBody.Part.createFormData("ProfilePic", file.getName(), filepart);
        Log.d("img", image1.toString());


        File file2 = new File(selectedImagePath2);

//        Uri uri2 = Uri.parse("android.resource:com.example.playflix/drawable/contact.png");
//        File file2=new File(imageUri2.getPath());
//

        RequestBody filepart2 = RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri2)), file2);

        Log.d("multi", filepart2.toString());

        image2 = MultipartBody.Part.createFormData("CoverPic", file2.getName(), filepart2);
        Log.d("img", image2.toString());


        CreateChannelInterface createChannelInterface = retrofit.create(CreateChannelInterface.class);
        Call<CreateChannel> call = createChannelInterface.createchannel("Bearer " + token,
                Url, namepart, descpart, image1, image2, facebookpart, twitterpart, linkedinpart,
                gogglebusinesspart, instapart);

        call.enqueue(new Callback<CreateChannel>() {
            @Override
            public void onResponse(Call<CreateChannel> call, Response<CreateChannel> response) {
//                String res=response.body().toString();

                Log.d("res", response.toString());

                Snackbar snackbar = Snackbar
                        .make(layoutchannel, response.toString(), Snackbar.LENGTH_LONG);
                snackbar.show();
//                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onFailure(Call<CreateChannel> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "sucessful", Toast.LENGTH_SHORT).show();

                notification.setContentText("Uploaded")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                notificationManager.notify(1, notification.build());

                Snackbar snackbar = Snackbar
                        .make(layoutchannel, "Sucessfully Created Channel", Snackbar.LENGTH_LONG);
                snackbar.show();
                Log.d("tag", t.toString());


            }
        });

//

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
