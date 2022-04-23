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
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.DeleteCoverPicINterface;
import com.fluntoo.zenberry.ApIInterface.UploadedInterface;
import com.fluntoo.zenberry.Model.DeleteCoverPic;
import com.fluntoo.zenberry.Model.SelectImage2;
import com.fluntoo.zenberry.Model.UploadedProfile;
import com.fluntoo.zenberry.MyAccountActivity;
import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadedProfileAdapter extends RecyclerView.Adapter<UploadedProfileAdapter.myview> {
    List<UploadedProfile> items = new ArrayList<>();
    Context context;

    public static final String MY_PREFS_NAME = "MyPrefsFile";


    String image, dimage;
    private NotificationManagerCompat notificationManager;

    public UploadedProfileAdapter(List<UploadedProfile> items, Context context) {
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
        UploadedProfile item = items.get(position);
        Glide.with(context)
                .load(item.getImagepath())
                .into(holder.img);
        String imgpath = item.getImagepath().toString();
        image = imgpath;


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UploadedProfile item1=items.get(position);
//                String imgpath1=item1.getImagepath().toString();
//                dimage=imgpath1;
//            }
//        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
//                String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//                String user = prefs.getString("userId", "no value");
//
//
//                String Url1 = "https://www.api.playflixx.com/selectcoverpic/" + user;
//                Log.d("url", Url1);
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl("https://www.api.playflixx.com/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//                UploadedInterface uploadedInterface = retrofit.create(UploadedInterface.class);
//                Call<SelectImage2> call = uploadedInterface.putpro(Url1, "Bearer " + token, imgpath);
//                call.enqueue(new Callback<SelectImage2>() {
//                    @Override
//                    public void onResponse(Call<SelectImage2> call, Response<SelectImage2> response) {
//                        Toast.makeText(context.getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<SelectImage2> call, Throwable t) {
//
//                        Toast.makeText(context.getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//
//                });
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myview extends RecyclerView.ViewHolder implements View.OnClickListener, android.widget.PopupMenu.OnMenuItemClickListener {
        ImageView img;


        public myview(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.uploaded_coverimg);
            img.setOnClickListener(this);


        }


        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.coverdelete:
                    delete();
                    return true;
                case R.id.uploadmenucover:
                    upload();
                    return true;

                default:
                    return false;
            }
        }
        private void upload() {
            String image8=items.get(getAdapterPosition()).getImagepath();
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

            SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
            String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
            String user = prefs.getString("userId", "no value");


            String Url1 = "https://api.fluntoo.com/aboutme/selectcoverpic/" + user;
            Log.d("url", Url1);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.api.playflixx.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            UploadedInterface uploadedInterface = retrofit.create(UploadedInterface.class);
            Call<SelectImage2> call = uploadedInterface.putpro(Url1, "Bearer " + token, image8);
            call.enqueue(new Callback<SelectImage2>() {
                @Override
                public void onResponse(Call<SelectImage2> call, Response<SelectImage2> response) {
                    Toast.makeText(context.getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<SelectImage2> call, Throwable t) {
                    Toast.makeText(context.getApplicationContext(), "sucessful", Toast.LENGTH_SHORT).show();

                    notification.setContentText("Uploaded")
                            .setProgress(0, 0, false)
                            .setOngoing(false);
                    notificationManager.notify(1, notification.build());

                    Intent intent = new Intent(getApplicationContext(), MyAccountActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

//                context.startActivity(new Intent(context, MyAccountActivity.class));
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
                    Toast.makeText(context.getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<DeleteCoverPic> call, Throwable t) {

                    Toast.makeText(context.getApplicationContext(), "succesful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), MyAccountActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
//                    context.startActivity(new Intent(getApplicationContext(), MyAccountActivity.class));
                }
            });


        }


        @Override
        public void onClick(View v) {
            android.widget.PopupMenu popupMenu = new android.widget.PopupMenu(v.getContext(), v);
            popupMenu.inflate(R.menu.covermenu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }
    }


}
