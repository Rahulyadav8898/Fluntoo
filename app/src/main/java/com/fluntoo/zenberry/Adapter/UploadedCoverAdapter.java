package com.fluntoo.zenberry.Adapter;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.fluntoo.zenberry.App.CHANNEL_1_ID;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.DeleteCoverPicINterface;
import com.fluntoo.zenberry.ApIInterface.UploadedInterface;
import com.fluntoo.zenberry.Model.DeleteCoverPic;
import com.fluntoo.zenberry.Model.SelectImage;
import com.fluntoo.zenberry.Model.UploadedCover;
import com.fluntoo.zenberry.MyAccountActivity;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadedCoverAdapter extends RecyclerView.Adapter<UploadedCoverAdapter.myview> {
    List<UploadedCover> items = new ArrayList<>();
    Context context;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    String image;
    private NotificationManagerCompat notificationManager;

    public UploadedCoverAdapter(List<UploadedCover> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_image, parent, false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        UploadedCover item = items.get(position);
        Glide.with(context)
                .load(item.getImagepath())
                .into(holder.img);
        String imgpath = item.getImagepath().toString();
        image = imgpath;


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
//                String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//                String user = prefs.getString("userId", "no value");
//
//                String Url1 = "https://www.api.playflixx.com/selectprofilepic/" + user;
//                Log.d("url", Url1);
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl("https://www.api.playflixx.com/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//                UploadedInterface uploadedInterface = retrofit.create(UploadedInterface.class);
//                Call<SelectImage> call = uploadedInterface.putcover(Url1, "Bearer " + token, imgpath);
//                call.enqueue(new Callback<SelectImage>() {
//                    @Override
//                    public void onResponse(Call<SelectImage> call, Response<SelectImage> response) {
//                        Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<SelectImage> call, Throwable t) {
//                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class myview extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
        ImageView img;
        Button btn;

        public myview(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.uploaded_coverimg);
            img.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
            popupMenu.inflate(R.menu.profilemenu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        private void upload() {

            String image9 = items.get(getAdapterPosition()).getImagepath();

            notificationManager = NotificationManagerCompat.from(context);
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


            SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
            String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
            String user = prefs.getString("userId", "no value");

            String Url1 = "https://api.fluntoo.com/aboutme/selectprofilepic/" + user;
            Log.d("url", Url1);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.api.playflixx.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            UploadedInterface uploadedInterface = retrofit.create(UploadedInterface.class);
            Call<SelectImage> call = uploadedInterface.putcover(Url1, "Bearer " + token, image9);
            call.enqueue(new Callback<SelectImage>() {
                @Override
                public void onResponse(Call<SelectImage> call, Response<SelectImage> response) {
                    Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<SelectImage> call, Throwable t) {
                    Toast.makeText(context, "succesful", Toast.LENGTH_SHORT).show();


                    notification.setContentText("Uploaded")
                            .setProgress(0, 0, false)
                            .setOngoing(false);
                    notificationManager.notify(1, notification.build());
//                context.startActivity(new Intent(getApplicationContext(), MyAccountActivity.class));
                    Intent intent = new Intent(getApplicationContext(), MyAccountActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            });

        }

        private void delete() {
            String deleteimg = items.get(getAdapterPosition()).getImagepath();


            SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
            String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
            String user = prefs.getString("userId", "no value");

            String Url1 = "https://api.fluntoo.com/aboutme/deletecoverpic/" + user;
            Log.d("url", Url1);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.api.playflixx.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            DeleteCoverPicINterface deleteCoverPicINterface = retrofit.create(DeleteCoverPicINterface.class);
            Call<DeleteCoverPic> call = deleteCoverPicINterface.deletecover(Url1, deleteimg);
            call.enqueue(new Callback<DeleteCoverPic>() {
                @Override
                public void onResponse(Call<DeleteCoverPic> call, Response<DeleteCoverPic> response) {

                    Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<DeleteCoverPic> call, Throwable t) {
                    Toast.makeText(context.getApplicationContext(), "sucesful", Toast.LENGTH_SHORT).show();
//                    context.startActivity(new Intent(context, MyAccountActivity.class));
                    Intent intent = new Intent(getApplicationContext(), MyAccountActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.prodelete:
                    delete();
                    return true;
                case R.id.uploadmenu:
                    upload();
                    return true;

                default:
                    return false;
            }
        }
    }


}