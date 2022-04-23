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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.AboutmeInterface;
import com.fluntoo.zenberry.ApIInterface.UpdateCoverInterface;
import com.fluntoo.zenberry.ApIInterface.UpdateProfileInterface;
import com.fluntoo.zenberry.Model.Aboutme;
import com.fluntoo.zenberry.Model.UpdateCoverPic;
import com.fluntoo.zenberry.Model.UpdateProfileImg;
import com.google.android.material.bottomsheet.BottomSheetDialog;
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

public class MyAccountActivity extends AppCompatActivity {
    CardView card1, card10, card11, card12;
    ImageView channelimg, profileimg, updateprofimg, updatecoverimg;
    ImageView imgcover;
    TextView nametxt;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    ImageView img;

    Uri imageUri;
    Uri imageUri2;
    String selectedImagePath1 = "";
    String selectedImagePath2 = "";

    private BottomSheetDialog bottomSheetDialog;
    RelativeLayout layout;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        channelimg = findViewById(R.id.channel_img);
        profileimg = findViewById(R.id.img_background);
        nametxt = findViewById(R.id.channel_name);
        card1 = findViewById(R.id.cardview_1);
        card10 = findViewById(R.id.cardview_10);
        card11 = findViewById(R.id.cardview_11);
        card12 = findViewById(R.id.cardview_12);
        layout = findViewById(R.id.mainlayout);
//        updateprofimg=findViewById(R.id.updateprofilebtn);

        img = findViewById(R.id.img3);
//        updateprofimg = findViewById(R.id.updateprofilebtn);
//        updatecoverimg = findViewById(R.id.updatecoverebtn);
        getdata();

        notificationManager = NotificationManagerCompat.from(this);

        final SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.refreshmyaccount);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getdata();

                swipeRefreshLayout.setRefreshing(false);
            }
        });

//        profileimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), UploadedProfileActivity.class));
//
//            }
//        });

//        channelimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), UploadedCoverActivity.class));
//            }
//        });

        profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(MyAccountActivity.this, R.style.BottomSheetTheme);
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.profilepic_bottom_sheet_layout,
                        (ViewGroup) findViewById(R.id.bottom_sheetprofile));


                view.findViewById(R.id.uploadprofile).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                                    && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                                pickcoverimage();

                            } else {
                                allowPermissionForFile();
                            }
                        } else {
                            pickcoverimage();

                        }

                        pickcoverimage();

                    }
                });

                view.findViewById(R.id.uploadprofilelibrary).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "Upload", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), UploadedProfileActivity.class));
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
            }
        });


        channelimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(MyAccountActivity.this, R.style.BottomSheetTheme);
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.coverpic_bottom_sheet_layout,
                        (ViewGroup) findViewById(R.id.bottom_sheetcover));


                view.findViewById(R.id.uploadcover).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                                    && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                                pickprofileimage();

                            } else {
                                allowPermissionForFile();
                            }
                        } else {
                            pickprofileimage();

                        }
                        pickprofileimage();

                    }
                });

                view.findViewById(R.id.uploadcovverlibrary).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "Upload", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), UploadedCoverActivity.class));
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
            }
        });


//        updatecoverimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
//                            && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//                        pickcoverimage();
//
//                    } else {
//                        allowPermissionForFile();
//                    }
//                } else {
//                    pickcoverimage();
//
//                }
//
//                pickcoverimage();
//
//            }
//        });
//        updateprofimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
//                            && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//                        pickprofileimage();
//
//                    } else {
//                        allowPermissionForFile();
//                    }
//                } else {
//                    pickprofileimage();
//
//                }
//                pickprofileimage();
//
//
//            }
//        });


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), YourChannelActivity.class);
                startActivity(intent);
            }
        });
        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.fluntoo.com/legal";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                contactus
                String url = "https://www.fluntoo.com/contact-us";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                about legal
                String url = "https://www.fluntoo.com/legal";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        getdata();


    }

    private void allowPermissionForFile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    }, 101);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, 102);
        }
    }


    private void pickprofileimage() {
        Intent photoPickerIntent2 = new Intent(Intent.ACTION_PICK);
        photoPickerIntent2.setType("image/*");
        photoPickerIntent2.putExtra(Intent.EXTRA_LOCAL_ONLY, true); // this is the flag that does the trick
        startActivityForResult(photoPickerIntent2, 101);


    }

    private void pickcoverimage() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        photoPickerIntent.putExtra(Intent.EXTRA_LOCAL_ONLY, true); // this is the flag that does the trick
        startActivityForResult(photoPickerIntent, 102);
    }

    private void updateprofile() {

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
//        Toast.makeText(getApplicationContext(), token, Toast.LENGTH_SHORT).show();

        String Url1 = "https://api.fluntoo.com/aboutme/profilepic/" + user;
        Log.d("url", Url1);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

        MultipartBody.Part image1 = null;
        long userid = Long.parseLong(user);
        File file = new File(selectedImagePath1);

        Log.d("file", file.toString());
        RequestBody filepart = RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri)), file);

        image1 = MultipartBody.Part.createFormData("ProfilePic", file.getName(), filepart);
        Log.d("img", image1.toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UpdateProfileInterface updateProfileInterface = retrofit.create(UpdateProfileInterface.class);
        Call<UpdateProfileImg> call = updateProfileInterface.updateprofile(Url1, "Bearer " + token,
                userid, image1);
        call.enqueue(new Callback<UpdateProfileImg>() {
            @Override
            public void onResponse(Call<UpdateProfileImg> call, Response<UpdateProfileImg> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<UpdateProfileImg> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                notification.setContentText("Uploaded")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                notificationManager.notify(1, notification.build());

                Snackbar snackbar = Snackbar.make(layout, "Suessful", Snackbar.LENGTH_SHORT);
                snackbar.show();

                getdata();

            }
        });

    }


    private void updatecoverpic() {
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
//                for (int progress = 0; progress <= progressMax; progress += 10) {
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
        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

        String Url3 = "https://api.fluntoo.com/aboutme/profilecoverpic/" + user;
        Log.d("url", Url3);

        MultipartBody.Part image2 = null;
        long useridd = Long.parseLong(user);
        File file2 = new File(selectedImagePath2);

        Log.d("file", file2.toString());
        RequestBody filepart2 = RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri2)), file2);

        image2 = MultipartBody.Part.createFormData("CoverPic", file2.getName(), filepart2);
        Log.d("img", image2.toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UpdateCoverInterface coverInterface = retrofit.create(UpdateCoverInterface.class);
        Call<UpdateCoverPic> call = coverInterface.updatecover(Url3, "Bearer " + name, useridd, image2);
        call.enqueue(new Callback<UpdateCoverPic>() {
            @Override
            public void onResponse(Call<UpdateCoverPic> call, Response<UpdateCoverPic> response) {

                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UpdateCoverPic> call, Throwable t) {

//                Toast.makeText(getApplicationContext(), "Succesful", Toast.LENGTH_SHORT).show();
                notification.setContentText("Uploaded")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                notificationManager.notify(1, notification.build());

                Snackbar snackbar = Snackbar.make(layout, "Suessful", Snackbar.LENGTH_SHORT);
                snackbar.show();
                getdata();
            }
        });
    }


    private void getdata() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();


        String Url = "https://api.fluntoo.com/aboutme/aboutme/" + user;
        Log.d("comment", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AboutmeInterface aboutmeInterface = retrofit.create(AboutmeInterface.class);
        Call<Aboutme> call = aboutmeInterface.getaboutme(Url);
        call.enqueue(new Callback<Aboutme>() {
            @Override
            public void onResponse(Call<Aboutme> call, Response<Aboutme> response) {
                if (response.isSuccessful()) {
                    Aboutme aboutme = response.body();


                    String img1 = aboutme.getUserProfileimagepath();
                    String img2 = aboutme.getUserProfilecoverpath();
                    Log.d("res", response.body().getUserProfilecoverpath());
                    String name = aboutme.getUserName();

                    Glide.with(getApplicationContext())
                            .load(img1)
                            .into(channelimg);
                    Glide.with(getApplicationContext())
                            .load(img2)
                            .into(profileimg);
                    nametxt.setText(name);
                } else {
                    channelimg.setImageResource(R.drawable.ic_launcher_background);
                    profileimg.setImageResource(R.drawable.ic_launcher_background);
                }

//                if(user.isEmpty()) {
//                    channelimg.setImageResource(R.drawable.ic_launcher_background);
//                    profileimg.setImageResource(R.drawable.ic_launcher_background);
//                }


            }

            @Override
            public void onFailure(Call<Aboutme> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Snackbar snackbar = Snackbar.make(layout, "Suessful", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            if (requestCode == 101) {
//                try {
//                    imageUri = data.getData();
//                    selectedImagePath1 = generatePath(imageUri, this);
//
////                    Log.d("data", file.toString());
//
//                    InputStream imageStream = getContentResolver().openInputStream(imageUri);
//                    Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
////                img.setImageBitmap(selectedImage);
//                    updateprofile();
//
//
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
//                    Log.d("e", e.toString());
//                }
//
//                if (requestCode == 102) {
//                    try {
//                        imageUri2 = data.getData();
//                        selectedImagePath2 = generatePath(imageUri2, this);
////                    Log.d("data", file.toString());
//                        InputStream imageStream2 = getContentResolver().openInputStream(imageUri2);
//                        Bitmap selectedImage2 = BitmapFactory.decodeStream(imageStream2);
////                img.setImageBitmap(selectedImage);
//                        updatecoverpic();
//
//
////
////
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
//                        Log.d("e", e.toString());
//                    }
//
//                }
//
//
//            }
//        }
        if (resultCode == RESULT_OK) {

            if (requestCode == 101) {
                try {
                    imageUri = data.getData();

                    selectedImagePath1 = generatePath(imageUri, this);

//                    Log.d("data", file.toString());

                    InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

                    updateprofile();


//                    img.setImageBitmap(selectedImage);


//                createchannel(imageUri,imageUri2);

//                uploadFile(imageUri);
//
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    Log.d("e", e.toString());
                }
            }
//            } else {
//                Toast.makeText(getApplicationContext(), "select", Toast.LENGTH_SHORT).show();
//            }
            if (requestCode == 102) {
                try {


                    imageUri2 = data.getData();
//                    Log.d("data", imageUri2.toString());
                    selectedImagePath2 = generatePath(imageUri2, this);


//                    Log.d("file", imageUri2.toString());

                    InputStream imageStream2 = getContentResolver().openInputStream(imageUri2);
                    Bitmap selectedImage2 = BitmapFactory.decodeStream(imageStream2);
                    updatecoverpic();

//                    img2.setImageBitmap(selectedImage2);


//                createchannel(imageUri,imageUri2);

//                uploadFile(imageUri);
//
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    Log.d("e", e.toString());
                }
//            } else {
//                Toast.makeText(getApplicationContext(), "selectp", Toast.LENGTH_SHORT).show();
//            }
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